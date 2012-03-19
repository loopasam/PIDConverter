/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Pathway {
    
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
     * 
     */
    public Pathway() {
	// TODO Auto-generated constructor stub
	this.curators = new ArrayList<String>();
	this.reviewers = new ArrayList<String>();
	this.pathwayComponents = new ArrayList<PathwayComponent>();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isSubnet() {
        return isSubnet;
    }
    public void setSubnet(boolean isSubnet) {
        this.isSubnet = isSubnet;
    }
    public String getOrganism() {
        return organism;
    }
    public void setOrganism(String organism) {
        this.organism = organism;
    }
    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public void setSource(String source) {
	this.source = source;
    }
    public String getSource() {
	return source;
    }
    public void setCurators(ArrayList<String> curators) {
	this.curators = curators;
    }
    public ArrayList<String> getCurators() {
	return curators;
    }

    public void setReviewers(ArrayList<String> reviewers) {
	this.reviewers = reviewers;
    }

    public ArrayList<String> getReviewers() {
	return reviewers;
    }

    public void setPathwayComponents(ArrayList<PathwayComponent> pathwayComponents) {
	this.pathwayComponents = pathwayComponents;
    }

    public ArrayList<PathwayComponent> getPathwayComponents() {
	return pathwayComponents;
    }
    
}
