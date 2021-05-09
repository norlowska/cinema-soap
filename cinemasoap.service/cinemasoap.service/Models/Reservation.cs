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

        public void bookScreening(Screening screening, User user, List<Seat> bookedSeats) //w argumecnie/broszurze trzeba przekazać na jaki seans oraz jake siedzenia rezerwujesz oraz uzytkownika
        {
            if (checkSeats(bookedSeats) != 1) return;
            else
            {
                Reservation newReservation = new Reservation();
                newReservation.user = user;
                newReservation.screening = screening;
                newReservation.seats = bookedSeats;

                preparePDF(newReservation);
            }
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

        private void preparePDF(Reservation reservation)
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
                Process.Start(@"cmd.exe ", @"/c txttopdf.pdf");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
        }

        public void cancelReservation(Reservation reservation)
        {
            if (clearSeats(reservation.seats) != 1) return;
            else
            {
                CinemaContext cinemaContext = CinemaContext.GetContext();
                cinemaContext.Reservations.Remove(reservation);
                reservation.user.reservations.Remove(reservation);
            }
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
    }
}