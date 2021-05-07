using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class Screening
    {
        public Guid screeningID;
         
        private Movie movie; //odwołanie do filmu
        private string date; //zmienna pomocnicza- wyswietla datę w stringu
        private string time; //zmienna pomocnicza- wyswietla godzinę w stringu
        private DateTime fulldDate;   //pełna data, do przekazania w argumecnie do konstruktora!

        public bool deleted;
        
        public Screening(DateTime movieScreeningDate)
        {
            screeningID = Guid.NewGuid(); ;
            fulldDate = movieScreeningDate;
           
            movie = null;
            date = getDate();
            time = getTime();
            deleted = false;
        }

        public void setMovie(Movie newMovie)
        {
            movie = newMovie;
        }

        public Movie getMovie()
        {
            return movie;
        }

        public void setFullDate(DateTime newDate)
        {
            fulldDate = newDate;
        }

        public string getDate()
        {
            return fulldDate.ToString("DD/MM/YYYY");
        }

        public string getTime()
        {
            return fulldDate.ToString("HH:mm");
        }

        public Guid getScreeningID()
        {
            return screeningID;
        }
    }
}