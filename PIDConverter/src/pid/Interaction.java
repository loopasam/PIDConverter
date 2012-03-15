/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * @author Samuel Croset
 *
 */
public class Interaction {
    
    //It's a string because of one problem with an id
    private String id;
    //Odd construct of the XML
    private String interactionType;
    private Abstraction abstraction;
    private String source;
    private ArrayList<Condition> conditions;
    private ArrayList<String> evidences;
    private ArrayList<Integer> references;
    private ArrayList<InteractionComponent> components;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setInteractionType(String interactionType) {
	this.interactionType = interactionType;
    }
    public String getInteractionType() {
	return interactionType;
    }
    public Abstraction getAbstraction() {
        return abstraction;
    }
    public void setAbstraction(Abstraction abstraction) {
        this.abstraction = abstraction;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public ArrayList<Condition> getConditions() {
        return conditions;
    }
    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }
    public ArrayList<String> getEvidences() {
        return evidences;
    }
    public void setEvidences(ArrayList<String> evidences) {
        this.evidences = evidences;
    }
    public ArrayList<Integer> getReferences() {
        return references;
    }
    public void setReferences(ArrayList<Integer> references) {
        this.references = references;
    }
    public ArrayList<InteractionComponent> getComponents() {
        return components;
    }
    public void setComponents(ArrayList<InteractionComponent> components) {
        this.components = components;
    }
    
    /**
     * 
     */
    public Interaction() {
	// TODO Auto-generated constructor stub
	this.components = new ArrayList<InteractionComponent>();
	this.conditions = new ArrayList<Condition>();
	this.evidences = new ArrayList<String>();
	this.references = new ArrayList<Integer>();
    }
    
    
}
