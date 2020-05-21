using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Class that generate the astroid object.
    /// </summary>
    class Asteroid
    {
        private Rectangle screen;
        public Rectangle circle;   
        private int xVelocity;
        private int yVelocity;
        private Image ast;
        private String imagefolder;

        //Constructor fopr class.
        public Asteroid(Rectangle screen)
        {
            this.screen = screen;
            imagefolder = "C:\\C#\\Assignment 5\\Asteroids\\astroidassets";

            //Select astroid size and image.
            selectastroid();

            //Select astroid speed and initial location.
            selectvelocityandlocation();           
        }

        public void selectvelocityandlocation()
        {
            Random random = new Random();

            while (xVelocity == 0)
            {
                xVelocity = random.Next(-20, 20);
            }

            while (yVelocity == 0)
            {
                yVelocity = random.Next(-20, 20);
            }

            if (xVelocity < 0)
            {
                circle.X = random.Next(screen.Right / 2, screen.Right);
            }
            else
            {
                circle.X = random.Next(screen.Left, screen.Right - screen.Width / 2);
            }

            if (yVelocity < 0)
            {
                circle.Y = random.Next(screen.Top + screen.Height / 2, screen.Bottom);
            }
            else
            {
                circle.Y = random.Next(screen.Top, screen.Bottom - screen.Height / 2);
            }

            if (random.Next(1, 100) % 2 == 0)
            {
                if (xVelocity > 0)
                {
                    circle.X = screen.Left - circle.Width;
                }
                else
                {
                    circle.X = screen.Right;
                }
            }
            else
            {
                if (yVelocity > 0)
                {
                    circle.Y = screen.Top - circle.Width;
                }
                else
                {
                    circle.Y = screen.Bottom;
                }
            }
        }

        public void selectastroid()
        {
            Random random = new Random();
            int a = random.Next(14, 32);
            circle.Width = a * 5;
            circle.Height = circle.Width;
            string selectedas = "\\ast (" + a.ToString() + ").png";
            ast = Image.FromFile(imagefolder + selectedas);
        }

        //Generate the object on screen.
        public void Make(Graphics graphics)
        {             
            graphics.DrawImage(ast, circle);
        }

        //Function to move the object
        public void Move()
        {
            DetectCollisionwithboundary();
            circle.Y += yVelocity;
            circle.X += xVelocity;
        }

        //Function to detectcollision with boundary and bounce back.
        public void DetectCollisionwithboundary()
        {
            if ((circle.X < screen.Left && xVelocity < 0) || ((circle.X + circle.Width) > screen.Right && xVelocity > 0))
            {
                xVelocity *= -1;
            }

            if ((circle.Y < screen.Top && yVelocity < 0) || ((circle.Y + circle.Height) > screen.Bottom && yVelocity > 0))
            {
                yVelocity *= -1;
            }
        }
    }
}
