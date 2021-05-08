
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
        }

        private void InitMovies()
        {
            throw new NotImplementedException();
        }

        private void InitUsers()
        {
            Users = new List<User>
            {
                new User { email="kontakt@norlowska.com", password="ZAQ!@WSX", firstName="Natalia", lastName="Orłowska" }
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