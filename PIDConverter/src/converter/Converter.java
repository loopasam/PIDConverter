/**
 * 
 */
package converter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import pid.ActivityStateLabel;
import pid.AliasName;
import pid.ChemicalAbstractName;
import pid.Complex;
import pid.ComplexComponent;
import pid.EntrezGeneName;
import pid.GeneOntologyName;
import pid.Label;
import pid.LabelType;
import pid.LabelValue;
import pid.LocationLabel;
import pid.Model;
import pid.Molecule;
import pid.Name;
import pid.PTMExpression;
import pid.PTMTerm;
import pid.PreferredSymbolName;
import pid.Protein;
import pid.Ontology;
import pid.PID;
import pid.RNA;
import pid.Compound;
import pid.UniprotName;

import core.XMLBurger;



/**
 * @author Samuel Croset
 *
 */
public class Converter {


    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError  {

	XMLBurger burger = new XMLBurger("data/NCI-Nature_Curated.xml");
	//	XMLBurger burger = new XMLBurger("data/dev.xml");

	PID pid = new PID();

	while(burger.isNotOver()){

	    if(burger.tag("NCI_PID_XML")){

		while(burger.inTag("NCI_PID_XML")){
		    if(burger.tag("Created")){
			pid.setCreated(burger.getTagText());
		    }
		    //Ontogy tag
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

		    //TODO model tag
		    if(burger.tag("Model")){
			Model model = new Model();
			while(burger.inTag("Model")){
			    //Molecule Tags
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
					    
					    //TODO finir les molecules
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
						    }
						}
						
					    }

					}
					model.getMolecules().add(molecule);
				    }
				}

			    }
			}
			pid.setModel(model);

		    }

		}
	    }
	}

//	verifyMolecules(pid);
	//	verifyOntologyData(pid);

    }

    /**
     * @param pid 
     * 
     */
    private static void verifyMolecules(PID pid) {
	// TODO Auto-generated method stub
	Model model = pid.getModel();
	for (Molecule molecule : model.getMolecules()) {
	    System.out.println("ID: " + molecule.getId());
	    for (Name name : molecule.getNames()) {
		System.out.println("Name: " + name.getValue());
	    }
	}
    }

    /**
     * @param pid 
     * 
     */
    private static void verifyOntologyData(PID pid) {
	// TODO Auto-generated method stub
	String created = pid.getCreated();
	System.out.println("Created: " + created);
	Ontology ontology = pid.getOntology();
	for (LabelType labelType : ontology.getLabelTypes()) {
	    System.out.println("Id: " + labelType.getId() + " - Name: " + labelType.getName());
	    for (LabelValue labelValue : labelType.getLabelValues()) {
		System.out.println("label name: " + labelValue.getName() + " -Id: " + labelValue.getId() + " -GO: " + labelValue.getGo() + "  - Parent: " + labelValue.getParent_idref());
	    }

	}
    }

}