using System;
using System.Windows.Forms;
using System.Net.Sockets;
using System.Threading;
//using Logger;
using NewLogger;
using ChatLibrary;
using Delegates;

namespace AsynchronousChat
{
    /// <summary>
    /// Windows form class
    /// </summary>
    public partial class Network_Game : Form
    {
        AsynchronousClient clientpc;
        public Thread ThreadtoSendMessage;
        public Thread ThreadtoReceiveMessage;
        public bool loopcont;

        public Network_Game(ILoggingService textLogger) 
        {
            clientpc = new AsynchronousClient("127.0.0.1", 11000, textLogger);

            //Message sent event subscribers
            clientpc.Sent += clientpc.writesentmessage;
            clientpc.Sent += PrintMessageSent;

            //Message received event subscribers
            clientpc.Received += clientpc.writereceivedmessage;
            clientpc.Received += PrintMessageReceived;

            loopcont = true;
            InitializeComponent();            
        }

        //Function for exit button.
        public void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Shutconnection();
            System.Windows.Forms.Application.Exit();
        }

        //Function for connect button.
        public void connectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //Start connection.
            clientpc.StartClient();

            //Check if connection could be established 
            if (string.Compare(clientpc.ConnectionStatus, "Connected") == 0)
            {
                loopcont = true;

                //Enable send button.
                btnSend.Enabled = true;

                //Focus Text message write area
                textMessage.Focus();

                //Function call to create a new txt file for each new connection.
                //clientpc.createFile();

                //Thread to receive message
                ThreadtoReceiveMessage = new Thread(ReceiveMessageLoop);
                ThreadtoReceiveMessage.Start();

                //Start Sending Message
                SendMessage();

                //Make Disconnect button visible
                disconnectToolStripMenuItem.Visible = true;

                //Make connect button invisible
                connectToolStripMenuItem.Visible = false;
            }

            //Print if connection was successfull or not
            if (string.Compare(textBox.Text, "") == 0)
            {
                textBox.Text = clientpc.ConnectionStatus;
            }
            else
            {
                textBox.Text = textBox.Text + Environment.NewLine + clientpc.ConnectionStatus;
            }
        }

        //Function for disconnect button
        public void disconnectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Shutconnection();
        }

        //----------------------------------------------------------------------Send--------------------------------------------------------------
        //Function for Send button
        public void btnSend_Click(object sender, EventArgs e)
        {
            SendMessage();
        }

        public void SendMessage()
        {
            clientpc.messagesent = textMessage.Text;
            ThreadtoSendMessage = new Thread(new ThreadStart(SendMessageThreading));
            ThreadtoSendMessage.Start();
            textMessage.Clear();
        }

        public void SendMessageThreading()
        {
            clientpc.Send(clientpc.client);                        
        }

        //Function to print sent messages in textBox.
        private void PrintMessageSent(EventArgs args)
        {
            string textintextBox = textBox.Text;
            if(clientpc.messagesent!="")
            {
                string s = textintextBox + Environment.NewLine + ">>" + clientpc.messagesent;
                writesafe(s);
            }            
        }

//----------------------------------------------------------------------Send--------------------------------------------------------------


        //private void writesafesend(string text)
        //{
        //    if (textBox.InvokeRequired)
        //    {
        //        var d = new SafeCallDelegate(writesafesend);
        //        textBox.Invoke(d, new object[] { text });
        //    }
        //    else
        //    {
        //        textBox.Text = text;
        //    }
        //}        

//----------------------------------------------------------------------Receive--------------------------------------------------------------

        //Function to start messgae receiving loop
        public void ReceiveMessageLoop()
        {
            while (loopcont)
            {
                ReceiveMessage();

                if (string.Compare(clientpc.messagereceived, "Server connection unavailable") == 0)
                {
                    break;
                }
            }
        }

        public void ReceiveMessage()
        {
            clientpc.Receive(clientpc.client);
        }

        //Function to print received messages in textBox.
        private void PrintMessageReceived(EventArgs args)
        {
            string textintextBox = textBox.Text;
            string s = textintextBox + Environment.NewLine + "Server: " + clientpc.messagereceived;
            writesafe(s);                       
        }

//----------------------------------------------------------------------Receive--------------------------------------------------------------

        
        //Function to Shut down all the threads and socket
        public void Shutconnection()
        {
            try
            {
                btnSend.Enabled = false;
                disconnectToolStripMenuItem.Visible = false;
                connectToolStripMenuItem.Visible = true;
                loopcont = false;

                if (ThreadtoReceiveMessage.IsAlive)
                {
                    ThreadtoReceiveMessage.Abort();
                }                
                if (ThreadtoSendMessage.IsAlive)
                {
                    ThreadtoSendMessage.Abort();
                }

                clientpc.client.Shutdown(SocketShutdown.Both);
                clientpc.client.Close();
            }
            catch(Exception e)
            {
                Console.WriteLine(e.ToString());
            }                       
        }

        //Thread safe Form element handling
        private void writesafe(string text)
        {
            if (textBox.InvokeRequired)
            {
                var d = new SafeCallDelegate(writesafe);
                textBox.Invoke(d, new object[] { text });
            }
            else
            {
                textBox.Text = text;
            }
        }

        private void Network_Game_FormClosing(object sender, FormClosingEventArgs e)
        {
            Shutconnection();
            ThreadtoReceiveMessage.Join();
            ThreadtoSendMessage.Join();
            System.Windows.Forms.Application.Exit();
        }
    }
}
