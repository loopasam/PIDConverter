/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Model {
    
    private ArrayList<Molecule> molecules;
    private ArrayList<Interaction> interactions;
    private ArrayList<Pathway> pathways;
    
    
    public ArrayList<Molecule> getMolecules() {
        return molecules;
    }
    public void setMolecules(ArrayList<Molecule> molecules) {
        this.molecules = molecules;
    }
    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }
    public void setInteractions(ArrayList<Interaction> interactions) {
        this.interactions = interactions;
    }
    public ArrayList<Pathway> getPathways() {
        return pathways;
    }
    public void setPathways(ArrayList<Pathway> pathways) {
        this.pathways = pathways;
    }
    
    /**
     * 
     */
    public Model() {
	// TODO Auto-generated constructor stub
	this.interactions = new ArrayList<Interaction>();
	this.molecules = new ArrayList<Molecule>();
	this.pathways = new ArrayList<Pathway>();
    }

}
