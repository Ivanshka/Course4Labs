using PVI_6.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PVI_6
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
