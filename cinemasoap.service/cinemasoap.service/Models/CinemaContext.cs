
using System;
using System.Collections.Generic;

namespace cinemasoap.service.Models
{
    public class CinemaContext 
    {
        private static CinemaContext _context;
        private CinemaContext()
        {
            InitUsers();
            InitMovies();
            InitScreens();
            InitActors();
            InitCrewMembers();
            InitCharacters();
            InitScreenings();
            InitSeats();
            InitReservations();
        }

        /// <summary>
        /// Inicjalizacja listy aktorów
        /// </summary>
        public void InitActors()
        {
            Actors = new List<Actor>();
        }

        /// <summary>
        /// Inicjalizacja listy bohaterów
        /// </summary>
        public void InitCharacters()
        {
            Characters = new List<Character>();
        }

        /// <summary>
        /// Inicjalizacja listy członków ekipy filmowej
        /// </summary>
        public void InitCrewMembers()
        {
            CrewMembers = new List<CrewMember>();
        }

        /// <summary>
        /// Inicjalizacja listy filmów
        /// </summary>
        private void InitMovies()
        {
            Movies = new List<Movie>();
        }

        /// <summary>
        /// Inicjalizacja listy rezerwacji
        /// </summary>
        private void InitReservations()
        {
            Reservations = new List<Reservation>();
        }

        /// <summary>
        /// Inicjalizacja listy pokazów filmów
        /// </summary>
        private void InitScreenings()
        {
            Screenings = new List<Screening>();
        }

        /// <summary>
        /// Inicjalizacja listy sal kinowych
        /// </summary>
        private void InitScreens()
        {
            Screens = new List<Screen>();
        }

        /// <summary>
        /// Inicjalizacja listy siedzeń
        /// </summary>
        private void InitSeats()
        {
            Seats = new List<Seat>();
        }

        /// <summary>
        /// Inicjalizacja listy użytkowników
        /// </summary>
        private void InitUsers()
        {
            Users = new List<User>
            {
                new User { email="kontakt@norlowska.com", password="epMz1AKqh2IAZvi+qcRbxAWOGCfaQBqhLGyU98g5pgDiTsCA", firstName="Natalia", lastName="Orłowska" }
            };
        }

        public static CinemaContext GetContext()
        {
            if (_context == null)
            {
                _context = new CinemaContext();
            }
            return _context;
        }

        public ICollection<User> Users { get; set; }
        public ICollection<CrewMember> CrewMembers { get; set; }
        public ICollection<Character> Characters { get; set; }
        public ICollection<Actor> Actors{ get; set; }
        public ICollection<Movie> Movies{ get; set; }
        public ICollection<Reservation> Reservations{ get; set; }
        public ICollection<Screening> Screenings{ get; set; }
        public ICollection<Seat> Seats { get; set; }
        public ICollection<Screen> Screens { get; set; }
    }
}