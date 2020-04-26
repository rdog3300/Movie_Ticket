package Screening_System;

import java.io.Serializable;

/**
 * Ticket Class
 * Holds information about each movie theater ticket
 * @author Ryan Kruszewski
 */
public class Ticket implements Serializable
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
        setType(0);
        setPrice(0.00);
    }

    /**
     * Overloaded Constructor
     * @param movie_name The name of the movie
     * @param age The age of the ticket customer
     */
    public Ticket(String movie_name, int age)
    {
        setMovie_name(movie_name);
        setType(age);
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
     * @param age The age of the customer
     */
    private void setType(int age)
    {
       if(age >= Age_Groups.SENIOR.min)
           this.type = Age_Groups.SENIOR;
       else if(age >= Age_Groups.ADULT.min)
           this.type = Age_Groups.ADULT;
       else if(age >= Age_Groups.TEEN.min)
            this.type = Age_Groups.TEEN;
       else
           this.type = Age_Groups.CHILD;

       setPrice(this.type.price);
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
        return String.format("Ticket\n\tMovie:\t%s\tPrice:\t$%.2f\tType:\t%s\n",getMovie_name(),getPrice(),getType());
    }
}


enum Age_Groups
{

    SENIOR(59,150),
    ADULT(17,58),
    TEEN(13,16),
    CHILD(0,12);

    int max,min;
    double price;

    Age_Groups(int min, int max)
    {
        this.min = min;
        this.max = max;
        setPrice();
    }

    private void setPrice()
    {
        if(this.min == 59)
            this.price = 4.00;//set senior price
        else if(this.min == 17)
            this.price = 7.00;//set adult price
        else if(this.min == 13)
            this.price = 5.00;
        else
            this.price = 2.50;
    }

    public String toString()
    {
        return this.name();
    }
}
