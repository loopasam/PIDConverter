/**
 * 
 */
package pid;

import java.io.Serializable;

/**
 * A step in a pathway, pointing to an interaction.
 * 
 * @author Samuel Croset
 * 
 */
@SuppressWarnings("serial")
public class PathwayComponent implements Serializable {

    // It's a string for some odd reasons
    private String interaction_idref;

    public void setInteraction_idref(String interaction_idref) {
	this.interaction_idref = interaction_idref;
    }

    /**
     * @return the id of the interaction.
     */
    public String getInteraction_idref() {
	return interaction_idref;
    }

}
