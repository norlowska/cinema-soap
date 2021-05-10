using cinemasoap.service.Models;
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
        List<Movie> GetRepertoire(DateTime date);

        [OperationContract]
        bool SignUp(User user);

        [OperationContract]
        [UsernamePasswordAuthentication]
        bool CancelReservation(Guid id);

        [OperationContract]
        [UsernamePasswordAuthentication]
        bool EditReservation(Reservation newReservation);

        [OperationContract]
        [UsernamePasswordAuthentication]
        byte[] BookScreening(Guid id, int[][] chosenSeats, Guid userID);

        [OperationContract]
        [UsernamePasswordAuthentication]
        List<Reservation> GetReservationList(User user);
    }
}
