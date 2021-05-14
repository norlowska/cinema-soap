﻿using cinemasoap.service.Models;
using cinemasoap.service.SoapDTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace cinemasoap.service
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface ICinemaService
    {
        [OperationContract]
        [WebInvoke(ResponseFormat =WebMessageFormat.Json)]
        List<Screening> GetRepertoire(string date);

        [OperationContract]
        bool SignUp(User user);

        [OperationContract]
        [UsernamePasswordAuthentication]
        bool CancelReservation(Guid id);

        [OperationContract]
        [UsernamePasswordAuthentication]
        bool EditReservation(EditReservationRequestDTO newReservation);

        [OperationContract]
        [UsernamePasswordAuthentication]
        FileContentResponseDTO BookScreening(Guid screeningID, List<Seat> chosenSeats, Guid userID);

        [OperationContract]
        [UsernamePasswordAuthentication]
        List<Reservation> GetReservationList(Guid userId);

        [OperationContract]
        [UsernamePasswordAuthentication]
        FileContentResponseDTO GetMoviePoster(Guid movieId);
    }
}
