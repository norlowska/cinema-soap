
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="movieId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
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
    "movieId"
})
@XmlRootElement(name = "GetMoviePoster")
public class GetMoviePoster {

    protected String movieId;

    /**
     * Gets the value of the movieId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Sets the value of the movieId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieId(String value) {
        this.movieId = value;
    }

}
