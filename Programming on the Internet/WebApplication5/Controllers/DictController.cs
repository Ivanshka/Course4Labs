using WebApplication5.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication5.Controllers
{
    public class DictController : Controller
    {
        static ContactsHolder holder = new ContactsHolder();

        public ActionResult Index()
        {
            ViewBag.allContacts = holder.GetAllContacts();

            return View("Index");
        }

        public ActionResult Add()
        {
            return View();
        }

        public ActionResult AddSave(String lastname, String phoneNumber)
        {
            String method = this.HttpContext.Request.HttpMethod;

            if (method.Equals("POST"))
            {
                Contact contact = new Contact(lastname, phoneNumber);

                holder.Insert(contact);
            }

            return Index();
        }

        public ActionResult Update(String id)
        {
            Contact contact = holder.Find(id);

            if (contact != null)
            {
                ViewBag.contact = contact;
                return View();
            }

            return View();
        }

        public ActionResult UpdateSave(String id, String lastname, String phoneNumber)
        {
            Contact contact = new Contact(id, lastname, phoneNumber);

            holder.Update(contact);

            return Index();
        }

        public ActionResult Delete()
        {
            ViewBag.allContacts = holder.GetAllContacts();

            return View();
        }

        public ActionResult DeleteSave(String id)
        {
            Contact contact = holder.Find(id);

            if (contact != null)
            {
                holder.Delete(contact);
            }

            return Index();
        }
    }
}