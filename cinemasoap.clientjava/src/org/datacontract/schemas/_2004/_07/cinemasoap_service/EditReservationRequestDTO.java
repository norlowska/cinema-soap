
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EditReservationRequestDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EditReservationRequestDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservationID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/>
 *         &lt;element name="seats" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfSeat" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EditReservationRequestDTO", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", propOrder = {
    "reservationID",
    "seats"
})
public class EditReservationRequestDTO {

    @XmlElement(required = true)
    protected String reservationID;
    @XmlElementRef(name = "seats", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSeat> seats;

    /**
     * Gets the value of the reservationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationID() {
        return reservationID;
    }

    /**
     * Sets the value of the reservationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationID(String value) {
        this.reservationID = value;
    }

    /**
     * Gets the value of the seats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSeat> getSeats() {
        return seats;
    }

    /**
     * Sets the value of the seats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public void setSeats(JAXBElement<ArrayOfSeat> value) {
        this.seats = value;
    }

}
