/* This code accepts a test string and a byte array as inputs, encodes the inputs into base64 and base64url strings,
 * and prints the encoded strings and their resultant lengths to the console. The purpose of this code is to compare
 * base64 encoding to hexadecimal encoding. */
package Charcode;

import java.util.Arrays;
import java.util.Base64;

public class GrandSlamHex {

    /* Fields (Constants) */
    private String sdi = "0123456789"; // sdi = single digit integers
    private int a = 100;

    /* Package-Private Methods */

    /** TA generates a byte array of a specific length whose elements are assigned values from 0 to x-1.
     * @param x is the number of elements in the byte array (i.e. byte array length);
     * @return a byte array that stores integers from 0 to x-1 in numeric order */
    byte[] TA(int x){
        byte[] X = new byte[x]; // initializes byte array of length x

        for (byte i = 0; i < x; i++){
            X[i] = i; // assign byte to each array element
        }
        return X;
    }

    /** Repeat concatenates a string to itself until it reaches a length of 50.
     * @param s is the string
     * @return the self-concatenated string
     */
    String Repeat(String s){
        StringBuilder root = new StringBuilder(s); // initialize a root string

        while (root.length() < 50){
            root.append(s); // concatenate the input string
        }
        return root.toString(); // return self-concatenated string
    }

    /** s2b encodes a string into a chain of bytes and stores the bytes into an array,
     * @param s is the input string
     * @return the encoded string as an array that stores bytes as elements */
    byte[] s2b(String s){
        return s.getBytes(); // returns string as byte array
    }

    /** b2d decodes an array of bytes into an array of decimal integers.
     * @param B is the input byte array
     * @return an array of decimal integers as a string */
    String b2d(byte[] B){
        return Arrays.toString(B); // returns a string representation of a decimal array
    }

    /** b2h is similar to b2d, except that it decodes bytes to hexadecimal numbers.
     * @param B is the input byte array
     * @return an array of hexadecimal integers as a string */
    String b2h(byte[] B){
        String[] HA = new String[B.length]; // HA is the initial hex array as a string

        for(int i = 0; i < B.length; i++){
            HA[i] = String.format("%02x",B[i]); // converts each element to a 2-digit hexadecimal integer
        }
        return Arrays.toString(HA); // returns a string representation of a hex array
    }

    /** Whomp encodes bytes into a string using the standard Base64 scheme.
     * A whomp is an enemy in Super Mario 64 (1996).
     * @param B is the input byte array
     * @return the byte array encoded as a Base64 string */
    String Whomp(byte[] B){
        return Base64.getEncoder().encodeToString(B); // uses standard Base64 encoder
    }

    /** Bomp encodes bytes into a string using the URL and filename safe Base64 scheme.
     * A bomp is also an enemy in Super Mario 64 (1996).
     * @param B is the input byte array
     * @return the byte array encoded as a Base64url string */
    String Bomp(byte[] B){
        return Base64.getUrlEncoder().encodeToString(B); // uses URL-safe Base64 encoder
    }

    /* Print to Console (private) */

    private void ptoc(){
        String ccs = Repeat(sdi); // ccs = concatenated character string
        System.out.println(ccs); // prints ccs

        byte[] BA = TA(a); // BA = byte array (first input)
        byte[] SDI = s2b(ccs); // SDI = single digit integers (second input)

        String ds1 = b2d(BA); // ds1 = 1st input as string of decimal array
        System.out.println(ds1); // print ds1
        String ds2 = b2d(SDI); // ds2 = 2nd input as string of decimal array
        System.out.println(ds2); // print ds2

        String hs1 = b2h(BA); // hs1 = 1st input as string of hex array
        System.out.println(hs1); // print hs1
        System.out.println("Array Length = " + hs1.length()); // length of hs1 as full array
        System.out.println("Hex Length = " + hs1.length()/2); // length of hs1 without spaces, brackets, ot commas

        String hs2 = b2h(SDI); // hs2 = 2nd array input as string of hex array
        System.out.println(hs2); // print hs2
        System.out.println("Array Length = " + hs2.length()); // length of hs2 as full array
        System.out.println("Hex Length = " + hs2.length()/2); // length of hs2 without spaces, brackets, or commas

        // whomp1 is the 1st input encoded as a Base64 string.
        String whomp1 = Whomp(BA);
        System.out.println(whomp1);
        System.out.println("Length = " + whomp1.length());

        // whomp2 is the 2nd input encoded as a Base64 string.
        String whomp2 = Whomp(SDI);
        System.out.println(whomp2);
        System.out.println("Length = " + whomp2.length());

        // bomp1 is the 1st input encoded as Base64url string.
        String bomp1 = Bomp(BA);
        System.out.println(bomp1);
        System.out.println("Length = " + bomp1.length());

        // bomp2 is the first input encoded as Base64url string.
        String bomp2 = Bomp(SDI);
        System.out.println(bomp2);
        System.out.println("Length = " + bomp2.length());
    }

    /* Main Method */

    public static void main(String[] args){

        GrandSlamHex gsh = new GrandSlamHex(); // instantiates object
        gsh.ptoc(); // prints all content to console
    }
}
