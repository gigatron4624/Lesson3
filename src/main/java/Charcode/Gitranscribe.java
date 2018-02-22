/* This program reads a string from an external text file, converts the original string into a character array
 * using a character set, appends the character to a new sequence, and prints the string to the console.  The purpose
 * of this program is to determine which character set accurately interprets and transcribes the input data.*/
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

    /* Package-Private Methods*/

    /** This method opens an external file that contains data.
     * @param fn is the name of input file (fn = file name)
     * @return access to external file */
    File accept(String fn){
        return new File(fn); // opens the external file
    }

    /** This method transcribes a string from an external file with respect to a charset.
     * @param flf is the file to be opened (flf = foreign language file)
     * @param cs is the character set
     * @return the string read by the charset
     * @throws IOException if input stream is missing or blocked */
    String deliver(File flf, Charset cs) throws IOException {

        // initialize an empty string builder sequence
        StringBuilder rnr = new StringBuilder(); // rnr = rock n' roll

        // checks if the file to be transcribed is available
        try{
            FileInputStream feed = new FileInputStream(flf); // feed flf to FileInputStream
            InputStreamReader isr = new InputStreamReader(feed, cs); // subjects file to character set
            Reader entry = new BufferedReader(isr); // reads an input stream line by line
            int l = entry.read(); // reads the character and stores its input as an integer

            // l = -1 once end of character stream is reached
            while (l > -1){
                char c = (char) l; // converts integer to a character
                rnr.append(c); // appends character to string builder sequence
                l = entry.read(); // reads the next character as a string and stores its corresponding integer
            }
            entry.close(); // closes the input stream
        }

        // Aww tentacles! The file is either missing, hidden, or in the wrong directory.
        catch (FileNotFoundException tentacles){
            return "Error: Where's the file?" + tentacles.getMessage();
        }

        return rnr.toString(); // returns character sequence formatted as a string
    }

    /* Main Method */
    /* @throws IO Exception if deliver throws IO exception*/
    public static void main(String[] args) throws IOException {
        Gitranscribe etch = new Gitranscribe(); // instantiates object
        String meal = "Lesson3-japanese.txt"; // this is the file to be transcribed

        // print strings to console/screen depending on character set
        System.out.println(etch.deliver(etch.accept(meal), etch.CS01)); // prints string using UTF-8 charset
        System.out.println(etch.deliver(etch.accept(meal), etch.CS02)); // prints string using US-ASCII charset
        System.out.println(etch.deliver(etch.accept(meal), etch.CS03)); // prints string using Latin-1 charset
        System.out.println(etch.deliver(etch.accept(meal), etch.CS04)); // prints string using UTF-16 charset
    }
}
