/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A molecule member of a family (higher order).
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class FamilyMember implements Serializable {

    private int member_molecule_idref;
    private ArrayList<Label> labels;
    private PTMExpression ptmExpression;

    public void setMember_molecule_idref(int member_molecule_idref) {
	this.member_molecule_idref = member_molecule_idref;
    }

    /**
     * @return the id of the current family member.
     */
    public int getMember_molecule_idref() {
	return member_molecule_idref;
    }

    public void setPtmExpression(PTMExpression ptmExpression) {
	this.ptmExpression = ptmExpression;
    }

    /**
     * @return the PTM expression associated with the current family member.
     */
    public PTMExpression getPtmExpression() {
	return ptmExpression;
    }

    public void setLabels(ArrayList<Label> labels) {
	this.labels = labels;
    }

    /**
     * @return the labels associated with the current family member.
     */
    public ArrayList<Label> getLabels() {
	return labels;
    }

    /**
     * Only constructor, initialise the array.
     */
    public FamilyMember() {
	this.labels = new ArrayList<Label>();
    }

}
