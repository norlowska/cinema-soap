using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;

namespace cinemasoap.service.Models
{
    [Serializable]
    [DataContract]
    public class Movie
    {
        [DataMember]
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
        [DataMember]
        public List<Screening> screenings;

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

        public static List<Movie> GetRepertoire(DateTime date)
        {
            CinemaContext dc = CinemaContext.GetContext();
            List<Movie> movies = dc.Movies.Where(item => item.screenings.Any(i => i.date == date.ToString("yyyy-MM-dd"))).Select(x => x.DeepClone()).ToList();
            foreach(var m in movies)
            {
                m.screenings = m.screenings.Where(item => item.date == date.ToString("yyyy-MM-dd")).Select(x=>x.DeepClone()).ToList();
            }
            return movies;
        }

        public static Movie GetById(Guid id)
        {
            return CinemaContext.GetContext().Movies.Where(item => item.movieID == id).FirstOrDefault();
        }
    }
}