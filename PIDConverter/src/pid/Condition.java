/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * A generic condition, influencing an interaction
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class Condition implements Serializable {

    private String condition_type;

    public String getCondition_type() {
	return condition_type;
    }

    public void setCondition_type(String condition_type) {
	this.condition_type = condition_type;
    }

}
