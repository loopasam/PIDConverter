/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class PTMExpression {
    
    private ArrayList<PTMTerm> ptmTerms;

    public void setPtmTerms(ArrayList<PTMTerm> ptmTerms) {
	this.ptmTerms = ptmTerms;
    }

    public ArrayList<PTMTerm> getPtmTerms() {
	return ptmTerms;
    }
    
    /**
     * 
     */
    public PTMExpression() {
	// TODO Auto-generated constructor stub
	this.ptmTerms = new ArrayList<PTMTerm>();
    }

}
