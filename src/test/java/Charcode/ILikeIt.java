/** This program uses TestNG assertion methods to check if Gitranscribe reads foreign text properly and transcribes
 * the text verbatim to the console. The assertion tests also confirm whether or not Gitranscribe is case-sensitive. */
package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.charset.Charset;

public class ILikeIt extends Gitranscribe {

    /* File Name */
    private String fn = "Lesson3-japanese.txt";
    private String chorus = "それはロックンロールだけですが、私はそれが好きです"; // string from Lesson3-japanese.txt

    /* Character Sets */
    private Charset CS01 = Charset.forName("UTF-8"); // default character set (1)
    private Charset CS02 = Charset.forName("US-ASCII"); // (2)
    private Charset CS03 = Charset.forName("ISO-8859-1"); // aka Latin-1 (3)
    private Charset CS04 = Charset.forName("UTF-16"); // 16-bit unicode (4)

    /** This method returns an error message if an assertion test fails.
     * @return a sentence expressing disapproval */
    private String boo () {
        return "I want my money back!"; // X-/
    }

    private boolean facsimile(String sn){
        return sn.equals(chorus);
    }

    @Test
    void Acceptance() throws Exception {
        File tf = accept(fn); // tf = test file
        Assert.assertTrue(tf.isFile(),boo());
    }

    /* The deliver method in Gitranscribe is subject to two assertion tests. */

    @Test
    void Delivery1() throws Exception {
        String s1 = deliver(accept(fn),CS01);
        Assert.assertEquals(facsimile(s1),true,boo());
    }

    @Test
    void Delivery2() throws Exception{
        String s2 = deliver(accept(fn),CS02);
        String s3 = deliver(accept(fn),CS03);
        String s4 = deliver(accept(fn),CS04);
        Assert.assertEquals(facsimile(s2),false,boo()); // no match
        Assert.assertEquals(facsimile(s3),false,boo()); // no match
        Assert.assertEquals(facsimile(s4),false,boo()); // no match
    }
}