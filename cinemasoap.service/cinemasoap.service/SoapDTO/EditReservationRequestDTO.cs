using cinemasoap.service.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.SoapDTO
{
    [DataContract]
    public class EditReservationRequestDTO
    {
        [DataMember]
        public Guid reservationID;
        [DataMember]
        public List<Seat> seats;
    }
}