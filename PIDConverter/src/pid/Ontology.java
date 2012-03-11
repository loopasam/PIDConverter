/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Ontology {
    
    private ArrayList<LabelType> labelTypes;
    
    /**
     * 
     */
    public Ontology() {
	// TODO Auto-generated constructor stub.
	this.labelTypes = new ArrayList<LabelType>();
    }

    public void setLabelTypes(ArrayList<LabelType> labelTypes) {
	this.labelTypes = labelTypes;
    }

    public ArrayList<LabelType> getLabelTypes() {
	return labelTypes;
    }

}
