using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace PVI_7b.Models
{
    public class ContactsHolderSql : IPhoneDictionary
    {
        private static int atomicInt = 0; // it should be atomic var
        private static Object objLock = new Object();
        private ContactContext db = ContactContext.Db;

        public ContactsHolderSql()
        {

            lock (objLock)
            {
                if (atomicInt == 0)
                {
                    System.IO.File.WriteAllText(@"d:\log.txt", "[" + DateTime.Now.ToString() + "] Application was started\n");
                }
                atomicInt++;
            }

            System.IO.File.AppendAllText(@"d:\log.txt", "[" + DateTime.Now.ToString() + "] I have been instantiated " + atomicInt + " times \n");
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