using cinemasoap.service.Models;
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
        [UsernamePasswordAuthentication]
        [WebInvoke(ResponseFormat =WebMessageFormat.Json)]
        List<Movie> GetRepertoire(string date);

        [OperationContract]
        bool SignUp(User user);

        [OperationContract]
        [UsernamePasswordAuthentication]
        bool CancelReservation(Guid id);

        [OperationContract]
        [UsernamePasswordAuthentication]
        FileContentResponseDTO EditReservation(EditReservationRequestDTO newReservation);

        [OperationContract]
        [UsernamePasswordAuthentication]
        FileContentResponseDTO BookScreening(Guid screeningID, List<Seat> chosenSeats, string email);

        [OperationContract]
        [UsernamePasswordAuthentication]
        List<Reservation> GetReservationList(string email);

        [OperationContract]
        [UsernamePasswordAuthentication]
        FileContentResponseDTO GetMoviePoster(Guid movieId);
    }
}
