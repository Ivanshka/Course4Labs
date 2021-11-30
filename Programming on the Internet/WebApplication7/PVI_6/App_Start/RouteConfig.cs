using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace PVI_6
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            //routes.MapMvcAttributeRoutes();

            routes.MapRoute(
                name: "AResearch",
                url: "{controller}",
                defaults: new { controller = "TsDefault", action = "Index" }
            );

            /*            routes.MapRoute(
                            name: "HW",
                            url: "{controller}/{action}",
                            defaults: new { controller = "Dict", action = "Index" }
                        );*/
        }
    }
}
