
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.cinemasoap_service.ArrayOfSeat;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="screeningID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="chosenSeats" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfSeat" minOccurs="0"/>
 *         &lt;element name="userID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "screeningID",
    "chosenSeats",
    "userID"
})
@XmlRootElement(name = "BookScreening")
public class BookScreening {

    protected String screeningID;
    @XmlElementRef(name = "chosenSeats", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSeat> chosenSeats;
    protected String userID;

    /**
     * Gets the value of the screeningID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScreeningID() {
        return screeningID;
    }

    /**
     * Sets the value of the screeningID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScreeningID(String value) {
        this.screeningID = value;
    }

    /**
     * Gets the value of the chosenSeats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSeat> getChosenSeats() {
        return chosenSeats;
    }

    /**
     * Sets the value of the chosenSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSeat }{@code >}
     *     
     */
    public void setChosenSeats(JAXBElement<ArrayOfSeat> value) {
        this.chosenSeats = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

}
