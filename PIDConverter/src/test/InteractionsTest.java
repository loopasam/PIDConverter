/**
 * 
 */
package test;

import static org.junit.Assert.*;


import javax.xml.stream.XMLStreamException;

import org.junit.Before;
import org.junit.Test;

import pid.Interaction;
import pid.Model;
import pid.PID;
import converter.Converter;

/**
 * @author Samuel Croset
 *
 */
public class InteractionsTest {

    private PID pid;

    @Before
    public void initiatePid() throws XMLStreamException {
	Converter converter = new Converter("data/NCI-Nature_Curated.xml");
	converter.start();
	this.pid = converter.getPid();

    }

    @Test
    public void testInteractionId() throws XMLStreamException {
	Model model = pid.getModel();
	Interaction interaction = model.getInteraction("205018");
	assertNotNull(interaction);
    }

}
