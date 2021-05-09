using cinemasoap.service.Models;
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
        [DataMember]
        public Guid screeningID;
        [DataMember]
        public Movie movie; //odwołanie do filmu
        [DataMember]
        public string date { get { return fullDate.ToString("DD/MM/YYYY"); } } //zmienna pomocnicza- wyswietla datę w stringu
        [DataMember]
        public string time { get { return fullDate.ToString("HH:mm"); } } //zmienna pomocnicza- wyswietla godzinę w stringu
        [DataMember]
        public DateTime fullDate;   //pełna data, do przekazania w argumecnie do konstruktora!
        [DataMember]
        public Screen screen;
        [DataMember]
        public bool deleted = false;

        public Screening()
        {

        }

        public Screening(Guid movieId, DateTime movieScreeningDate)
        {
            screeningID = Guid.NewGuid();
            fullDate = movieScreeningDate;
            CinemaContext dc = CinemaContext.GetContext();
            movie = dc.Movies.Where(item => item.movieID == movieId).FirstOrDefault();
            deleted = false;
        }
    }
}