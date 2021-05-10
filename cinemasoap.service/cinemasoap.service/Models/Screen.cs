using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Screen
    {
        public Guid screenID;
        [DataMember]
        public string screenName;
        [DataMember]
        public int screenSize;
        public List<Seat> seats;
        public LinkedList<Screening> screenings;

        public Screen()
        {
            screenID = Guid.NewGuid();

            screenName = null;
            screenSize = 0;
            seats = new List<Seat>();
        }

        public void setScreenName(string name)
        {
            screenName = name;
        }

        public string getScreenName()
        {
            return screenName;
        }

        public void setScreenSize(int size)
        {
            screenSize = size;
        }

        public int getScreenSize()
        {
            return screenSize;
        }

        public Guid getID()
        {
            return screenID;
        }

        public List<Seat> getSeatsList()
        {
            return seats;
        }

        public Guid getScreenID()
        {
            return screenID;
        }
    }
}