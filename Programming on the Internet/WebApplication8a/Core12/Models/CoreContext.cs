using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
{
    public class CoreContext : DbContext
    {

        public DbSet<Contact> Contact { get; set; }
        public DbSet<User> User { get; set; }
        public CoreContext(DbContextOptions<CoreContext> options)
            : base(options)
        {
            Database.EnsureCreated();   // создаем базу данных при первом обращении
        }
    }
}
