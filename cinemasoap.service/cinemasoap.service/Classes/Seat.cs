using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class Seat
    {
        private Guid SeatID;
        private Screen screen;
        private int row;
        private int innerSeat;
        private Reservation reservation;

        public Seat()
        {
            SeatID = Guid.NewGuid();

            screen = null;
            row = 0;
            innerSeat = 0;
            reservation = null;
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
            row = num;
        }

        public int getRow()
        {
            return row;
        }

        public void setInnerSeat(int num)
        {
            innerSeat = num;
        }

        public int getInnerSeat()
        {
            return innerSeat;
        }

        public void setReservation(Reservation newReservation)
        {
            reservation = newReservation;
        }

        public Reservation getReservation()
        {
            return reservation;
        }

        public Guid getSeatID()
        {
            return SeatID;
        }
    }
}