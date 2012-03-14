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
    private ArrayList<ComplexComponent> complexComponents;
    private ArrayList<FamilyMember> familyMembers;
    private ArrayList<MoleculePart> parts;

    public void setParts(ArrayList<MoleculePart> parts) {
	this.parts = parts;
    }

    public ArrayList<MoleculePart> getParts() {
	return parts;
    }

    public void setMembers(ArrayList<FamilyMember> familyMembers) {
	this.familyMembers = familyMembers;
    }

    public ArrayList<FamilyMember> getMembers() {
	return familyMembers;
    }

    public void setComplexComponents(ArrayList<ComplexComponent> complexComponents) {
	this.complexComponents = complexComponents;
    }

    public ArrayList<ComplexComponent> getComplexComponents() {
	return complexComponents;
    }

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
	this.complexComponents = new ArrayList<ComplexComponent>();
	this.familyMembers = new ArrayList<FamilyMember>();
	this.parts = new ArrayList<MoleculePart>();
    }

    /**
     * @return 
     */
    public UniprotName getUniprotName() {
	for (Name name : this.names) {
	    if(name.getClass().equals(UniprotName.class)){
		return (UniprotName) name;
	    }
	}
	return null;
    }

    /**
     * @return
     */
    public PreferredSymbolName getPreferredSymbolName() {
	for (Name name : this.names) {
	    if(name.getClass().equals(PreferredSymbolName.class)){
		return (PreferredSymbolName) name;
	    }
	}
	return null;
    }

}
