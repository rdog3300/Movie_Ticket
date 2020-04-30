package Concessions_System;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Concessions Class
 * Holds information about each concession item purchased
 * @author Ryan Beveridge
 */
public class Concessions implements Serializable{
    ArrayList<Popcorn> popcorn = new ArrayList<>();
    ArrayList<Snacks> snacks = new ArrayList<>();
    ArrayList<Drinks> drinks = new ArrayList<>();

    public static int Num_ofCons = 0;
    private String ConcessionName;
    private double price_total = 0.00;

    /**
     * Default Constructor
     */
    public Concessions(){}

    /*METHODS*/
    //Setters

    /**
     * Sets the total price of the concessions
     */
    public void setPrice_total()
    {
        for(Popcorn P : popcorn)
        {
            price_total += P.getPrice();
        }
        for(Snacks S : snacks)
        {
            price_total += S.getPrice();
        }
        for(Drinks D : drinks)
        {
            price_total += D.getPrice();
        }
    }
    /**
     * Sets the name of the concession
     * @param name name of concession
     */
    public void setConcessionName(String name){this.ConcessionName = name;}

    //Getters
    /**
     * Returns the total price of the concession
     * @return price_total
     */
    public double getPrice_total() { return this.price_total; }

    /**
     * Returns the name of the concession
     * @return The name of the concession
     */
    public String getConcessionName() { return this.ConcessionName; }

    //Popcorn, Snacks, Drinks Functions
    /**
     * Adds popcorn to the ArrayList of concessions
     * @param P The popcorn to be added
     */
    public void addPopcorn(Popcorn P) { popcorn.add(P); }
    /**
     * Adds a snack to the ArrayList of concessions
     * @param S The snack to be added
     */
    public void addSnacks(Snacks S) { snacks.add(S); }
    /**
     * Adds a drink to the ArrayList of concessions
     * @param D The drink to be added
     */
    public void addDrinks(Drinks D) { drinks.add(D); }

    /**
     * Returns a string representation of the concession
     * @return A string representation of the concession
     */
    @Override
    public String toString()
    {
        Num_ofCons++;
        setConcessionName("Concession_" + Num_ofCons);
        StringBuilder returnString = new StringBuilder(getConcessionName());
        for(Popcorn P : popcorn){
            returnString.append("\t").append(P.toString());
        }
        for(Snacks S : snacks){
            returnString.append("\t").append(S.toString());
        }
        for(Drinks D : drinks){
            returnString.append("\t").append(D.toString());
        }
        returnString.append(String.format("TOTAL:\t$ %.2f", getPrice_total()));
        return returnString.toString();
    }
}
