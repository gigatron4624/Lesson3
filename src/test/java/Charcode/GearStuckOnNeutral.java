/** This code uses TestNG assertion methods to check if TheGSONMenace functions properly. The purpose of assertion
 * testing in this case is to verify that both Address objects has identical content/fields. The first Address object
 * is initialized through standard procedure, while GSON converts the first instance to and from JSON to initialize
 * the second instance. */

package Charcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearStuckOnNeutral extends TheGSONMenace {

    /* Address Fields */
    private String tag = "WTF Productions"; // tag is another word for name; the address is fake
    private String location = "7056 Blight Boulevard"; // street address; this one is fake
    private String city = "East Bumf--k, Mississippi"; // Every address needs a city. This city is fake.
    private int zone = 38809; // zone is the zip code (this one is fake)

    /** @return an error message should one or more assertion test fail */
    private String boo(){
        return "The gear stick is still jammed. Un-jam it now."; // assertion error message
    }

    /** This method generates an Address instance with occupied fields. [1]
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

    @Test(alwaysRun = true)
    void testGetters(){

        TheGSONMenace tgm1 = new TheGSONMenace(tag, location, city, zone); // initialize 1st Address instance
        Gson shift = new GsonBuilder().create(); // builds a GSON instance
        String mask = shift.toJson(tgm1); // converts address object to JSON string
        TheGSONMenace tgm2 = shift.fromJson(mask, TheGSONMenace.class); // create 2nd address instance

        Assert.assertEquals(tgm1.getTag(),tgm2.getTag(),boo()); // Do the names match?
        Assert.assertEquals(tgm1.getLocation(),tgm2.getLocation(),boo()); // Do the locations match?
        Assert.assertEquals(tgm1.getCity(),tgm2.getCity(),boo()); // Do the cities match?
        Assert.assertEquals(tgm1.getZone(),tgm2.getZone(),boo()); // Do the zip codes match?
    }

    /* Works Cited */
    /* [1] Source: Address.java. Author: Thomas Kennedy. Old Dominion University
     * https://www.cs.odu.edu/~tkennedy/cs350/sum16/Public/adtTesting/Address.java.html */
}
