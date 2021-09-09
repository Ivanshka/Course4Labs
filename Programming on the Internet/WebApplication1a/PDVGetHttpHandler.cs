using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;

namespace WebApplication1a
{
    public class PDVGetHttpHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
            string result = "<p>GET-Http-PDV:ParmA = "
                + context.Request.Params.Get("ParmA")
                + ", ParmB = " + context.Request.Params.Get("ParmB")
                + "</p>";
            context.Response.ContentType = "text/plain";
            context.Response.Write(result);
        }
        public bool IsReusable
        {
            get { return true; }
        }
    }
}
