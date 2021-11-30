using PVI_6.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace PVI_6
{
    public class ContactContext : DbContext
    {

        public static ContactContext Db { get; private set; } = new ContactContext();

        private ContactContext() : base("testDB")
        {

        }

        public DbSet<Contact> Contacts { get; set; }
    }
}