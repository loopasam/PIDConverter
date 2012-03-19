/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * An entity interacting in an interaction.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class InteractionComponent implements Serializable{
    
    private PTMExpression ptmExpression;
    private ArrayList<Label> labels;
    private int molecule_idref;
    
    /**
     * @return the PTM expression associated with the component.
     */
    public PTMExpression getPtmExpression() {
        return ptmExpression;
    }
    public void setPtmExpression(PTMExpression ptmExpression) {
        this.ptmExpression = ptmExpression;
    }
    
    /**
     * @return the list of labels (activity states, etc...) associated with the current component.
     */
    public ArrayList<Label> getLabels() {
        return labels;
    }
    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }
    public void setMolecule_idref(int molecule_idref) {
	this.molecule_idref = molecule_idref;
    }
    
    /**
     * @return the ID of the molecule behind the interaction.
     */
    public int getMolecule_idref() {
	return molecule_idref;
    }

    
    /**
     * Only constructor, initialise the arrays.
     */
    public InteractionComponent() {
	this.labels = new ArrayList<Label>();
    }

}
