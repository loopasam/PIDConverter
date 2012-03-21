/**
 * 
 */
package manipulator;

import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

import pid.Molecule;
import pid.PID;

/**
 * Examples on how to interact with the library.
 * 
 * @author Samuel Croset
 * 
 */
public class Example {

    public static void main(String[] args) throws IOException,
    XMLStreamException, ClassNotFoundException {


	//Register the URL where the PID XML version is stored.
	URL pidUrl = new URL("ftp://ftp1.nci.nih.gov/pub/PID/XML/NCI-Nature_Curated.xml.gz");
	//Create a converter, first param is the url, the second is path and name where to save the serialised objects.
	Converter converter = new Converter(pidUrl, "data/NCI-Nature_Curated.ser");
	//Start to parse the PID XML
	converter.start();
	//Serialise PID at the location entered in the constructor.
	converter.save();

	//Alternative way of parsing the PID XML from a local version of the file.
	//First param is the path to XML, second parameter is the path and name of the output file.
	//	Converter converterLocal = new Converter("data/NCI-Nature_Curated.xml",
	//    "data/NCI-Nature_Curated-from-local.ser");

	//Once the PID has been serialised once, it can be loaded this way:
	PID pid = new PID("data/NCI-Nature_Curated.ser");
	//Get the creation date of the PID
	System.out.println("creation: " + pid.getCreated());


	//To interact with the content of PID, the best is to use a for construct, till you reach the desired object.
	//Example:
	//Iterates over the molecules present inside the PID
	for (Molecule molecule : pid.getModel().getMolecules()) {
	    //Print out the names of ALL the molecules inside the PID
	    System.out.println(molecule.getPreferredSymbolName().getValue());
	}


    }

}
