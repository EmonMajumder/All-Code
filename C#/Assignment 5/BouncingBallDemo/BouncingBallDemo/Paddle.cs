using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BouncingBallDemo
{
    class Paddle
    {
        private readonly int width = 60;
        private readonly int height = 20;
        private Rectangle canvas;
        private Rectangle displayArea;
        public Paddle(Rectangle canvas)
        {
            this.canvas = canvas;
            displayArea.Width = this.width;
            displayArea.Height = this.height;
            displayArea.Y = this.canvas.Bottom - this.height - 20;
            displayArea.X = (this.canvas.Width / 2) - (this.width / 2);
            public enum direction()
            {
            }

        }

        public void Draw(Graphics graphics)
        {
            Rectangle rect = new Rectangle(displayArea.X, displayArea.Y, 80, 20);
            graphics.FillRectangle(Brushes.White, rect);
        }

    }
}
