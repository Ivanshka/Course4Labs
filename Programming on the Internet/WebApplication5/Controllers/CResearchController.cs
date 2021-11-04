using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5.Controllers
{
    public class CResearchController : Controller
    {
        [AcceptVerbs(HttpVerbs.Get | HttpVerbs.Post)]
        public ActionResult C01()
        {
            String method = HttpContext.Request.HttpMethod;
            String parameters = HttpContext.Request.QueryString.ToString();
            String url = HttpContext.Request.Url.ToString();
            String headers = HttpContext.Request.Headers.ToString();

            Stream req = Request.InputStream;
            req.Seek(0, System.IO.SeekOrigin.Begin);
            String body = new StreamReader(req).ReadToEnd();

            ViewBag.method = method;
            ViewBag.parameters = parameters;
            ViewBag.url = url;
            ViewBag.headers = headers;
            ViewBag.body = body;

            return View();
        }

        [AcceptVerbs(HttpVerbs.Get | HttpVerbs.Post)]
        public ActionResult C02()
        {
            String responseStatus = HttpContext.Response.StatusCode.ToString();
            String headers = HttpContext.Response.Headers.ToString();

            Stream req = Request.InputStream;
            req.Seek(0, System.IO.SeekOrigin.Begin);
            String body = new StreamReader(req).ReadToEnd();

            ViewBag.responseStatus = responseStatus;
            ViewBag.headers = headers;
            ViewBag.body = body;

            return View();
        }
    }
}