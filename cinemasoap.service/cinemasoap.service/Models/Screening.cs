using cinemasoap.service.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [Serializable]
    [DataContract]
    public class Screening
    {
        [DataMember]
        public Guid screeningID;
        [DataMember]
        public Movie movie; //odwołanie do filmu
        public string date; //zmienna pomocnicza- wyswietla datę w stringu
        public string time; //zmienna pomocnicza- wyswietla godzinę w stringu
        [DataMember(IsRequired = true)]
        public DateTime fullDate;   //pełna data, do przekazania w argumecnie do konstruktora!
        [DataMember]
        public Screen screen;
        private List<Seat> _reservedSeats;
        public List<Seat> ReservedSeats
        {
            get
            {
                return CinemaContext.GetContext().Reservations.Where(item => item.screening.screeningID == this.screeningID).SelectMany(item => item.seats).ToList();
            }
        }
        private List<Seat> _freeSeats;
        [DataMember]
        public List<Seat> FreeSeats
        {
            get
            {
                return screen.seats != null ? screen.seats.Where(item => ReservedSeats.All(i => i.SeatID != item.SeatID)).ToList() : null ;
            }
            set
            {
                _freeSeats = value;
            }
        }
        public bool deleted = false;

        public Screening()
        {

        }

        public Screening(Guid id, DateTime date, Movie movie, Screen screen)
        {
            screeningID = id;
            fullDate = date;
            this.date = getDate();
            time = getTime();
            this.movie = ExtensionMethods.DeepClone<Movie>(movie);
            this.screen = screen;
            deleted = false;
        }

        public string getDate()
        {
            return fullDate.ToString("yyyy-MM-dd");
        }

        public string getTime()
        {
            return fullDate.ToString("HH:mm");
        }

        public static Screening GetById(Guid id)
        {
            return CinemaContext.GetContext().Screenings.Where(item => item.screeningID == id).FirstOrDefault();
        }

        /// <summary>
        /// Sprawdzenie czy wybrane miejsca na seans istnieją i są zarezerwowane
        /// </summary>
        /// <param name="reservedSeats"></param>
        /// <param name="chosenSeats"></param>
        /// <returns>Prawda, jeśli którekolwiek z miejsc jest już zarezerwowane</returns>
        public bool checkSeats(List<Seat> chosenSeats)
        {
            return chosenSeats.Any(item => !screen.seats.Exists(i => i.Row == item.Row && i.SeatNumber == item.SeatNumber) || this.ReservedSeats.Any(i => i.Row == item.Row && i.SeatNumber == item.SeatNumber));
        }

        /// <summary>
        /// Sprawdzenie czy wybrane miejsca na seans istnieją i są zarezerwowane (przez kogoś innego niż rezerwujący użytkownik)
        /// </summary>
        /// <param name="reservedSeats"></param>
        /// <param name="chosenSeats"></param>
        /// <returns>Prawda, jeśli którekolwiek z miejsc jest już zarezerwowane</returns>
        public bool checkSeatsForEdit(List<Seat> chosenSeats, Guid userId)
        {
            return chosenSeats.Any(item => !screen.seats.Exists(i => i.Row == item.Row && i.SeatNumber == item.SeatNumber) || CinemaContext.GetContext().Reservations.Any(i => i.getUser().getUserID() != userId && i.getSeatsList().Any(ii => ii.Row == item.Row && ii.SeatNumber == item.SeatNumber)));
        }
    }
}