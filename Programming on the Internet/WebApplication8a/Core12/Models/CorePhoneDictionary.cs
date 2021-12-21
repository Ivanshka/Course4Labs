using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
{
    public class CorePhoneDictionary : IPhoneDictionary
    {

        CoreContext db;

        public CorePhoneDictionary(CoreContext db)
        {
            this.db = db;
        }

        public Contact Delete(Contact contact)
        {
            Contact ct = db.Contact.Remove(contact).Entity;

            db.SaveChanges();

            return ct;
        }

        public Contact Find(string id)
        {
            return db.Contact.Find(id);
        }

        public Contact[] GetAllContacts()
        {
            return db.Contact.ToArray();
        }

        public Contact Insert(Contact contact)
        {
            contact.Id = Guid.NewGuid().ToString();

            Contact ct = db.Contact.Add(contact).Entity;

            db.SaveChanges();

            return ct;
        }

        public Contact Update(Contact contact)
        {
            Contact ct = db.Contact.Update(contact).Entity;
            
            db.SaveChanges();

            return ct;
        }
    }
}
