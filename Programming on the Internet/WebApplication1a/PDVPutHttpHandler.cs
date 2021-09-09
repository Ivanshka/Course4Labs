using System;
using System.Web;

namespace WebApplication1a
{
    public class PDVPutHttpHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {

            string result = "<p>PUT-Http-PDV:ParmA = "
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
