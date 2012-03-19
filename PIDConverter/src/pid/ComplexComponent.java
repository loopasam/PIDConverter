/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Complex Component is of of the building block composing a complex molecule. 
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class ComplexComponent implements Serializable{
    
    private int molecule_idref;
    private ArrayList<Label> labels;
    private PTMExpression ptmExpression;
    
    /**
     * @return the id of the protein when it is alone
     */
    public int getMolecule_idref() {
        return molecule_idref;
    }
    public void setMolecule_idref(int molecule_idref) {
        this.molecule_idref = molecule_idref;
    }
    
    /**
     * @return the labels associated with this component. Gives indications about location, states, etc...
     */
    public ArrayList<Label> getLabels() {
        return labels;
    }
    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }
    
    /**
     * @return the post-translational modifications associated with this component. 
     */
    public PTMExpression getPtmExpression() {
        return ptmExpression;
    }
    public void setPtmExpression(PTMExpression ptmExpression) {
        this.ptmExpression = ptmExpression;
    }
    
    /**
     * Only constructor, initialise the label array
     */
    public ComplexComponent() {
	this.labels = new ArrayList<Label>();
    }
    
}
