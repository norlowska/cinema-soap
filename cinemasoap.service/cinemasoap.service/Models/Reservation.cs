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

namespace cinemasoap.service.Models
{
    [DataContract]
    public class Reservation
    {
        [DataMember]
        public Guid reservationID;
        [DataMember]
        public User user;
        [DataMember]
        public Screening screening;
        [DataMember]
        public List<Seat> seats;
        [DataMember]
        public bool deleted;

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

        public Byte[] bookScreening(Screening screening, List<Seat> bookedSeats) //w argumecnie/broszurze trzeba przekazać na jaki seans oraz jake siedzenia rezerwujesz oraz uzytkownika
        {
            if (checkSeats(bookedSeats) != 1) return null;
            else
            {
                CinemaContext cinemaContext = CinemaContext.GetContext();
                Reservation newReservation = new Reservation();
                newReservation.user = this.user;
                newReservation.screening = screening;
                newReservation.seats = bookedSeats;
                foreach(Seat s in seats)
                {
                    cinemaContext.Seats.Add(s);
                }
                return preparePDF(newReservation);
                
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
                    return Seat.screen == screening.screen && Seat.row == seatsTab[i][0] && Seat.innerSeat == seatsTab[i][1];
                }
                ));
            }
            return seatsList;
        }

        private int checkSeats(List<Seat> bookedSeats)
        {
            CinemaContext cinemaContext = CinemaContext.GetContext();

            foreach (Seat bs in bookedSeats)
            {
                foreach (Seat s in cinemaContext.Seats)
                {
                    if (bs.row == s.row)
                    {
                        return -1;
                    }
                    else continue;
                }
            }
            return 1;
        }

        private Byte[] preparePDF(Reservation reservation)
        {
            try
            {
                TextWriter writeFile = new StreamWriter("Text.txt");

                writeFile.WriteLine("Reservation no. " + Guid.NewGuid());
                writeFile.WriteLine();
                writeFile.WriteLine("Movie: " + reservation.screening.movie.title);
                writeFile.WriteLine("Data: " + reservation.screening.getDate() + " ,Time: " + reservation.screening.getTime());
                writeFile.WriteLine("Screen no. " + reservation.screening.screen.getScreenID());
                writeFile.WriteLine("Seats: ");
                foreach(Seat s in seats)
                {
                    writeFile.WriteLine("Seat: " + s.innerSeat + ", Row: " + s.row);
                }
                writeFile.WriteLine();
                writeFile.WriteLine("User:");
                writeFile.WriteLine("Email: " + reservation.user.email);
                writeFile.WriteLine("First Name " + reservation.user.firstName);
                writeFile.WriteLine("Last Name " + reservation.user.lastName);
                writeFile.WriteLine("ID " + reservation.user.userID);

                writeFile.Close();
                writeFile = null;

                string line = null;
                TextReader readFile = new StreamReader("Text.txt");
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

                string pdfFilename = "txttopdf.pdf";
                pdf.Save(pdfFilename);
                readFile.Close();
                readFile = null;
                //Process.Start(@"cmd.exe ", @"/c txttopdf.pdf");
                string pdfFilePath = "txttopdf.pdf";
                byte[] bytes = System.IO.File.ReadAllBytes(pdfFilePath);
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
            if (clearSeats(this.seats) != 1) return false;
            else
            {
                CinemaContext cinemaContext = CinemaContext.GetContext();
                cinemaContext.Reservations.Remove(this);
                this.user.reservations.Remove(this);
            }
            return true;
        }

        private int clearSeats(List<Seat> canceledSeats)
        {
            try
            {
                CinemaContext cinemaContext = CinemaContext.GetContext();
                foreach (Seat cs in canceledSeats)
                {
                    cinemaContext.Seats.Remove(cs);
                }
                return 1;
            }
            catch
            {
                return -1;
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

        public int editReservation(Reservation editedReservation)   //return 1 if function was successful and -1 when occurs any errors
        {
            CinemaContext cinema = CinemaContext.GetContext();
            foreach(Reservation r in cinema.Reservations)
            {
                if(r.reservationID == editedReservation.reservationID)
                {
                    if (checkSeats(editedReservation.seats) != 1) return -1; //check if editedReservation's seats aren't already taken
                    else
                    {
                        r.seats = editedReservation.seats;
                        clearSeats(r.seats);    //deleted old seats
                        foreach (Seat s in editedReservation.seats)  //add seats from editedReservation
                        {
                            cinema.Seats.Add(s);
                        }

                        r.screening = editedReservation.screening;
                        r.user = editedReservation.user;
                        return 1;
                    }
                }
            }
            return -1;
        }
    }
}