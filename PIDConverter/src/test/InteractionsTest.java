/**
 * 
 */
package test;

import static org.junit.Assert.*;

import javax.xml.stream.XMLStreamException;

import manipulator.Converter;

import org.junit.Before;
import org.junit.Test;

import pid.Interaction;
import pid.Model;
import pid.PID;

/**
 * Test to see whether the interactions are correctly populated.
 * 
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
	Interaction interaction = model.getInteraction("206322");
	assertNotNull(interaction);
	assertEquals("microtubule-based movement",
		interaction.getInteractionType());
    }

    @Test
    public void testAbstraction() {
	Model model = pid.getModel();
	Interaction interaction = model.getInteraction("202269");
	assertEquals("Alternative NF-kappaB pathway", interaction
		.getAbstraction().getPathway_name());
	assertEquals("NCI-Nature Curated", interaction.getSource());
    }

    @Test
    public void testInteractionArrays() {
	Model model = pid.getModel();
	Interaction interaction = model.getInteraction("200806");
	assertEquals(2, interaction.getConditions().size());
	assertEquals("receptor clustering", interaction.getConditions().get(0)
		.getCondition_type());
	assertEquals("IDA", interaction.getEvidences().get(0));
	int pmid = interaction.getReferences().get(0);
	assertEquals(9244302, pmid);
    }

    @Test
    public void testLabelInteractionComponent() {
	Model model = pid.getModel();
	Interaction interaction = model.getInteraction("206160");
	assertEquals(3, interaction.getComponents().size());
	assertEquals("cytoplasm", interaction.getComponents().get(0)
		.getLabels().get(0).getValue());
    }

    @Test
    public void testPTMinteractionComponent() {
	Model model = pid.getModel();
	Interaction interaction = model.getInteraction("206160");
	assertEquals("Q05397-1", interaction.getComponents().get(0)
		.getPtmExpression().getPtmTerms().get(0).getProtein());
    }

}
