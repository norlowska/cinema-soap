using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [Serializable]
    [DataContract]
    public class Seat
    {
        public Guid SeatID;
        public Screen screen;
        [DataMember]
        public int Row;
        [DataMember]
        public int SeatNumber;

        public Seat()
        {
            SeatID = Guid.NewGuid();

            screen = null;
            Row = 1;
            SeatNumber = 1;
        }

        public void setScreen(Screen newScreen)
        {
            screen = newScreen;
        }

        public Screen GetScreen()
        {
            return screen;
        }

        public void setRow(int num)
        {
            Row = num;
        }

        public int getRow()
        {
            return Row;
        }

        public Guid getSeatID()
        {
            return SeatID;
        }
    }
}