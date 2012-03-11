/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Molecule {
    
    private int id;
    private ArrayList<Name> names;
    

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public void setNames(ArrayList<Name> names) {
	this.names = names;
    }

    public ArrayList<Name> getNames() {
	return names;
    }
    
    /**
     * 
     */
    public Molecule() {
	// TODO Auto-generated constructor stub
	this.names = new ArrayList<Name>();
    }

}
