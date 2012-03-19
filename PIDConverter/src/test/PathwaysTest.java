/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;


import javax.xml.stream.XMLStreamException;

import manipulator.Converter;

import org.junit.Before;
import org.junit.Test;

import pid.Model;
import pid.PID;
import pid.Pathway;

/**
 * @author Samuel Croset
 *
 */
public class PathwaysTest {

    private PID pid;

    @Before
    public void initiatePid() throws XMLStreamException {
	Converter converter = new Converter("data/NCI-Nature_Curated.xml");
	converter.start();
	this.pid = converter.getPid();

    }

    @Test
    public void testPathwayBasicInfos() throws XMLStreamException {
	Model model = pid.getModel();
	Pathway pathway = model.getPathway(200202);
	assertEquals(pathway.isSubnet(), true);
	assertEquals("Hs", pathway.getOrganism());
	assertEquals("HIF-1-alpha transcription factor network", pathway.getLongName());
	assertEquals("hif1_tfpathway", pathway.getShortName());
	assertEquals("NCI-Nature Curated", pathway.getSource());
	assertEquals(1, pathway.getCurators().size());
	assertEquals("Kira Anthony", pathway.getCurators().get(0));
	assertEquals("Guo-Hua Fong", pathway.getReviewers().get(1));
	assertEquals(57, pathway.getPathwayComponents().size());
	assertEquals("209914", pathway.getPathwayComponents().get(55).getInteraction_idref());
    }

}
