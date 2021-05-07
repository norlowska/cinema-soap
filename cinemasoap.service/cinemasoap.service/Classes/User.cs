using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class User
    {
        private Guid userID;
        private string email;
        private string password;
        private string firstName;
        private string secondName; // dodałem ekstra zmienną- w przyszłości można dodać do dziedziczenia z klasy osoba
        private string lastName;
        private List<Reservation> reservations;

        public bool deleted;

        public User()
        {
            userID = Guid.NewGuid();
            email = null;
            password = null;
            firstName = null;
            secondName = null;
            lastName = null;
            reservations = new List<Reservation>();

            deleted = false;
        }

        public void setEmail(string newEmail)
        {
            email = newEmail;
        }

        public string getEmail()
        {
            return email;
        }

        public void setPassowrd(string newPassowrd)
        {
            password = newPassowrd;
        }

        public string getPassword()
        {
            return password;
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

        public void addReservation(Reservation reservation)
        {
            reservations.Add(reservation);
        }

        public List<Reservation> getReservationsList()
        {
            return reservations;
        }

        public Guid getUserID()
        {
            return userID;
        }
    }
}