using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Class that display the number of life remain
    /// </summary>
    class LifeBoard
    {
        private Rectangle lifeboard;
        private Rectangle screen;
        private Point location;
        public int point;
        private Pen pen;
        private Image life;

        //Constructor for class.
        public LifeBoard(Rectangle screen)
        {
            this.screen = screen;
            point = 3;            
            lifeboard = new Rectangle(screen.Left + 50, screen.Top + 50, 170, 50);
            location.Y = lifeboard.Y + 10;
            pen = new Pen(Brushes.Gold);
            life = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\life.png");
        }

        //Display object on screen.
        public void Make(Graphics graphics)
        {
            graphics.DrawRectangle(pen, lifeboard);

            location.X = lifeboard.X + 20;            

            for (int i= 1; i<= point; i++)
            {
                graphics.DrawImage(life, location);
                location.X = location.X + 50;
            }
        }
    }
}
