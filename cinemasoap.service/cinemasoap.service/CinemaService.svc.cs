using cinemasoap.service.Models;
using cinemasoap.service.SoapDTO;
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

        public bool EditReservation(EditReservationRequestDTO newReservation)
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
        public FileContentResponseDTO BookScreening(Guid screeningID, List<Seat> chosenSeats, Guid userID)
        {
            try
            {
                Screening screening = Screening.GetById(screeningID);
                if (screening != null)
                {
                    Reservation newReservation = Reservation.bookScreening(screening, chosenSeats, userID);
                    if (newReservation == null) return new FileContentResponseDTO { Message = "Wybrane miejsca są zajęte." };
                    byte[] pdfBytes = newReservation.preparePDF();
                    if (pdfBytes == null) return new FileContentResponseDTO { Message = "Wystąpił błąd podczas generowania potwierdzenia rezerwacji." };
                    return new FileContentResponseDTO { Content = pdfBytes, Message = newReservation.reservationID.ToString() };
                }
                return new FileContentResponseDTO { Message = "Nie znaleziono seansu."};
            }
            catch (Exception ex)
            {
                return new FileContentResponseDTO { Message = "Wystąpił błąd podczas rezerwowania miejsc. " + ex.Message };
            }
        }

        /// <summary>
        /// Pobranie listy rezerwacji użytkownika
        /// </summary>
        /// <param name="user"></param>
        /// <returns></returns>
        public List<Reservation> GetReservationList(Guid id)
        {
            User user = User.GetById(id);
            if (user == null) return null;
            return user.reservations;
        }

        /// <summary>
        /// Pobranie szczegółów filmu
        /// </summary>
        /// <param name="user"></param>
        /// <returns></returns>
        public FileContentResponseDTO GetMoviePoster(Guid id)
        {
            Movie movie = Movie.GetById(id);
            if (movie == null) return new FileContentResponseDTO { Message = "Nie znaleziono filmu o podanym identyfikatorze" };
            return new FileContentResponseDTO { Content = movie.imageData };
        }
    }
}
