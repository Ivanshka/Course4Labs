using PVI_7b;
using PVI_7b.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace PVI_10_WCF_LIB
{
    [ServiceBehavior(IncludeExceptionDetailInFaults = true)]
    public class SomeWcfService : ISomeWcfService
    {

        IPhoneDictionary phoneDictionary = new ContactsHolderJson();

        public string HelloWorld()
        {
            return "Привет всем!";
        }

        public Contact[] GetDict()
        {
            return phoneDictionary.GetAllContacts().ToArray();
        }

        public Contact AddDict(Contact contact)
        {
            return phoneDictionary.Insert(contact);
        }

        public Contact PutDict(Contact contact)
        {
            return phoneDictionary.Update(contact);
        }
        
        public Contact DeleteDict(Contact contact)
        {
            return phoneDictionary.Delete(contact);
        }
    }
}
