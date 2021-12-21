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
    public class UserController : ControllerBase
    {
        private IUserDictionary holder;

        public UserController(IUserDictionary holder)
        {
            this.holder = holder;
        }

        /// <summary>
        /// Get users
        /// </summary>
        /// <param name="id"></param>
        /// <response code="201">201 CREATED</response>
        /// <response code="400">400 Bad Request</response>
        [ProducesResponseType(typeof(Users), 201)]
        [ProducesResponseType(typeof(Users), 400)]
        [HttpGet]
        public Users GetUsers()
        {
            return holder.GetAllUsers();
        }

        /// <summary>
        /// Get user
        /// </summary>
        /// <param name="id"></param>
        /// <response code="201">201 CREATED</response>
        /// <response code="400">400 Bad Request</response>
        [ProducesResponseType(typeof(User), 201)]
        [ProducesResponseType(typeof(User), 400)]
        [HttpGet("{id}")]
        public User GetUser(int id)
        {
            return holder.Find(id);
        }

        /// <summary>
        /// Post user
        /// </summary>
        /// <param name="id"></param>
        /// <response code="201">201 CREATED</response>
        /// <response code="400">400 Bad Request</response>
        [ProducesResponseType(typeof(User), 201)]
        [ProducesResponseType(typeof(User), 400)]
        [HttpPost]
        public User PostUser(User user)
        {
            return holder.Insert(user);
        }

        /// <summary>
        /// Delete user
        /// </summary>
        /// <param name="id"></param>
        /// <response code="201">201 CREATED</response>
        /// <response code="400">400 Bad Request</response>
        [ProducesResponseType(typeof(User), 201)]
        [ProducesResponseType(typeof(User), 400)]
        [HttpDelete("{id}")]
        public User DeleteUser(int id)
        {
            return holder.Delete(id);
        }

        /// <summary>
        /// Put user
        /// </summary>
        /// <param name="id"></param>
        /// <response code="201">201 CREATED</response>
        /// <response code="400">400 Bad Request</response>
        [ProducesResponseType(typeof(User), 201)]
        [ProducesResponseType(typeof(User), 400)]
        [HttpPut]
        public User PutContact(User user)
        {
            return holder.Update(user);
        }
    }
}
