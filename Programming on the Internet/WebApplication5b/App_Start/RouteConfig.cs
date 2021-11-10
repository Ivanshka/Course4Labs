using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Mvc.Routing.Constraints;
using System.Web.Routing;

namespace WebApplication5b
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapMvcAttributeRoutes();

            routes.MapRoute(
                 name: "M04post",
                 url: "it/{id}",
                 defaults: new { controller = "MResearch", action = "M04post" },
                 constraints: new { 
                     id = @"^\w*[@]\w*$",
                     httpcontr = new HttpMethodConstraint("POST")
                 }
            );

            routes.MapRoute(
                 name: "M01B",
                 url: "it/{id}/{str}",
                 defaults: new { controller = "MResearch", action = "M01B"},
                 constraints: new
                 {
                     httpcontr = new HttpMethodConstraint("GET"),
                     id = new IntRouteConstraint(),
                     str = @"^[a-zA-Z]+$"
                 }
             );

            routes.MapRoute(
             name: "M03",
             url: "it/{id}/{str}",
             defaults: new { controller = "MResearch", action = "M03" },
             constraints: new
                {
                     httpcontr = new HttpMethodConstraint("GET", "DELETE"),
                     id = new FloatRouteConstraint(),
                    str = @"^[a-zA-Z]+$"
             }
             );

            routes.MapRoute(
                 name: "M02",
                 url: "it/{id}/{letters}",
                 defaults: new { controller = "MResearch", action = "M02" },
                 constraints: new
                 {
                     httpcontr = new HttpMethodConstraint("GET","POST"),
                     id = new BoolRouteConstraint(),
                     letters = @"^[a-zA-Z]+$"
                 });

            routes.MapRoute(
                 name: "M04put",
                 url: "it/{letters}/{id}",
                 defaults: new { controller = "MResearch", action = "M04put" },
                 constraints: new
                 {
                     httpcontr = new HttpMethodConstraint("PUT"),
                     letters = @"^[a-zA-Z]+$",
                     id = new IntRouteConstraint()
                 }
             );

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

            routes.MapRoute(
                name: "M01",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M01", id = UrlParameter.Optional }
            );

/*
            routes.MapRoute(
                name: "AResearch",
                url: "ares/{action}",
                defaults: new { controller = "AResearch", action = "AA" }
            );

            routes.MapRoute(
                name: "CHResearch",
                url: "chres/{action}",
                defaults: new { controller = "CHResearch", action = "AD" }
            );
*/

        }
    }
}
