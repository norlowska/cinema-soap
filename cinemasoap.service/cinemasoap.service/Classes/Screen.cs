using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class Screen
    {
        private Guid screenID;

        private string screenName;
        private int screenSize;
        private List<Seat> seats;

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