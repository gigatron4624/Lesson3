/** This code uses TestNG assertion methods to determine whether or not GrandSlamHex functions properly.
 * (1) Each hex array should have properly padded elements. This means that each hex number has 2 digits.
 * (2) The test string composed of single-digit integers should self-concatenate 4 times.
 * (3) The length of a base-64 string should equal the length of a base-64-URL string.
 * (4) The base-64 and base-64-URL string representations of the self-concatenated string should be identical.
 * The said string representations of the byte array should not be identical but differ by one character. The base-64
 * string should have a plus-sign as a character, and the base-64-url string should have a minus sign as a character.
 * (5) Each digit in the single-digit string should match its proper UTF-8 reference number.
 * Note: Some tests include more than one assertion checks.
 * The title is named after Kadabra the Pokemon (Pocket Monsters, 1996). */

package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Kadabra extends GrandSlamHex {

    /* Fields: They're only constant if they're declared static and final. In this code, they're not constant. */
    private String SDI = "0123456789"; // SDI = single digit integers
    private int A = 100; // size of test array of bytes carrying numbers from 0 to 99

    @Test
    void repeat4x() throws Exception {
        String oops = "The string is either stunted or bloated."; // assertion error message
        String ccs = repeat(SDI); // ccs = concatenated character string
        int l0 = SDI.length(); // length of original single-digit-integers string
        int l4 = ccs.length(); // length of ccs
        Assert.assertTrue(5*l0 == l4, oops); // Does the SDI string self-concatenate 4 times?
    }

    @Test
    void HexArrayStrings() throws Exception {
        // hdo: hex digits only

        // 100 elements in the byte array should indicate 200 hex digits.
        String hs1 = b2h(ta(A)); // convert byte array to hex string
        String oops1 = "Time to recount the digits."; // assertion error message
        String hdo1 = hs1.replaceAll("[\\[ ,\\]]",""); // removes brackets, commas, and gaps
        Assert.assertEquals(hdo1.length(),2*A, oops1); // Does each element consist of two hex digits?

        // 50 digits in the concatenated string should mean 50 array elements, or 100 hex digits.
        String hs2 = b2h(s2b(repeat(SDI))); // converts concatenated string to byte array and produces a hex string
        String oops2 = "This string needs a recount."; // assertion error message
        String hdo2 = hs2.replaceAll("[\\[ ,\\]]",""); // removes brackets, commas, and gaps
        Assert.assertEquals(hdo2.length(),2*repeat(SDI).length(), oops2); // Does each hex number have two digits?
    }

    @Test
    void all64basesloaded() throws Exception {

        // Case 1: Byte Array of 0-99
        String b64s1 = whomp(ta(A)); // convert byte array to base-64 string
        String b64us1 = bomp(ta(A)); // convert byte array to base-64-URL string

        // Are both strings of equal length?
        Assert.assertEquals(b64s1.length(), b64us1.length(), "I expected " + b64s1.length() + " digits each!");

        // The base-64 string should have a plus sign and the base-64-URL string should have a minus sign.
        Assert.assertFalse(b64s1.equals(b64us1),"Each string should have one unique character!");

        // Case 2: Self-concatenated string
        String b64s2 = whomp(s2b(repeat(SDI)));
        String b64us2 = bomp(s2b(repeat(SDI)));

        // Are the strings identical?
        Assert.assertEquals(b64s2.length(), b64us2.length(), "The lengths aren't the same!");
        Assert.assertTrue(b64s2.equals(b64us2),"I was expecting a carbon copy!");
    }

    @Test
    void brn() throws Exception{
        /*brn: byte reference numbers
        * Each digit from 0 to 9 should correspond to its proper UTF-8 reference number. */

        byte[] od = s2b(SDI); // converts digits to bytes (od = ones digits)
        byte[] u8rn = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57}; // UTF-8 reference numbers (0 has a rn of 48)
        String oops = "Cloning of array of single-digits failed. "; // assertion error message
        Assert.assertEquals(od, u8rn, oops); // Do the bytes match?
    }
}