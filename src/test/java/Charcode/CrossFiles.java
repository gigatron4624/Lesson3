/** This code uses TestNG assertion methods to determine if ANewInterface functions properly.The assertion tests
 * determine if ANewInterface successfully creates two files, writes text into each file, reads each file, prints the
 * contents of each file to the console, and erases each file using classes bundled with the NIO package. */

package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CrossFiles extends ANewInterface {

    private String fn1 = "luigi.txt"; // name of first file
    private String fn2 = "mario.txt"; // name of second file
    private String ts1 = "I'm a Luigi. Number one!"; // first test string, from Mario Kart 64 (Charles Martinet)
    private String ts2 = "It's a me! Mario!"; // second test string, from Super Mario 64 (Charles Martinet)

    /** This method returns an error message should one or more assertion test fail.
     * @return a lament of pity*/
    private String boo(){
        return "I guess this is just not your day."; // assertion error message
    }

    /* Test Methods */
    /* 1. ANewInterface creates two normal (not directories) and visible (not hidden) files.
     * 2. ANewInterface has permission to modify and read each file and subsequently adds text to each file.
     * 3. Both files contain text. ANewInterface reads text from each file and prints all text to the console.
     * 4. ANewInterface successfully gets rid of each test file if asked to do so.
     * Note: This code uses the dependsOnMethods function  to run tests in order from 1 to 4. */

    @Test(alwaysRun = true)
    void testGenerate() throws Exception{
        Path p1 = way(fn1); // create file path
        generate(p1); // create file 1
        Assert.assertTrue(Files.exists(p1),boo()); // asserts that the file exists

        Path p2 = way(fn2); // create file path
        generate(p2); // create file 2
        Assert.assertTrue(Files.exists(p2),boo()); // asserts that the file exists
    }

    @Test(dependsOnMethods = {"testGenerate"})
    void testFill() throws Exception{
        Path p1 = way(fn1); // create file path
        Assert.assertEquals(permission(p1),"yes",boo()); // permission to write text to file 1?
        fill(p1,ts1); // write text to file 1

        Path p2 = way(fn2); // create file path
        Assert.assertEquals(permission(p2),"yes",boo()); // permission to write text to file 2?
        fill(p2,ts2); // write text to file 2
    }

    @Test(dependsOnMethods = {"testFill"})
    void testInspect() throws Exception{
        Path p1 = way(fn1); // create file path
        File ff = new File(fn1); // instance of file 1
        Assert.assertTrue(ff.length()!= 0,boo()); // file 1 is not blank/empty
        inspect(p1); // read file 1 and post contents to console

        Path p2 = way(fn2); // create file path
        File sf = new File(fn2); // instance of file 2
        Assert.assertTrue(sf.length()!= 0,boo()); // file 2 is not blank/empty
        inspect(p2); // read file 2 and post contents to console
    }

    @Test(dependsOnMethods = {"testInspect"})
    void testErase() throws Exception{
        Path p1 = way(fn1); // create file path
        erase(p1); // delete file 1
        Assert.assertFalse(Files.exists(p1),boo()); // file 1 should be gone

        Path p2 = way(fn2); // create file path
        erase(p2); // delete file 2
        Assert.assertFalse(Files.exists(p2),boo()); // file 2 should be gone
    }
}