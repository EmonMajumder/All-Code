using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using ChatLibrary;
using Delegates;


namespace AsynchronousServerWindowsform
{
    public partial class Form1 : Form
    {
        AsynchronousSocketListener server;
        public Thread t;
        public Thread s;
        public Thread c;
        public Thread t1;
        public bool loopreceive;

        public Form1()
        {
            server = new AsynchronousSocketListener("127.0.0.1", 11000);
            server.Received += PrintMessageReceived;
            server.Connected += PrintConnected;
            loopreceive = true;
            InitializeComponent();
            c = new Thread(new ThreadStart(setConnection));
            c.Start();
        }

        public void setConnection()
        {
            writesafe("Waiting for new Connection...");
            server.StartListening();
        }

        public void MessageReceive()
        {
            server.Receive(server.Handler);
        }

        public void MessageReceiveLoop()
        {
            while (true)
            {
                t = new Thread(new ThreadStart(MessageReceive));
                t.Start();
                t.Join();

                if (string.Compare(server.messagereceived, "Client connection unavailable") == 0)
                {
                    break;
                }
            }
        }

        private void MessageBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            server.messagesent = MessageBox.Text;
            PrintMessageSent();
            s = new Thread(new ThreadStart(SendMessage));
            s.Start();
        }

        private void ChatBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void SendMessage()
        {
            server.Send(server.Handler);
        }

        private void PrintMessageReceived(string msgrcv)
        {
            string s1 = ChatBox.Text;
            if(string.Compare(server.messagereceived, "Client connection unavailable") == 0)
            {
                string s2 = s1 + Environment.NewLine + server.messagereceived;
                writesafe(s2);
            }
            else if(server.messagereceived!="")
            {
                string s2 = s1 + Environment.NewLine + "Client: " + server.messagereceived;
                writesafe(s2);
            }
        }

        private void PrintMessageSent()
        {
            string s1 = ChatBox.Text;
            if (server.messagesent != "")
            {
                string s2 = s1 + Environment.NewLine + ">> " + server.messagesent;
                ChatBox.Text = s2;
            }
            MessageBox.Clear();
        }

        private void writesafe(string text)
        {
            if (ChatBox.InvokeRequired)
            {
                var d = new SafeCallDelegate(writesafe);
                ChatBox.Invoke(d, new object[] { text });
            }
            else
            {
                ChatBox.Text = text;
            }
        }

        private void PrintConnected(string s)
        {
            string s1 = ChatBox.Text;
            string s2 = s1 + Environment.NewLine + "Connected";
            writesafe(s2);
            t1 = new Thread(MessageReceiveLoop);
            t1.Start();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        public void shutconnection()
        {
            loopreceive = false;
            try
            {
                if (t.IsAlive)
                {
                    t.Abort();
                }
                if (s.IsAlive)
                {
                    s.Abort();
                }
                if (t1.IsAlive)
                {
                    t1.Abort();
                }
                if (c.IsAlive)
                {
                    c.Abort();
                }
                server.Handler.Close();
                server.listener.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }                      
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            //shutconnection();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            shutconnection();
            t.Join();
            s.Join();
            System.Windows.Forms.Application.Exit();
        }

        private void startServerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            shutconnection();
            c = new Thread(new ThreadStart(setConnection));
            c.Start();
        }

        private void restartserver()
        {
            shutconnection();
            c = new Thread(new ThreadStart(setConnection));
            c.Start();
        }
    }
}
