
package com.processcentric.goal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkWeightResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkWeightResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sentenceWeight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkWeightResponse", propOrder = {
    "sentenceWeight"
})
public class CheckWeightResponse {

    protected String sentenceWeight;

    /**
     * Gets the value of the sentenceWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentenceWeight() {
        return sentenceWeight;
    }

    /**
     * Sets the value of the sentenceWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentenceWeight(String value) {
        this.sentenceWeight = value;
    }

}
