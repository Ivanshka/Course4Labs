using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI;

namespace WebApplication5b.Controllers
{
    public class CHResearchController : Controller
    {
        [HttpGet]
        [Route("chres/AD")]
        [OutputCache(Duration = 5, Location = OutputCacheLocation.Server)]
        public ActionResult AD()
        {
            ViewBag.time = DateTime.Now;
            return View();
        }

        [Route("chres/AP")]
        [OutputCache(Duration = 7, Location = OutputCacheLocation.Server,VaryByParam ="x;y")]
        [HttpPost]
        public ActionResult AP(int x, int y)
        {
            //Перемещение данных в более быструю память
            ViewBag.time = DateTime.Now;
            ViewBag.x = x;
            ViewBag.y = y;
            return View();
        }
    }
}