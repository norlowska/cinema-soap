using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Drawing;
using cinemasoap.service.Models;

namespace cinemasoap.service.Models
{
    public class Movie
    {
        public Guid movieID;
        public String title; //tytuł filmu
        public String desc; //Opis fiomu
        public byte[] imageData;
        public Image image; //Grafika 
        public List<Character> characters;
        public List<CrewMember> crew;

        public bool deleted; //zmienna logiczna

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

        public void setImage()
        {
            //Trzeba dopisać metodę dodawania grafiki
        }

        public Image getImage()
        {
            return image;
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
            return dc.Screenings.Where(item => item.fullDate == date).Select(item => item.movie).ToList();
        }
    }
}