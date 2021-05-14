
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.cinemasoap_service.EditReservationRequestDTO;


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
 *         &lt;element name="newReservation" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO}EditReservationRequestDTO" minOccurs="0"/>
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
    "newReservation"
})
@XmlRootElement(name = "EditReservation")
public class EditReservation {

    @XmlElementRef(name = "newReservation", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<EditReservationRequestDTO> newReservation;

    /**
     * Gets the value of the newReservation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EditReservationRequestDTO }{@code >}
     *     
     */
    public JAXBElement<EditReservationRequestDTO> getNewReservation() {
        return newReservation;
    }

    /**
     * Sets the value of the newReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EditReservationRequestDTO }{@code >}
     *     
     */
    public void setNewReservation(JAXBElement<EditReservationRequestDTO> value) {
        this.newReservation = ((JAXBElement<EditReservationRequestDTO> ) value);
    }

}
