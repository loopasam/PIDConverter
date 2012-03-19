/**
 * 
 */
package manipulator;

import java.io.IOException;

import pid.Model;
import pid.Molecule;
import pid.PID;

/**
 * @author Samuel Croset
 * 
 */
public class Reader {

    public static void main(String[] args) throws IOException,
	    ClassNotFoundException {

	PID pid = new PID("data/data.pid");

	System.out.println("creation: " + pid.getCreated());
	Model model = pid.getModel();
	for (Molecule molecule : model.getMolecules()) {
	    System.out.println("Molecule ID: " + molecule.getId());
	}
    }

}
