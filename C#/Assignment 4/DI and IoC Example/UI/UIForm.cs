using Logger;
using System;
using System.Windows.Forms;
using TaskExecutors;

namespace UI
{
    public partial class UIForm : Form
    {
        private WaterDrinker drinker;// = new WaterDrinker(new ConsoleLogger());
        private MedicalResearcher genius;// = new MedicalResearcher(new TextFileLogger());
        private DoGooder niceGuy;// = new DoGooder(new ConsoleLogger());
        private CarHorn noiseMaker;// = new CarHorn(new TextFileLogger());

        public UIForm(WaterDrinker drinker, MedicalResearcher researcher,
                        DoGooder doGooder, CarHorn horn)
        {
            this.drinker = drinker;
            this.genius = researcher;
            this.niceGuy = doGooder;
            this.noiseMaker = horn;
            InitializeComponent();
        }

        private void performSortButton_Click(object sender, EventArgs e)
        {
            genius.PerformComplicatedTask();
        }

        private void takeDrinkButton_Click(object sender, EventArgs e)
        {
            drinker.TakeDrink();
        }

        private void makeNoiseButton_Click(object sender, EventArgs e)
        {
            noiseMaker.MakeNoise();
        }

        private void somethingGoodButton_Click(object sender, EventArgs e)
        {
            niceGuy.DoSomethingGood();
        }
    }
}