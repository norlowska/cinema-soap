using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Web;

namespace cinemasoap.service.Models
{
    public class User
    {
        public Guid userID =  Guid.NewGuid();
        public string email;
        public string password;
        public string firstName;
        public string secondName; // dodałem ekstra zmienną- w przyszłości można dodać do dziedziczenia z klasy osoba
        public string lastName;
        public List<Reservation> reservations;

        public bool deleted = false;

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

        /// <summary>
        /// Rejestracja użytkownika
        /// </summary>
        /// <param name="user">Użytkownik</param>
        /// <returns>Wartość logiczna, czy zarejestrowano użytkownika</returns>
        public static bool SignUp(User user)
        {
            if (user != null)
            {
                user.password = HashPassword(user.password);
                CinemaContext.GetContext().Users.Add(user);
            }
            return false;
        }

        /// <summary>
        /// Szyfrowanie hasła
        /// </summary>
        /// <param name="password">Hasło użytkownika</param>
        /// <returns>Zaszyfrowane hasło</returns>
        private static string HashPassword(string password)
        {
            byte[] salt;
            new RNGCryptoServiceProvider().GetBytes(salt = new byte[16]);
            var pbkdf2 = new Rfc2898DeriveBytes(password, salt, 100000);
            byte[] hash = pbkdf2.GetBytes(20);
            byte[] hashBytes = new byte[36];
            Array.Copy(salt, 0, hashBytes, 0, 16);
            Array.Copy(hash, 0, hashBytes, 16, 20);
            return Convert.ToBase64String(hashBytes);
        }

        /// <summary>
        /// Weryfikowanie hasła użytkownika
        /// </summary>
        /// <param name="user">Użytkownik</param>
        /// <param name="pass">Podane hasło</param>
        /// <returns>Wartość logiczna, czy podano prawidłowe hasło</returns>
        private bool VerifyPassword(User user, string pass)
        {
            byte[] hashBytes = Convert.FromBase64String(user.password);
            byte[] salt = new byte[16];
            Array.Copy(hashBytes, 0, salt, 0, 16);
            var pbkdf2 = new Rfc2898DeriveBytes(password, salt, 100000);
            byte[] hash = pbkdf2.GetBytes(20);
            for (int i = 0; i < 20; i++)
                if (hashBytes[i + 16] != hash[i])
                    return false;
            return true;
        }
    }
}