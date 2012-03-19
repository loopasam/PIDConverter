/**
 * Converter from the XML of the Pathway Interaction Database into Java Objects
 */
package manipulator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import pid.Abstraction;
import pid.ActivityStateLabel;
import pid.Agent;
import pid.AliasName;
import pid.ChemicalAbstractName;
import pid.Complex;
import pid.ComplexComponent;
import pid.Compound;
import pid.EntrezGeneName;
import pid.FamilyMember;
import pid.FunctionLabel;
import pid.GeneOntologyName;
import pid.Inhibitor;
import pid.Input;
import pid.Interaction;
import pid.InteractionComponent;
import pid.Label;
import pid.LabelType;
import pid.LabelValue;
import pid.LocationLabel;
import pid.Model;
import pid.Molecule;
import pid.MoleculePart;
import pid.Name;
import pid.NegativeCondition;
import pid.Ontology;
import pid.Output;
import pid.PID;
import pid.PTMExpression;
import pid.PTMTerm;
import pid.Pathway;
import pid.PathwayComponent;
import pid.PositiveCondition;
import pid.PreferredSymbolName;
import pid.Protein;
import pid.RNA;
import pid.UniprotName;

import core.XMLBurger;

/**
 * @author Samuel Croset
 *Main Class
 */
public class Converter {

    private XMLBurger burger;
    private PID pid;
    private String outputPath;

    public void setOutputPath(String outputPath) {
	this.outputPath = outputPath;
    }

    public String getOutputPath() {
	return outputPath;
    }

    public void setBurger(XMLBurger burger) {
	this.burger = burger;
    }

    /**
     * @return the XMLBurger object used to parse the XML
     * 
     */
    public XMLBurger getBurger() {
	return burger;
    }

    /**
     * @param a PID object
     * 
     */
    public void setPid(PID pid) {
	this.pid = pid;
    }

    /**
     * @return the PID object in the current state. The parsing that have already happened define the content of the returned PID element
     */
    public PID getPid() {
	return pid;
    }

    /**
     * Construction of the converter from the XML file of the PID.
     * @param pathToXml
     */

    public Converter(String pathToXml) {
	this.pid = new PID();
	this.burger = new XMLBurger(pathToXml);
    }

    /**
     * Construction of the converter and outputting the serialised objects.
     * @param pathToXml
     * @param pathToOutputFile
     */
    public Converter(String pathToXml, String pathToOutputFile) {
	this.pid = new PID();
	this.burger = new XMLBurger(pathToXml);
	this.outputPath = pathToOutputFile;
    }

    /**
     * Preferred constructor.
     * Constructor downloading the file from the online repository, doing the conversion and outputting the results.
     * @param pidUrl
     * @param pathToOutputFile
     * @throws IOException 
     */
    public Converter(URL pidUrl, String pathToOutputFile) throws IOException {
	System.out.println("Downloading the Pathway Interaction Database...");
	ReadableByteChannel rbc = Channels.newChannel(pidUrl.openStream());
	FileOutputStream fos = new FileOutputStream("data/NCI-Nature_Curated.xml.gz");
	System.out.println("Saving the archive file...");
	fos.getChannel().transferFrom(rbc, 0, 1 << 24);
	System.out.println("Unzipping the Pathway Interaction Database...");
	byte[] buffer = new byte[1024];
	GZIPInputStream gzis = new GZIPInputStream(new FileInputStream("data/NCI-Nature_Curated.xml.gz"));
	FileOutputStream out = new FileOutputStream("data/NCI-Nature_Curated.xml");
	int len;
	while ((len = gzis.read(buffer)) > 0) {
	    out.write(buffer, 0, len);
	}
	gzis.close();
	out.close();
	System.out.println("The latest version of the Pathway Interaction Database has been succesfully downloaded and is ready to be processed");
	this.outputPath = pathToOutputFile;
	this.pid = new PID();
	this.burger = new XMLBurger("data/NCI-Nature_Curated.xml");
    }

    public static void main(String[] args) throws XMLStreamException, FactoryConfigurationError, IOException  {

	Converter converter = new Converter("data/NCI-Nature_Curated.xml", "data/data.pid");
	converter.start();
	converter.save();

    }

    /**
     * Save the created objects in  ".pid" file.
     * @throws IOException 
     */
    void save() throws IOException {

	FileOutputStream fileOut = new FileOutputStream(this.outputPath);
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(this.pid);
	out.close();
	fileOut.close();
    }

    /**
     * Start the parsing of the document
     * @throws XMLStreamException 
     */
    public void start() throws XMLStreamException {
	while(this.burger.isNotOver()){
	    if(this.burger.tag("NCI_PID_XML")){
		while(this.burger.inTag("NCI_PID_XML")){
		    if(this.burger.tag("Created")){
			pid.setCreated(this.burger.getTagText());
		    }

		    this.parseOntology();

		    if(burger.tag("Model")){
			Model model = new Model();
			while(burger.inTag("Model")){
			    this.parseMolecules(model);
			    this.parseInteractions(model);
			    this.parsePathways(model);
			}
			pid.setModel(model);

		    }

		}
	    }
	}
    }

    /**
     * Parse the pathway section
     * @param model
     */
    private void parsePathways(Model model) {

	if(burger.tag("PathwayList")){
	    while(burger.inTag("PathwayList")){
		if(burger.tag("Pathway")){
		    Pathway pathway = new Pathway();
		    pathway.setId(Integer.parseInt(burger.getTagAttribute("id")));
		    pathway.setSubnet(Boolean.parseBoolean(burger.getTagAttribute("subnet")));		    
		    while(burger.inTag("Pathway")){
			if(burger.tag("Organism")){
			    pathway.setOrganism(burger.getTagText());
			}
			if(burger.tag("LongName")){
			    pathway.setLongName(burger.getTagText());
			}
			if(burger.tag("ShortName")){
			    pathway.setShortName(burger.getTagText());
			}
			if(burger.tag("Source")){
			    pathway.setSource(burger.getTagText());
			}

			if(burger.tag("CuratorList")){
			    while(burger.inTag("CuratorList")){
				if(burger.tag("Curator")){
				    pathway.getCurators().add(burger.getTagText());
				}
			    }
			}

			if(burger.tag("ReviewerList")){
			    while(burger.inTag("ReviewerList")){
				if(burger.tag("Reviewer")){
				    pathway.getReviewers().add(burger.getTagText());
				}
			    }
			}

			if(burger.tag("PathwayComponentList")){
			    while(burger.inTag("PathwayComponentList")){
				if(burger.tag("PathwayComponent")){
				    PathwayComponent component = new PathwayComponent();
				    component.setInteraction_idref(burger.getTagAttribute("interaction_idref"));
				    pathway.getPathwayComponents().add(component);
				}
			    }

			}

		    }
		    model.getPathways().add(pathway);
		}
	    }

	}

    }


    /**
     * Parse the interactions
     * @param model
     * @throws XMLStreamException 
     */
    private void parseInteractions(Model model) throws XMLStreamException {


	if(burger.tag("InteractionList")){
	    while(burger.inTag("InteractionList")){
		if(burger.tag("Interaction")){
		    Interaction interaction = new Interaction();
		    String interactionType = burger.getTagAttribute("interaction_type");
		    interaction.setInteractionType(interactionType);
		    String id = burger.getTagAttribute("id");
		    interaction.setId(id);
		    while(burger.inTag("Interaction")){

			if(burger.tag("Abstraction")){
			    Abstraction abstraction = new Abstraction();
			    abstraction.setExternal_pathway_id(burger.getTagAttribute("external_pathway_id"));
			    abstraction.setPathway_idref(Integer.parseInt(burger.getTagAttribute("pathway_idref")));
			    abstraction.setPathway_name(burger.getTagAttribute("pathway_name"));
			    interaction.setAbstraction(abstraction);
			}

			if(burger.tag("Source")){
			    interaction.setSource(burger.getTagText());
			}

			if(burger.tag("PositiveCondition")){
			    PositiveCondition positiveCondition = new PositiveCondition();
			    positiveCondition.setCondition_type(burger.getTagAttribute("condition_type"));
			    interaction.getConditions().add(positiveCondition);
			}

			if(burger.tag("NegativeCondition")){
			    NegativeCondition negativeCondition = new NegativeCondition();
			    negativeCondition.setCondition_type(burger.getTagAttribute("condition_type"));
			    interaction.getConditions().add(negativeCondition);
			}

			if(burger.tag("EvidenceList")){
			    while(burger.inTag("EvidenceList")){
				if(burger.tag("Evidence")){
				    String evidence = burger.getTagAttribute("value");
				    interaction.getEvidences().add(evidence);
				}
			    }
			}

			if(burger.tag("ReferenceList")){
			    while(burger.inTag("ReferenceList")){
				if(burger.tag("Reference")){
				    int pmid = Integer.parseInt(burger.getTagAttribute("pmid"));
				    interaction.getReferences().add(pmid);
				}
			    }
			}

			if(burger.tag("InteractionComponentList")){
			    while(burger.inTag("InteractionComponentList")){
				if(burger.tag("InteractionComponent")){
				    InteractionComponent interactionComponent = null;
				    String role = burger.getTagAttribute("role_type");
				    int idref = Integer.parseInt(burger.getTagAttribute("molecule_idref"));

				    if(role.equals("input")){
					interactionComponent = new Input();
				    }else if(role.equals("output")){
					interactionComponent = new Output();
				    }else if(role.equals("agent")){
					interactionComponent = new Agent();
				    }else if(role.equals("inhibitor")){
					interactionComponent = new Inhibitor();
				    }

				    interactionComponent.setMolecule_idref(idref);

				    while(burger.inTag("InteractionComponent")){

					if(burger.tag("Label")){
					    String labelType = burger.getTagAttribute("label_type");
					    Label label = null;
					    if(labelType.equals("activity-state")){
						label = new ActivityStateLabel();
					    }else if(labelType.equals("location")){
						label = new LocationLabel();
					    }else if(labelType.equals("function")){
						label = new FunctionLabel();
					    }else{
						label = new Label();
					    }
					    label.setValue(burger.getTagAttribute("value"));
					    interactionComponent.getLabels().add(label);
					}

					if(burger.tag("PTMExpression")){
					    PTMExpression ptmExpression = new PTMExpression();
					    while(burger.inTag("PTMExpression")){
						if(burger.tag("PTMTerm")){
						    PTMTerm ptmTerm = new PTMTerm();
						    ptmTerm.setAminoAcid(burger.getTagAttribute("aa"));
						    ptmTerm.setModification(burger.getTagAttribute("modification"));
						    ptmTerm.setPosition(Integer.parseInt(burger.getTagAttribute("position")));
						    ptmTerm.setProtein(burger.getTagAttribute("protein"));
						    ptmExpression.getPtmTerms().add(ptmTerm);
						}
					    }
					    interactionComponent.setPtmExpression(ptmExpression);
					}					
				    }
				    interaction.getComponents().add(interactionComponent);

				}
			    }

			}
		    }
		    model.getInteractions().add(interaction);
		}
	    }
	}


    }

    /**
     * Parse the molecule bit.
     * @param model 
     * @throws XMLStreamException 
     * @throws NumberFormatException 
     * 
     */
    private void parseMolecules(Model model) throws NumberFormatException, XMLStreamException {

	if(burger.tag("MoleculeList")){
	    while(burger.inTag("MoleculeList")){
		if(burger.tag("Molecule")){
		    String moleculeType = burger.getTagAttribute("molecule_type");
		    Molecule molecule = null;

		    if(moleculeType.equals("protein")){
			molecule = new Protein();
		    }else if(moleculeType.equals("rna")){
			molecule = new RNA();
		    }else if(moleculeType.equals("compound")){
			molecule = new Compound();
		    }else if(moleculeType.equals("complex")){
			molecule = new Complex();
		    }

		    molecule.setId(Integer.parseInt(burger.getTagAttribute("id")));
		    while(burger.inTag("Molecule")){
			if(burger.tag("Name")){
			    Name name = null;
			    String nameType = burger.getTagAttribute("name_type");
			    String longNameType = burger.getTagAttribute("long_name_type");
			    String value = burger.getTagAttribute("value");

			    if(nameType.equals("UP")){
				name = new UniprotName();
			    }else if(nameType.equals("PF")){
				name = new PreferredSymbolName();
			    }else if(nameType.equals("AS")){
				name = new AliasName();
			    }else if(nameType.equals("CA")){
				name = new ChemicalAbstractName();
			    }else if(nameType.equals("GO")){
				name = new GeneOntologyName();
			    }else if(nameType.equals("LL")){
				name = new EntrezGeneName();
			    }else{
				name = new Name();
			    }

			    name.setAbbreviation(nameType);
			    name.setFullName(longNameType);
			    name.setValue(value);
			    molecule.getNames().add(name);	
			}

			if(burger.tag("ComplexComponentList")){
			    while(burger.inTag("ComplexComponentList")){
				if(burger.tag("ComplexComponent")){
				    ComplexComponent complexComponent = new ComplexComponent();
				    complexComponent.setMolecule_idref(Integer.parseInt(burger.getTagAttribute("molecule_idref")));
				    while(burger.inTag("ComplexComponent")){
					if(burger.tag("Label")){
					    String labelType = burger.getTagAttribute("label_type");
					    String labelValue = burger.getTagAttribute("value");
					    Label label = null;
					    if(labelType.equals("activity-state")){
						label = new ActivityStateLabel();
					    }else if(labelType.equals("location")){
						label = new LocationLabel();
					    }
					    label.setValue(labelValue);
					    complexComponent.getLabels().add(label);
					}
					if(burger.tag("PTMExpression")){
					    PTMExpression ptmExpression = new PTMExpression();
					    while(burger.inTag("PTMExpression")){
						if(burger.tag("PTMTerm")){
						    PTMTerm ptmTerm = new PTMTerm();
						    ptmTerm.setAminoAcid(burger.getTagAttribute("aa"));
						    ptmTerm.setModification(burger.getTagAttribute("modification"));
						    ptmTerm.setPosition(Integer.parseInt(burger.getTagAttribute("position")));
						    ptmTerm.setProtein(burger.getTagAttribute("protein"));
						    ptmExpression.getPtmTerms().add(ptmTerm);
						}
					    }
					    complexComponent.setPtmExpression(ptmExpression);
					}
				    }
				    molecule.getComplexComponents().add(complexComponent);
				}
			    }
			}

			if(burger.tag("FamilyMemberList")){
			    while(burger.inTag("FamilyMemberList")){
				if(burger.tag("Member")){
				    FamilyMember familyMember = new FamilyMember();
				    familyMember.setMember_molecule_idref(Integer.parseInt(burger.getTagAttribute("member_molecule_idref")));
				    while(burger.inTag("Member")){
					if(burger.tag("Label")){
					    String labelType = burger.getTagAttribute("label_type");
					    String labelValue = burger.getTagAttribute("value");
					    Label label = null;
					    if(labelType.equals("activity-state")){
						label = new ActivityStateLabel();
					    }else if(labelType.equals("location")){
						label = new LocationLabel();
					    }
					    label.setValue(labelValue);
					    familyMember.getLabels().add(label);
					}
					if(burger.tag("PTMExpression")){
					    PTMExpression ptmExpression = new PTMExpression();
					    while(burger.inTag("PTMExpression")){
						if(burger.tag("PTMTerm")){
						    PTMTerm ptmTerm = new PTMTerm();
						    ptmTerm.setAminoAcid(burger.getTagAttribute("aa"));
						    ptmTerm.setModification(burger.getTagAttribute("modification"));
						    ptmTerm.setPosition(Integer.parseInt(burger.getTagAttribute("position")));
						    ptmTerm.setProtein(burger.getTagAttribute("protein"));
						    ptmExpression.getPtmTerms().add(ptmTerm);
						}
					    }
					    familyMember.setPtmExpression(ptmExpression);
					}
				    }
				    molecule.getMembers().add(familyMember);
				}
			    }
			}

			if(burger.tag("Part")){
			    MoleculePart moleculepart = new MoleculePart();
			    moleculepart.setWhole_molecule_idref(Integer.parseInt(burger.getTagAttribute("whole_molecule_idref")));
			    moleculepart.setPart_molecule_idref(Integer.parseInt(burger.getTagAttribute("part_molecule_idref")));
			    String start = burger.getTagAttribute("start");
			    String end = burger.getTagAttribute("end");
			    if(!start.equals("")){
				moleculepart.setStart(Integer.parseInt(start));
			    }
			    if(!end.equals("")){
				moleculepart.setEnd(Integer.parseInt(end));
			    }
			    molecule.getParts().add(moleculepart);
			}
		    }
		    model.getMolecules().add(molecule);
		}
	    }
	}
    }

    /**
     * Parse the "Ontology" section.
     * @throws XMLStreamException 
     * @throws NumberFormatException 
     */
    private void parseOntology() throws NumberFormatException, XMLStreamException {
	if(burger.tag("Ontology")){
	    Ontology ontology = new Ontology();
	    while(burger.inTag("Ontology")){
		if(burger.tag("LabelType")){
		    LabelType labelType = new LabelType();
		    labelType.setId(Integer.parseInt(burger.getTagAttribute("id")));
		    labelType.setName(burger.getTagAttribute("name"));
		    while(burger.inTag("LabelType")){
			if(burger.tag("LabelValue")){
			    LabelValue labelValue = new LabelValue();
			    labelValue.setName(burger.getTagAttribute("name"));
			    labelValue.setGo(burger.getTagAttribute("GO"));
			    labelValue.setId(Integer.parseInt(burger.getTagAttribute("id")));
			    labelValue.setParent_idref(burger.getTagAttribute("parent_idref"));
			    labelType.getLabelValues().add(labelValue);
			}
		    }
		    ontology.getLabelTypes().add(labelType);
		}
	    }
	    pid.setOntology(ontology);
	}
    }
}

