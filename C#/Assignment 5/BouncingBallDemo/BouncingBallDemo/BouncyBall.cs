using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BouncingBallDemo
{
    public partial class BouncyBall : Form
    {
        public BouncyBall()
        {
            InitializeComponent();
        }

        private void BouncyBall_Load(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;
        }

        private void BouncyBall_Paint(object sender, PaintEventArgs e)
        {
            Paddle paddle = new Paddle(this.DisplayRectangle);
            Graphics graphics = e.Graphics;
            paddle.Draw(graphics);
        }
    }
}
