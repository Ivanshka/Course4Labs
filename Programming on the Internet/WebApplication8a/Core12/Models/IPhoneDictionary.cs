using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
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
