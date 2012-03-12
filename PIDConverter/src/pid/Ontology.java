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

    /**
     * @param name
     * @return
     */
    public LabelType getLabelType(String name) {
	// TODO Auto-generated method stub
	
	for (LabelType labelType : this.labelTypes) {
	    if(labelType.getName().equals(name)){
		return labelType;
	    }
	}
	return null;
    }

    /**
     * @param id
     * @return
     */
    public LabelType getLabelType(int id) {
	// TODO Auto-generated method stub
	for (LabelType labelType : this.labelTypes) {
	    if(labelType.getId() == id){
		return labelType;
	    }
	}
	return null;
    }

}
