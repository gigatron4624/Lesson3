/** This code uses TestNG assertion methods to check if TheGSONMenace functions properly. The purpose of assertion
 * testing in this case is to verify that both Address objects has identical content/fields. The first Address object
 * is initialized through standard procedure, while GSON converts the first instance to and from JSON to initialize
 * the second instance. GearStuckOnNeutral is a spoof on GSON. XD */

package Charcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearStuckOnNeutral extends TheGSONMenace {

    /** @return an error message should one or more assertion test fail */
    private String boo(){
        return "The gear stick is still jammed. Un-jam it now."; // assertion error message
    }

    /* No Argument Constructor */
    /* User beware: This is only placed for TestNG to run the tests. Otherwise use the constructor below. */
    GearStuckOnNeutral(){
        // Voila! Empty!
    }

    /* Address Instantiation Constructor */
    /** This constructor generates an Address instance with occupied fields. [1]
     * @param tag      is the name of the place
     * @param location is the address of the place
     * @param city     is the city in which the address is located
     * @param zone     is the zip code */
    GearStuckOnNeutral(String tag, String location, String city, int zone) {
        super(tag, location, city, zone);
    }

    /*Test Method: 4 bundled into 1
     * 1. Do the names match?
     * 2. Do the street addresses match?
     * 3. Do the cities match?
     * 4. Do the zip codes match? */

    @Test()
    void testGetters() throws Exception{

        String tag1 = "WTF Productions"; // This name is fake.
        String location1 = "7056 Blight Boulevard"; // This street address is fake.
        String city1 = "East Bumf--k, Mississippi"; // EThis city is fake.
        int zone1 = 38809; // This zip code is fake.

        // initialize 1st Address instance
        GearStuckOnNeutral tgm1 = new GearStuckOnNeutral(tag1, location1, city1, zone1);
        Gson shift = new GsonBuilder().create(); // builds a GSON instance (shift variables to JSON object)
        String json = shift.toJson(tgm1); // converts address object to JSON string
        GearStuckOnNeutral tgm2 = shift.fromJson(json, GearStuckOnNeutral.class); // create 2nd address instance

        //The TestNG assertions test begins here.
        Assert.assertEquals(tgm1.getTag(),tgm2.getTag(),boo()); // Do the names match?
        Assert.assertEquals(tgm1.getLocation(),tgm2.getLocation(),boo()); // Do the locations match?
        Assert.assertEquals(tgm1.getCity(),tgm2.getCity(),boo()); // Do the cities match?
        Assert.assertEquals(tgm1.getZone(),tgm2.getZone(),boo()); // Do the zip codes match?
    }

    /* Works Cited */
    /* [1] Source: Address.java. Author: Thomas Kennedy. Old Dominion University
     * https://www.cs.odu.edu/~tkennedy/cs350/sum16/Public/adtTesting/Address.java.html */
}
