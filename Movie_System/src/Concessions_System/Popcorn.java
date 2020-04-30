package Concessions_System;

/**
 * Popcorn Class
 * Holds information about each popcorn purchase
 * @author Ryan Beveridge
 */
public class Popcorn extends Concessions{
    private double price;
    private String size;

    /**
     * Default Constructor
     */
    public Popcorn()
    {
        setSize("N/A");
        setType(0);
        setPrice(0.00);
    }

    /**
     * Overloaded Constructor
     * @param size The size of popcorn
     * @param sel The selection of which size
     */
    public Popcorn(String size, int sel)
    {
        setSize(size);
        setType(sel);
    }

    //setters
    /**
     * Sets the price of the popcorn
     * @param price The price of the popcorn
     */
    private void setPrice(double price){this.price = price;}

    /**
     * Sets the name of the movie
     * @param size The name of the movie
     */
    private void setSize(String size){this.size = size;}

    /**
     * Sets the size type of the popcorn
     * @param sel The age of the customer
     */
    private void setType(int sel)
    {
        PPrices type;
        if(sel == 1)
            type = PPrices.SMALL;
        else if(sel == 2)
            type = PPrices.MEDIUM;
        else
            type = PPrices.LARGE;

        setPrice(type.price);
    }

    /**
     * Returns the name of the movie
     * @return The name of the movie
     */
    public String getSize(){return this.size;}

    /**
     * Returns the price of the popcorn
     * @return The price of the popcorn
     */
    public double getPrice(){return this.price;}

    /**
     * Returns the type of the concession, aka POPCORN
     * @return The type of the concession, aka POPCORN
     */
    public String getType(){return "POPCORN";}

    /**
     * Returns a string version of the popcorn purchase
     * @return A string version of the popcorn purchase
     */
    @Override
    public String toString()
    {
        return String.format("Concession\n\tType:\t%s\tSize:\t%s\tPrice:\t$%.2f\t\n",getType(),getSize(),getPrice());
    }

}
enum PPrices { // enum for the size and price of popcorn
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    int sel;
    double price;

    PPrices(int sel) {
        this.sel = sel;
        setPrice();
    }

    private void setPrice() {
        if (this.sel == 1)
            this.price = 4.00;
        else if (this.sel == 2)
            this.price = 5.00;
        else
            this.price = 6.00;
    }

    public String toString() {
        return this.name();
    }
}
