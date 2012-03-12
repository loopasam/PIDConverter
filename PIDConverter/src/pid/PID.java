/**
 * 
 */
package pid;

/**
 * An Object mimicking the XML coming from PID
 * @author Samuel Croset
 *
 */
public class PID {
    
    private String created;
    private Ontology ontology;
    private Model model;
    
    /**
     * @return the creation date of the XML file.
     * 
     */
    public String getCreated() {
        return created;
    }
    
    /**
     * @param set the date of creation.
     * 
     */
    public void setCreated(String created) {
        this.created = created;
    }
    
    /**
     * @return Get the ontology structure behind PID.
     * 
     */
    public Ontology getOntology() {
        return ontology;
    }
    
    public void setOntology(Ontology ontology) {
        this.ontology = ontology;
    }
    
    /**
     * @return get the model object, inside which there are Molecules, Pathways and Interactions.
     * 
     */
    public Model getModel() {
        return model;
    }
    
    public void setModel(Model model) {
        this.model = model;
    }
    
}
