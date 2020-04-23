package MovieTheater_System;

import Screening_System.*;
import File_IO.*;

import java.io.Serializable;
import java.util.ArrayList;
//import Concessions.*;


/**
 * TheaterSystem Class
 * Holds functions and data for the movie theater
 * @author Ryan Kruszeski
 * @author Ryan Beveridge
 */
public class TheaterSystem implements Serializable {
    /*ATTRIBUTES*/
    ArrayList<ScreeningRoom> ScreeningRooms = new ArrayList<>();
    ArrayList<Order> Orders = new ArrayList<>();
    static WriteFile writeFile = new WriteFile();
    static ReadFile  readFile = new ReadFile();
    double totalSales;

    /*Constructors*/
    /*METHODS*/

    /**
     * Adds a screening room to the list of screening rooms
     * @param S
     */
    public void add_ScreeningRoom(ScreeningRoom S) { ScreeningRooms.add(S); }

    /**
     * Adds an order to the list of orders
     * @param O
     */
    public void add_Order(Order O) { Orders.add(O); }

    /**
     * Removes a screening room from the list of screening rooms
     * @param S
     */
    public void remove_ScreeningRoom(ScreeningRoom S) { ScreeningRooms.remove(S); }

    /**
     * Removes an order from the list of orders
     * @param O The order to be removed
     */
    public void remove_Order(Order O)
    {
        for(ScreeningRoom S : ScreeningRooms)
        {
            if(S.Contains_Tickets(O))
                S.remove_Ticket(O);
        }
        Orders.remove(O);
        for(int i = 0; i < Orders.size(); i++)
        {
            Orders.get(i).setOrderName("Order_" + i + 1);
        }
        Order.NumOrders = Orders.size();
    }

    /**
     * Returns a screening room from a certain index
     * @param index The index of the screening room
     * @return A screening room from an index
     */
    public ScreeningRoom get_ScreeningRoom(int index) {return this.ScreeningRooms.get(index);}

    /**
     * Returns the order from a certain index
     * @param index The index of the order
     * @return An order from an index
     */
    public Order getOrder(int index) { return this.Orders.get(index);}

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
     * Returns the number of screening rooms
     * @return The number of screening rooms
     */
    public int get_ScreeningRoom_Size(){return this.ScreeningRooms.size();}

    /**
     * Returns the number of orders
     * @return The number of orders
     */
    public int get_Order_Size(){return this.Orders.size();}


    public boolean Orders_empty(){return this.Orders.isEmpty();}
    public boolean Screens_empty(){return this.ScreeningRooms.isEmpty();}
    /**
     * Returns a string of movie titles
     * @return A string of movie titles
     */
    public String getMovies()
    {
        String return_String = "MOVIES:\n";
        for(int i = 0; i < ScreeningRooms.size(); i++)
        {
            if (!ScreeningRooms.get(i).isFull())
                return_String += i+1 + ". " + ScreeningRooms.get(i).getMovie_shown() + "\n";
        }
        return return_String;
    }

    public void printOrders()
    {
        for(int i = 0; i < Orders.size(); i++)
            System.out.println(Orders.get(i));
    }

    /**
     * Returns a String version of the theater system
     * @return A string version of the theater system
     */
    @Override
    public String toString() {
        return "Theater system:\n" + get_ScreeningRoom_Size();
    }

    /*FILE OPERATIONS*/

    /**
     * Loads system data from a .ser file
     */
    public static TheaterSystem load_system()
    {
        return readFile.Read();
    }

    /**
     * Saves theater system data to a .ser file
     */
    public static void save_system(TheaterSystem system)
      {
        writeFile.write(system);
      }




}
