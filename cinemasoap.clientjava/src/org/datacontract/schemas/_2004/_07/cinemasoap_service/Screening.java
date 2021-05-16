
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Screening complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Screening">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FreeSeats" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfSeat" minOccurs="0"/>
 *         &lt;element name="fullDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="movie" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Movie" minOccurs="0"/>
 *         &lt;element name="screen" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Screen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Screening", propOrder = {
    "freeSeats",
    "fullDate",
    "movie",
    "screen"
})
public class Screening {

    @XmlElementRef(name = "FreeSeats", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSeat> freeSeats;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fullDate;
    @XmlElementRef(name = "movie", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<Movie> movie;
    @XmlElementRef(name = "screen", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<Screen> screen;

    /**
     * Gets the value of the freeSeats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSeat> getFreeSeats() {
        return freeSeats;
    }

    /**
     * Sets the value of the freeSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public void setFreeSeats(JAXBElement<ArrayOfSeat> value) {
        this.freeSeats = value;
    }

    /**
     * Gets the value of the fullDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFullDate() {
        return fullDate;
    }

    /**
     * Sets the value of the fullDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFullDate(XMLGregorianCalendar value) {
        this.fullDate = value;
    }

    /**
     * Gets the value of the movie property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Movie }{@code >}
     *     
     */
    public JAXBElement<Movie> getMovie() {
        return movie;
    }

    /**
     * Sets the value of the movie property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Movie }{@code >}
     *     
     */
    public void setMovie(JAXBElement<Movie> value) {
        this.movie = value;
    }

    /**
     * Gets the value of the screen property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Screen }{@code >}
     *     
     */
    public JAXBElement<Screen> getScreen() {
        return screen;
    }

    /**
     * Sets the value of the screen property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Screen }{@code >}
     *     
     */
    public void setScreen(JAXBElement<Screen> value) {
        this.screen = value;
    }

}
