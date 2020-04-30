package MovieTheater_System;

import Screening_System.*;
import Concessions_System.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * TheaterDay Class
 * Holds functions and data for the movie theater
 * @author Ryan Kruszeski
 * @author Ryan Beveridge
 */
public class TheaterDay implements Serializable {
    /*ATTRIBUTES*/
    ArrayList<Order> Orders = new ArrayList<>();
    ArrayList<Concessions> concessions = new ArrayList<>();
    Date theaterDate = new Date();
    double totalSales = 0, ticketSales = 0, concessionSales = 0;

    /*Constructors*/
    /*METHODS*/

    /**
     * Sets the total sales of tickets
     */
    void addTicketSale(double d)
    {
       ticketSales += d;
    }

    /**
     * Sets the total sales of concessions
     */
    void addConcessionSale(double d) { concessionSales += d; }

    /**
     * Sets the total day's sales
     */
    void setTotalSales()
    {
        totalSales = ticketSales + concessionSales;
    }

    /**
     * Returns the total sales of the day
     * @return The total sales of the day
     */
    public double getTotalSales() { return totalSales = (ticketSales + concessionSales); }

    /**
     * Returns the ticket sales of the day
     * @return The ticket sales of the day
     */
    public double getTicketSales() { return ticketSales; }

    /**
     * Returns the concession sales of the day
     * @return The concession sales of the day
     */
    public double getConcessionSales() { return concessionSales; }

    /**
     * Adds an order to the list of orders
     * @param O
     */
    public void add_Order(Order O)
    {
        Orders.add(O);
        addTicketSale(O.getPrice_total());
    }

    /**
     * Removes an order from the list of orders
     * @param O The order to be removed
     */
    void remove_Order(Order O)
    {
        addTicketSale(-1 * O.getPrice_total());
        Orders.remove(O);
        for(int i = 0; i < Orders.size(); i++)
        {
            Orders.get(i).setOrderName("Order_" + i + 1);
        }
        Order.NumOrders = Orders.size();
    }

    /**
     * Adds a concession sale to the list of cncessions
     * @param C Concessions
     */
    public void add_Concession(Concessions C)
    {
        concessions.add(C);
        addConcessionSale(C.getPrice_total());
    }

    /**
     * Returns the order from a certain index
     * @param index The index of the order
     * @return An order from an index
     */
    public Order getOrder(int index) { return this.Orders.get(index);}

    /**
     * Returns the order from a certain index
     * @param index The index of the order
     * @return An order from an index
     */
    public Concessions getConcession(int index){return this.concessions.get(index);}

    /**
     * Returns an order based on the order name
     * @param order The name of the order
     * @return The order named
     */
    public Order getOrder(String order)
    {
        for(Order O : Orders)
        {
            if(O.getOrderName().equals(order))
                return O;
        }
            return null;
    }

    /**
     * Returns the number of orders
     * @return The number of orders
     */
    public int get_Order_Size(){return this.Orders.size();}

    /**
     * Returns if there are orders available
     * @return If there are orders available
     */
    public boolean Orders_empty(){return this.Orders.isEmpty();}

    /**
     * Prints the orders in the orders list
     */
    public void printOrders()
    {
        for(Order O : Orders)
            System.out.println(O);
    }

    /**
     * Returns a String version of the theater system
     * @return A string version of the theater system
     */
    @Override
    public String toString() {
        return "Theater System " + theaterDate.toString() + "\n\tTicket Sales: " + String.format("$%.2f",getTicketSales()) + "\tConcession: " + String.format("$%.2f",getConcessionSales()) + "\tTOTAL: " + String.format("$%.2f",getTotalSales()) ;
    }
}
