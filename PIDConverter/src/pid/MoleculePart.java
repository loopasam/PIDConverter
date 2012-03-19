/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * If the molecule is part of a bigger molecule, in some occasion, it is described within that class.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class MoleculePart implements Serializable{
    
    private int whole_molecule_idref;
    private int part_molecule_idref;
    private int start;
    private int end;
    
    /**
     * @return the id of the whole molecule this molecule is part of.
     */
    public int getWhole_molecule_idref() {
        return whole_molecule_idref;
    }
    public void setWhole_molecule_idref(int whole_molecule_idref) {
        this.whole_molecule_idref = whole_molecule_idref;
    }
    
    /**
     * @return the id of the part, seems that it is the id of this molecule (bit unclear).
     */
    public int getPart_molecule_idref() {
        return part_molecule_idref;
    }
    public void setPart_molecule_idref(int part_molecule_idref) {
        this.part_molecule_idref = part_molecule_idref;
    }
    
    /**
     * @return the start position of the whole molecule sequence where this molecule is located.
     */
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    
    /**
     * @return the end position of the whole molecule sequence where this molecule is located.
     */
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    
    
}
