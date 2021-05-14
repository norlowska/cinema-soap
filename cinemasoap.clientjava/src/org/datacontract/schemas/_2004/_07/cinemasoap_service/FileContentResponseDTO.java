
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileContentResponseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileContentResponseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileContentResponseDTO", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", propOrder = {
    "content",
    "message"
})
public class FileContentResponseDTO {

    @XmlElementRef(name = "Content", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", type = JAXBElement.class)
    protected JAXBElement<byte[]> content;
    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.SoapDTO", type = JAXBElement.class)
    protected JAXBElement<String> message;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setContent(JAXBElement<byte[]> value) {
        this.content = ((JAXBElement<byte[]> ) value);
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = ((JAXBElement<String> ) value);
    }

}
