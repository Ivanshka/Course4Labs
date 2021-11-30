using Ninject.Modules;
using PVI_6.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PVI_6
{
    public class NinjectRegistrations : NinjectModule
    {
        public override void Load()
        {
            bool isSqlMode = false;

            if (isSqlMode)
            {
                Bind<IPhoneDictionary>().To<ContactsHolderSql>()
                    .InSingletonScope(); // 1
                                         //.InRequestScope(); // 2
                                         //.InTransientScope(); // 3;
            }
            else
            {
                Bind<IPhoneDictionary>().To<ContactsHolderJson>()
                    //.InSingletonScope(); // 1
                                         //.InThreadScope(); // 2
                                         .InTransientScope(); // 3
            }
        }
    }
}