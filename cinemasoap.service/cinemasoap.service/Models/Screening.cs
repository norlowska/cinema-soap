using cinemasoap.service.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Models
{
    public class Screening
    {
        public Guid screeningID;         
        public Movie movie; //odwołanie do filmu
        public string date; //zmienna pomocnicza- wyswietla datę w stringu
        public string time; //zmienna pomocnicza- wyswietla godzinę w stringu
        public DateTime fullDate;   //pełna data, do przekazania w argumecnie do konstruktora!
        public bool deleted;

        public Screening(Guid movieId, DateTime movieScreeningDate)
        {
            screeningID = Guid.NewGuid();
            fullDate = movieScreeningDate;
            CinemaContext dc = CinemaContext.GetContext();
            movie = dc.Movies.Where(item => item.movieID == movieId).FirstOrDefault();
            date = getDate();
            time = getTime();
            deleted = false;
        }

        public string getDate()
        {
            return fullDate.ToString("DD/MM/YYYY");
        }

        public string getTime()
        {
            return fullDate.ToString("HH:mm");
        }
    }
}