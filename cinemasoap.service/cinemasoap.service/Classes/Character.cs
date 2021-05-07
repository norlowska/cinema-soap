using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinemasoap.service.Classes
{
    public class Character
    {
        private Guid characterID;
        private string characterName;
        private Actor actor;

        public bool deleted; 

        public Character()
        {
            characterID = Guid.NewGuid();
            characterName = null;

            actor = null;
            deleted = false;
        }

        public void setCharacterName (string name)
        {
            characterName = name;
        }

        public string getCharacterName ()
        {
            return characterName;
        }

        public void setActor(Actor newActor)
        {
            actor = newActor;
        }

        public Actor getActor()
        {
            return actor;
        }

        public Guid getCharacterID()
        {
            return characterID;
        }
    }
}