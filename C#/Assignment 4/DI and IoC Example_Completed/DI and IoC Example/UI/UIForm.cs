using Logger;
using System;
using System.Windows.Forms;
using TaskExecutors;

namespace UI
{
    public partial class UIForm : Form
    {
        private IDrink drinker;// = new WaterDrinker(new ConsoleLogger());
        private IComplicated genius;// = new MedicalResearcher(new TextFileLogger());
        private ICharitable niceGuy;// = new DoGooder(new ConsoleLogger());
        private INoisy noiseMaker;// = new CarHorn(new TextFileLogger());

        public UIForm(IDrink drinker, IComplicated researcher,
                        ICharitable doGooder, INoisy horn)
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
            drinker.TakeADrink();
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