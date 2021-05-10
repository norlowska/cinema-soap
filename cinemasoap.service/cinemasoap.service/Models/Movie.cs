using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Drawing;
using cinemasoap.service.Models;
using System.Runtime.Serialization;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Movie
    {
        public Guid movieID;
        [DataMember]
        public String title; //tytuł filmu
        [DataMember]
        public String desc; //Opis fiomu
        [DataMember]
        public byte[] imageData;
        [DataMember]
        public List<Character> characters;
        [DataMember]
        public List<CrewMember> crew;
        public bool deleted = false; //zmienna logiczna

        public void setTitle(String newTitle)
        {
            title = newTitle;
        }

        public string getTitle()
        {
            return title;
        }

        public void setDesc(String newDesc)
        {
            desc = newDesc;
        }

        public string getDesc()
        {
            return desc;
        }

        public void AddCharacter(Character character)
        {
            this.characters.Add(character);
        }

        public List<Character> getCharacterList()
        {
            return characters;
        }

        public void AddCrewMember(CrewMember member)
        {
            crew.Add(member);
        }

        public List<CrewMember> getCrewMemberList()
        {
            return crew;
        }

        public Guid getMovieID()
        {
            return movieID;
        }

        public static List<Movie> GetRepertoire(CinemaContext dc, DateTime date)
        {
            return dc.Screenings.Where(item => item.fullDate.ToString("yyyy-MM-dd") == date.ToString("yyyy-MM-dd")).Select(item => item.movie).ToList();
        }

        public static Movie GetById(Guid id)
        {
            return CinemaContext.GetContext().Movies.Where(item => item.movieID == id).FirstOrDefault();
        }
    }
}