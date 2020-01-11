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

namespace AsynchronousChat
{

    public partial class Network_Game : Form
    {
        AsynchronousClient clientpc;
        Socket clientt;
        public static string messagesent;
        public static string messagereceived;
        public Thread t;
        public Thread s;
        public Network_Game()
        {
            clientpc = new AsynchronousClient("127.0.0.1", 11000);
            clientpc.Sent += clientpc.writesentmessage;
            clientpc.Sent += PrintMessageSent;
            clientpc.Received += clientpc.writereceivedmessage;
            clientpc.Received += PrintMessageReceived;
            messagesent = "";
            messagereceived = "";
            InitializeComponent();            
        }        

        public void btnSend_Click(object sender, EventArgs e)
        {
            clientpc.messagesent = textMessage.Text;
            s = new Thread(new ThreadStart(MessageSend));
            s.Start();
            textMessage.Clear();
            //MessageSend();            
        }

        public void MessageSend()
        {
            clientpc.Send(clientt);
        }

        private void PrintMessageSent(string msgsnt)
        {
            string m = textBox.Text;
            string s2 = m + Environment.NewLine + ">>" + clientpc.messagesent;
            writesafesend(s2);          
            t = new Thread(new ThreadStart(MessageReceive));
            t.Start();
        }

        private void writesafe(string text)
        {
            if(textBox.InvokeRequired)
            {
                var d = new SafeCallDelegate(writesafe);
                textBox.Invoke(d, new object[] { text });
            }
            else
            {
                textBox.Text = text;
            }
        }

        private void writesafesend(string text)
        {
            if (textBox.InvokeRequired)
            {
                var d = new SafeCallDelegate(writesafesend);
                textBox.Invoke(d, new object[] { text });
            }
            else
            {
                textBox.Text = text;
            }
        }

        public void MessageReceive()
        {
            clientpc.Receive(clientt);           
        }

        private void PrintMessageReceived(string msgrcv)
        {
            string s1 = textBox.Text;
            if(clientpc.messagereceived!="" || clientpc.messagereceived != "quit" || clientpc.messagereceived != "Quit")
            {
                string s2 = s1 + Environment.NewLine + "Server: " + clientpc.messagereceived;
                writesafe(s2);
            }
        }

        public void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                messagesent = "Quit";
                Thread tend = new Thread(shutconnection);
                tend.Start();
                
            }
            catch(Exception)
            {

            }
            System.Windows.Forms.Application.Exit();
        }

        public void shutconnection()
        {
            if(t.IsAlive)
            {
                t.Suspend();
            }
            if (s.IsAlive)
            {
                s.Suspend();
            }            
            clientt.Shutdown(SocketShutdown.Both);
            clientt.Close();            
        }


        public void connectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            clientpc.StartClient();
            clientt = clientpc.client; 
            btnSend.Enabled = true;
            textBox.Text = "Connected to Server ...";
            btnSend.Enabled = true;
            textMessage.Focus();
            clientpc.namenewlogfile();
            t = new Thread(new ThreadStart(MessageReceive));
            t.Start();
        }

        public void disconnectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            clientt.Shutdown(SocketShutdown.Both);
            clientt.Close();
        }
        

        private void textMessage_TextChanged(object sender, EventArgs e)
        {

        }

        private void listBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
    }
}
