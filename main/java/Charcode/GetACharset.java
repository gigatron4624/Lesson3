/* This program converts a sample string to bytes through various character sets. The program prints double-digit
 * hexadecimal representations for each byte, and the byte count measured by each character set, and the
 * name of each character set used to convert the sample string into an array of bytes. */
package Charcode;

import java.lang.String;
import java.nio.charset.Charset;
import java.util.Arrays;

public class GetACharset {

    /* Package-Private Methods */

    /** barr converts a string to an array of bytes through a character set. (barr = byte array)
     * Each byte in the array stores the numerical reference value of a character in a string.
     * Each reference value depends on the character set being applied.
     * @param ts is the test string
     * @param cs is the character set
     * @return an array of bytes that contain character reference numbers */
    byte[] barr (String ts, Charset cs){
        return ts.getBytes(cs); // encodes the test string into a sequence of bytes
    }

    /** ByteCount counts the number of bytes in a string when converted to byte array through a character set.
     * @param ba is the array of bytes to be analyzed
     * @return the number of bytes in the test string */
    int ByteCount(byte[] ba){
        return ba.length; //
    }

    /** b2d converts bytes of character reference numbers to integers in decimal format.
     * each integer represents the corresponding reference number of a byte within a character set
     * @param ba is the input byte array
     * @return a string representation of an array of byte reference numbers in decimal format */
    String b2d(byte[] ba){
        return Arrays.toString(ba);
    }

    /** b2h is similar to b2d, except that it converts bytes to hexadecimal numbers.
     * @param ba is the input byte array
     * @return a string representation of an array of byte reference numbers in hexadecimal format */
    String b2h(byte[] ba){
        String[] hda = new String[ba.length]; // hda = hexadecimal array
        for(int i = 0; i < ba.length; i++){
            hda[i] = String.format("%02x",ba[i]); // converts each element to a 2-digit hexadecimal integer
        }
        return Arrays.toString(hda);
    }

    /* Private Method */

    /** p2c extracts data from byte arrays and prints the data to the console. p2c calls ByteCount to print the number
     * of bytes in the test string when converted to bytes using various character sets. p2c calls b2d and b2h
     * to print decimal and hexadecimal representations, respectively, of byte arrays to the console.
     * @param ts is the test string */
    private void p2c(String ts){

        byte[] ba01 = barr(ts,Charset.forName("UTF-8")); // UTF-8 is the first and default character set
        System.out.println("1. UTF-8: " + ByteCount(ba01) + " bytes");
        System.out.println(b2d(ba01)); // b2d is short for byte to decimal
        System.out.println(b2h(ba01)); // b2h is short for byte to hexadecimal
        System.out.println();

        byte[] ba02 = barr(ts,Charset.forName("US-ASCII"));
        System.out.println("2. US-ASCII: " + ByteCount(ba02) + " bytes");
        System.out.println(b2d(ba02));
        System.out.println(b2h(ba02));
        System.out.println();

        byte[] ba03 = barr(ts,Charset.forName("ISO-8859-1")); // ISO-8859 is also known as Latin-1.
        System.out.println("3. ISO-8859-1: " + ByteCount(ba03) + " bytes");
        System.out.println(b2d(ba03));
        System.out.println(b2h(ba03));
        System.out.println();

        byte[] ba04 = barr(ts,Charset.forName("UTF-16")); // 16-bit unicode
        System.out.println("4. UTF-16: " + ByteCount(ba04) + " bytes");
        System.out.println(b2d(ba04));
        System.out.println(b2h(ba04));
        System.out.println();

        byte[] ba05 = barr(ts,Charset.forName("UTF-16BE")); // BE = Big Endian
        System.out.println("5. UTF-16BE: " + ByteCount(ba05) + " bytes");
        System.out.println(b2d(ba05));
        System.out.println(b2h(ba05));
        System.out.println();

        byte[] ba06 = barr(ts,Charset.forName("UTF-16LE")); // LE = Little Endian
        System.out.println("6. UTF-16LE: " + ByteCount(ba06) + " bytes");
        System.out.println(b2d(ba06));
        System.out.println(b2h(ba06));
        System.out.println();

        byte[] ba07 = barr(ts,Charset.forName("x-UTF-16LE-BOM")); // BOM = Byte Order Mark
        System.out.println("7. x-UTF-16LE-BOM: " + ByteCount(ba07) + " bytes");
        System.out.println(b2d(ba07));
        System.out.println(b2h(ba07));
        System.out.println();

        byte[] ba08 = barr(ts,Charset.forName("UTF-32"));
        System.out.println("8. UTF-32: " + ByteCount(ba08) + " bytes");
        System.out.println(b2d(ba08));
        System.out.println(b2h(ba08));
        System.out.println();

        byte[] ba09 = barr(ts,Charset.forName("UTF-32BE"));
        System.out.println("9. UTF-32BE: " + ByteCount(ba09) + " bytes");
        System.out.println(b2d(ba09));
        System.out.println(b2h(ba09));
        System.out.println();

        byte[] ba10 = barr(ts,Charset.forName("X-UTF-32BE-BOM"));
        System.out.println("10. X-UTF-32BE-BOM: " + ByteCount(ba10) + " bytes");
        System.out.println(b2d(ba10));
        System.out.println(b2h(ba10));
        System.out.println();

        byte[] ba11 = barr(ts,Charset.forName("UTF-32LE"));
        System.out.println("11. UTF-32LE: " + ByteCount(ba11) + " bytes");
        System.out.println(b2d(ba11));
        System.out.println(b2h(ba11));
        System.out.println();

        byte[] ba12 = barr(ts,Charset.forName("X-UTF-32LE-BOM"));
        System.out.println("12. X-UTF-32LE-BOM: " + ByteCount(ba12) + " bytes");
        System.out.println(b2d(ba12));
        System.out.println(b2h(ba12));
        System.out.println();

        byte[] ba13 = barr(ts,Charset.forName("IBM1047")); // EBCDIC
        System.out.println("13. IBM1047: " + ByteCount(ba13) + " bytes");
        System.out.println(b2d(ba13));
        System.out.println(b2h(ba13));
        System.out.println();
    }

    /* Main Method */

    /** The main method prints the test string, the name of the default character set, and the length of the test
     * string to the console on its own. Main calls p2c to print the byte array information and the names of
     * each character set to the console. */
    public static void main(String[] args){
        GetACharset obj = new GetACharset(); // new instance
        String ones = "0123456789"; // ones is the test string

        System.out.println("The default character set is " + Charset.defaultCharset() + "."); // UTF-8
        System.out.println("Test String: " + ones); //  prints test string
        System.out.println("The test string has " + ones.length() + " characters."); // counts characters
        System.out.println();
        obj.p2c(ones); // byte analysis
    }
}
