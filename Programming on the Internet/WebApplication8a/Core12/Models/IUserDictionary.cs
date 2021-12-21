using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
{
    public interface IUserDictionary
    {
        User Find(int id);

        User Insert(User user);

        User Update(User user);

        User Delete(int id);

        Users GetAllUsers();
    }
}
