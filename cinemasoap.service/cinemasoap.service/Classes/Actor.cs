using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class Actor
    {
        private Guid actorID;
        private string firstName;
        private string secondName;
        private string lastName;

        public bool deleted;

        public Actor()
        {
            actorID = Guid.NewGuid(); ;
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
    }
}