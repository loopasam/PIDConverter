/**
 * 
 */
package test;

import static org.junit.Assert.*;

import javax.xml.stream.XMLStreamException;

import manipulator.Converter;

import org.junit.Before;
import org.junit.Test;

import pid.LabelType;
import pid.LabelValue;
import pid.Ontology;
import pid.PID;



/**
 * Test to see whether the objects associated with ontology are correctly populated
 * @author Samuel Croset
 *
 */
public class OntologyTest {
    
    private PID pid;

    @Before
    public void initiatePid() throws XMLStreamException {
	Converter converter = new Converter("data/NCI-Nature_Curated.xml");
	converter.start();
	this.pid = converter.getPid();
	
    }
    
	@Test
	public void testOntologyLabelType() throws XMLStreamException {
		Ontology ontology = pid.getOntology();
		LabelType labelType = ontology.getLabelType("function");
		assertEquals(8, labelType.getId());
		LabelType labelTypeFromId = ontology.getLabelType(8);
		assertEquals("function", labelTypeFromId.getName());
	}

	@Test
	public void testOntologyLabelValue() throws XMLStreamException {
		Ontology ontology = pid.getOntology();
		LabelType labelType = ontology.getLabelType("function");
		LabelValue labelValue = labelType.getLabelValue(8000);
		assertEquals("molecular_function", labelValue.getName());
		LabelValue labelValueVoid = labelType.getLabelValue(8003);
		assertNull(labelValueVoid.getGo());
	}


}
