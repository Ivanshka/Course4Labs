using System;
using System.Text.Json.Serialization;

namespace WebApplication3.Models
{
    public class Contact : IComparable<Contact>
    {
        [JsonInclude]
        public String Id { get; set; }
        [JsonInclude]
        public String Lastname { get; set; }
        [JsonInclude]
        public String PhoneNumber { get; set; }

        public Contact()
        {

        }

        public Contact(String lastname, String phonenumber)
        {
            Lastname = lastname;
            PhoneNumber = phonenumber;
        }

        public Contact(String id, String lastname, String phonenumber) : this(lastname, phonenumber)
        {
            Id = id;
        }

        public Contact(Contact contact)
        {
            if (contact == null)
            {
                throw new NullReferenceException();
            }
            this.Id = contact.Id;
            this.Lastname = contact.Lastname;
            this.PhoneNumber = contact.PhoneNumber;
        }

        public int CompareTo(Contact contact)
        {
            return Lastname.CompareTo(contact.Lastname);
        }
    }

}