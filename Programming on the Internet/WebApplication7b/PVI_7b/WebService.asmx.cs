using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using PVI_7b;
using PVI_7b.Models;

namespace PVI_7b
{
    /// <summary>
    /// Сводное описание для WebService
    /// </summary>
    [WebService(Namespace = "PVI_7b.Models")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Чтобы разрешить вызывать веб-службу из скрипта с помощью ASP.NET AJAX, раскомментируйте следующую строку. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService : System.Web.Services.WebService
    {
        IPhoneDictionary phoneDictionary = new ContactsHolderSql();

        [WebMethod]
        public string HelloWorld()
        {
            return "Привет всем!";
        }

        [WebMethod]
        public Contact[] GetDict()
        {
            return phoneDictionary.GetAllContacts().ToArray();
        }

        [WebMethod]
        public Contact AddDict(Contact contact)
        {
            return phoneDictionary.Insert(contact);
        }

        [WebMethod]
        public Contact PutDict(Contact contact)
        {
            return phoneDictionary.Update(contact);
        }

        [WebMethod]
        public Contact DeleteDict(Contact contact)
        {
            return phoneDictionary.Delete(contact);
        }
    }
}
