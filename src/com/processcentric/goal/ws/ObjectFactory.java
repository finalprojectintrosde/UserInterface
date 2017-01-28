
package com.processcentric.goal.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.processcentric.goal.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckCalories_QNAME = new QName("http://ws.goal.processcentric.com/", "checkCalories");
    private final static QName _CheckDistanceResponse_QNAME = new QName("http://ws.goal.processcentric.com/", "checkDistanceResponse");
    private final static QName _CheckWeightResponse_QNAME = new QName("http://ws.goal.processcentric.com/", "checkWeightResponse");
    private final static QName _CheckCaloriesResponse_QNAME = new QName("http://ws.goal.processcentric.com/", "checkCaloriesResponse");
    private final static QName _CheckStepsResponse_QNAME = new QName("http://ws.goal.processcentric.com/", "checkStepsResponse");
    private final static QName _CheckDistance_QNAME = new QName("http://ws.goal.processcentric.com/", "checkDistance");
    private final static QName _CheckSteps_QNAME = new QName("http://ws.goal.processcentric.com/", "checkSteps");
    private final static QName _CheckWeight_QNAME = new QName("http://ws.goal.processcentric.com/", "checkWeight");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.processcentric.goal.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckWeightResponse }
     * 
     */
    public CheckWeightResponse createCheckWeightResponse() {
        return new CheckWeightResponse();
    }

    /**
     * Create an instance of {@link CheckDistanceResponse }
     * 
     */
    public CheckDistanceResponse createCheckDistanceResponse() {
        return new CheckDistanceResponse();
    }

    /**
     * Create an instance of {@link CheckCalories }
     * 
     */
    public CheckCalories createCheckCalories() {
        return new CheckCalories();
    }

    /**
     * Create an instance of {@link CheckStepsResponse }
     * 
     */
    public CheckStepsResponse createCheckStepsResponse() {
        return new CheckStepsResponse();
    }

    /**
     * Create an instance of {@link CheckCaloriesResponse }
     * 
     */
    public CheckCaloriesResponse createCheckCaloriesResponse() {
        return new CheckCaloriesResponse();
    }

    /**
     * Create an instance of {@link CheckDistance }
     * 
     */
    public CheckDistance createCheckDistance() {
        return new CheckDistance();
    }

    /**
     * Create an instance of {@link CheckWeight }
     * 
     */
    public CheckWeight createCheckWeight() {
        return new CheckWeight();
    }

    /**
     * Create an instance of {@link CheckSteps }
     * 
     */
    public CheckSteps createCheckSteps() {
        return new CheckSteps();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCalories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkCalories")
    public JAXBElement<CheckCalories> createCheckCalories(CheckCalories value) {
        return new JAXBElement<CheckCalories>(_CheckCalories_QNAME, CheckCalories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDistanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkDistanceResponse")
    public JAXBElement<CheckDistanceResponse> createCheckDistanceResponse(CheckDistanceResponse value) {
        return new JAXBElement<CheckDistanceResponse>(_CheckDistanceResponse_QNAME, CheckDistanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckWeightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkWeightResponse")
    public JAXBElement<CheckWeightResponse> createCheckWeightResponse(CheckWeightResponse value) {
        return new JAXBElement<CheckWeightResponse>(_CheckWeightResponse_QNAME, CheckWeightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCaloriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkCaloriesResponse")
    public JAXBElement<CheckCaloriesResponse> createCheckCaloriesResponse(CheckCaloriesResponse value) {
        return new JAXBElement<CheckCaloriesResponse>(_CheckCaloriesResponse_QNAME, CheckCaloriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckStepsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkStepsResponse")
    public JAXBElement<CheckStepsResponse> createCheckStepsResponse(CheckStepsResponse value) {
        return new JAXBElement<CheckStepsResponse>(_CheckStepsResponse_QNAME, CheckStepsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDistance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkDistance")
    public JAXBElement<CheckDistance> createCheckDistance(CheckDistance value) {
        return new JAXBElement<CheckDistance>(_CheckDistance_QNAME, CheckDistance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSteps }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkSteps")
    public JAXBElement<CheckSteps> createCheckSteps(CheckSteps value) {
        return new JAXBElement<CheckSteps>(_CheckSteps_QNAME, CheckSteps.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckWeight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.goal.processcentric.com/", name = "checkWeight")
    public JAXBElement<CheckWeight> createCheckWeight(CheckWeight value) {
        return new JAXBElement<CheckWeight>(_CheckWeight_QNAME, CheckWeight.class, null, value);
    }

}
