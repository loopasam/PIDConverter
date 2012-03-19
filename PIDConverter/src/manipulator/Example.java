/**
 * 
 */
package manipulator;

import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

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

	// //TODO just parsing
	// Converter converter = new Converter("data/data.pid");

	URL pidUrl = new URL(
		"ftp://ftp1.nci.nih.gov/pub/PID/XML/NCI-Nature_Curated.xml.gz");
	Converter uptodateConverter = new Converter(pidUrl,
		"data/NCI-Nature_Curated.ser");
	uptodateConverter.start();
	uptodateConverter.save();

	PID pid = new PID("data/NCI-Nature_Curated.ser");
	System.out.println("creation: " + pid.getCreated());

	// TODO maj download and parse

	// Converter converter = new Converter("data/NCI-Nature_Curated.xml",
	// "data/data.pid");
	// converter.start();
	// converter.save();
	//
	//
	//
	// PID pid = new PID("data/data.pid");
	// System.out.println("creation: " + pid.getCreated());

    }

}
