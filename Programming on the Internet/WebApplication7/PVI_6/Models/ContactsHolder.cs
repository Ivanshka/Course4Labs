﻿//using System;
//using System.Collections.Generic;
//using System.IO;
//using System.Linq;
//using System.Text.Json;
//using System.Text.Json.Serialization;

//namespace PVI_6.Models
//{
//    public class ContactsHolder : IPhoneDictionary
//    {
//        private static int atomicInt = 0; // it should be atomic var
//        private ContactContext db = ContactContext.Db;

//        public ContactsHolder()
//        {
//            if(atomicInt == 0)
//            {
//                System.IO.File.WriteAllText(@"d:\log.txt", "[" + DateTime.Now.ToString() + "] Application was started\n");
//            }
//            atomicInt++;

//            System.IO.File.AppendAllText(@"d:\log.txt", "[" + DateTime.Now.ToString() + "] I have been instantiated " + atomicInt + " times \n");
//        }

//        public Contact Find(String id)
//        {
//            return db.Contacts.FirstOrDefault(contact => contact.Id.Equals(id));
//        }

//        public Contact Insert(Contact contact)
//        {
//            contact.Id = Guid.NewGuid().ToString();

//            db.Contacts.Add(contact);

//            db.SaveChanges();

//            return contact;
//        }

//        public Contact Update(Contact contact)
//        {
//            Contact oldContact = Find(contact.Id);

//            if (oldContact == null)
//            {
//                return null;
//            }

//            oldContact.Lastname = contact.Lastname;
//            oldContact.PhoneNumber = contact.PhoneNumber;

//            db.SaveChanges();

//            return oldContact;
//        }

//        public Contact Delete(Contact contact)
//        {
//            Contact oldContact = Find(contact.Id);

//            if (oldContact == null)
//            {
//                return null;
//            }

//            db.Contacts.Remove(oldContact);

//            db.SaveChanges();

//            return oldContact;
//        }

//        public Contact[] GetAllContacts()
//        {
//            return db.Contacts.ToArray();
//        }

//    }
//}