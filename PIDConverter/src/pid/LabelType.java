/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * LabelTypes are top level categories for a small ontology present within PID
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class LabelType implements Serializable {
    private ArrayList<LabelValue> labelValues;
    private String name;
    private int id;

    /**
     * Default constructor, initialise the array.
     */
    public LabelType() {
	this.labelValues = new ArrayList<LabelValue>();
    }

    /**
     * @return the name of the label type, in other word name of the ontology
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the id of the label type
     */
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setLabelValues(ArrayList<LabelValue> labelValues) {
	this.labelValues = labelValues;
    }

    /**
     * @return the label values (children) associated with a label type.
     */
    public ArrayList<LabelValue> getLabelValues() {
	return labelValues;
    }

    /**
     * @param id
     * @return return the label value (child of label type) matching the id
     */
    public LabelValue getLabelValue(int id) {
	for (LabelValue labelValue : this.labelValues) {
	    if (labelValue.getId() == id) {
		return labelValue;
	    }
	}
	return null;
    }

}
