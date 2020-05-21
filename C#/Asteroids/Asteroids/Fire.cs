using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Class that handles the firing.
    /// </summary>
    class Fire
    {
        private readonly int Sizeoffire = 20;
        public Rectangle fireball;
        public Rectangle screen;
        public String face;
        public Image fire;
        private readonly int xVelocity = 30;
        private readonly int yVelocity = 30;

        //Constructor
        public Fire(Rectangle screen,String face, Point c)
        {
            this.screen = screen;
            fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\firew.png");

            //face determine fire orientation
            this.face = face;           

            fireball.X = c.X - Sizeoffire / 2;
            fireball.Y = c.Y - Sizeoffire / 2;            
            fireball.Width = Sizeoffire;
            fireball.Height = Sizeoffire;
        }

        //Display on screen
        public void Make(Graphics graphics)
        {
            graphics.DrawImage(fire, fireball.X, fireball.Y);
        }

        //Function to give the fire Yondu Udonta effect (the power of controlling fire)
        public void firenow(String face)
        {
            if (fireball.X < screen.Left || fireball.X > screen.Right || fireball.Y < screen.Top || fireball.Y > screen.Bottom)
            {
                fireball.X = 10000;
            }

            switch (face)
            {            
                case "D":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\fired.png");
                        fireball.X += xVelocity;
                        break;
                    }
                case "W":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\firew.png");
                        fireball.Y -= yVelocity;
                        break;
                    }
                case "A":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\firea.png");
                        fireball.X -= xVelocity;
                        break;
                    }
                case "S":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\fires.png");
                        fireball.Y += yVelocity;
                        break;
                    }
            }          
        }


        //Move the the fire.
        public void Move()
        {
            if (fireball.X < screen.Left || fireball.X > screen.Right || fireball.Y < screen.Top || fireball.Y > screen.Bottom)
            {
                fireball.X = 10000;
            }

            switch (face)
            {
                case "D":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\fired.png");
                        fireball.X += xVelocity;
                        break;
                    }
                case "W":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\firew.png");
                        fireball.Y -= yVelocity;
                        break;
                    }
                case "A":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\firea.png");
                        fireball.X -= xVelocity;
                        break;
                    }
                case "S":
                    {
                        fire = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\fires.png");
                        fireball.Y += yVelocity;
                        break;
                    }
            }
        }
    }
}
