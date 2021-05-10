using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Security.Cryptography;
using System.Web;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class User
    {
        [DataMember]
        public Guid userID =  Guid.NewGuid();
        [DataMember]
        public string email;
        [DataMember]
        public string password;
        [DataMember]
        public string firstName;
        [DataMember]
        public string secondName; // dodałem ekstra zmienną- w przyszłości można dodać do dziedziczenia z klasy osoba
        [DataMember]
        public string lastName;
        [DataMember]
        public List<Reservation> reservations;
        [DataMember]
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
        /// Pobranie użytkownika na podstawie adresu e-mail
        /// </summary>
        /// <param name="email">Adres e-mail</param>
        /// <returns>Model użytkownika</returns>
        public static User GetByEmail(string email)
        {
            return CinemaContext.GetContext().Users.Where(item => item.email == email).FirstOrDefault();
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
        /// Logowanie użytkownika
        /// </summary>
        /// <param name="email">Adres e-mail</param>
        /// <param name="password">Hasło</param>
        /// <returns>Wartość logiczna czy pomyślnie zalogowano</returns>
        public static bool SignIn(string email, string password)
        {
            User user = GetByEmail(email);
            if (user != null)
            {
                return user.VerifyPassword(password);
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
        /// <param name="pass">Podane hasło</param>
        /// <returns>Wartość logiczna, czy podano prawidłowe hasło</returns>
        private bool VerifyPassword(string pass)
        {
            byte[] hashBytes = Convert.FromBase64String(this.password);
            byte[] salt = new byte[16];
            Array.Copy(hashBytes, 0, salt, 0, 16);
            var pbkdf2 = new Rfc2898DeriveBytes(pass, salt, 100000);
            byte[] hash = pbkdf2.GetBytes(20);
            for (int i = 0; i < 20; i++)
                if (hashBytes[i + 16] != hash[i])
                    return false;
            return true;
        }

        public static User GetById(Guid id)
        {
            return CinemaContext.GetContext().Users.Where(item => item.userID == id).FirstOrDefault();
        }

        public List<Reservation> getReservation()
        {
            return reservations;
        }
    }
}