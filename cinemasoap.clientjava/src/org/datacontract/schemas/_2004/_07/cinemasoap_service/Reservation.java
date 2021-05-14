
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="screening" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Screening"/>
 *         &lt;element name="seats" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfSeat"/>
 *         &lt;element name="user" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}User"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation", propOrder = {
    "screening",
    "seats",
    "user"
})
public class Reservation {

    @XmlElement(required = true, nillable = true)
    protected Screening screening;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfSeat seats;
    @XmlElement(required = true, nillable = true)
    protected User user;

    /**
     * Gets the value of the screening property.
     * 
     * @return
     *     possible object is
     *     {@link Screening }
     *     
     */
    public Screening getScreening() {
        return screening;
    }

    /**
     * Sets the value of the screening property.
     * 
     * @param value
     *     allowed object is
     *     {@link Screening }
     *     
     */
    public void setScreening(Screening value) {
        this.screening = value;
    }

    /**
     * Gets the value of the seats property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSeat }
     *     
     */
    public ArrayOfSeat getSeats() {
        return seats;
    }

    /**
     * Sets the value of the seats property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSeat }
     *     
     */
    public void setSeats(ArrayOfSeat value) {
        this.seats = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

}
