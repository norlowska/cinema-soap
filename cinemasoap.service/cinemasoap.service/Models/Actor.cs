using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Actor
    {
        public Guid actorID;
        [DataMember]
        public string firstName = "";
        [DataMember]
        public string secondName = "";
        [DataMember]
        public string lastName = "";
        public bool deleted=false;
        public string FullName { get { return firstName + " " + lastName; } }

        public Actor()
        {
            actorID = Guid.NewGuid();
            firstName = null;
            secondName = null;
            lastName = null;

            deleted = false;
        }

        public void setFirstName(string name)
        {
            firstName = name;
        }

        public string getFirstName()
        {
            return firstName;
        }

        public void setSecondName(string name)
        {
            secondName = name;
        }

        public string getSecondName()
        {
            return secondName;
        }

        public void setLastName(string name)
        {
            lastName = name;
        }

        public string getLastName()
        {
            return lastName;
        }

        public Guid getActorID()
        {
            return actorID;
        }

        public static Actor GetById(Guid id)
        {
            return CinemaContext.GetContext().Actors.Where(item => item.actorID == id).FirstOrDefault();
        }
    }
}