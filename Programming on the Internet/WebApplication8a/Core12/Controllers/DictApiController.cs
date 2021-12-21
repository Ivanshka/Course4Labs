using Core12.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DictApiController : ControllerBase
    {
        private IPhoneDictionary holder;

        public DictApiController(IPhoneDictionary holder)
        {
            this.holder = holder;
        }

        [HttpGet]
        public IEnumerable<Contact> GetContacts()
        {
            return holder.GetAllContacts();
        }

        [HttpGet("{id}")]
        public Contact GetContact(String id)
        {
            return holder.Find(id);
        }

        [HttpPost]
        public Contact PostContact(Contact contact)
        {
            return holder.Insert(contact);
        }
        
        [HttpDelete]
        public Contact DeleteContact(Contact contact)
        {
            return holder.Delete(contact);
        }
        
        [HttpPut]
        public Contact PutContact(Contact contact)
        {
            return holder.Update(contact);
        }
    }
}
