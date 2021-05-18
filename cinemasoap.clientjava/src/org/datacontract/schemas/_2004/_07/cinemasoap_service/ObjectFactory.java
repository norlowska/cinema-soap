
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.cinemasoap_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Movie_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Movie");
    private final static QName _Seat_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Seat");
    private final static QName _Actor_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Actor");
    private final static QName _ArrayOfScreening_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfScreening");
    private final static QName _User_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "User");
    private final static QName _FileContentResponseDTO_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", "FileContentResponseDTO");
    private final static QName _ArrayOfSeat_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfSeat");
    private final static QName _Reservation_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Reservation");
    private final static QName _ArrayOfMovie_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfMovie");
    private final static QName _ArrayOfCrewMember_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfCrewMember");
    private final static QName _ArrayOfCharacter_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfCharacter");
    private final static QName _EditReservationRequestDTO_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", "EditReservationRequestDTO");
    private final static QName _CrewMember_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "CrewMember");
    private final static QName _Screen_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Screen");
    private final static QName _Screening_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Screening");
    private final static QName _Character_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "Character");
    private final static QName _ArrayOfReservation_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "ArrayOfReservation");
    private final static QName _MovieCrew_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "crew");
    private final static QName _MovieScreenings_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "screenings");
    private final static QName _MovieDesc_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "desc");
    private final static QName _MovieTitle_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "title");
    private final static QName _MovieImageData_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "imageData");
    private final static QName _MovieCharacters_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "characters");
    private final static QName _ScreenScreenName_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "screenName");
    private final static QName _ScreeningScreen_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "screen");
    private final static QName _ScreeningMovie_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "movie");
    private final static QName _ScreeningFreeSeats_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "FreeSeats");
    private final static QName _EditReservationRequestDTOSeats_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", "seats");
    private final static QName _ActorSecondName_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "secondName");
    private final static QName _UserEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "email");
    private final static QName _UserLastName_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "lastName");
    private final static QName _UserReservations_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "reservations");
    private final static QName _UserPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "password");
    private final static QName _UserFirstName_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", "firstName");
    private final static QName _FileContentResponseDTOContent_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", "Content");
    private final static QName _FileContentResponseDTOMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.cinemasoap_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Screen }
     * 
     */
    public Screen createScreen() {
        return new Screen();
    }

    /**
     * Create an instance of {@link Character }
     * 
     */
    public Character createCharacter() {
        return new Character();
    }

    /**
     * Create an instance of {@link ArrayOfReservation }
     * 
     */
    public ArrayOfReservation createArrayOfReservation() {
        return new ArrayOfReservation();
    }

    /**
     * Create an instance of {@link ArrayOfMovie }
     * 
     */
    public ArrayOfMovie createArrayOfMovie() {
        return new ArrayOfMovie();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Seat }
     * 
     */
    public Seat createSeat() {
        return new Seat();
    }

    /**
     * Create an instance of {@link CrewMember }
     * 
     */
    public CrewMember createCrewMember() {
        return new CrewMember();
    }

    /**
     * Create an instance of {@link ArrayOfCrewMember }
     * 
     */
    public ArrayOfCrewMember createArrayOfCrewMember() {
        return new ArrayOfCrewMember();
    }

    /**
     * Create an instance of {@link Screening }
     * 
     */
    public Screening createScreening() {
        return new Screening();
    }

    /**
     * Create an instance of {@link EditReservationRequestDTO }
     * 
     */
    public EditReservationRequestDTO createEditReservationRequestDTO() {
        return new EditReservationRequestDTO();
    }

    /**
     * Create an instance of {@link Actor }
     * 
     */
    public Actor createActor() {
        return new Actor();
    }

    /**
     * Create an instance of {@link ArrayOfSeat }
     * 
     */
    public ArrayOfSeat createArrayOfSeat() {
        return new ArrayOfSeat();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link FileContentResponseDTO }
     * 
     */
    public FileContentResponseDTO createFileContentResponseDTO() {
        return new FileContentResponseDTO();
    }

    /**
     * Create an instance of {@link ArrayOfScreening }
     * 
     */
    public ArrayOfScreening createArrayOfScreening() {
        return new ArrayOfScreening();
    }

    /**
     * Create an instance of {@link ArrayOfCharacter }
     * 
     */
    public ArrayOfCharacter createArrayOfCharacter() {
        return new ArrayOfCharacter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Seat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Seat")
    public JAXBElement<Seat> createSeat(Seat value) {
        return new JAXBElement<Seat>(_Seat_QNAME, Seat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Actor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Actor")
    public JAXBElement<Actor> createActor(Actor value) {
        return new JAXBElement<Actor>(_Actor_QNAME, Actor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfScreening }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfScreening")
    public JAXBElement<ArrayOfScreening> createArrayOfScreening(ArrayOfScreening value) {
        return new JAXBElement<ArrayOfScreening>(_ArrayOfScreening_QNAME, ArrayOfScreening.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", name = "FileContentResponseDTO")
    public JAXBElement<FileContentResponseDTO> createFileContentResponseDTO(FileContentResponseDTO value) {
        return new JAXBElement<FileContentResponseDTO>(_FileContentResponseDTO_QNAME, FileContentResponseDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfSeat")
    public JAXBElement<ArrayOfSeat> createArrayOfSeat(ArrayOfSeat value) {
        return new JAXBElement<ArrayOfSeat>(_ArrayOfSeat_QNAME, ArrayOfSeat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<Reservation>(_Reservation_QNAME, Reservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfMovie")
    public JAXBElement<ArrayOfMovie> createArrayOfMovie(ArrayOfMovie value) {
        return new JAXBElement<ArrayOfMovie>(_ArrayOfMovie_QNAME, ArrayOfMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCrewMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfCrewMember")
    public JAXBElement<ArrayOfCrewMember> createArrayOfCrewMember(ArrayOfCrewMember value) {
        return new JAXBElement<ArrayOfCrewMember>(_ArrayOfCrewMember_QNAME, ArrayOfCrewMember.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCharacter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfCharacter")
    public JAXBElement<ArrayOfCharacter> createArrayOfCharacter(ArrayOfCharacter value) {
        return new JAXBElement<ArrayOfCharacter>(_ArrayOfCharacter_QNAME, ArrayOfCharacter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditReservationRequestDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", name = "EditReservationRequestDTO")
    public JAXBElement<EditReservationRequestDTO> createEditReservationRequestDTO(EditReservationRequestDTO value) {
        return new JAXBElement<EditReservationRequestDTO>(_EditReservationRequestDTO_QNAME, EditReservationRequestDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrewMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "CrewMember")
    public JAXBElement<CrewMember> createCrewMember(CrewMember value) {
        return new JAXBElement<CrewMember>(_CrewMember_QNAME, CrewMember.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Screen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Screen")
    public JAXBElement<Screen> createScreen(Screen value) {
        return new JAXBElement<Screen>(_Screen_QNAME, Screen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Screening }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Screening")
    public JAXBElement<Screening> createScreening(Screening value) {
        return new JAXBElement<Screening>(_Screening_QNAME, Screening.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Character }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "Character")
    public JAXBElement<Character> createCharacter(Character value) {
        return new JAXBElement<Character>(_Character_QNAME, Character.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "ArrayOfReservation")
    public JAXBElement<ArrayOfReservation> createArrayOfReservation(ArrayOfReservation value) {
        return new JAXBElement<ArrayOfReservation>(_ArrayOfReservation_QNAME, ArrayOfReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCrewMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "crew", scope = Movie.class)
    public JAXBElement<ArrayOfCrewMember> createMovieCrew(ArrayOfCrewMember value) {
        return new JAXBElement<ArrayOfCrewMember>(_MovieCrew_QNAME, ArrayOfCrewMember.class, Movie.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfScreening }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "screenings", scope = Movie.class)
    public JAXBElement<ArrayOfScreening> createMovieScreenings(ArrayOfScreening value) {
        return new JAXBElement<ArrayOfScreening>(_MovieScreenings_QNAME, ArrayOfScreening.class, Movie.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "desc", scope = Movie.class)
    public JAXBElement<String> createMovieDesc(String value) {
        return new JAXBElement<String>(_MovieDesc_QNAME, String.class, Movie.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "title", scope = Movie.class)
    public JAXBElement<String> createMovieTitle(String value) {
        return new JAXBElement<String>(_MovieTitle_QNAME, String.class, Movie.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "imageData", scope = Movie.class)
    public JAXBElement<byte[]> createMovieImageData(byte[] value) {
        return new JAXBElement<byte[]>(_MovieImageData_QNAME, byte[].class, Movie.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCharacter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "characters", scope = Movie.class)
    public JAXBElement<ArrayOfCharacter> createMovieCharacters(ArrayOfCharacter value) {
        return new JAXBElement<ArrayOfCharacter>(_MovieCharacters_QNAME, ArrayOfCharacter.class, Movie.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "screenName", scope = Screen.class)
    public JAXBElement<String> createScreenScreenName(String value) {
        return new JAXBElement<String>(_ScreenScreenName_QNAME, String.class, Screen.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Screen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "screen", scope = Screening.class)
    public JAXBElement<Screen> createScreeningScreen(Screen value) {
        return new JAXBElement<Screen>(_ScreeningScreen_QNAME, Screen.class, Screening.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "movie", scope = Screening.class)
    public JAXBElement<Movie> createScreeningMovie(Movie value) {
        return new JAXBElement<Movie>(_ScreeningMovie_QNAME, Movie.class, Screening.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "FreeSeats", scope = Screening.class)
    public JAXBElement<ArrayOfSeat> createScreeningFreeSeats(ArrayOfSeat value) {
        return new JAXBElement<ArrayOfSeat>(_ScreeningFreeSeats_QNAME, ArrayOfSeat.class, Screening.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", name = "seats", scope = EditReservationRequestDTO.class)
    public JAXBElement<ArrayOfSeat> createEditReservationRequestDTOSeats(ArrayOfSeat value) {
        return new JAXBElement<ArrayOfSeat>(_EditReservationRequestDTOSeats_QNAME, ArrayOfSeat.class, EditReservationRequestDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "secondName", scope = Actor.class)
    public JAXBElement<String> createActorSecondName(String value) {
        return new JAXBElement<String>(_ActorSecondName_QNAME, String.class, Actor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "secondName", scope = User.class)
    public JAXBElement<String> createUserSecondName(String value) {
        return new JAXBElement<String>(_ActorSecondName_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "email", scope = User.class)
    public JAXBElement<String> createUserEmail(String value) {
        return new JAXBElement<String>(_UserEmail_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "lastName", scope = User.class)
    public JAXBElement<String> createUserLastName(String value) {
        return new JAXBElement<String>(_UserLastName_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "reservations", scope = User.class)
    public JAXBElement<ArrayOfReservation> createUserReservations(ArrayOfReservation value) {
        return new JAXBElement<ArrayOfReservation>(_UserReservations_QNAME, ArrayOfReservation.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "password", scope = User.class)
    public JAXBElement<String> createUserPassword(String value) {
        return new JAXBElement<String>(_UserPassword_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "firstName", scope = User.class)
    public JAXBElement<String> createUserFirstName(String value) {
        return new JAXBElement<String>(_UserFirstName_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", name = "Content", scope = FileContentResponseDTO.class)
    public JAXBElement<byte[]> createFileContentResponseDTOContent(byte[] value) {
        return new JAXBElement<byte[]>(_FileContentResponseDTOContent_QNAME, byte[].class, FileContentResponseDTO.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", name = "Message", scope = FileContentResponseDTO.class)
    public JAXBElement<String> createFileContentResponseDTOMessage(String value) {
        return new JAXBElement<String>(_FileContentResponseDTOMessage_QNAME, String.class, FileContentResponseDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", name = "secondName", scope = CrewMember.class)
    public JAXBElement<String> createCrewMemberSecondName(String value) {
        return new JAXBElement<String>(_ActorSecondName_QNAME, String.class, CrewMember.class, value);
    }

}
