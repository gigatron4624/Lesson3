/** This program uses GSON to convert objects to strings in Java Script Object Notation (JSON) format. GSON is an
 * open-source parser for JSON developed by Google. GSON will convert an Address instance to a JSON string
 * and then initialize a new Address object from the JSON string. The output should match the original instance. */

package Charcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TheGSONMenace {

    /* Address Fields */
    private String tag; // tag is another word for name
    private String location; // street address
    private String city; // Come on! Every address needs a city right?
    private int zone; // zone is the zip code

    /* No Argument Constructor */
    TheGSONMenace(){
        tag = "";
        location = "";
        city = "";
        zone = 0;
    }

    /* Address Instantiation Constructor */

    /** This constructor generates an Address instance with occupied fields. [1]
     * @param tag is the name of the place
     * @param location is the address of the place
     * @param city is the city in which the address is located
     * @param zone is the zip code*/
    TheGSONMenace(String tag, String location, String city, int zone){
        this.tag = tag; // sets the name of place
        this.location = location; // sets the location
        this.city = city; // sets the city
        this.zone = zone; // sets the zip code
    }

    /* Getters: These methods obtain the necessary variables. [1] */

    /** @return the name/tag */
    String getTag(){
        return tag; // name
    }

    /** @return the street address (i.e. location) */
    String getLocation(){
        return location; // street address
    }

    /** @return the city of the street address */
    String getCity(){
        return city; // self-explanatory
    }

    /** @return the zip code of the city */
    int getZone(){
        return zone; // zip code
    }

    public static void main(String[] args){

        String org = "WTF Productions"; // org is short for organization; the address is fake
        String loc = "7056 Blight Boulevard"; // loc is short for location;
        String cp = "East Bumf--k, Mississippi"; // cp = city proper (fake)
        int zc = 38809; // zc = zip code (fake)

        TheGSONMenace tgm1 = new TheGSONMenace(org, loc, cp, zc); // create an address object
        Gson force = new GsonBuilder().create(); // builds a GSON instance
        String warped = force.toJson(tgm1); // converts address object to JSON string
        TheGSONMenace tgm2 = force.fromJson(warped, TheGSONMenace.class); //  converts JSON string to address object


        System.out.println(tgm1.getTag()); // print name to console
        System.out.println(tgm1.getLocation()); // print location to console
        System.out.println(tgm1.getCity()); // print city to console
        System.out.println(tgm1.getZone()); // print zip code to console

        System.out.println(tgm2.getTag()); // print name to console
        System.out.println(tgm2.getLocation()); // print location to console
        System.out.println(tgm2.getCity()); // print city to console
        System.out.println(tgm2.getZone()); // print zip code to console
    }

    /* Works Cited */
    /* [1] Source: Address.java. Author: Thomas Kennedy. Old Dominion University
     * https://www.cs.odu.edu/~tkennedy/cs350/sum16/Public/adtTesting/Address.java.html */
}
