
package pe.joedayz.sumservice.schema;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addendOne" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="addendTwo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addendOne",
    "addendTwo"
})
@XmlRootElement(name = "GetSumRequest")
public class GetSumRequest {

    protected int addendOne;
    protected int addendTwo;

    /**
     * Gets the value of the addendOne property.
     * 
     */
    public int getAddendOne() {
        return addendOne;
    }

    /**
     * Sets the value of the addendOne property.
     * 
     */
    public void setAddendOne(int value) {
        this.addendOne = value;
    }

    /**
     * Gets the value of the addendTwo property.
     * 
     */
    public int getAddendTwo() {
        return addendTwo;
    }

    /**
     * Sets the value of the addendTwo property.
     * 
     */
    public void setAddendTwo(int value) {
        this.addendTwo = value;
    }

}
