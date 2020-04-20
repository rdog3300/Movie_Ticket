package Screening_System;

/**
 * Customer Class
 * Holds information about each movie theater customer
 * @author Ryan Kruszewski
 */
public class Customer {
    /*ATTRIBUTES*/
    private String name;
    private int age;
    private Age_Groups AgeGroup;
    private Ticket ticket;

    /*CONSTRUCTORS*/

    /**
     * Default Constructor
     */
    public Customer()
    {
        setName("N/A");
        setAge(0);
        setAgeGroup();
    }

    /**
     * Overloaded Constructor
     * @param name The name of the customer
     * @param age The age of the customer
     */
    public Customer(String name, int age)
    {
        setName(name);
        setAge(age);
        setAgeGroup();
    }

    /*METHODS*/
    //setters

    /**
     * Sets the name of the customer
     * @param name The name of the customer
     */
    public void setName(String name){this.name = name;}

    /**
     * Sets the age of the customer
     * @param age The age of the customer
     */
    public void setAge(int age){this.age = age;}

    /**
     * Sets the age group of the customer
     */
    private void setAgeGroup()
    {
        if(getAge() >= 59)
            this.AgeGroup = Age_Groups.SENIOR;
        else if(getAge() >= 18)
            this.AgeGroup = Age_Groups.ADULT;
        else if(getAge() >= 13)
            this.AgeGroup = Age_Groups.TEEN;
        else
            this.AgeGroup = Age_Groups.CHILD;
    }

    /**
     * Sets the customer's ticket
     * @param T The customer's ticket
     */
    public void setTicket(Ticket T){this.ticket = T;}

    //getters

    /**
     * Returns the name of the customer
     * @return The name of the customer
     */
    public String getName(){return this.name;}

    /**
     * Returns the age of the customer
     * @return The age of the customer
     */
    public int getAge(){return this.age;}

    /**
     * Returns the age group of the customer
     * @return The age group of the customer
     */
    public String getAgeGroup(){return this.AgeGroup.toString();}



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
        else if(this.min == 18)
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