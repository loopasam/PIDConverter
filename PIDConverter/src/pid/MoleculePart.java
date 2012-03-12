/**
 * 
 */
package pid;

/**
 * @author Samuel Croset
 *
 */
public class MoleculePart {
    
    private int whole_molecule_idref;
    private int part_molecule_idref;
    private int start;
    private int end;
    
    
    public int getWhole_molecule_idref() {
        return whole_molecule_idref;
    }
    public void setWhole_molecule_idref(int whole_molecule_idref) {
        this.whole_molecule_idref = whole_molecule_idref;
    }
    public int getPart_molecule_idref() {
        return part_molecule_idref;
    }
    public void setPart_molecule_idref(int part_molecule_idref) {
        this.part_molecule_idref = part_molecule_idref;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    
    
}
