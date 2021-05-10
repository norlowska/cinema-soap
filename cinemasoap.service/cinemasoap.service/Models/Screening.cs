﻿using cinemasoap.service.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Screening
    {
        public Guid screeningID;
        [DataMember]
        public Movie movie; //odwołanie do filmu
        public string date; //zmienna pomocnicza- wyswietla datę w stringu
        public string time; //zmienna pomocnicza- wyswietla godzinę w stringu
        [DataMember]
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
                return screen.seats.Where(item => ReservedSeats.All(i => i.SeatID != item.SeatID)).ToList();
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
            this.movie = movie;
            this.screen = screen;
            deleted = false;
        }

        public static List<Screening> GetRepertoire(DateTime date)
        {
            var x = CinemaContext.GetContext().Screenings.Where(item => item.fullDate.ToString("yyyy-MM-dd") == date.ToString("yyyy-MM-dd")).ToList();
            return x;
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
    }
}