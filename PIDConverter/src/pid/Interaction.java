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
    private Abstraction abstraction;
    private String source;
    private ArrayList<Condition> conditions;
    private ArrayList<Label> labels;
    private ArrayList<String> evidences;
    private ArrayList<Integer> references;
    private ArrayList<InteractionComponent> components;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public ArrayList<Label> getLabels() {
        return labels;
    }
    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
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
    
    
}
