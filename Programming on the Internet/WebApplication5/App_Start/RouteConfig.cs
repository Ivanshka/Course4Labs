using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace WebApplication5
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "C01",
                url: "CResearch/{action}",
                defaults: new { controller = "CResearch", action = "C01" }
            );

            routes.MapRoute(
                name: "M03b",
                url: "V3/{controller}/X/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M03", id = UrlParameter.Optional }
            );

            //routes.MapRoute(
            //    name: "M03",
            //    url: "V3/{controller}/{action}/{id}",
            //    defaults: new { controller = "MResearch", action = "M03", id = UrlParameter.Optional }
            //);


            routes.MapRoute(
                name: "M03",
                url: "V3/",
                defaults: new { controller = "MResearch", action = "M03" }
            );

            routes.MapRoute(
                name: "M02",
                url: "V2/{controller}/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M02", id = UrlParameter.Optional }
            );

            routes.MapRoute(
                name: "M01",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M01", id = UrlParameter.Optional }
            );

        }
    }
}
