package Screening_System;

/**
 * Ticket Class
 * Holds information about each movie theater ticket
 * @author Ryan Kruszewski
 */
public class Ticket
{
    /*ATTRIBUTES*/
    private double price;
    private Age_Groups type;
    private String movie_name;

    /**
     * Default Constructor
     */
    public Ticket()
    {
        setMovie_name("N/A");
        setPrice(0.00);
        setType(Age_Groups.CHILD);
    }

    /**
     * Overloaded Constructor
     * @param movie_name The name of the movie
     * @param type The age group of the ticket
     */
    public Ticket(String movie_name, Age_Groups type)
    {
        setMovie_name(movie_name);
        setType(type);
    }
    //setters

    /**
     * Sets the price of the ticket
     * @param price The price of the ticket
     */
    private void setPrice(double price){this.price = price;}

    /**
     * Sets the name of the movie
     * @param movie_name The name of the movie
     */
    private void setMovie_name(String movie_name){this.movie_name = movie_name;}

    /**
     * Sets the type of the ticket
     * @param type The type of the ticket
     */
    private void setType(Age_Groups type)
    {
        this.type = type;
        setPrice(type.price);
    }

    /**
     * Returns the name of the movie
     * @return The name of the movie
     */
    public String getMovie_name(){return this.movie_name;}

    /**
     * Returns the price of the ticket
     * @return The price of the ticket
     */
    public double getPrice(){return this.price;}

    /**
     * Returns the type of the ticket
     * @return The type of the ticket
     */
    public String getType(){return this.type.toString();}

    /**
     * Returns a string version of the ticket
     * @return A string version of the ticket
     */
    @Override
    public String toString()
    {
        return String.format("Ticket\nMovie:\t%s\tPrice:\t$%.2f\tType:\t%s\n",getMovie_name(),getPrice(),getType());
    }
}
