using System;
using System.Web;

namespace WebApplication1a
{
    public class GetPostHttpHandler : IHttpHandler
    {
        public bool IsReusable
        {
            get { return true; }
        }

        public void ProcessRequest(HttpContext context)
        {

            if (context.Request.HttpMethod.Equals("GET"))
            {
                context.Response.Redirect("/FirstPage.html");
            }
            else if (context.Request.HttpMethod.Equals("POST"))
            {
                string paramX = context.Request.Params.Get("X");
                string paramY = context.Request.Params.Get("Y");
                int x;
                int y;

                context.Response.ContentType = "text/plain";

                if (int.TryParse(paramX, out x) && int.TryParse(paramY, out y))
                {
                    int sum = x * y;
                    context.Response.Write(sum);

                    return;
                }

                context.Response.Write("Invalid params");
            }
        }
    }
}
