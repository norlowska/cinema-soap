using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Drawing;

namespace cinemasoap.service.Classes
{
    public class Movie
    {
        private Guid movieID;
        private String title; //tytuł filmu
        private String desc; //Opis fiomu
        private Image image; //Grafika 
        private List<Character> characters;
        private List<CrewMember> crew;

        public bool deleted; //zmienna logiczna

        public Movie()
        {
            movieID = Guid.NewGuid();
            title = null;
            desc = null;
            image = null;

            characters = new List<Character>();
            crew = new List<CrewMember>();
            deleted = false;
        }

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
            characters.Add(character);
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
    }
}