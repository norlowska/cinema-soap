
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.cinemasoap_service.FileContentResponseDTO;


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
 *         &lt;element name="EditReservationResult" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO}FileContentResponseDTO" minOccurs="0"/>
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
    "editReservationResult"
})
@XmlRootElement(name = "EditReservationResponse")
public class EditReservationResponse {

    @XmlElementRef(name = "EditReservationResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<FileContentResponseDTO> editReservationResult;

    /**
     * Gets the value of the editReservationResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}
     *     
     */
    public JAXBElement<FileContentResponseDTO> getEditReservationResult() {
        return editReservationResult;
    }

    /**
     * Sets the value of the editReservationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}
     *     
     */
    public void setEditReservationResult(JAXBElement<FileContentResponseDTO> value) {
        this.editReservationResult = ((JAXBElement<FileContentResponseDTO> ) value);
    }

}
