/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * Reference to a name for an entity.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class Name implements Serializable {
    
    private String abbreviation;
    private String fullName;
    private String value;
    
    /**
     * @return the abbreviation of the name (two letters code)
     */
    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    /**
     * @return the full name in string of the type of name
     */
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    /**
     * @return the actual value of the name.
     */
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    

}
