
package org.datacontract.schemas._2004._07.cinemasoap_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfScreening complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfScreening">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Screening" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}Screening" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfScreening", propOrder = {
    "screening"
})
public class ArrayOfScreening {

    @XmlElement(name = "Screening", nillable = true)
    protected List<Screening> screening;

    /**
     * Gets the value of the screening property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the screening property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScreening().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Screening }
     * 
     * 
     */
    public List<Screening> getScreening() {
        if (screening == null) {
            screening = new ArrayList<Screening>();
        }
        return this.screening;
    }

}
