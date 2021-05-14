
package org.datacontract.schemas._2004._07.cinemasoap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Movie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Movie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="characters" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfCharacter" minOccurs="0"/>
 *         &lt;element name="crew" type="{http://schemas.datacontract.org/2004/07/cinemasoap.service.Models}ArrayOfCrewMember" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movieID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Movie", propOrder = {
    "characters",
    "crew",
    "desc",
    "movieID",
    "title"
})
public class Movie {

    @XmlElementRef(name = "characters", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCharacter> characters;
    @XmlElementRef(name = "crew", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCrewMember> crew;
    @XmlElementRef(name = "desc", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class)
    protected JAXBElement<String> desc;
    protected String movieID;
    @XmlElementRef(name = "title", namespace = "http://schemas.datacontract.org/2004/07/cinemasoap.service.Models", type = JAXBElement.class)
    protected JAXBElement<String> title;

    /**
     * Gets the value of the characters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCharacter }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCharacter> getCharacters() {
        return characters;
    }

    /**
     * Sets the value of the characters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCharacter }{@code >}
     *     
     */
    public void setCharacters(JAXBElement<ArrayOfCharacter> value) {
        this.characters = ((JAXBElement<ArrayOfCharacter> ) value);
    }

    /**
     * Gets the value of the crew property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCrewMember }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCrewMember> getCrew() {
        return crew;
    }

    /**
     * Sets the value of the crew property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCrewMember }{@code >}
     *     
     */
    public void setCrew(JAXBElement<ArrayOfCrewMember> value) {
        this.crew = ((JAXBElement<ArrayOfCrewMember> ) value);
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDesc(JAXBElement<String> value) {
        this.desc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the movieID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieID() {
        return movieID;
    }

    /**
     * Sets the value of the movieID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieID(String value) {
        this.movieID = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitle(JAXBElement<String> value) {
        this.title = ((JAXBElement<String> ) value);
    }

}
