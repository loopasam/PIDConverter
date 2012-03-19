/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The main content of PID.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class Model implements Serializable{
    
    private ArrayList<Molecule> molecules;
    private ArrayList<Interaction> interactions;
    private ArrayList<Pathway> pathways;
    
    /**
     * @return the list of molecules present within PID.
     */
    public ArrayList<Molecule> getMolecules() {
        return molecules;
    }
    public void setMolecules(ArrayList<Molecule> molecules) {
        this.molecules = molecules;
    }
    
    /**
     * @return the list of interactions within PID.
     */
    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }
    public void setInteractions(ArrayList<Interaction> interactions) {
        this.interactions = interactions;
    }
    
    /**
     * @return the list of pathways within PID.
     */
    public ArrayList<Pathway> getPathways() {
        return pathways;
    }
    public void setPathways(ArrayList<Pathway> pathways) {
        this.pathways = pathways;
    }
    
    /**
     * Only constructor, create the arrays.
     */
    public Model() {
	this.interactions = new ArrayList<Interaction>();
	this.molecules = new ArrayList<Molecule>();
	this.pathways = new ArrayList<Pathway>();
    }
    
    /**
     * @param id 
     * @return the molecule corresponding to the id
     */
    public Molecule getMolecule(int id) {
	for (Molecule molecule : this.molecules) {
	    if(molecule.getId() == id){
		return molecule;
	    }
	}
	return null;
    }
    
    /**
     * @param id
     * @return the interaction corresponding to the id.
     */
    public Interaction getInteraction(String id) {
	for (Interaction interaction : this.interactions) {
	    if(interaction.getId().equals(id)){
		return interaction;
	    }
	}
	return null;
    }
    
    /**
     * @param id
     * @return the pathway corresponding to the id.
     */
    public Pathway getPathway(int id) {
	for (Pathway pathway : this.pathways) {
	    if(pathway.getId() == id){
		return pathway;
	    }
	}
	return null;
    }

}
