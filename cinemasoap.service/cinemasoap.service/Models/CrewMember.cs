using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [Serializable]
    [DataContract]
    public class CrewMember
    {
        public Guid crewMemberID;
        [DataMember(IsRequired = true)]
        public string firstName = "";
        [DataMember]
        public string secondName = "";
        [DataMember(IsRequired = true)]
        public string lastName = "";
        [DataMember(IsRequired = true)]
        public string job = ""; //można przerobić na enum'a? 
        public bool deleted = false; //zmienna logiczna
        public Guid movieID;

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
