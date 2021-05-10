using PdfSharp.Drawing;
using PdfSharp.Pdf;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;
using System.Xml.Linq;
using System.Text;
using cinemasoap.service.SoapDTO;

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Reservation
    {
        public Guid reservationID;
        [DataMember]
        public User user;
        [DataMember]
        public Screening screening;
        [DataMember]
        public List<Seat> seats;
        [DataMember]
        public bool deleted = false;

        public Reservation()
        {
            reservationID = Guid.NewGuid();
            user = null;
            screening = null;
            deleted = false;
            seats = new List<Seat>();
        }

        public void setUser(User newUser)
        {
            user = newUser;
        }

        public User getUser()
        {
            return user;
        }

        public void setScreening(Screening newScreening)
        {
            screening = newScreening;
        }

        public Screening getScreening()
        {
            return screening;
        }

        public void addSeat(Seat seat)
        {
            seats.Add(seat);
        }

        public List<Seat> getSeatsList()
        {
            return seats;
        }

        public Guid getReservationID()
        {
            return reservationID;
        }

        public static Reservation bookScreening(Screening screening, List<Seat> chosenSeats, Guid userID) //w argumecnie/broszurze trzeba przekazać na jaki seans oraz jake siedzenia rezerwujesz oraz uzytkownika
        {
            if (screening.checkSeats(chosenSeats)) return null;
            else
            {
                CinemaContext cinemaContext = CinemaContext.GetContext();
                Reservation newReservation = new Reservation();
                User user = User.GetById(userID);
                newReservation.user = user;
                newReservation.screening = screening;
                chosenSeats.ForEach(item => item.SeatID = cinemaContext.Seats.Where(i => i.screen.screenID == screening.screen.screenID && i.Row == item.Row && i.SeatNumber == item.SeatNumber).FirstOrDefault().SeatID);
                newReservation.seats = chosenSeats;
                user.reservations.Add(newReservation);
                cinemaContext.Reservations.Add(newReservation);
                return newReservation;                
            }
        }

        public List<Seat> ConvertSeatsTabToList(Guid sID, int[][] seatsTab)
        {
            List<Seat> seatsList = new List<Seat>();
            CinemaContext cinemaContext = CinemaContext.GetContext();
            Screening screening = Screening.GetById(sID);
            for (int i =0; i<seatsTab.Length; i++)
            {
                seatsList.Add(cinemaContext.Seats.FirstOrDefault(Seat => 
                {
                    return Seat.screen == screening.screen && Seat.Row == seatsTab[i][0] && Seat.SeatNumber == seatsTab[i][1];
                }
                ));
            }
            return seatsList;
        }

        public Byte[] preparePDF()
        {
            try
            {
                string filePath = Path.Combine(System.Configuration.ConfigurationManager.AppSettings["AppDataPath"], $"Reservation{this.reservationID}");
                TextWriter writeFile = new StreamWriter(filePath + ".txt");

                writeFile.WriteLine("Reservation no. " + Guid.NewGuid());
                writeFile.WriteLine();
                writeFile.WriteLine("Movie: " + this.screening.movie.title);
                writeFile.WriteLine("Data: " + this.screening.date + " ,Time: " + this.screening.time);
                writeFile.WriteLine("Screen no. " + this.screening.screen.screenName);
                writeFile.WriteLine("Seats: ");
                foreach(Seat s in seats)
                {
                    writeFile.WriteLine("Seat: " + s.SeatNumber + ", Row: " + s.Row);
                }
                writeFile.WriteLine();
                writeFile.WriteLine("User:");
                writeFile.WriteLine("Email: " + this.user.email);
                writeFile.WriteLine("First Name " + this.user.firstName);
                writeFile.WriteLine("Last Name " + this.user.lastName);
                //writeFile.WriteLine("ID " + this.user.userID);

                writeFile.Close();
                writeFile = null;

                string line = null;
                TextReader readFile = new StreamReader(filePath + ".txt");
                int yPoint = 0;

                PdfDocument pdf = new PdfDocument();
                pdf.Info.Title = "TXT to PDF";
                PdfPage pdfPage = pdf.AddPage();
                XGraphics graph = XGraphics.FromPdfPage(pdfPage);
                XFont font = new XFont("Verdana", 20, XFontStyle.Regular);

                while (true)
                {
                    line = readFile.ReadLine();
                    if (line == null)
                    {
                        break; // TODO: might not be correct. Was : Exit While
                    }
                    else
                    {
                        graph.DrawString(line, font, XBrushes.Black, new XRect(40, yPoint, pdfPage.Width.Point, pdfPage.Height.Point), XStringFormats.TopLeft);
                        yPoint = yPoint + 40;
                    }
                }

                pdf.Save(filePath + ".pdf");
                readFile.Close();
                readFile = null;
                //Process.Start(@"cmd.exe ", @"/c txttopdf.pdf");
                byte[] bytes = System.IO.File.ReadAllBytes(filePath + ".pdf");
                return bytes;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
                return null;
            }
        }

        public bool cancelReservation()
        {
            try { 
                CinemaContext cinemaContext = CinemaContext.GetContext();
            this.user.reservations.Remove(this);
            cinemaContext.Reservations.Remove(this);
            return true;
            } catch(Exception ex)
            {
                return false;
            }
        }

        /// <summary>
        /// Pobranie rezerwacji na podstawie identyfikatora
        /// </summary>
        /// <param name="id">Identyfikator</param>
        /// <returns></returns>
        public static Reservation GetById(Guid id)
        {
            return CinemaContext.GetContext().Reservations.Where(item => item.reservationID == id).FirstOrDefault();
        }

        public static bool editReservation(EditReservationRequestDTO editedReservation)   //return 1 if function was successful and -1 when occurs any errors
        {
            CinemaContext cinemaContext = CinemaContext.GetContext();
            Reservation originalReservation = cinemaContext.Reservations.Where(item => item.reservationID == editedReservation.reservationID).FirstOrDefault();
            if (originalReservation != null)
            {
                if (originalReservation.screening.checkSeats(editedReservation.seats)) return false; //check if editedReservation's seats aren't already taken
                else
                {
                    editedReservation.seats.ForEach(item => item.SeatID = cinemaContext.Seats.Where(i => i.screen.screenID == originalReservation.screening.screen.screenID && i.Row == item.Row && i.SeatNumber == item.SeatNumber).FirstOrDefault().SeatID);
                    originalReservation.seats = editedReservation.seats;
                    return true;
                }
            }
            return false;
        }
    }
}