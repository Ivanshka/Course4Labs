using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5b.Filters
{
    public class MyResultAttribute : FilterAttribute, IResultFilter
    {
        public void OnResultExecuted(ResultExecutedContext filterContext)
        {

            filterContext.HttpContext.Response.Write("Before result is returned " + filterContext.HttpContext.Request.HttpMethod);
        }

        public void OnResultExecuting(ResultExecutingContext filterContext)
        {

            filterContext.HttpContext.Response.Write("After result is returned " + filterContext.HttpContext.Response.StatusCode);
        }
    }
}