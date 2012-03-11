/**
 * 
 */
package converter;

import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import pid.AliasName;
import pid.ChemicalAbstractName;
import pid.Complex;
import pid.EntrezGeneName;
import pid.GeneOntologyName;
import pid.LabelType;
import pid.LabelValue;
import pid.Model;
import pid.Molecule;
import pid.Name;
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

	verifyMolecules(pid);
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