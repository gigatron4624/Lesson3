/** This code uses TestNG assertion tests to check if TungsticAcidRain functions properly. The first two assertion
 * tests check if the exported Base64URL string has a length divisible by 4 and whether or not the exported string
 * has to be padded. The last assertion test verifies that the original and reconstructed GSON strings are identical.
 * The name of this TestNG class pokes fun at WSO2 like its parent class does. Even code needs oxygen, right? XD */

package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvenCodeNeedsAir extends TungsticAcidRain {

    /** @return an error message should one or more assertion test fail */
    private String boo(){
        return "Error: Code can't breathe!"; // assertion error message
    }

    /*Assertion Tests*/

    @Test
    void testBomp() throws Exception {
        String ejs1 = inspect("scheelite.txt"); // encoded JSON string 1
        int bs1cs = ejs1.length(); // should be 1485
        char lb64uc = ejs1.charAt(bs1cs-1); // last base64 character
        Assert.assertTrue((bs1cs-1) % 4 == 0, boo()); // Is the length of the encoded string divisible by 4?
        Assert.assertFalse(lb64uc == '=',boo()); // Does the string need padding?
    }

    @Test
    void testCarboncopy() throws Exception {
        String ojs = inspect("tungstensulfite.txt"); // original JSON string
        String rjs = ba2s(pmob(inspect("scheelite.txt"))); // reconstructed JSON string
        Assert.assertTrue(carboncopy(ojs,rjs), boo()); // do they match?
    }
}