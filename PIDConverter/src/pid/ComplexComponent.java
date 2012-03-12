/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class ComplexComponent {
    
    private int molecule_idref;
    private ArrayList<Label> labels;
    private PTMExpression ptmExpression;
    
    
    public int getMolecule_idref() {
        return molecule_idref;
    }
    public void setMolecule_idref(int molecule_idref) {
        this.molecule_idref = molecule_idref;
    }
    public ArrayList<Label> getLabels() {
        return labels;
    }
    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }
    public PTMExpression getPtmExpression() {
        return ptmExpression;
    }
    public void setPtmExpression(PTMExpression ptmExpression) {
        this.ptmExpression = ptmExpression;
    }
    
}
