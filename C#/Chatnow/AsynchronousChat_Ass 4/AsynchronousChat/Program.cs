using System.Windows.Forms;
using NewLogger;
//using Logger;
using Unity;
using StructureMap;

namespace AsynchronousChat
{
    class Program
    {
        //For library Logger.
        //private static readonly log4net.ILog log = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        static void Main(string[] args)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            //-----------------Structuremap-------------------- -
            //var container = new Container(
            //    c =>
            //    {
            //        c.For<ILoggingService>().Use<TextFileLogger>();
            //    }
            //    );
            //Application.Run(container.GetInstance<Network_Game>());



            //------------------Unity---------------------------
            UnityContainer container = new UnityContainer();
            //container.RegisterType<ILoggingService, TextFileLogger>();
            container.RegisterType<ILoggingService, Logging>();
            Application.Run(container.Resolve<Network_Game>());



            //------------------log4net---------------
            //UnityContainer container = new UnityContainer();
            //container.RegisterType<ILoggingService, ConsoleLoggerwithlog4net>();
            //Application.Run(container.Resolve<Network_Game>());
        }
    }
}
