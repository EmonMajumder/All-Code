using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Class that generate all the explosion features on screen.
    /// </summary>
    class Explosion
    {
        private readonly int Sizeofexplosion = 250;
        private Rectangle explosionarea;
        private Image explosion;

        //Constructor for class. 
        public Explosion(Rectangle entity)
        {
            explosionarea.X = entity.X + (entity.Width - Sizeofexplosion) / 2;
            explosionarea.Y = entity.Y + (entity.Height - Sizeofexplosion) / 2; ;
            explosionarea.Width = Sizeofexplosion;
            explosionarea.Height = Sizeofexplosion;
        }

        //generate the object on screen
        public void Make(Graphics graphics, bool isship)
        {
            //Determine if ship or astroid explosion.
            if (isship)
            {
                explosion = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\explosion2.png");
            }
            else
            {
                explosion = Image.FromFile("C:\\C#\\Assignment 5\\Asteroids\\asexp.png");
            }

            graphics.DrawImage(explosion, explosionarea.X, explosionarea.Y);
        }
    }
}
