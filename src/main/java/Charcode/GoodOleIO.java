/** This code demonstrates the inner workings of the Input/Output (IO) pacakge. The code creates two blank files (1),
 * writes random text to each file (2), reads each file (3), checks for each file's existence (4), and deletes
 * one of the files (5). The other file stays just to make sure the first 4 steps work. */

package Charcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GoodOleIO {

    /*Input-Output (IO) Methods */

    /** gnf: generate new file. This method uses the File constructor to create a new file and allocates it to
     * the parent directory. It may throw an IO Exception.
     * @param fn represents the name of the new file (fn: file name)
     * File names are relative to project directory.*/
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
            wtf.write(ts + "\n"); // write test string to file on a separate line
            wtf.close(); // closes the character stream
        }

        // catches IO exception thrown by FileWriter, write(), or close()
        catch (IOException oops){
            // 1. The target text file is missing.
            // 2. The text file cannot be either accessed or modified.
            // 3. FileWriter is writing to a directory when it can't.
            System.out.println("The file is either missing or locked. " + oops.getMessage());
        }
    }

    /** inspect reads contents from a file and prints them to the console.
     * @param fn is the name of the file being scanned
     * @return the contents of the file to the console as strings
     * @throws IOException if the file is restricted (i.e. can't open or read file contents) */
    String inspect(String fn) throws IOException{

        // pull file contents
        StringBuilder pull = new StringBuilder(); // initialize blank string builder

        // Attempting to read the target file might throw a File Not Found Exception.
        try{
            FileReader rf = new FileReader(fn); // rf: read file
            int j = rf.read(); // reads the first character as an integer

            while (j > -1){
                char c = (char) j; // converts integer to corresponding character
                pull.append(c); // appends each character to the string builder
                j = rf.read(); // overwrite integer
            }
            rf.close(); // closes the character stream
        }

        // The file that is being accessed is either absent or a directory.
        catch (FileNotFoundException ouch){
            // The read function cannot read a directory or empty space.
            return "File not found! Searching oblivion is forbidden sucker! " + ouch.getMessage();
        }
        return pull.toString(); // converts data to strings and prints strings to console
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

        GoodOleIO goio = new GoodOleIO(); // instantiates object
        String fn1 = "weegee.txt"; // fn1: file name 1
        String ts1 = "I hope she made lots of spaghetti!"; // ts1: test string #1
        goio.gnf(fn1); // creates blank file named "weegee"
        goio.fill(fn1, ts1); // writes test string #1 to file "weegee"
        System.out.println(goio.inspect(fn1)); // reads "weegee"
        System.out.println(goio.cfe(fn1)); // checks if "weegee" exists
        String fn2 = "malleo.txt"; // fn2: file name 2
        String ts2 = "I do too!"; // ts2: test string #2
        goio.gnf(fn2); // creates blank file named "malleo"
        goio.fill(fn2, ts2); // writes test string #2 to "malleo"
        System.out.println(goio.inspect(fn2)); // reads "malleo"
        System.out.println(goio.cfe(fn2)); // checks if "malleo" exists
        System.out.println(goio.purge(fn2)); // deletes "malleo"
    }
} // end of code
