
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.cinemasoap_service.ArrayOfMovie;
import org.datacontract.schemas._2004._07.cinemasoap_service.ArrayOfReservation;
import org.datacontract.schemas._2004._07.cinemasoap_service.ArrayOfSeat;
import org.datacontract.schemas._2004._07.cinemasoap_service.EditReservationRequestDTO;
import org.datacontract.schemas._2004._07.cinemasoap_service.FileContentResponseDTO;
import org.datacontract.schemas._2004._07.cinemasoap_service.User;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _GetMoviePosterResponseGetMoviePosterResult_QNAME = new QName("http://tempuri.org/", "GetMoviePosterResult");
    private final static QName _GetRepertoireResponseGetRepertoireResult_QNAME = new QName("http://tempuri.org/", "GetRepertoireResult");
    private final static QName _BookScreeningChosenSeats_QNAME = new QName("http://tempuri.org/", "chosenSeats");
    private final static QName _EditReservationNewReservation_QNAME = new QName("http://tempuri.org/", "newReservation");
    private final static QName _BookScreeningResponseBookScreeningResult_QNAME = new QName("http://tempuri.org/", "BookScreeningResult");
    private final static QName _SignUpUser_QNAME = new QName("http://tempuri.org/", "user");
    private final static QName _GetRepertoireDate_QNAME = new QName("http://tempuri.org/", "date");
    private final static QName _GetReservationListResponseGetReservationListResult_QNAME = new QName("http://tempuri.org/", "GetReservationListResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditReservation }
     * 
     */
    public EditReservation createEditReservation() {
        return new EditReservation();
    }

    /**
     * Create an instance of {@link BookScreeningResponse }
     * 
     */
    public BookScreeningResponse createBookScreeningResponse() {
        return new BookScreeningResponse();
    }

    /**
     * Create an instance of {@link SignUp }
     * 
     */
    public SignUp createSignUp() {
        return new SignUp();
    }

    /**
     * Create an instance of {@link GetRepertoire }
     * 
     */
    public GetRepertoire createGetRepertoire() {
        return new GetRepertoire();
    }

    /**
     * Create an instance of {@link CancelReservation }
     * 
     */
    public CancelReservation createCancelReservation() {
        return new CancelReservation();
    }

    /**
     * Create an instance of {@link EditReservationResponse }
     * 
     */
    public EditReservationResponse createEditReservationResponse() {
        return new EditReservationResponse();
    }

    /**
     * Create an instance of {@link GetReservationListResponse }
     * 
     */
    public GetReservationListResponse createGetReservationListResponse() {
        return new GetReservationListResponse();
    }

    /**
     * Create an instance of {@link GetMoviePosterResponse }
     * 
     */
    public GetMoviePosterResponse createGetMoviePosterResponse() {
        return new GetMoviePosterResponse();
    }

    /**
     * Create an instance of {@link GetRepertoireResponse }
     * 
     */
    public GetRepertoireResponse createGetRepertoireResponse() {
        return new GetRepertoireResponse();
    }

    /**
     * Create an instance of {@link CancelReservationResponse }
     * 
     */
    public CancelReservationResponse createCancelReservationResponse() {
        return new CancelReservationResponse();
    }

    /**
     * Create an instance of {@link BookScreening }
     * 
     */
    public BookScreening createBookScreening() {
        return new BookScreening();
    }

    /**
     * Create an instance of {@link GetReservationList }
     * 
     */
    public GetReservationList createGetReservationList() {
        return new GetReservationList();
    }

    /**
     * Create an instance of {@link GetMoviePoster }
     * 
     */
    public GetMoviePoster createGetMoviePoster() {
        return new GetMoviePoster();
    }

    /**
     * Create an instance of {@link SignUpResponse }
     * 
     */
    public SignUpResponse createSignUpResponse() {
        return new SignUpResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetMoviePosterResult", scope = GetMoviePosterResponse.class)
    public JAXBElement<FileContentResponseDTO> createGetMoviePosterResponseGetMoviePosterResult(FileContentResponseDTO value) {
        return new JAXBElement<FileContentResponseDTO>(_GetMoviePosterResponseGetMoviePosterResult_QNAME, FileContentResponseDTO.class, GetMoviePosterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRepertoireResult", scope = GetRepertoireResponse.class)
    public JAXBElement<ArrayOfMovie> createGetRepertoireResponseGetRepertoireResult(ArrayOfMovie value) {
        return new JAXBElement<ArrayOfMovie>(_GetRepertoireResponseGetRepertoireResult_QNAME, ArrayOfMovie.class, GetRepertoireResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "chosenSeats", scope = BookScreening.class)
    public JAXBElement<ArrayOfSeat> createBookScreeningChosenSeats(ArrayOfSeat value) {
        return new JAXBElement<ArrayOfSeat>(_BookScreeningChosenSeats_QNAME, ArrayOfSeat.class, BookScreening.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditReservationRequestDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "newReservation", scope = EditReservation.class)
    public JAXBElement<EditReservationRequestDTO> createEditReservationNewReservation(EditReservationRequestDTO value) {
        return new JAXBElement<EditReservationRequestDTO>(_EditReservationNewReservation_QNAME, EditReservationRequestDTO.class, EditReservation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BookScreeningResult", scope = BookScreeningResponse.class)
    public JAXBElement<FileContentResponseDTO> createBookScreeningResponseBookScreeningResult(FileContentResponseDTO value) {
        return new JAXBElement<FileContentResponseDTO>(_BookScreeningResponseBookScreeningResult_QNAME, FileContentResponseDTO.class, BookScreeningResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "user", scope = SignUp.class)
    public JAXBElement<User> createSignUpUser(User value) {
        return new JAXBElement<User>(_SignUpUser_QNAME, User.class, SignUp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "date", scope = GetRepertoire.class)
    public JAXBElement<String> createGetRepertoireDate(String value) {
        return new JAXBElement<String>(_GetRepertoireDate_QNAME, String.class, GetRepertoire.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetReservationListResult", scope = GetReservationListResponse.class)
    public JAXBElement<ArrayOfReservation> createGetReservationListResponseGetReservationListResult(ArrayOfReservation value) {
        return new JAXBElement<ArrayOfReservation>(_GetReservationListResponseGetReservationListResult_QNAME, ArrayOfReservation.class, GetReservationListResponse.class, value);
    }

}
