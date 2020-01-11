namespace UI
{
    partial class UIForm
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
            this.performComplicatedTaskButton = new System.Windows.Forms.Button();
            this.takeDrinkButton = new System.Windows.Forms.Button();
            this.makeNoiseButton = new System.Windows.Forms.Button();
            this.somethingGoodButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // performComplicatedTaskButton
            // 
            this.performComplicatedTaskButton.Location = new System.Drawing.Point(44, 35);
            this.performComplicatedTaskButton.Name = "performComplicatedTaskButton";
            this.performComplicatedTaskButton.Size = new System.Drawing.Size(146, 66);
            this.performComplicatedTaskButton.TabIndex = 0;
            this.performComplicatedTaskButton.Text = "Perform Compilcated Task";
            this.performComplicatedTaskButton.UseVisualStyleBackColor = true;
            this.performComplicatedTaskButton.Click += new System.EventHandler(this.performSortButton_Click);
            // 
            // takeDrinkButton
            // 
            this.takeDrinkButton.Location = new System.Drawing.Point(44, 120);
            this.takeDrinkButton.Name = "takeDrinkButton";
            this.takeDrinkButton.Size = new System.Drawing.Size(146, 66);
            this.takeDrinkButton.TabIndex = 2;
            this.takeDrinkButton.Text = "Take a Drink";
            this.takeDrinkButton.UseVisualStyleBackColor = true;
            this.takeDrinkButton.Click += new System.EventHandler(this.takeDrinkButton_Click);
            // 
            // makeNoiseButton
            // 
            this.makeNoiseButton.Location = new System.Drawing.Point(228, 120);
            this.makeNoiseButton.Name = "makeNoiseButton";
            this.makeNoiseButton.Size = new System.Drawing.Size(146, 65);
            this.makeNoiseButton.TabIndex = 3;
            this.makeNoiseButton.Text = "Make Noise";
            this.makeNoiseButton.UseVisualStyleBackColor = true;
            this.makeNoiseButton.Click += new System.EventHandler(this.makeNoiseButton_Click);
            // 
            // somethingGoodButton
            // 
            this.somethingGoodButton.Location = new System.Drawing.Point(228, 36);
            this.somethingGoodButton.Name = "somethingGoodButton";
            this.somethingGoodButton.Size = new System.Drawing.Size(146, 65);
            this.somethingGoodButton.TabIndex = 4;
            this.somethingGoodButton.Text = "Do Something Charitable";
            this.somethingGoodButton.UseVisualStyleBackColor = true;
            this.somethingGoodButton.Click += new System.EventHandler(this.somethingGoodButton_Click);
            // 
            // LogUIForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(420, 220);
            this.Controls.Add(this.somethingGoodButton);
            this.Controls.Add(this.makeNoiseButton);
            this.Controls.Add(this.takeDrinkButton);
            this.Controls.Add(this.performComplicatedTaskButton);
            this.Name = "LogUIForm";
            this.Text = "DI and IoC Example";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button performComplicatedTaskButton;
        private System.Windows.Forms.Button takeDrinkButton;
        private System.Windows.Forms.Button makeNoiseButton;
        private System.Windows.Forms.Button somethingGoodButton;
    }
}

