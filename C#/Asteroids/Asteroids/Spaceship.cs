using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Class for spaceship character.
    /// </summary>
    class Spaceship
    {
        private int Sizeofship = 120;
        private Rectangle screen;
        public Rectangle circle;
        public Point c;
        public String face;
        private Image ship;

        //Direction and rotation
        public enum Direction
        {
            Left,
            Right,
            Up,
            Down,
            A,
            D,
            W,
            S           
        }

        private readonly int xVelocity = 30;
        private readonly int yVelocity = 30;

        public Spaceship(Rectangle screen)
        {
            this.screen = screen;
            circle.Width = Sizeofship;
            circle.Height = Sizeofship;
            circle.X = (screen.Width / 2) - (Sizeofship / 2);
            circle.Y = (screen.Height * 2) / 3 - (Sizeofship / 2);
            face = "W";
            trianglepoints();
            ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\shipw.png");
        }

        public void Make(Graphics graphics)
        {            
            trianglepoints();
            graphics.DrawImage(ship, circle.X, circle.Y);
        }

        //Calculate the point to put fire starting point 
        public void trianglepoints()
        {
            switch(face)
            {
                case "D":
                    {
                        c.X = circle.X + Sizeofship;
                        c.Y = circle.Y + Sizeofship / 2;
                        break;
                    }
                case "W":
                    {
                        c.X = circle.X + Sizeofship / 2;
                        c.Y = circle.Y;
                        break;
                    }
                case "A":
                    {
                        c.X = circle.X;
                        c.Y = circle.Y + Sizeofship/2;
                        break;
                    }
                case "S":
                    {
                        c.X = circle.X + Sizeofship / 2;
                        c.Y = circle.Y;
                        break;
                    }
            }
        }

        //Move and rotate the spaceship on requited keystroke
        public void Move(Direction direction)
        {
            switch(direction)
            {
                case Direction.Left:
                    {
                        if(circle.X > screen.Left)
                        {
                            circle.X -= xVelocity;                            
                        }                                            
                        break;
                    }
                case Direction.Right:
                    {
                        if ((circle.X+circle.Width) < screen.Right)
                        {
                            this.circle.X += xVelocity;
                        }                                             
                        break;
                    }
                case Direction.Up:
                    {
                        if (circle.Y > screen.Top)
                        {
                            circle.Y -= yVelocity;
                        }                                              
                        break;
                    }
                case Direction.Down:
                    {
                        if ((circle.Y + circle.Height) < screen.Bottom)
                        {
                            this.circle.Y += yVelocity;
                        }                                              
                        break;
                    }
                case Direction.A:
                    {
                        face = "A";
                        ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\shipa.png");
                        break;
                    }
                case Direction.D:
                    {
                        face = "D";
                        ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\shipd.png");
                        break;
                    }
                case Direction.W:
                    {
                        face = "W";
                        ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\shipw.png");
                        break;
                    }
                case Direction.S:
                    {
                        face = "S";
                        ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\ships.png");
                        break;
                    }
            }
        }

        //Collision effect
        public void DetectCollision()
        {
            ship = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\shipdestroyed.PNG");
        }
    }
}
