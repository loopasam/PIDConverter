/**
 * 
 */
package pid;

import java.util.ArrayList;

/**
 * Interaction between two entities
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
    
    /**
     * @return the ID of the current interaction
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setInteractionType(String interactionType) {
	this.interactionType = interactionType;
    }
    
    /**
     * @return the type of interaction. <bold>WARNING: this part is odd, because of the original XML</bold>
     */
    public String getInteractionType() {
	return interactionType;
    }
    
    /**
     * @return the abstraction object, which is a reference to another pathway.
     */
    public Abstraction getAbstraction() {
        return abstraction;
    }
    public void setAbstraction(Abstraction abstraction) {
        this.abstraction = abstraction;
    }
    
    /**
     * @return the databse from which the interaction is coming from (only PID at the moment).
     */
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    
    /**
     * @return the condition (Positive or Negative) governing the apparition of this interation.
     */
    public ArrayList<Condition> getConditions() {
        return conditions;
    }
    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }
    
    /**
     * @return the list of evidences. At the moment it is a 3 letters code, should be mapped to human readable via static variable.
     */
    public ArrayList<String> getEvidences() {
        return evidences;
    }
    public void setEvidences(ArrayList<String> evidences) {
        this.evidences = evidences;
    }
    
    /**
     * @return the list of PubMed Ids (pmid) describing the interaction.
     */
    public ArrayList<Integer> getReferences() {
        return references;
    }
    public void setReferences(ArrayList<Integer> references) {
        this.references = references;
    }
    
    /**
     * @return the list of components interacting in this interaction.
     */
    public ArrayList<InteractionComponent> getComponents() {
        return components;
    }
    public void setComponents(ArrayList<InteractionComponent> components) {
        this.components = components;
    }
    
    /**
     * Only constructor, initialise the arrays.
     */
    public Interaction() {
	this.components = new ArrayList<InteractionComponent>();
	this.conditions = new ArrayList<Condition>();
	this.evidences = new ArrayList<String>();
	this.references = new ArrayList<Integer>();
    }
    
    
}
