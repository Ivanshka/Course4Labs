using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5b.Filters
{
    public class IndexException : FilterAttribute, IExceptionFilter
    {

        public void OnException(ExceptionContext exceptionContext)
        {
            if (!exceptionContext.ExceptionHandled)
            {
                exceptionContext.HttpContext.Response.Write("Exception message " + exceptionContext.Exception.Message);

                exceptionContext.ExceptionHandled = true;
            }
        }
    }
}