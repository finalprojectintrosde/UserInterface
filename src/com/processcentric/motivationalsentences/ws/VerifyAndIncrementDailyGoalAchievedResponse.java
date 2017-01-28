
package com.processcentric.motivationalsentences.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verifyAndIncrementDailyGoalAchievedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verifyAndIncrementDailyGoalAchievedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sentence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyAndIncrementDailyGoalAchievedResponse", propOrder = {
    "sentence"
})
public class VerifyAndIncrementDailyGoalAchievedResponse {

    protected int sentence;

    /**
     * Gets the value of the sentence property.
     * 
     */
    public int getSentence() {
        return sentence;
    }

    /**
     * Sets the value of the sentence property.
     * 
     */
    public void setSentence(int value) {
        this.sentence = value;
    }

}
