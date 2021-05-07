﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class CrewMember
    {
        private Guid crewMemberID;
        private string firstName;
        private string secondName;
        private string lastName;
        private string job; //można przerobić na enum'a?

        public bool deleted; //zmienna logiczna

        public CrewMember()
        {
            crewMemberID = Guid.NewGuid();
            firstName = null;
            secondName = null;
            lastName = null;
            job = null;

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

        public void setJob(string newjob)
        {
            job = newjob;
        }

        public string getJob()
        {
            return job;
        }
        
        public Guid getcrewMemberID()
        {
            return crewMemberID;
        }
    }
}
