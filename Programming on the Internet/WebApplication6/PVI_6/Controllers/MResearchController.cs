using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Mvc;

namespace PVI_6.Controllers
{
    public class MResearchController : Controller
    {

        [Route("it/{n:int}/{str}")]
        [AcceptVerbs(HttpVerbs.Get)]
        public ActionResult M01B(int n, String str)
        {
            ViewBag.n = n;
            ViewBag.str = str;
            return View();
        }

        [Route("it/{b:bool}/{letters:alpha}")]
        [AcceptVerbs(HttpVerbs.Get | HttpVerbs.Post)]
        public ActionResult M02(bool b, String letters)
        {
            ViewBag.method = HttpContext.Request.HttpMethod;
            ViewBag.b = b;
            ViewBag.letters = letters;

            return View();
        }

        [Route("it/{f:float}/{str:length(2,5)}")]
        [AcceptVerbs(HttpVerbs.Get | HttpVerbs.Delete)]
        public ActionResult M03(float f, String str)
        {
            ViewBag.f = f;
            ViewBag.str = str;
            ViewBag.method = HttpContext.Request.HttpMethod;

            return View();
        }

        [Route("it/{str:length(3,4)}/{n:range(100,200)}")]
        [AcceptVerbs(HttpVerbs.Put)]
        public ActionResult M04(String str, int n)
        {
            ViewBag.method = HttpContext.Request.HttpMethod;
            ViewBag.letters = str;
            ViewBag.n = n;

            return View();
        }

        [Route(@"it/{mail:regex(^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$)}")]
        [AcceptVerbs(HttpVerbs.Post)]
        public ActionResult M04(String mail)
        {
            ViewBag.method = HttpContext.Request.HttpMethod;
            ViewBag.mail = mail;

            return View();
        }
    }
}