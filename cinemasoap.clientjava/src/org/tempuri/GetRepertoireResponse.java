
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.cinemasoap_service.ArrayOfMovie;


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
 *         &lt;element name="GetRepertoireResult" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfMovie" minOccurs="0"/>
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
    "getRepertoireResult"
})
@XmlRootElement(name = "GetRepertoireResponse")
public class GetRepertoireResponse {

    @XmlElementRef(name = "GetRepertoireResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMovie> getRepertoireResult;

    /**
     * Gets the value of the getRepertoireResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMovie }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMovie> getGetRepertoireResult() {
        return getRepertoireResult;
    }

    /**
     * Sets the value of the getRepertoireResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMovie }{@code >}
     *     
     */
    public void setGetRepertoireResult(JAXBElement<ArrayOfMovie> value) {
        this.getRepertoireResult = value;
    }

}
