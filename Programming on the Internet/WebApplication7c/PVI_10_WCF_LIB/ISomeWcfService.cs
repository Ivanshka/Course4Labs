using PVI_7b.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace PVI_10_WCF_LIB
{

    [ServiceContract]
    public interface ISomeWcfService
    {
        [OperationContract]
        string HelloWorld();

        [OperationContract]
        Contact[] GetDict();

        [OperationContract]
        Contact AddDict(Contact contact);
 
        [OperationContract]
        Contact PutDict(Contact contact);

        [OperationContract]
        Contact DeleteDict(Contact contact);
    }
}
