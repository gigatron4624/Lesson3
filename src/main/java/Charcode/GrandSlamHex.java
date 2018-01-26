/* This code accepts a test string and a byte array as inputs, encodes the inputs into base64 and base64url strings,
 * and prints the encoded strings and their resultant lengths to the console. The purpose of this code is to compare
 * base64 encoding to hexadecimal encoding. The byte array has 100 elements that are assiged numeric values from 0
 * to 99. The test string is concatenated to itself 5 times before it is encoded. */
package Charcode;

import java.util.Arrays;
import java.util.Base64;

public class GrandSlamHex {

    /* Fields (Constants) */
    private String SDI = "0123456789"; // SDI = single digit integers
    private int A = 100; // length of test array

    /* Package-Private Methods */

    /** Method ta generates a byte array of a specific length whose elements are assigned values from 0 to x-1.
     * ta = test array
     * @param x is the number of elements in the byte array (i.e. byte array length);
     * @return a byte array that stores integers from 0 to x-1 in numeric order */
    byte[] ta(int x){
        byte[] b = new byte[x]; // initializes byte array of length x

        for (byte i = 0; i < x; i++){
            b[i] = i; // assign byte to each array element
        }
        return b; // return the byte array
    }

    /** Repeat concatenates a string to itself until it reaches a length of 50.
     * @param s is the string
     * @return the self-concatenated string
     */
    String repeat(String s){
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
     * @param b is the input byte array
     * @return an array of decimal integers as a string */
    String b2d(byte[] b){
        return Arrays.toString(b); // returns a string representation of a decimal array
    }

    /** b2h is similar to b2d, except that it decodes bytes to hexadecimal numbers.
     * @param b is the input byte array
     * @return an array of hexadecimal integers as a string */
    String b2h(byte[] b){
        String[] ha = new String[b.length]; // ha is the initial hex array as a string

        for(int i = 0; i < b.length; i++){
            ha[i] = String.format("%02x",b[i]); // converts each element to a 2-digit hexadecimal integer
        }
        return Arrays.toString(ha); // returns a string representation of a hex array
    }

    /** whomp encodes bytes into a string using the standard Base64 scheme.
     * A whomp is an enemy in Super Mario 64 (1996).
     * @param b is the input byte array
     * @return the byte array encoded as a Base64 string */
    String whomp(byte[] b){
        return Base64.getEncoder().encodeToString(b); // uses standard Base64 encoder
    }

    /** bomp encodes bytes into a string using the URL and filename safe Base64 scheme.
     * A bomp is also an enemy in Super Mario 64 (1996).
     * @param b is the input byte array
     * @return the byte array encoded as a Base64url string */
    String bomp(byte[] b){
        return Base64.getUrlEncoder().encodeToString(b); // uses URL-safe Base64 encoder
    }

    /* Print to Console (private) */

    private void ptoc(){
        String ccs = repeat(SDI); // ccs = concatenated character string
        byte[] ba = ta(A); // ba = byte array of values from 0 to 99; A = 100 (first input)
        byte[] csa = s2b(ccs); // csa = character string array (second input)

        String ds1 = b2d(ba); // ds1 = 1st input as string of decimal array
        System.out.println("First input: byte array from 0 to 99");
        System.out.println(ds1); // print ds1
        System.out.println();

        String hs1 = b2h(ba); // hs1 = 1st input as string of hex array
        System.out.println("Hex Array 1: ");
        System.out.println(hs1); // print hs1
        System.out.println("Array Length = " + hs1.length()); // length of hs1 as full array
        System.out.println("Total Hex Digits = " + hs1.length()/2); // length without spaces, brackets, or commas
        System.out.println();

        // whomp1 is the 1st input encoded as a Base64 string.
        String whomp1 = whomp(ba);
        System.out.println("Base-64 string 1: ");
        System.out.println(whomp1);
        System.out.println("Length = " + whomp1.length());
        System.out.println();

        // bomp1 is the 1st input encoded as Base64url string.
        String bomp1 = bomp(ba);
        System.out.println("Base-64-URL string 1: ");
        System.out.println(bomp1);
        System.out.println("Length = " + bomp1.length());
        System.out.println();

        System.out.println("2nd input: Concatenated String"); // prints ccs
        System.out.println(ccs);
        System.out.println();
        String ds2 = b2d(csa); // ds2 = 2nd input as string of decimal array
        System.out.println("Byte reference numbers of 2nd input (UTF-8): ");
        System.out.println(ds2); // print ds2
        System.out.println();

        String hs2 = b2h(csa); // hs2 = 2nd array input as string of hex array
        System.out.println("Hex Array 2: ");
        System.out.println(hs2); // print hs2
        System.out.println("Array Length = " + hs2.length()); // length of hs2 as full array
        System.out.println("Total Hex Digits = " + hs2.length()/2); // length without spaces, brackets, or commas
        System.out.println();

        // whomp2 is the 2nd input encoded as a Base64 string.
        String whomp2 = whomp(csa);
        System.out.println("Base-64 string 2: ");
        System.out.println(whomp2);
        System.out.println("Length = " + whomp2.length());
        System.out.println();

        // bomp2 is the first input encoded as Base64url string.
        String bomp2 = bomp(csa);
        System.out.println("Base-64-URL string 2: ");
        System.out.println(bomp2);
        System.out.println("Length = " + bomp2.length());
        System.out.println();
    }

    /* Main Method */

    public static void main(String[] args){

        GrandSlamHex gsh = new GrandSlamHex(); // instantiates object
        gsh.ptoc(); // prints all content to console
    }
}
