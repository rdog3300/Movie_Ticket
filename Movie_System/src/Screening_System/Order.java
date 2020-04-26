package Screening_System;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Order Class
 * Holds information about movie theater ticket order
 * @author Ryan Kruszewski
 */
public class Order implements Serializable {
    /*ATTRIBUTES*/
    public static int NumOrders = 0;
    private String OrderName;
    ArrayList<Ticket> Tickets = new ArrayList<>();
    private double price_total = 0.00;

    /*CONSTRUCTOR*/

    /**
     * Default Constructor
     */
    public Order()
    {
        NumOrders++;
        setOrderName("Order_" + NumOrders);
    }

    /*METHODS*/

    //Setters

    /**
     * Sets the total price of the order
     */
    public void setPrice_total()
    {
        for(Ticket T : Tickets)
            price_total += T.getPrice();
    }

    /**
     * Sets the name of the order
     * @param name
     */
    public void setOrderName(String name){this.OrderName = name;}

    //Getters
     /**
      * Returns the total price of the order
      * @return
      */
     public double getPrice_total() { return this.price_total; }

    /**
     * Returns the name of the order
     * @return The name of the order
     */
    public String getOrderName() { return this.OrderName; }

     //Ticket Functions
    /**
     * Adds a ticket to the ArrayList of tickets
     * @param T The ticket to be added
     */
    public void addTicket(Ticket T) { Tickets.add(T); }

    /**
     * Removes a ticket from the ArrayList of tickets
     * @param T The ticket to be added
     */
    public void removeTicket(Ticket T) { Tickets.remove(T); }


    /**
     * Returns a string representation of the order
     * @return A string representation of the order
     */
    @Override
    public String toString()
    {
        String returnString = String.format(getOrderName());
        for(Ticket T : Tickets)
        {
            returnString += "\t" + T.toString();
        }
        returnString += String.format("TOTAL:\t$ %.2f",getPrice_total());
         return returnString;
    }
}
