
package org.datacontract.schemas._2004._07.cinemasoap_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCharacter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCharacter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Character" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Character" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCharacter", propOrder = {
    "character"
})
public class ArrayOfCharacter {

    @XmlElement(name = "Character", nillable = true)
    protected List<Character> character;

    /**
     * Gets the value of the character property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the character property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Character }
     * 
     * 
     */
    public List<Character> getCharacter() {
        if (character == null) {
            character = new ArrayList<Character>();
        }
        return this.character;
    }

}
