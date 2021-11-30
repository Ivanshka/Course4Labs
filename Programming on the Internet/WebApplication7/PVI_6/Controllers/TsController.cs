using PVI_6.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace PVI_6.Controllers
{
    public class TsController : ApiController
    {
        private IPhoneDictionary phoneDictionary = new ContactsHolderJson();
        public TsController()
        {
        }

        public IEnumerable<Contact> GetAllContacts()
        {
            return phoneDictionary.GetAllContacts();
        }

        public Contact PostContact(Contact contact)
        {
            return phoneDictionary.Insert(contact);
        }

        public Contact PutContact(Contact contact)
        {
            return phoneDictionary.Update(contact);
        }

        public Contact DeleteContact(Contact contact)
        {
            return phoneDictionary.Delete(contact);
        }
    }
}
