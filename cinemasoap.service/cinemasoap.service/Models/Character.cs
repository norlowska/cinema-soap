﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Character
    {
        public Guid characterID;
        [DataMember]
        public string characterName = "";
        [DataMember]
        public Actor actor;
        public bool deleted = false;
        public Guid movieID;

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

        public string getCharacterName()
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