package Concessions_System;

/**
 * Drinks Class
 * Holds information about each drink purchased
 * @author Ryan Beveridge
 */
public class Drinks extends Concessions
{
    private double price;
    private String size;

    /**
     * Default Constructor
     */
    public Drinks() {
        setSize("N/A");
        setType(0);
        setPrice(0.00);
    }

    /**
     * Overloaded Constructor
     * @param size The size of the drink
     * @param sel  The selection of the type of drink
     */
    public Drinks(String size, int sel) {
        setSize(size);
        setType(sel);
    }

    //setters
    /**
     * Sets the price of the drink
     * @param price The price of the drink
     */
    private void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the size of the drink
     * @param size The size of the drink
     */
    private void setSize(String size) {
        this.size = size;
    }

    /**
     * Sets the type of drink
     * @param sel The sel of drink type (water or size of soda)
     */
    private void setType(int sel) {
        DPrices type;
        if (sel == 1)
            type = DPrices.WATER;
        else if (sel == 2)
            type = DPrices.SMALL;
        else if (sel == 3)
            type = DPrices.MEDIUM;
        else
            type = DPrices.LARGE;
        setPrice(type.price);
    }

    /**
     * Returns the size of the drink
     * @return The size of the drink
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Returns the price of the drink
     * @return The price of the drink
     */
    public double getPrice() { return this.price; }

    /**
     * Returns the type of the concession, aka DRINK
     * @return The type of the concession, aka DRINK
     */
    public String getType() {
        return "DRINK";
    }

    /**
     * Returns a string version of the ticket
     *
     * @return A string version of the ticket
     */
    @Override
    public String toString() {
        return String.format("Concession\n\tType:\t%s\tSize:\t%s\tPrice:\t$%.2f\t\n", getType(), getSize(), getPrice());
    }
}
enum DPrices {
    WATER(1),
    SMALL(2),
    MEDIUM(3),
    LARGE(4);

    int sel;
    double price;

    DPrices(int sel) {
        this.sel = sel;
        setPrice();
    }

    private void setPrice() {
        if (this.sel == 1)
            this.price = 1.50;
        else if (this.sel == 2)
            this.price = 2.50;
        else if (this.sel == 3)
            this.price = 3.00;
        else if(this.sel == 4)
            this.price = 3.50;
    }

    public String toString() {
        return this.name();
    }
}
