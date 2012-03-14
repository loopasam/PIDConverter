/**
 * 
 */
package test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import org.junit.Before;
import org.junit.Test;

import pid.Model;
import pid.Molecule;
import pid.Name;
import pid.PID;
import pid.PreferredSymbolName;
import pid.UniprotName;
import converter.Converter;


/**
 * Test to see whether the molecules elements are well populated
 * @author Samuel Croset
 *
 */
public class MoleculesTest {

    private PID pid;

    @Before
    public void initiatePid() throws XMLStreamException {
	Converter converter = new Converter("data/NCI-Nature_Curated.xml");
	converter.start();
	this.pid = converter.getPid();

    }

    @Test
    public void testMoleculeId() throws XMLStreamException {
	Model model = pid.getModel();
	Molecule molecule = model.getMolecule(201231);
	ArrayList<Name> names = molecule.getNames();
	assertEquals(2, names.size());
	UniprotName uniprotName = molecule.getUniprotName();
	assertEquals("P01903", uniprotName.getValue());
	PreferredSymbolName prefSymbol = molecule.getPreferredSymbolName();
	assertEquals("MHC II alpha", prefSymbol.getValue());
    }

}
