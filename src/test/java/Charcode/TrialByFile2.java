/** This code uses TestNG assertion methods to determine whether BufferMeUpScotty functions properly. Unlike
 * TrialByFile1, this code tests inspect() without storing the return value of said method as a string. This is due to
 * inspect having a return type of void in BufferMeUpScotty as opposed to a return type of String in GoodOleIO. */

package Charcode;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrialByFile2 extends BufferMeUpScotty {

    private String fn1 = "weegee.txt"; // name of first file
    private String fn2 = "malleo.txt"; // name of second file
    private String ts1 = "I hope she made lots of spaghetti!"; // ts1: test string #1
    private String ts2 = "I do too!"; // ts2: test string #2

    /** This method returns an error message should one or more assertion test fail.
     * @return a demand to fix the code */
    private String boo(){
        return "If it's broke, you fix it!!"; // assertion error message
    }

    /* Test Methods */
    /* 1. BufferMeUpScotty creates two normal and visible (not hidden) files. Neither file is a directory.
     * 2. BufferMeUpScotty has permission to modify each file and subsequently adds text to each file.
     * 3. BufferMeUpScotty has permission to read each file and prints each file's contents to the console.
     * The inspect method is declared void in BufferMeUpScotty, so a data type needn't be declared for testing.
     * 4. BufferMeUpScotty successfully gets rid of each test file if asked to do so. */


    @Test
    void testGnf() throws Exception {
        gnf(fn1); // create file 1 (weegee)
        File ff = new File(fn1); // ff = first file (file already exists; this is just for reference)
        boolean yeah = ff.isFile() && !ff.isHidden(); // first file exists as text file
        Assert.assertTrue(yeah,boo()); // Did GoodOleIO successfully create the file?

        gnf(fn2); // create file 2 (malleo)
        File sf = new File (fn2); // sf = second file (file already exists; this is just for reference)
        yeah = sf.isFile() && !sf.isHidden(); // second file exists as test file
        Assert.assertTrue(yeah, boo()); // Did GoodOleIO successfully create the file?
    }

    @Test
    void testFill() throws Exception {
        testGnf(); // This is called so the assertion tests in testFill won't fail due to missing files.
        File ff = new File(fn1); // this is just an instance (see testGnf)
        Assert.assertTrue(ff.canWrite(),boo()); // May GoodOleIO modify the file?
        fill(fn1,ts1); // write test string #1 into file 1
        Assert.assertFalse(ff.length() == 0, boo()); // Does the file contain text?

        File sf = new File(fn2); // this is just an instance (see testGnf)
        Assert.assertTrue(sf.canWrite(),boo()); // May GoodOleIO modify the file?
        fill(fn2,ts2); // write test string #2 into file 2
        Assert.assertFalse(sf.length() == 0, boo()); // Does the file contain text?
    }

    @Test
    void testInspect() throws Exception {
        File ff = new File(fn1); // this is just an instance (see testGnf)
        Assert.assertTrue(ff.canRead(),boo()); // May GoodOleIO read the file?
        inspect(fn1); // read file 1

        File sf = new File(fn2); // this is just an instance (see testGnf)
        Assert.assertTrue(sf.canRead(),boo()); // May GoodOleIO read the file?
        inspect(fn2); // read file 2
    }

    @Test
    void testPurge() throws Exception {
        File ff = new File(fn1); // this is just an instance (see testGnf)
        boolean goner = purge(fn1); // delete the first file
        Assert.assertEquals(goner,!ff.exists(),boo()); // Was the first file purged or not?

        File sf = new File(fn2); // this is just an instance (see testGnf)
        goner = purge(fn2); // delete the second file
        Assert.assertEquals(goner,!sf.exists(),boo()); // Was the second file purged or not?
    }
}