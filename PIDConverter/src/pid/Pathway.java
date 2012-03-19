/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A pathway from PID
 * @author Samuel Croset
 *
 */
@SuppressWarnings("serial")
public class Pathway implements Serializable {
    
    private int id;
    private boolean isSubnet;
    private String organism;
    private String longName;
    private String shortName;
    private String source;
    private ArrayList<String> curators;
    private ArrayList<String> reviewers;
    private ArrayList<PathwayComponent> pathwayComponents;
    
    /**
     * Only constructor, initialise the arrays.
     */
    public Pathway() {
	// TODO Auto-generated constructor stub
	this.curators = new ArrayList<String>();
	this.reviewers = new ArrayList<String>();
	this.pathwayComponents = new ArrayList<PathwayComponent>();
    }
    
    /**
     * @return the id of the pathway
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return whether the current pathway is a subnet of another pathway or not.
     */
    public boolean isSubnet() {
        return isSubnet;
    }
    public void setSubnet(boolean isSubnet) {
        this.isSubnet = isSubnet;
    }
    
    /**
     * @return the organism of the pathway.
     */
    public String getOrganism() {
        return organism;
    }
    public void setOrganism(String organism) {
        this.organism = organism;
    }
    
    /**
     * @return the human readable form of the pathway name.
     */
    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }
    
    /**
     * @return the name of the pathway in a more computer oriented way. 
     */
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public void setSource(String source) {
	this.source = source;
    }
    
    /**
     * @return the original source holding the data.
     */
    public String getSource() {
	return source;
    }
    public void setCurators(ArrayList<String> curators) {
	this.curators = curators;
    }
    
    /**
     * @return the curators of the pathway.
     */
    public ArrayList<String> getCurators() {
	return curators;
    }

    public void setReviewers(ArrayList<String> reviewers) {
	this.reviewers = reviewers;
    }

    /**
     * @return the list of reviewer for the pathway.
     */
    public ArrayList<String> getReviewers() {
	return reviewers;
    }

    public void setPathwayComponents(ArrayList<PathwayComponent> pathwayComponents) {
	this.pathwayComponents = pathwayComponents;
    }

    /**
     * @return the list of steps within the pathway, so called pathway components.
     */
    public ArrayList<PathwayComponent> getPathwayComponents() {
	return pathwayComponents;
    }
    
}
