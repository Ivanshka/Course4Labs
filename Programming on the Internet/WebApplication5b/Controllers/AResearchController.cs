using WebApplication5b.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5b.Controllers
{
    public class AResearchController : Controller
    {
        [MyAction]
        [Route("ares/AA")]
        public ActionResult AA()
        {
            return View();
        }


        [Route("ares/AR")]
        [MyResult]
        public ActionResult AR()
        {
            return View();
        }

        [IndexException]
        [Route("ares/AE")]
        public ActionResult AE()
        {
            throw new Exception("Some exception");
            return View();
        }
    }
}