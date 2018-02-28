/* This program uses TestNG assertion methods to compare the byte sums of a string when subject to various
* character sets. Each byte sum should match a specific value so that the string size doesn't affect the abilities
* of each character set to properly encode characters into bytes. */
package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CharSetCheck {

    /* Fields: They are not necessarily constant unless classified as static and final. */
    private String s = "Mama Mia!"; // this is a sample string
    private int sl = s.length(); // sl = length of sample string

    /* Character Sets */
    /* Each set is numbered in parentheses. */
    private Charset CS01 = Charset.forName("UTF-8"); // default character set (1)
    private Charset CS02 = Charset.forName("US-ASCII"); // (2)
    private Charset CS03 = Charset.forName("ISO-8859-1"); // Latin-1 (3)
    private Charset CS04 = Charset.forName("UTF-16"); // aka x-UTF-16BE-BOM? (4)
    private Charset CS05 = Charset.forName("UTF-16BE"); // BE = Big Endian (5)
    private Charset CS06 = Charset.forName("UTF-16LE"); // LE = Little Endian (6)
    private Charset CS07 = Charset.forName("x-UTF-16LE-BOM"); // BOM = byte order mark (7)
    private Charset CS08 = Charset.forName("UTF-32"); // (8)
    private Charset CS09 = Charset.forName("UTF-32BE"); // (9)
    private Charset CS10 = Charset.forName("X-UTF-32BE-BOM"); // (10)
    private Charset CS11 = Charset.forName("UTF-32LE"); // (11)
    private Charset CS12 = Charset.forName("X-UTF-32LE-BOM"); // (12)
    private Charset CS13 = Charset.forName("IBM1047"); // aka EBCDIC (13)

    /** Method oops() is called when assertEquals throws an assertion error.
     * An assertion error occurs if the string returns an incorrect byte sum for one or more character sets.
     * @return error message indicating an incorrect byte sum */
    private String oops(){
        return "Oops! Some bytes are missing!";
    }

    /** ByteSumArray converts a string to an array of bytes using barr and counts bytes using ByteCount.
     * barr accepts a string and character set and converts the string to bytes using said character set.
     * ByteCount calculates the length of the byte array, or the number of bytes in the converted string.
     * @param p is an input string variable (p = phrase)
     * @return an array of byte sums for all 13 character sets*/
    int[] ByteSumArray(String p){

        GetACharset gac = new GetACharset(); // invokes source code (GerACharset) and instantiates object
        int[] bsa = new int[13]; // initializes row of 13 elements

        // fills each element with a byte sum
        bsa[0] = gac.ByteCount(gac.barr(p,CS01)); // UTF-8: 1 byte per string character
        bsa[1] = gac.ByteCount(gac.barr(p,CS02)); // US-ASCII: 1 byte per string character
        bsa[2] = gac.ByteCount(gac.barr(p,CS03)); // ISO-8859-1: 1 byte per string character
        bsa[3] = gac.ByteCount(gac.barr(p,CS04)); // UTF-16: 2 bytes per string character + 2 BOMs
        bsa[4] = gac.ByteCount(gac.barr(p,CS05)); // UTF16BE: 2 bytes per string character
        bsa[5] = gac.ByteCount(gac.barr(p,CS06)); // UTF16LE: 2 bytes per string character
        bsa[6] = gac.ByteCount(gac.barr(p,CS07)); // x-UTF-16LE-BOM: 2 bytes per string character + 2 BOMs
        bsa[7] = gac.ByteCount(gac.barr(p,CS08)); // UTF-32: 4 bytes per string character
        bsa[8] = gac.ByteCount(gac.barr(p,CS09)); // UTF-32BE: 4 bytes per string character
        bsa[9] = gac.ByteCount(gac.barr(p,CS10)); // X-UTF-32BE-BOM: 4 bytes per string character + 4 BOMs
        bsa[10] = gac.ByteCount(gac.barr(p,CS11)); // UTF-32LE: 4 bytes per string character
        bsa[11] = gac.ByteCount(gac.barr(p,CS12)); // X-UTF-32LE-BOM: 4 bytes per string character + 4 BOMs
        bsa[12] = gac.ByteCount(gac.barr(p,CS13)); // IBM1047: 1 byte per string character
        return bsa; // array of byte sums
    }

    /* In this code, 13 tests are treated as 1 assessment. */

    @Test
    void match() throws Exception{
        String bummer = oops(); // error message

        // Charsets 1 (UTF-8), 2 (US-ASCII), 3 (ISO-8859-1), and 13 (IBM1047)
        int a = sl; // byte sum should match character sum (1 byte per character)

        // Charsets 5 (UTF-16BE) and 6 (UTF-16LE)
        int b = 2*a; // byte sum should be double the character sum (2 bytes per character)

        // Charsets 4 (UTF-16) and 7 (x-UTF-16LE-BOM)
        int c = b + 2; // byte sum = double the character sum + 2 BOMs

        // Charsets 8 (UTF-32), 9 (UTF-32BE), and 11 (UTF-32LE)
        int d = 2*b; // byte sum should be four times the character sum

        // Charsets 10 (X-UTF-32BE-BOM) and 12 (X-UTF-32LE-BOM)
        int e = 2*c; // four times the character sum plus 4 BOMS

        int[] esums = {a, a, a, c, b, b, c, d, d, e, d, e, a}; // expected byte sums
        System.out.println(Arrays.toString(esums));

        int[] asums = ByteSumArray(s); // actual byte sums

        // asserts that each byte sum matches its expected value
        Assert.assertEquals(asums, esums, bummer); // throws assertion error if any value does not match
    }
}
