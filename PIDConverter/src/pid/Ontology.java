/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * Ontologies behind PID
 * @author Samuel Croset
 *
 */
public class Ontology {
    
    private ArrayList<LabelType> labelTypes;
    
    /**
     * Only constructor, initialise the array of LabelTypes.
     */
    public Ontology() {
	this.labelTypes = new ArrayList<LabelType>();
    }

    public void setLabelTypes(ArrayList<LabelType> labelTypes) {
	this.labelTypes = labelTypes;
    }

    /**
     * @return the labelTypes, which is a small ontology about a particular facet of the DB.
     */
    public ArrayList<LabelType> getLabelTypes() {
	return labelTypes;
    }

    /**
     * From the name of the LabelType (aka small internal ontology, e.g: "function" or "edge-type") return the object.
     * @param name 
     * @return the LabelType object matching the name or null.
     */
    public LabelType getLabelType(String name) {	
	for (LabelType labelType : this.labelTypes) {
	    if(labelType.getName().equals(name)){
		return labelType;
	    }
	}
	return null;
    }

    /**
     * From the id of the labelType, returns the object.
     * @param id
     * @return the labelType object with the corresponding id.
     */
    public LabelType getLabelType(int id) {
	for (LabelType labelType : this.labelTypes) {
	    if(labelType.getId() == id){
		return labelType;
	    }
	}
	return null;
    }
}
