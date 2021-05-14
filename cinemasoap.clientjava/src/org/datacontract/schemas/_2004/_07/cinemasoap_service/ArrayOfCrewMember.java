
package org.datacontract.schemas._2004._07.cinemasoap_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCrewMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCrewMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CrewMember" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}CrewMember" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCrewMember", propOrder = {
    "crewMember"
})
public class ArrayOfCrewMember {

    @XmlElement(name = "CrewMember", nillable = true)
    protected List<CrewMember> crewMember;

    /**
     * Gets the value of the crewMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crewMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrewMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrewMember }
     * 
     * 
     */
    public List<CrewMember> getCrewMember() {
        if (crewMember == null) {
            crewMember = new ArrayList<CrewMember>();
        }
        return this.crewMember;
    }

}
