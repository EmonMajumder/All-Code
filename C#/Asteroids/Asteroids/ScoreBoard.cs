using System;
using System.Drawing;

namespace Asteroids
{
    /// <summary>
    /// Produce Scoreboard object for screen.
    /// </summary>
    class ScoreBoard
    {
        private Rectangle scoreboard;
        private Rectangle screen;
        private Font font;
        public int point;
        private Pen pen;

        public ScoreBoard(Rectangle screen)
        {
            this.screen = screen;
            point = 0;
            scoreboard = new Rectangle(screen.Right - 200, screen.Top + 50,150,50);
            pen = new Pen(Brushes.Gold);
            font = new Font(FontFamily.GenericSerif, 20);
        }

        public void Make(Graphics graphics)
        {
            graphics.DrawRectangle(pen, scoreboard);
            graphics.DrawString("Score: "+point.ToString(), font, Brushes.Lime, scoreboard.Left + 20, scoreboard.Top + 10);
        }
    }
}
