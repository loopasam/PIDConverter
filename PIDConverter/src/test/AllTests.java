/**
 * 
 */
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Samuel Croset
 * 
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ InteractionsTest.class, MoleculesTest.class,
	OntologyTest.class, PathwaysTest.class })
public class AllTests {

}
