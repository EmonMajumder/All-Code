using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Asteroids
{
    /// <summary>
    /// Main form to play the game.
    /// </summary>
    public partial class Asteroids_form : Form
    {
        private Spaceship spaceship;
        private HashSet<Asteroid> asteroids = new HashSet<Asteroid>();
        private HashSet<Fire> fires = new HashSet<Fire>();
        private ScoreBoard scoreboard;
        private LifeBoard lifeboard;
        private Fire fire;
        private Result result;
        private Explosion explosion;
        private int level;
        private bool newround;
        private Image space;
        private bool explode;
        private bool shipexplode;

        public Asteroids_form()
        {
            InitializeComponent();            
        }

        private void Asteroids_form_Load(object sender, EventArgs e)
        {
            newround = true;
            level = 1;
            explode = false;
            shipexplode = false;

            this.WindowState = FormWindowState.Maximized;

            space = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\space.jpg");

            spaceship = new Spaceship(this.DisplayRectangle);
            asteroids.Add(new Asteroid(this.DisplayRectangle));           
            fires.Add(new Fire(this.DisplayRectangle, spaceship.face, spaceship.c));
            scoreboard = new ScoreBoard(this.DisplayRectangle);
            lifeboard = new LifeBoard(this.DisplayRectangle);
            result = new Result(this.DisplayRectangle);
            explosion = new Explosion(spaceship.circle);
        }

        //Form paint to show objects on screen.
        private void Asteroids_form_Paint(object sender, PaintEventArgs e)
        {
            Graphics graphics = e.Graphics;

            graphics.DrawImage(space, this.DisplayRectangle.X, this.DisplayRectangle.Y);

            if (newround)
            {
                result.winorlose = "Level: "+ level.ToString() + Environment.NewLine + "Press Enter to start.";
                result.Make(graphics);
            }

            //Clear items from astroids list as needed
            asteroids.RemoveWhere(isastroiddestroyed);

            //Clear items from fires list as needed
            fires.RemoveWhere(isfiredone);

            foreach (var fire in fires)
            {
                fire.Make(graphics);
            }            

            spaceship.Make(graphics);

            foreach (var asteroid in asteroids)
            {
                asteroid.Make(graphics);                               
            }            

            scoreboard.Make(graphics);

            lifeboard.Make(graphics);

            if(explode)
            {
                explosion.Make(graphics, shipexplode);

                if (!Explosionanimation.Enabled)
                {
                    Explosionanimation.Start();
                }
            }

            if (scoreboard.point == 10)
            {
                result.winorlose = "!!! YOU WON !!!";
                result.Make(graphics);
            }
            else if(lifeboard.point == 0)
            {
                result.winorlose = "!!! YOU LOST !!!";
                result.Make(graphics);
            }
        }

        //Function to get user input from key press.
        private void Asteroids_form_KeyDown(object sender, KeyEventArgs e)
        {
            if(FPS.Enabled || e.KeyCode == Keys.Enter)
            {
                switch (e.KeyCode)
                {
                    case Keys.Left:
                        {
                            spaceship.Move(Spaceship.Direction.Left);
                            break;
                        }

                    case Keys.Right:
                        {
                            spaceship.Move(Spaceship.Direction.Right);
                            break;
                        }

                    case Keys.Up:
                        {
                            spaceship.Move(Spaceship.Direction.Up);
                            break;
                        }

                    case Keys.Down:
                        {
                            spaceship.Move(Spaceship.Direction.Down);
                            break;
                        }

                    case Keys.A:
                        {
                            spaceship.Move(Spaceship.Direction.A);
                            break;
                        }

                    case Keys.D:
                        {
                            spaceship.Move(Spaceship.Direction.D);
                            break;
                        }

                    case Keys.W:
                        {
                            spaceship.Move(Spaceship.Direction.W);
                            break;
                        }

                    case Keys.S:
                        {
                            spaceship.Move(Spaceship.Direction.S);
                            break;
                        }

                    case Keys.Enter:
                        {
                            if (!Newgametimer.Enabled)
                            {
                                if (!FPS.Enabled)
                                {
                                    FPS.Start();
                                    newround = false;
                                }

                                if (!Generateasteroids.Enabled)
                                {
                                    Generateasteroids.Start();
                                }
                            }
                            break;
                        }

                    case Keys.Space:
                        {
                            if(!shipexplode)
                            {
                                fires.Add(new Fire(this.DisplayRectangle, spaceship.face, spaceship.c));                                
                            }                            
                            break;
                        }
                }            
            }

            //Exit application on pressing escape button.
            if(e.KeyCode == Keys.Escape)
            {
                Application.Exit();
            }
        }

        //Check collision between fire and astroid and astroid and spaceship.
        private void CheckCollision()
        {
            bool killed = false;

            foreach (var asteroid in asteroids)
            {
                foreach(var fire in fires)
                {
                    if (fire.fireball.IntersectsWith(asteroid.circle))
                    {
                        explode = true;
                        explosion = new Explosion(asteroid.circle);

                        asteroid.circle.X = 10000;

                        if (Generateasteroids.Interval > 1000)
                        {
                            Generateasteroids.Interval = Generateasteroids.Interval - 500;
                        }

                        fire.fireball.X = 10000;

                        scoreboard.point += 1;
                    }
                }

                if (spaceship.circle.IntersectsWith(asteroid.circle))
                {
                    spaceship.DetectCollision();
                    explode = true;
                    shipexplode = true;
                    explosion = new Explosion(spaceship.circle);
                    lifeboard.point -= 1;
                    killed = true;
                }                
            }

            if (killed)
            {
                asteroids.Clear();
                fires.Clear();
            }
        }

        private static bool isastroiddestroyed(Asteroid asteroid)
        {
            return asteroid.circle.X > 8000;
        }

        private static bool isfiredone(Fire fire)
        {
            return fire.fireball.X > 8000;
        }


        //Main tick event that fires the paint event.
        private void FPS_Tick(object sender, EventArgs e)
        {
            if(Newgametimer.Enabled)
            {
                Newgametimer.Stop();
            }

            foreach (var asteroid in asteroids)
            {
                asteroid.Move();
            }

            //fire.firenow(spaceship.face);

            foreach (var fire in fires)
            {
                fire.firenow(spaceship.face);
            }

            CheckCollision();

            CheckGameEnding();

            //Redraw funality
            Invalidate();
        }


        //Checks logics to find if the game end requirement met.
        private void CheckGameEnding()
        {
            if (lifeboard.point == 0 || scoreboard.point == 10)
            {
                if (Generateasteroids.Enabled)
                {
                    Generateasteroids.Stop();
                }

                asteroids.Clear();
                fires.Clear();
                asteroids.TrimExcess();             


                if (FPS.Enabled)
                {
                    FPS.Stop();
                }

                if (!Newgametimer.Enabled)
                {
                    Newgametimer.Start();
                }                              
            }
        }

        //Tick event to generate astroids.
        private void Generateasteroids_Tick(object sender, EventArgs e)
        {
            asteroids.Add(new Asteroid(this.DisplayRectangle));
        }

        //Tick event that handles start of new Round.
        private void Newgametimer_Tick(object sender, EventArgs e)
        {
            newround = true;

            if (scoreboard.point == 10)
            {
                level += 1;
            }

            Invalidate();

            spaceship = new Spaceship(this.DisplayRectangle);
            asteroids.Add(new Asteroid(this.DisplayRectangle));
            fire = new Fire(this.DisplayRectangle, spaceship.face, spaceship.c);
            scoreboard = new ScoreBoard(this.DisplayRectangle);
            lifeboard = new LifeBoard(this.DisplayRectangle);
            result = new Result(this.DisplayRectangle);

            Generateasteroids.Interval = 10000 - (level-1)*2*1000;

            if(Newgametimer.Enabled)
            {
                Newgametimer.Stop();
            }
        }

        //Tick event to animate explosion.
        private void Explosionanimation_Tick(object sender, EventArgs e)
        {
            explode = false;
            if(shipexplode)
            {
                spaceship = new Spaceship(this.DisplayRectangle);
                shipexplode = false;
            }            
            Explosionanimation.Stop();
        }
    }
}
