/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * A link to another pathway from a pathway. It is usually represented as a box on a PID diagram.
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class Abstraction implements Serializable{

    private int pathway_idref;
    private String pathway_name;
    private String external_pathway_id;
    
    
    /**
     * @return a reference to the abstracted pathway.
     */
    public int getPathway_idref() {
        return pathway_idref;
    }
    public void setPathway_idref(int pathway_idref) {
        this.pathway_idref = pathway_idref;
    }
    
    /**
     * @return the name of the referenced pathway.
     */
    public String getPathway_name() {
        return pathway_name;
    }
    public void setPathway_name(String pathway_name) {
        this.pathway_name = pathway_name;
    }
    
    /**
     * @return textual reference to the abstracted pathway. Useful while querying via URLs through the web interface of PID.
     */
    public String getExternal_pathway_id() {
        return external_pathway_id;
    }
    public void setExternal_pathway_id(String external_pathway_id) {
        this.external_pathway_id = external_pathway_id;
    }
    
    
    
}
