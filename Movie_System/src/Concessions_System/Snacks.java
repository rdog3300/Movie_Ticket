package Concessions_System;

/**
 * Snacks Class
 * Holds information about each snack purchase
 * @author Ryan Beveridge
 */
public class Snacks extends Concessions{

    /*ATTRIBUTES*/
    private double price;
    private String brand;

    /**
     * Default Constructor
     */
    public Snacks()
    {
        setBrand("N/A");
        setType(0);
        setPrice(0.00);
    }

    /**
     * Overloaded Constructor
     * @param brand The name of the brand
     * @param sel The selection of the brand of candy
     */
    public Snacks(String brand, int sel)
    {
        setBrand(brand);
        setType(sel);
    }
    //setters

    /**
     * Sets the price of the candy
     * @param price The price of the candy
     */
    private void setPrice(double price){this.price = price;}

    /**
     * Sets the name of the brand
     * @param brand The name of the brand
     */
    private void setBrand(String brand){this.brand = brand;}

    /**
     * Sets the type of the candy
     * @param sel The selection of the candy
     */
    private void setType(int sel)
    {
        SPrices type;
        if(sel == 1)
            type = SPrices.MILKDUDS;
        else if(sel == 2)
            type = SPrices.OREOS;
        else
            type = SPrices.SKITTLES;
        setPrice(type.price);
    }

    /**
     * Returns the name of the brand
     * @return The name of the brand
     */
    public String getBrand(){return this.brand;}

    /**
     * Returns the price of the candy
     * @return The price of the candy
     */
    public double getPrice(){return this.price;}

    /**
     * Returns the type of the concession, aka CANDY
     * @return The type of the concession, aka CANDY
     */
    public String getType(){return "CANDY";}

    /**
     * Returns a string version of the candy purchase
     * @return A string version of the candy purchase
     */
    @Override
    public String toString()
    {
        return String.format("Concession\n\tType:\t%s\tBrand:\t%s\tPrice:\t$%.2f\t\n",getType(),getBrand(),getPrice());
    }

}
enum SPrices {  //enum for the price of each brand of candy
    MILKDUDS(1),
    OREOS(2),
    SKITTLES(3);

    int sel;
    double price;

    SPrices(int sel) {
        this.sel = sel;
        setPrice();
    }

    private void setPrice() {
        if (this.sel == 1)
            this.price = 3.25;
        else if (this.sel == 2)
            this.price = 3.50;
        else
            this.price = 3.75;
    }
    public String toString() {
        return this.name();
    }
}
