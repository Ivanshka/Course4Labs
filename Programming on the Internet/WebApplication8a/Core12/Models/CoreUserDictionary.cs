using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
{
    public class CoreUserDictionary : IUserDictionary
    {
        CoreContext db;
        Random random = new Random();

        public CoreUserDictionary(CoreContext db)
        {
            this.db = db;
        }

        public User Delete(int id)
        {
            User user = db.User.Remove(db.User.Find(id)).Entity;

            db.SaveChanges();

            return user;
        }

        public User Find(int id)
        {
            return db.User.Find(id);
        }

        public Users GetAllUsers()
        {
            Users users = new Users();
            users.UsersList = db.User.ToList();
            return users;
        }

        public User Insert(User user)
        {
            User newUser = db.User.Add(user).Entity;

            db.SaveChanges();

            return newUser;
        }

        public User Update(User user)
        {
            User updatedUser = db.User.Update(user).Entity;

            db.SaveChanges();

            return updatedUser;
        }
    }
}
