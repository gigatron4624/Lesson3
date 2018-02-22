/** This program uses TestNG assertion methods to check if Gitranscribe functions properly. The assertion tests fulfill
 * this task by checking if the test file exists and determining whether or not Gitranscribe is character set
 * sensitive. (If Gitranscribe is character set sensitive, then Gitranscribe must use the same character set as the
 * character set used to write the sample file to read the file contents and print them to the console.) */
package Charcode;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.charset.Charset;

public class ILikeIt extends Gitranscribe {

    /* Fields */
    private String fn = "Lesson3-japanese.txt"; // name of test file
    private String chorus = "それはロックンロールだけですが、私はそれが好きです"; // original string from Lesson3-japanese.txt

    /* Character Sets */
    private Charset CS01 = Charset.forName("UTF-8"); // default character set (1)
    private Charset CS02 = Charset.forName("US-ASCII"); // (2)
    private Charset CS03 = Charset.forName("ISO-8859-1"); // aka Latin-1 (3)
    private Charset CS04 = Charset.forName("UTF-16"); // 16-bit unicode (4)

    /** This method returns an error message if an assertion test fails.
     * @return a sentence expressing disapproval */
    private String boo () {
        return "Your code is subpar! I want my money back!"; // Do I need to say more?
    }

    /** This method checks whether or not the rendered string matches the original string (i.e. chorus).
     * @param ts is the string transcribed from the test file
     * @return true if ts and chorus are identical and false if they are not */
    private boolean facsimile(String ts){
        return ts.equals(chorus); // Do ts and chorus match?
    }

    @Test
    void Acceptance() throws Exception {
        File tf = accept(fn); // tf = test file
        Assert.assertTrue(tf.exists(),boo()); // Does the test file exist?
    }

    /* Gitranscribe's deliver method is subject to two assertion tests that check for character set sensitivity.
    * The first test involves transcribing the test string through UTF-8, while the second test utilizes the other
    * three character sets. If both tests pass, then the first transcription is accurate and the other three
    * transcriptions are inaccurate. This would confirm that Gitranscribe is character set sensitive. */

    @Test
    void Delivery1() throws Exception {
        String s1 = deliver(accept(fn),CS01); // transcribe the test string through UTF-8
        Assert.assertEquals(facsimile(s1),true,boo()); // string and chorus match
    }

    @Test
    void Delivery2() throws Exception{
        String s2 = deliver(accept(fn),CS02); // transcribe the test string through US-ASCII
        String s3 = deliver(accept(fn),CS03); // transcribe the test string through Latin-1
        String s4 = deliver(accept(fn),CS04); // transcribe the test string through UTF-16
        Assert.assertEquals(facsimile(s2),false,boo()); // string and chorus don't match
        Assert.assertEquals(facsimile(s3),false,boo()); // string and chorus don't match
        Assert.assertEquals(facsimile(s4),false,boo()); // string and chorus don't match
    }
}
