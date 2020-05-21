namespace Asteroids
{
    partial class Asteroids_form
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.FPS = new System.Windows.Forms.Timer(this.components);
            this.Generateasteroids = new System.Windows.Forms.Timer(this.components);
            this.Newgametimer = new System.Windows.Forms.Timer(this.components);
            this.Explosionanimation = new System.Windows.Forms.Timer(this.components);
            this.SuspendLayout();
            // 
            // FPS
            // 
            this.FPS.Interval = 20;
            this.FPS.Tick += new System.EventHandler(this.FPS_Tick);
            // 
            // Generateasteroids
            // 
            this.Generateasteroids.Interval = 10000;
            this.Generateasteroids.Tick += new System.EventHandler(this.Generateasteroids_Tick);
            // 
            // Newgametimer
            // 
            this.Newgametimer.Interval = 2000;
            this.Newgametimer.Tick += new System.EventHandler(this.Newgametimer_Tick);
            // 
            // Explosionanimation
            // 
            this.Explosionanimation.Interval = 1000;
            this.Explosionanimation.Tick += new System.EventHandler(this.Explosionanimation_Tick);
            // 
            // Asteroids_form
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Cursor = System.Windows.Forms.Cursors.Cross;
            this.DoubleBuffered = true;
            this.Name = "Asteroids_form";
            this.Text = "Asteroids";
            this.Load += new System.EventHandler(this.Asteroids_form_Load);
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.Asteroids_form_Paint);
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Asteroids_form_KeyDown);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Timer FPS;
        private System.Windows.Forms.Timer Generateasteroids;
        private System.Windows.Forms.Timer Newgametimer;
        private System.Windows.Forms.Timer Explosionanimation;
    }
}

