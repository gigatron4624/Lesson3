/** This code uses TestNG assertion tests to check if TungsticAcidRain functions properly. The first two assertion
 * tests check if the exported Base64URL string has a length divisible by 4 and whether or not the exported string
 * has to be padded. The last assertion test verifies that the original and reconstructed GSON strings are identical.
 * The name of this TestNG class pokes fun at WSO2 like its parent class does. Even code needs oxygen, right? XD */

package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvenCodeNeedsAir extends TungsticAcidRain {

    /** @return an error message should one or more assertion test fail
     * boo is a nod to crowds that boo when they don't get what they want. */
    private String boo(){
        return "Error: Code can't breathe!"; // assertion error message
    }

    /* Assertion Tests */

    /** inspect: reads JSON string from a file and stores into a console
     * bomp: converts JSON string to Base64URL string
     * pmob: converts a Base64URL string to an array of bytes
     * ba2s: transforms byte array into a UTF-8 string
     * carboncopy: checks if the original and reconstructed JSON strings are carbon copies (i.e. identical strings)
     * Tungsten has a symbol of W, while sulfur dioxide has a formula of SO2. Tungsten sulfoxide is thus a pun on WSO2.
     * The tests will throw exceptions if any of the above methods throw one or more exception. */

    @Test
    void testBomp() throws Exception {

        String ojs = inspect("tungstensulfoxide.txt"); // ojs = original JSON string
        String ejs = bomp(ojs); // ejs = encoded JSON string
        System.out.println(ejs); // print the encoded JSON string to console
        int bscs = ejs.length(); // should be 1484; bscs = Base64URL string character sum
        System.out.println(bscs); // print Base64URL string to console

        char lb64uc = ejs.charAt(bscs-1); // lb64uc = last base64URL character
        Assert.assertTrue(bscs % 4 == 0, boo()); // Is the length of the encoded string divisible by 4?
        Assert.assertFalse(lb64uc != '=',boo()); // Does the string need padding?
    }

    @Test
    void testCarboncopy() throws Exception {
        String ojs = inspect("tungstensulfoxide.txt"); // original JSON string
        String ejs = bomp(ojs); // encoded JSON string
        byte[] dba = pmob(ejs); // dba = decoded byte array
        String rjs = ba2s(dba); // reconstructed JSON string
        Assert.assertTrue(carboncopy(ojs,rjs), boo()); // Does carboncopy return true?
    }
}
