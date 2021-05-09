using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Models
{
    public class Reservation
    {
        public Guid reservationID;
        public User user;
        public Screening screening;
        public List<Seat> seats;

        public bool deleted;

        public Reservation()
        {
            reservationID = Guid.NewGuid();
            user = null;
            screening = null;
            deleted = false;
            seats = new List<Seat>();
        }

        public void setUser(User newUser)
        {
            user = newUser;
        }

        public User getUser()
        {
            return user;
        }

        public void setScreening(Screening newScreening)
        {
            screening = newScreening;
        }

        public Screening getScreening()
        {
            return screening;
        }

        public void addSeat(Seat seat)
        {
            seats.Add(seat);
        }

        public List<Seat> getSeatsList()
        {
            return seats;
        }

        public Guid getReservationID()
        {
            return reservationID;
        }

        public void bookScreening(Screening screening, User user, List<Seat> bookedSeats) //w argumecnie/broszurze trzeba przekazać na jaki seans oraz jake siedzenia rezerwujesz oraz uzytkownika
        {
            if (checkSeats(bookedSeats) != 1) return;
            else
            {
                Reservation newReservation = new Reservation();
                newReservation.user = user;
                newReservation.screening = screening;
                newReservation.seats = bookedSeats;


            }
        }

        private int checkSeats(List<Seat> bookedSeats)
        {
            CinemaContext cinemaContext = CinemaContext.GetContext();

            foreach (Seat bs in bookedSeats)
            {
                foreach (Seat s in cinemaContext.Seats)
                {
                    if (bs.row == s.row)
                    {
                        return -1;
                    }
                    else continue;
                }
            }
            return 1;
        }

        private void preparePDF(Reservation reservation)
        {

        }
    }
}