using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication4.Models
{
    public class ContactsHolder
    {
        private ContactContext db = ContactContext.Db;

        public ContactsHolder()
        {

        }

        public Contact Find(String id)
        {
            return db.Contacts.FirstOrDefault(contact => contact.Id.Equals(id));
        }

        public Contact Insert(Contact contact)
        {
            contact.Id = Guid.NewGuid().ToString();

            db.Contacts.Add(contact);

            db.SaveChanges();

            return contact;
        }

        public Contact Update(Contact contact)
        {
            Contact oldContact = Find(contact.Id);

            if (oldContact == null)
            {
                return null;
            }

            oldContact.Lastname = contact.Lastname;
            oldContact.PhoneNumber = contact.PhoneNumber;

            db.SaveChanges();

            return oldContact;
        }

        public Contact Delete(Contact contact)
        {
            Contact oldContact = Find(contact.Id);

            if (oldContact == null)
            {
                return null;
            }

            db.Contacts.Remove(oldContact);

            db.SaveChanges();

            return oldContact;
        }

        public Contact[] GetAllContacts()
        {
            return db.Contacts.ToArray();
        }

    }
}