using System;
using System.Windows.Forms;
using TaskExecutors;
using Logger;
namespace UI
{
    internal static class Program
    {
        /// <summary>
        ///     The main entry point for the application.
        /// </summary>
        [STAThread]
        private static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            // Water drinker for applicaiton
            ILoggable consoleLogger = new ConsoleLogger();
            ILoggable textLogger = new TextFileLogger();
            WaterDrinker drinker = new WaterDrinker(consoleLogger);
            MedicalResearcher researcher = new MedicalResearcher(textLogger);
            DoGooder doGooder = new DoGooder(consoleLogger);
            CarHorn carHorn = new CarHorn(textLogger);
            Application.Run(new UIForm(
                drinker, 
                researcher,
                doGooder,
                carHorn));
        }
    }
}