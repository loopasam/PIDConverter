/**
 * 
 */
package pid;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * An Object mimicking the XML coming from PID
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class PID implements Serializable {

    private String created;
    private Ontology ontology;
    private Model model;

    /**
     * @param path
     *            to serialised file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public PID(String path) throws IOException, ClassNotFoundException {

	FileInputStream fileIn = new FileInputStream(path);
	ObjectInputStream in = new ObjectInputStream(fileIn);
	PID pid = (PID) in.readObject();
	this.created = pid.getCreated();
	this.ontology = pid.getOntology();
	this.model = pid.getModel();
	in.close();
	fileIn.close();

    }

    /**
     * Default constructor.
     */
    public PID() {
    }

    /**
     * @return the creation date of the XML file.
     * 
     */
    public String getCreated() {
	return created;
    }

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
     * @return get the model object, inside which there are Molecules, Pathways
     *         and Interactions.
     * 
     */
    public Model getModel() {
	return model;
    }

    public void setModel(Model model) {
	this.model = model;
    }

}
