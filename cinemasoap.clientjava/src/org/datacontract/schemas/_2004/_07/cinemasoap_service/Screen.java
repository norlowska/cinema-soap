
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Screen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Screen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="screenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="screenSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Screen", propOrder = {
    "screenName",
    "screenSize"
})
public class Screen {

    @XmlElementRef(name = "screenName", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> screenName;
    protected Integer screenSize;

    /**
     * Gets the value of the screenName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getScreenName() {
        return screenName;
    }

    /**
     * Sets the value of the screenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setScreenName(JAXBElement<String> value) {
        this.screenName = value;
    }

    /**
     * Gets the value of the screenSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getScreenSize() {
        return screenSize;
    }

    /**
     * Sets the value of the screenSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setScreenSize(Integer value) {
        this.screenSize = value;
    }

}
