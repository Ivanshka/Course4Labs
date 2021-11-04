using WebApplication5.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WebApplication5
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