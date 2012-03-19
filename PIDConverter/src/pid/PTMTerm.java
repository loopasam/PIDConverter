/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * A PTM for the current molecule.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class PTMTerm implements Serializable{
    
    private String protein;
    private int position;
    private String aminoAcid;
    private String modification;
    
    /**
     * @return a reference to the original protein (Uniprot).
     */
    public String getProtein() {
        return protein;
    }
    public void setProtein(String protein) {
        this.protein = protein;
    }
    
    /**
     * @return position on the protein sequence where the PTM is located.
     */
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    /**
     * @return the amino-acid that has been modified. 
     */
    public String getAminoAcid() {
        return aminoAcid;
    }
    public void setAminoAcid(String aminoAcid) {
        this.aminoAcid = aminoAcid;
    }
    
    /**
     * @return the type of modification the amino-acid had.
     */
    public String getModification() {
        return modification;
    }
    public void setModification(String modification) {
        this.modification = modification;
    }
    

}
