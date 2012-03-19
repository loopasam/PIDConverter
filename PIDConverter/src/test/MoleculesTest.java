/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import manipulator.Converter;

import org.junit.Before;
import org.junit.Test;

import pid.ComplexComponent;
import pid.FamilyMember;
import pid.Model;
import pid.Molecule;
import pid.MoleculePart;
import pid.Name;
import pid.PID;
import pid.PTMExpression;
import pid.PTMTerm;
import pid.PreferredSymbolName;
import pid.UniprotName;

/**
 * Test to see whether the molecules elements are well populated
 * 
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

    @Test
    public void testComplexComponentMolecule() throws XMLStreamException {
	Model model = pid.getModel();
	Molecule moleculeComplex = model.getMolecule(207617);
	assertEquals("RET9/GFRalpha1/GDNF/SHC/Grb2/SOS1", moleculeComplex
		.getPreferredSymbolName().getValue());
	ArrayList<ComplexComponent> complexComponents = moleculeComplex
		.getComplexComponents();
	assertEquals(9, complexComponents.size());
	ComplexComponent component = complexComponents.get(0);
	assertEquals(201600, component.getMolecule_idref());
	assertEquals(2, component.getLabels().size());
	PTMExpression ptmExpression = component.getPtmExpression();
	assertEquals(7, ptmExpression.getPtmTerms().size());
	PTMTerm term = ptmExpression.getPtmTerms().get(0);
	assertEquals(806, term.getPosition());
	assertEquals("phosphorylation", term.getModification());
    }

    @Test
    public void testFamiliesMolecule() {
	Model model = pid.getModel();
	Molecule moleculeFamily = model.getMolecule(200033);
	assertEquals(3, moleculeFamily.getMembers().size());
	FamilyMember member = moleculeFamily.getMembers().get(0);
	assertEquals(201087, member.getMember_molecule_idref());
	PTMTerm ptmTerm = member.getPtmExpression().getPtmTerms().get(0);
	assertEquals("P07947", ptmTerm.getProtein());
    }

    @Test
    public void testPartMolecule() {
	Model model = pid.getModel();
	Molecule moleculePart = model.getMolecule(200978);
	MoleculePart part = moleculePart.getParts().get(0);
	assertEquals(200451, part.getWhole_molecule_idref());
    }

}
