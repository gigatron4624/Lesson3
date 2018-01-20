/* This program reads a string from an external text file, converts the original string into a character array
 * using a character set, appends the character to a new sequence, and prints the string to the console.  The purpose
 * of this program is to determine  which character set accurately interprets and transcribes the input data.*/
package Charcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class Gitranscribe {

    /* Character Sets */
    private Charset CS01 = Charset.forName("UTF-8"); // default character set
    private Charset CS02 = Charset.forName("US-ASCII");
    private Charset CS03 = Charset.forName("ISO-8859-1"); // aka Latin-1
    private Charset CS04 = Charset.forName("UTF-16"); // 16-bit unicode

    /* Package private methods */

    /* This method converts a string from an external file into a character array through a charset.
     * @param cs is the character set
     * @return the string read by the charset
     * @throws IO Exception if an input/output error occurs
      * The IO Exception is for the Reader Class. */
    String accept(Charset cs) throws IOException {

        // initialize an empty string builder sequence
        StringBuilder rnr = new StringBuilder(); // rnr = rock n' roll
        String fn = "Lesson3-japanese.txt"; // name of input file (fn = file name)
        File flf = new File(fn); // opens the external file (flf = foreign language file)
        FileInputStream feed = null; // initialize FileInputStream;

        try{
            feed = new FileInputStream(flf); // feed flf to FileInputStream
        } catch (FileNotFoundException tentacles){
            // Aww tentacles! The file is either missing, hidden, or in the wrong directory.
            System.out.println("Error: Where's the file?"); // error message for FileNotFound exception
        }

        InputStreamReader isr = new InputStreamReader(feed, cs); // subjects file to character set
        Reader entry = new BufferedReader(isr); // reads an input stream line by line

        // reads the character and stores its input as an integer
        int l = entry.read(); // throws IOException if input source is missing

        // l = -1 once end of character stream is reached
        while (l > -1){
            char c = (char) l; // converts integer to a character
            rnr.append(c); // appends character to string builder sequence
            l = entry.read(); // reads the next character as a string and stores its corresponding integer
        }
        entry.close(); // closes the input stream
        return rnr.toString(); // returns character sequence formatted as a string
    }

    /* Main Method */
    /* @throws IO Exception if accept throws IO exception*/
    public static void main(String[] args) throws IOException {
        Gitranscribe etch = new Gitranscribe(); // instantiates object

        // print strings to console
        System.out.println(etch.accept(etch.CS01)); // prints string to screen using UTF-8 charset
        System.out.println(etch.accept(etch.CS02)); // prints string to screen using US-ASCII charset
        System.out.println(etch.accept(etch.CS03)); // prints string to screen using Latin-1 charset
        System.out.println(etch.accept(etch.CS04)); // prints string to screen using UTF-16
    }
}