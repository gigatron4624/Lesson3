/** This program creates a file, writes text into it, reads it, checks for its existence, and deletes it. Unlike
 * GoodOleIO, ANewInterface uses methods from classes bundled with the NIO package to accomplish each task.
 * ANewInterface does call BufferedWriter, BufferedReader, and IOException from IO to supplement NIO functions.*/

package Charcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ANewInterface {
    
    /* NIO Methods */

    /** This method generates a file path based on the file name using the FileSystems and Path classes.
     * @param fn is the name of the file being located
     * @return the file path and sets up the location of a future file */
    Path way(String fn){
        // The default working directory is the current project directory.
        return FileSystems.getDefault().getPath(fn); // declare the location of a new file in a system
    }

    /** This method creates a new blank file using the Files class.
     * @param p is the path of the file
     * The method will throw an IO Exception if the file being created already exists. */
    void generate(Path p){
        try{
            // the new file is named after its path
            Files.createFile(p); // create blank file in a specific location based on the path
        }
        // catch IO exception in the event that the file path/name is not unique
        catch (IOException oops){
            // Creating identical files is forbidden.
            System.out.println("Duplicate files hoard disk space! " + oops.getMessage());
        }
    }

    /** This method determines whether or not the code has permission to write to and read a file.
     * @param p is the path of the file
     * @return yes if the file is writable and readable, no if otherwise */
    String permission (Path p){

        // both booleans must be true
        if (Files.isWritable(p) && Files.isReadable(p)){
            return "yes"; // file is fully accessible
        } else {
            return "no"; // file is missing, locked, read-only, or write-only
        }
    }

    /** This method adds contents to a file whether it's empty or partially filled. The contents may be integers,
     * characters, decimal values, or strings. In this code, "fill" will add test strings to a file using
     * newBufferedWriter from the NIO.Files class.
     * @param p is the path of the file
     * @param ts is the test string accepted as input. */
    void fill(Path p, String ts){

        // Source: https://docs.oracle.com/javase/tutorial/essential/io/file.html
        // Caution: Writing text into a file might throw an exception.
        try(BufferedWriter bw = Files.newBufferedWriter(p)) {
            bw.write(ts); // writes string to file using default character set: UTF-8
        }
        // catch IO exception if permission to write to file is denied or target file does not exist
        catch(IOException oops){
            System.out.println("File is either missing or locked. " + oops.getMessage());
        }
    }

    /** This method uses newBufferedReader from the NIO.Files class to read the contents of a file and print
     * the contents to the console.
     * @param p is the path of the file.*/
    void inspect(Path p){

        // Source: https://docs.oracle.com/javase/tutorial/essential/io/file.html
        try(BufferedReader br = Files.newBufferedReader(p)){
            String chain = br.readLine(); // reads the first line
            while (chain != null){
                System.out.println(chain); // prints line to console
                chain = br.readLine(); // reads next line
            }
        }
        // Catch IO exception if permission to read file is denied or file is non-existent
        catch(IOException oops){
            System.out.println("File is missing, locked, or write-only." + oops.getMessage());
        }
    }

    /** This method checks for the existence of a file path.
     * @param p is the file path
     * @return true if the file/path exists and false if it is missing, misplaced, or absent. */
    boolean find(Path p){
        return Files.exists(p); // returns true or false;
    }

    /** This method deletes a file based on its path.
     * @param p is the path used to locate the given file
     * The method will throw an IO Exception if directory is empty.*/
    void erase(Path p){
        try{
            Files.delete(p); // delete file
        }
        // catch IO exception if file was never created or already deleted
        catch (IOException oops){
            // why bother deleting empty space?
            System.out.println("You can't delete empty space! " + oops.getMessage());
        }
    }

    /* Main Method */

    public static void main (String[] args){
        ANewInterface ani = new ANewInterface(); // instantiate object

        String fn1 = "luigi.txt"; // name of first file
        Path p1 = ani.way(fn1); // declare and create location (path) for first file
        ani.generate(p1); // create first file
        System.out.println(ani.find(p1)); // check for existence of first file
        System.out.println("Permission to modify or read file? " + ani.permission(p1)); // yes or no?
        String ts1 = "I'm a Luigi. Number one!"; // first test string, from Mario Kart 64 (Charles Martinet)
        ani.fill(p1,ts1); // add contents to first file
        ani.inspect(p1); // read contents of first file
        ani.erase(p1); // delete first file

        String fn2 = "mario.txt"; // name of second file
        Path p2 = ani.way(fn2); // declare and create location for second file
        ani.generate(p2); // create second file
        System.out.println(ani.find(p2)); // check for existence of second file
        System.out.println("Permission to modify or read file? " + ani.permission(p2)); // yes or no?
        String ts2 = "It's a me! Mario!"; // second test string, from Super Mario 64 (Charles Martinet)
        ani.fill(p2,ts2); // add contents to second file
        ani.inspect(p2); // read contents of second file
        ani.erase(p2); // delete second file
    }
}
