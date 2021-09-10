using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WebApplication1a_Form
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private async void sendButton_Click(object sender, EventArgs e)
        {
            string uri = "https://localhost:44385/sum";

            var values = new Dictionary<string, string>
            {
                { "X", x.Text },
                { "Y", y.Text }
            };

            using (HttpClient client = new HttpClient())
            {
                try
                {
                    var content = new FormUrlEncodedContent(values);
                    var response = await client.PostAsync(uri, content);
                    var responseString = await response.Content.ReadAsStringAsync();
                    result.Text = responseString;
                }
                catch (Exception exception)
                {
                    result.Text = "try again: " + exception.Message;
                }
            }
        }
    }
}
