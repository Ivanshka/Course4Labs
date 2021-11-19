using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5b.Controllers
{
    [RoutePrefix("it")]
    public class MResearchController : Controller
    {

        [HttpGet]
        public ActionResult M01()
        {
            return View();
        }

        [AcceptVerbs("get", "post")]
        [Route("{id:bool}/{letters:alpha}")]
        public ActionResult M02(bool id, string letters)
        {
            ViewBag.method = HttpContext.Request.HttpMethod;
            ViewBag.b = id;
            ViewBag.letters = letters;
            return View();
        }

        [AcceptVerbs("get", "delete")]
        //[HttpGet, HttpDelete]
        [Route("{id:float}/{str:minlength(2):maxlength(5)}")]
        public ActionResult M03(float id, String str)
        {
            ViewBag.method = HttpContext.Request.HttpMethod;
            ViewBag.f = id;
            ViewBag.letters = str;
            return View();
        }

        [HttpPut]
        [Route("{letters:alpha:minlength(3):maxlength(4)}/{id:int:range(100,200)}")]
        public ActionResult M04put(String letters, int id)
        {
            String method = HttpContext.Request.HttpMethod;
            ViewBag.letters = letters;
            ViewBag.n = id;
            return View();
        }
        
        [HttpPost]
        [Route("{id:regex(^\\w*[@]\\w*$)}")]
        public ActionResult M04post(String id)
        {
            String method = HttpContext.Request.HttpMethod;
            ViewBag.mail = id;
            return View();
        }

        [HttpGet]
        public ActionResult MXX()
        {
            return View();
        }
        
        [HttpGet]
        [Route("{id:int}/{str}")]
        public ActionResult M01B(int id, String str)
        {
            ViewBag.n = id;
            ViewBag.str = str;
            return View();
        }
    }
}