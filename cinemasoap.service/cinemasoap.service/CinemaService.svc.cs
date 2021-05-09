using cinemasoap.service.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace cinemasoap.service
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class CinemaSoap : ICinemaService
    {
        /// <summary>
        /// Pobranie repertuaru w podanym dniu
        /// </summary>
        /// <param name="date">Data</param>
        /// <returns>Lista filmów wraz z seansami w danym dniu</returns>
        public List<Movie> GetRepertoire(DateTime date)
        {
            CinemaContext dc = CinemaContext.GetContext();
            return Movie.GetRepertoire(dc, date);
        }

        /// <summary>
        /// Rejestracja użytkownika
        /// </summary>
        /// <param name="user">Model użytkownika z danymi</param>
        /// <returns></returns>
        public bool SignUp(User user)
        {
            return User.SignUp(user);
        }

        public bool CancelReservation(Guid id)
        {
            Reservation reservation = Reservation.GetById(id);
            if(reservation != null)
                return reservation.cancelReservation();
            return false;
        }
    }
}
