using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace WebApplication3.Models
{
    public class ContactsHolder
    {
        private const String jsonFile = "D:/contacts.json";

        [JsonInclude]
        public List<Contact> JsonDatabase { get; set; } = null;
        public ContactsHolder()
        {
            if (File.Exists(jsonFile))
            {
                JsonDatabase = ReadAllContactsFromJsonFile(jsonFile);
            }
            else
            {
                JsonDatabase = new List<Contact>();
                WriteAllContactsInJsonFile(jsonFile);
            }
        }

        public Contact Find(String id)
        {
            return JsonDatabase.FirstOrDefault(contact => contact.Id.Equals(id));
        }

        public Contact Insert(Contact contact)
        {
            contact.Id = Guid.NewGuid().ToString();

            JsonDatabase.Add(contact);

            WriteAllContactsInJsonFile(jsonFile);

            return contact;
        }

        public Contact Update(Contact contact)
        {
            Contact oldContact = Find(contact.Id);

            if (oldContact == null)
            {
                return null;
            }

            JsonDatabase.Remove(oldContact);

            oldContact.Lastname = contact.Lastname;
            oldContact.PhoneNumber = contact.PhoneNumber;

            JsonDatabase.Add(contact);

            WriteAllContactsInJsonFile(jsonFile);

            return oldContact;
        }

        public Contact Delete(Contact contact)
        {
            Contact oldContact = Find(contact.Id);

            if (oldContact == null)
            {
                return null;
            }

            JsonDatabase.Remove(oldContact);

            WriteAllContactsInJsonFile(jsonFile);

            return oldContact;
        }

        public Contact[] GetAllContacts()
        {
            return JsonDatabase.ToArray();
        }

        private void DeleteJsonFile(String jsonFile)
        {
            if (File.Exists(jsonFile))
            {
                File.Delete(jsonFile);
            }

        }

        private void WriteAllContactsInJsonFile(String jsonFile)
        {
            String json = JsonSerializer.Serialize<List<Contact>>(JsonDatabase);
            File.WriteAllText(jsonFile, json);
        }

        private List<Contact> ReadAllContactsFromJsonFile(String jsonFile)
        {
            String json = File.ReadAllText(jsonFile);
            return JsonSerializer.Deserialize<List<Contact>>(json);
        }
    }
}