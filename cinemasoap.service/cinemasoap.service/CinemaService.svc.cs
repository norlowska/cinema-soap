using cinemasoap.service.Models;
using cinemasoap.service.Results;
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
        public List<Screening> GetRepertoire(DateTime date)
        {
            return Screening.GetRepertoire(date);
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

        public bool EditReservation(Reservation newReservation)
        {            
            return Reservation.editReservation(newReservation);
        }

        /// <summary>
        /// Rezerwacja miejsc na seans filmowy
        /// </summary>
        /// <param name="screeningID">Identyfikator seansu</param>
        /// <param name="chosenSeats">Tablica wybranych miejsc </param>
        /// <param name="userID"></param>
        /// <returns></returns>
        public FileContentResult BookScreening(Guid screeningID, List<Seat> chosenSeats, Guid userID)
        {
            try
            {
                Screening screening = Screening.GetById(screeningID);
                if (screening != null)
                {
                    Reservation newReservation = Reservation.bookScreening(screening, chosenSeats, userID);
                    if (newReservation == null) return new FileContentResult { Message = "Wybrane miejsca są zajęte." };
                    byte[] pdfBytes = newReservation.preparePDF();
                    if (pdfBytes == null) return new FileContentResult { Message = "Wystąpił błąd podczas generowania potwierdzenia rezerwacji." };
                    return new FileContentResult { Content = pdfBytes };
                }
                return new FileContentResult { Message = "Nie znaleziono seansu."};
            }
            catch (Exception ex)
            {
                return new FileContentResult { Message = "Wystąpił błąd podczas rezerwowania miejsc. " + ex.Message };
            }
        }

        public List<Reservation> GetReservationList(User user)
        {
            return user.getReservationsList();
        }
    }
}
