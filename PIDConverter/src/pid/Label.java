/**
 * 
 */
package pid;

/**
 * Labels give information about the location, activity state, etc... of molecules
 * @author Samuel Croset
 *
 */
public class Label {
    
    private String value;

    public void setValue(String value) {
	this.value = value;
    }

    /**
     * @return the value of the label
     */
    public String getValue() {
	return value;
    }

}
