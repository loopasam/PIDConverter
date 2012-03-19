/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * A label Value is a category of a label type pseudoo-ontology
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class LabelValue implements Serializable {

    private String name;
    private int id;
    private String parent_idref;
    private String go;

    /**
     * @return the name of the category (called label value within PID)
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the id of the category
     */
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the id of the parent category
     */
    public String getParent_idref() {
	return parent_idref;
    }

    public void setParent_idref(String parent_idref) {
	this.parent_idref = parent_idref;
    }

    /**
     * @return the corresponding GO term ID
     */
    public String getGo() {
	return go;
    }

    public void setGo(String go) {
	this.go = go;
    }

}
