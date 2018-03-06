/** This program yields the same results as GoodOleIO. The implementation of this code has several differences.
 * 1. This code applies BufferedWriter and BufferedReader to buffer the character streams. Buffering the streams
 * improves efficiency by writing/reading lines of characters as opposed to writing/reading one character at a time.
 * 2. The usage of BufferedReader to read buffered streams dispenses the need for a string builder.
 * 3. The inspect call has a void return type as it uses System.out.println instead of return.
 * 4. The fill and inspect calls may throw additional IO exceptions due to buffering.
 * 5. This code deletes both files. GoodOleIO only deletes 1 file. */

package Charcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferMeUpScotty {

    /*Input-Output (IO) Methods */

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

    /** fill adds contents to a file using the FileWriter class. The contents can be an integer, character, double,
     * or string. In this code method "fill" will add a test string to an existing file. The recipient file doesn't
     * need to be empty.
     * @param fn is the name of the file that is being filled.
     * @param ts is the test string to be added to the file. */
    void fill(String fn, String ts){

        // Writing to the target file might throw an IO exception.
        try{
            FileWriter wtf = new FileWriter(fn,true); // wtf: write to file
            BufferedWriter bt = new BufferedWriter(wtf); // bt: buffered text
            bt.write(ts); // write test string to file using buffer
            bt.newLine(); // separate lines of text
            bt.close(); // closes the character stream
        }

        // catches IO exception thrown by FileWriter, BufferedWriter, write(), newLine(),  or close()
        catch (IOException oops){
            // 1. The target text file is missing.
            // 2. The text file cannot be either accessed or modified.
            // 3. FileWriter is writing to a directory when it can't.
            System.out.println("The file is either missing or locked. " + oops.getMessage());
        }
    }

    /** inspect reads contents from a file and prints them to the console.
     * @param fn is the name of the file being scanned
     * @throws IOException if the file is restricted (i.e. can't open or read file contents) */
    void inspect(String fn) throws IOException{

        // Attempting to read the target file might throw a File Not Found Exception.
        try{
            FileReader rf = new FileReader(fn); // rf: read file
            BufferedReader br = new BufferedReader(rf); // br = buffered reader
            String word = br.readLine(); // reads first line of contents
            while (word != null){
                System.out.println(word); // prints line of contents to console
                word = br.readLine(); // reads next line of contents
            }
            br.close(); // closes the buffered character stream
        }

        // The file that is being accessed is either absent or a directory.
        catch (FileNotFoundException ouch){
            // The read function cannot read a directory or empty space.
            System.out.println("Searching oblivion is forbidden sucker! " + ouch.getMessage());
        }
    }

    /** cfe: check for existence. This code checks if a file is either present or absent.
     * @param fn is the name of the file being searched for
     * @return a response indicating either existence or absence */
    String cfe(String fn){
        File eureka = new File(fn); // Eureka! I found it! Shout-out to Archimedes!

        if (eureka.exists()){
            return "Jackpot!"; // true: file exists in its proper directory
        }
        else {
            return "Look elsewhere."; // false: file either doesn't exists or exists in an alternate directory
        }
    }

    /**This method deletes a specified file, hence the name "purge".
     * @param fn is the name of the file being erased.
     * @return true if file is successfully erased and false if the file either doesn't exist or can't be erased.*/
    boolean purge(String fn){
        File pf = new File(fn); // pf: purge file
        return pf.delete(); // deletes file and return true if successful
    }

    /* Main Method */

    /** @throws IOException if any IO calls throw an exception*/
    public static void main(String[] args) throws IOException{

        BufferMeUpScotty bmus = new BufferMeUpScotty(); // instantiates object
        String fn1 = "weegee.txt"; // fn1: file name 1
        String ts1 = "I hope she made lots of spaghetti!"; // ts1: test string #1
        bmus.gnf(fn1); // creates blank file named "weegee"
        bmus.fill(fn1, ts1); // writes test string #1 to file "weegee"
        bmus.inspect(fn1); // reads "weegee"
        System.out.println(bmus.cfe(fn1)); // checks if "weegee" exists
        System.out.println(bmus.purge(fn1)); // deletes "weegee"
        String fn2 = "malleo.txt"; // fn2: file name 2
        String ts2 = "I do too!"; // ts2: test string #2
        bmus.gnf(fn2); // creates blank file named "malleo"
        bmus.fill(fn2, ts2); // writes test string #2 to "malleo"
        bmus.inspect(fn2); // reads "malleo"
        System.out.println(bmus.cfe(fn2)); // checks if "malleo" exists
        System.out.println(bmus.purge(fn2)); // deletes "malleo"
    }
} // end of code
