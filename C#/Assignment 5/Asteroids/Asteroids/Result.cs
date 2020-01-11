using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Produce level end messages.
    /// </summary>
    /// 
    class Result
    {
        private Rectangle resultboard;
        private Rectangle screen;
        private Font font;
        private Pen pen;
        public String winorlose;
      
        public Result(Rectangle screen)
        {
            this.screen = screen;
            resultboard = new Rectangle(screen.Right/2 - 300, screen.Bottom/2 - 150, 600, 200);
            pen = new Pen(Brushes.Green);
            pen.Width = 5.0F;
            font = new Font(FontFamily.GenericSerif, 40);
        }

        public void Make(Graphics graphics)
        {
            graphics.DrawRectangle(pen, resultboard);
            graphics.DrawString(winorlose, font, Brushes.Yellow, resultboard.Left + 90, resultboard.Top + 50);
            graphics.DrawString("Press escape to exit", new Font(FontFamily.GenericMonospace, 20), Brushes.Silver, resultboard.Left + 120, screen.Bottom - 200);
        }
    }
}
