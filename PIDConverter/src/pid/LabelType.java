/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class LabelType {
    
    private ArrayList<LabelValue> labelValues;
    private String name;
    private int id;

    /**
     * 
     */
    public LabelType() {
	// TODO Auto-generated constructor stub
	this.labelValues = new ArrayList<LabelValue>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabelValues(ArrayList<LabelValue> labelValues) {
	this.labelValues = labelValues;
    }

    public ArrayList<LabelValue> getLabelValues() {
	return labelValues;
    }

}
