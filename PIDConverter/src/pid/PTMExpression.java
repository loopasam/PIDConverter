/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Post-Translational Modification
 * (http://en.wikipedia.org/wiki/Posttranslational_modification) expression: A
 * set of PTMs for this molecule.
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class PTMExpression implements Serializable {

    private ArrayList<PTMTerm> ptmTerms;

    public void setPtmTerms(ArrayList<PTMTerm> ptmTerms) {
	this.ptmTerms = ptmTerms;
    }

    /**
     * @return the list of PTMs for this molecule.
     */
    public ArrayList<PTMTerm> getPtmTerms() {
	return ptmTerms;
    }

    /**
     * Only constructor, initialise the array.
     */
    public PTMExpression() {
	this.ptmTerms = new ArrayList<PTMTerm>();
    }

}
