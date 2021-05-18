
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Seat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Seat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Row" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SeatID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="SeatNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seat", propOrder = {
    "row",
    "seatID",
    "seatNumber"
})
public class Seat {

    @XmlElement(name = "Row")
    protected Integer row;
    @XmlElement(name = "SeatID")
    protected String seatID;
    @XmlElement(name = "SeatNumber")
    protected Integer seatNumber;

    /**
     * Gets the value of the row property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRow(Integer value) {
        this.row = value;
    }

    /**
     * Gets the value of the seatID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatID() {
        return seatID;
    }

    /**
     * Sets the value of the seatID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatID(String value) {
        this.seatID = value;
    }

    /**
     * Gets the value of the seatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the value of the seatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeatNumber(Integer value) {
        this.seatNumber = value;
    }

}
