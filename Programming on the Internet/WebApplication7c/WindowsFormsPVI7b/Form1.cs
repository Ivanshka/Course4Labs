using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.Xml.Serialization;

namespace WindowsFormsPVI7b
{
    public partial class Form1 : Form
    {
        SomeWcfServiceClient client = new SomeWcfServiceClient();
        public Form1()
        {
            InitializeComponent();
        }

        private void RefreshButton_Click(object sender, EventArgs e)
        {
            ContactsList.DataSource = client.GetDict();
        }

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            PVI_7b.Models.Contact contact = new PVI_7b.Models.Contact();
            contact.Id = DeleteId.Text;
            client.DeleteDict(contact);
        }

        private void SaveButton_Click(object sender, EventArgs e)
        {
            PVI_7b.Models.Contact contact = new PVI_7b.Models.Contact();
            contact.Id = UpdateId.Text;
            contact.Lastname = UpdateLastname.Text;
            contact.PhoneNumber = UpdatePhoneNumber.Text;
            client.AddDict(contact);
        }

        private void UpdateButton_Click(object sender, EventArgs e)
        {

            PVI_7b.Models.Contact contact = new PVI_7b.Models.Contact();
            contact.Id = UpdateId.Text;
            contact.Lastname = UpdateLastname.Text;
            contact.PhoneNumber = UpdatePhoneNumber.Text;
            client.PutDict(contact);

        }
    }
}
