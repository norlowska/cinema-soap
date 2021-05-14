
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Character complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Character">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actor" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Actor"/>
 *         &lt;element name="characterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Character", propOrder = {
    "actor",
    "characterName"
})
public class Character {

    @XmlElement(required = true, nillable = true)
    protected Actor actor;
    @XmlElement(required = true, nillable = true)
    protected String characterName;

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link Actor }
     *     
     */
    public Actor getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Actor }
     *     
     */
    public void setActor(Actor value) {
        this.actor = value;
    }

    /**
     * Gets the value of the characterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Sets the value of the characterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacterName(String value) {
        this.characterName = value;
    }

}
