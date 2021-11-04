using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5.Controllers
{
    public class MResearchController : Controller
    {

        [HttpGet]
        public ActionResult M01()
        {
            return View();
        }

        [HttpGet]
        public ActionResult M02()
        {
            return View();
        }

        [HttpGet]
        public ActionResult M03()
        {
            return View();
        }

        [HttpGet]
        public ActionResult MXX()
        {
            return View();
        }
    }
}