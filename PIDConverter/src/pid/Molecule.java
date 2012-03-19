/**
 * 
 */
package pid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Generic type of molecule, this class represent a structured sequence of
 * atoms.
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class Molecule implements Serializable {

    private int id;
    private ArrayList<Name> names;
    private ArrayList<ComplexComponent> complexComponents;
    private ArrayList<FamilyMember> familyMembers;
    private ArrayList<MoleculePart> parts;

    public void setParts(ArrayList<MoleculePart> parts) {
	this.parts = parts;
    }

    /**
     * @return the molecules in which the current molecule is part of.
     */
    public ArrayList<MoleculePart> getParts() {
	return parts;
    }

    public void setMembers(ArrayList<FamilyMember> familyMembers) {
	this.familyMembers = familyMembers;
    }

    /**
     * @return the family members of the current molecule.
     */
    public ArrayList<FamilyMember> getMembers() {
	return familyMembers;
    }

    public void setComplexComponents(
	    ArrayList<ComplexComponent> complexComponents) {
	this.complexComponents = complexComponents;
    }

    /**
     * @return the component of a complex molecule.
     */
    public ArrayList<ComplexComponent> getComplexComponents() {
	return complexComponents;
    }

    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the id of the current molecule.
     */
    public int getId() {
	return id;
    }

    public void setNames(ArrayList<Name> names) {
	this.names = names;
    }

    /**
     * @return the names associated with the current molecule. Names are ways to
     *         describe proteins by the community.
     */
    public ArrayList<Name> getNames() {
	return names;
    }

    /**
     * Only constructor, initialise the array.
     */
    public Molecule() {
	this.names = new ArrayList<Name>();
	this.complexComponents = new ArrayList<ComplexComponent>();
	this.familyMembers = new ArrayList<FamilyMember>();
	this.parts = new ArrayList<MoleculePart>();
    }

    /**
     * @return the uniprot name for the current molecule. Uniprot name is a
     *         cross-reference to a uniprot identifier.
     */
    public UniprotName getUniprotName() {
	for (Name name : this.names) {
	    if (name.getClass().equals(UniprotName.class)) {
		return (UniprotName) name;
	    }
	}
	return null;
    }

    /**
     * @return the preferred symbol of the current molecule. Useful to display
     *         the protein name to users.
     */
    public PreferredSymbolName getPreferredSymbolName() {
	for (Name name : this.names) {
	    if (name.getClass().equals(PreferredSymbolName.class)) {
		return (PreferredSymbolName) name;
	    }
	}
	return null;
    }

}
