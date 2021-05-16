
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
 *         &lt;element name="GetMoviePosterResult" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO}FileContentResponseDTO" minOccurs="0"/>
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
    "getMoviePosterResult"
})
@XmlRootElement(name = "GetMoviePosterResponse")
public class GetMoviePosterResponse {

    @XmlElementRef(name = "GetMoviePosterResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileContentResponseDTO> getMoviePosterResult;

    /**
     * Gets the value of the getMoviePosterResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}
     *     
     */
    public JAXBElement<FileContentResponseDTO> getGetMoviePosterResult() {
        return getMoviePosterResult;
    }

    /**
     * Sets the value of the getMoviePosterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileContentResponseDTO }{@code >}
     *     
     */
    public void setGetMoviePosterResult(JAXBElement<FileContentResponseDTO> value) {
        this.getMoviePosterResult = value;
    }

}
