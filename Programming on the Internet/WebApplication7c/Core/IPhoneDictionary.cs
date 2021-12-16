using PVI_7b.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PVI_7b
{
    public interface IPhoneDictionary
    {
        Contact Find(String id);

        Contact Insert(Contact contact);

        Contact Update(Contact contact);

        Contact Delete(Contact contact);

        Contact[] GetAllContacts();
    }
}
