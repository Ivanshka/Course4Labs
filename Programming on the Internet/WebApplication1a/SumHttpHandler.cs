using System;
using System.Web;

namespace WebApplication1a
{
    public class SumHttpHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
            string ParmA = context.Request.Params.Get("X");
            string ParmB = context.Request.Params.Get("Y");
            int x;
            int y;

            context.Response.ContentType = "text/plain";

            if (int.TryParse(ParmA, out x) && int.TryParse(ParmB, out y))
            {
                int sum = x + y;

                context.Response.Write(sum);

                return;
            }
            context.Response.Write("Invalid params");
        }
        public bool IsReusable
        {
            get { return true; }
        }
    }
}
