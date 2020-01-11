using System;
using System.Windows.Forms;
using TaskExecutors;
using Logger;
using Unity;

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
            // Register your objects, mapping them to interfaces.
            UnityContainer container = new UnityContainer();
            BeerDrinker homer = new BeerDrinker(new ConsoleLogger()); 
            container.RegisterType<ILoggable, ConsoleLogger>();
            //container.RegisterType<IDrink, BeerDrinker>();
            container.RegisterInstance<IDrink>(homer);
            container.RegisterType<ICharitable, BillGates>();
            //container.RegisterType<INoisy, BeerDrinker>();
            container.RegisterInstance<INoisy>(homer);
            container.RegisterType<IComplicated, RocketScientist>();
            
            Application.Run(container.Resolve<UIForm>());
        }
    }
}