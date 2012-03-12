/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class FamilyMember {
    
    private int member_molecule_idref;
    private ArrayList<Label> labels;
    private PTMExpression ptmExpression;

    public void setMember_molecule_idref(int member_molecule_idref) {
	this.member_molecule_idref = member_molecule_idref;
    }

    public int getMember_molecule_idref() {
	return member_molecule_idref;
    }

    public void setPtmExpression(PTMExpression ptmExpression) {
	this.ptmExpression = ptmExpression;
    }

    public PTMExpression getPtmExpression() {
	return ptmExpression;
    }

    public void setLabels(ArrayList<Label> labels) {
	this.labels = labels;
    }

    public ArrayList<Label> getLabels() {
	return labels;
    }

}
