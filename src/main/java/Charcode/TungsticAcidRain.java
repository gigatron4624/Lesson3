/** This program converts JSON strings to base64url strings and vice-versa. The program accomplishes the former
 * (i.e. JSON to base64url) by reading the JSON string from a source file, encoding the JSON string with base64url
 * format, and exporting the encoded string to a new file. The program then reverts the encoded string to JSON by
 * importing the previously exported string and decoding the string. The original JSON inputs should match the
 * reconstructed JSON output if the conversions are successful. This program's name, TungsticAcidRain, pokes fun
 * at WSO2. W is the symbol for tungsten, while SO2 is the chemical formula for sulfur dioxide, a key catalyst of
 * acid rain. WSO2 sounds like a chemical compound right? */

package Charcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TungsticAcidRain {

    /* Methods */

    /** bomp encodes a string into a chain of bytes, stores the bytes into an array, and converts the byte array to a
     *  base64url string. A bomp is also an enemy in Super Mario 64 (1996).
     * @param s is the input string
     * @return a Base64url representation of the input string */
    String bomp(String s){

        // Encoding the string will throw an exception if the string is null.
        try{
            return Base64.getUrlEncoder().encodeToString(s.getBytes()); // uses URL-safe encoder
        }

        // catch Null Pointer Exception if empty space is detected
        catch(NullPointerException bummer){
            return "Wait a minute. We can't write empty gaps. " + bummer.getMessage(); // Exception message
        }
    }

    /** gnf: generate new file. This method uses the File constructor to create a new file and allocates it to
     * the parent directory. It may throw an IO Exception.
     * @param fn represents the name of the new file (fn: file name)
     * File names are relative to project directory. */
    void gnf(String fn){

        // Creating the new file might throw an IO exception.
        try{
            File bf = new File(fn); // bf: blank file with specified name
            // check if the newly created file has a unique file name
            if (!bf.createNewFile()){
                System.out.println("File already exists! Copies just hoard disk space! "); // file name is not unique
            }
            else {
                System.out.println("Happy Birthday " + fn + "!"); // The file name is unique. Create the new file.
            } // move along
        }

        // catch IO exception if the target directory of the file is either missing or locked
        catch (IOException oops){
            // The target directory of the file either doesn't exist or cannot be accessed.
            System.out.println("Houston. We have a problem. " + oops.getMessage());
        }
    }

    /** fill adds a string encoded in Base-64-url to a file using the FileWriter class.
     * @param fn is the name of the file that is being filled.
     * @param es is the encoded base-64-url string to be written to the file. */
    void fill(String fn, String es){

        // Writing to the target file might throw an IO exception.
        try{
            FileWriter wtf = new FileWriter(fn,true); // wtf: write to file
            BufferedWriter bt = new BufferedWriter(wtf); // bt: buffered text
            bt.write(es); // write encoded string to file
            bt.newLine(); // separate lines of text
            bt.close(); // closes the character stream
        }

        // catches IO exception thrown by FileWriter, BufferedWriter, write(), newLine(), flush(), or close()
        catch (IOException oops){
            // 1. The target text file is missing.
            // 2. The text file cannot be either accessed or modified.
            // 3. FileWriter is writing to a directory when it can't.
            System.out.println("The file is either missing or locked. " + oops.getMessage());
        }
    }

    /** inspect reads contents from a file and prints them to the console when called.
     * @param fn is the name of the file being scanned
     * @throws IOException if the file is restricted (i.e. can't open or read file contents) */
    String inspect(String fn) throws IOException{

        // Attempting to read the target file might throw a File Not Found Exception.
        try{
            FileReader rf = new FileReader(fn); // rf: read file
            BufferedReader br = new BufferedReader(rf); // br = buffered reader
            String lot = ""; // initialize string (lot = line of text)
            String row = br.readLine(); // read first line of the file
            while (row != null){
                lot += row + "\n"; // appends current line to contents and moves on to the next line
                row = br.readLine(); // reads next line
            }
            br.close(); // closes the character stream
            return lot; // print contents to console
        }

        // The file that is being accessed is either absent or a directory.
        catch (FileNotFoundException ouch){
            // The read function cannot read a directory or empty space.
            return "Searching oblivion is forbidden sucker! " + ouch.getMessage();
        }
    }

    /** pmob does the opposite of bomp by decoding a Base64-URL string into an array of bytes.
     * The equality sign "=" is outside the Base64 alphabet and exists for padding purposes. The basic type decoder
     * and the URL/Filename safe type decoders will throw IllegalArgumentExceptions if it tries to decode the equality
     * sign. The MIME type decoder accepts padding without throwing an Exception.
     * @param s is the input string
     * @return a decoded byte array */
    byte[] pmob(String s){
        return Base64.getMimeDecoder().decode(s); // uses MIME type Base64 decoder
    }

    /** ba2s converts byte arrays to strings through UTF-8, the default character set
     * @param b is the byte array
     * @return a string of UTF-8 characters */
    String ba2s(byte[] b){

        // Warning: Converting the byte array to a string might throw an UnsupportedEncodingException.
        try{
            return new String(b, "UTF-8");
        }

        // Perhaps your JVM encountered an error.
        catch (UnsupportedEncodingException bogus){
            return "Your JVM caught a bug. " + bogus.getMessage(); // catch the UnsupportedEncodingException.
        }
    }

    /** carboncopy verifies whether or not the original and reconstructed JSON strings are identical.
     * @param peat is the original JSON string
     * @param repeat is the reconstructed JSON string
     * @return true if they match and false if they don't */
    boolean carboncopy(String peat, String repeat){
        return peat.equals(repeat); // Do the strings match?
    }

    /* Main Method */

    /**@param args carries the command line argument as an array of strings.
     * @throws Exception if any methods call throw an exception of any type. */
    public static void main(String[] args) throws Exception {

        TungsticAcidRain tar = new TungsticAcidRain(); // instantiate object
        String wolf = "tungstensulfite.txt"; // source of original JSON string

        String s0 = tar.inspect(wolf); // reads the original JSON string from source file
        System.out.println(s0); // prints the original JSON string to console
        tar.gnf("scheelite.txt"); // create new file as a destination for the encoded JSON string
        String s1 = tar.bomp(s0); // encodes JSON string into Base64-URL characters
        System.out.println(s1); // prints encoded Base64-URL string to console
        System.out.println(s1.length()); // yields length of encoded string
        tar.fill("scheelite.txt", s1); // exports encoded Base64-URL string to file
        String s2 = tar.inspect("scheelite.txt"); // re-import the previously exported string
        System.out.println(s2); // prints imported Base64-URL string
        String s3 = tar.ba2s(tar.pmob(s2)); // decodes imported string into reconstructed JSON string
        System.out.println(s3); // prints decoded JSON string
        System.out.println(tar.carboncopy(s0,s3)); // checks if the reconstructed string matches the original string
    }
}