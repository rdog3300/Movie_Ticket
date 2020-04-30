package Screening_System;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ScreeningRoom Class
 * Holds information about each movie theater screening room
 * @author Ryan Kruszewski
 */
public class ScreeningRoom implements Serializable
{
    /*ATTRIBUTES*/
    private String movie_shown;
    private final int MAX_OCCUPANCY;
    private int current_occupancy;
    Age_Groups MovieAge;
    ArrayList<Ticket> Tickets = new ArrayList<>();

    /*CONSTRUCTORS*/

    /**
     * Default Constructor
     */
    public ScreeningRoom() {
        MAX_OCCUPANCY = 10;
        setCurrent_occupancy(0);
        setMovie_shown("N/A");
    }

    /**
     * Overloaded Constructor
     * @param MAX The maximum occupancy
     * @param movie_shown the name of the movie being shown
     */
    public ScreeningRoom(int MAX, String movie_shown,int age_limit)
    {
        MAX_OCCUPANCY = MAX;
        setCurrent_occupancy(0);
        setMovie_shown(movie_shown);
        setMovieAge(age_limit);
    }

    /*METHODS*/
    //setters

    /**
     * Sets the name of the movie shown
     * @param movie_shown The movie shown
     */
    public void setMovie_shown(String movie_shown) {this.movie_shown = movie_shown;}

    /**
     * Sets the current occupancy
     * @param current The current occupancy
     */
    private void setCurrent_occupancy(int current){this.current_occupancy = current;}

    /**
     * Sets the age group limit for the movie
     * @param age_limit The age limit for the movie
     */
    public void setMovieAge(int age_limit)
    {
        if(age_limit >= Age_Groups.ADULT.min)
            MovieAge = Age_Groups.ADULT;
        else if(age_limit >= Age_Groups.TEEN.min)
            MovieAge = Age_Groups.TEEN;
        else
            MovieAge = Age_Groups.CHILD;
    }

    //getters

    /**
     * Returns the max occupancy
     * @return The max occupancy
     */
    public int getMAX_OCCUPANCY() {return this.MAX_OCCUPANCY;}

    /**
     * Returns the current occupancy
     * @return The current occupancy
     */
    public int getCurrent_occupancy(){return this.current_occupancy;}

    /**
     * Returns the name of the movie shown
     * @return The name of the movie shown
     */
    public String getMovie_shown (){return this.movie_shown;}

    /**
     * Returns the age group of the movie
     * @return The age group of the movie
     */
    private Age_Groups getMovieAge(){ return this.MovieAge; }

    /**
     * Returns the content rating of the movie
     * @return The content rating of the movie
     */
    public String getMovie_Rating()
    {
        if(MovieAge == Age_Groups.ADULT)
            return "R";
        else if(MovieAge == Age_Groups.TEEN)
            return "PG-13";
        else
            return "PG";
    }



    //Other functions

    /**
     * Adds customer to the screening room
     * @param T The customer to be added
     */
    public void add_Ticket(Ticket T)
    {
        Tickets.add(T);
        setCurrent_occupancy(getCurrent_occupancy() + 1);
    }

    /**
     * Adds tickets from an order
     * @param O The order of tickets
     */
    public void add_Ticket(Order O)
    {
        for(Ticket T : O.Tickets)
            add_Ticket(T);
    }

    /**
     * Removes customers from the screening room
     * @param T The customer to be removed
     */
    public void remove_Ticket(Ticket T)
    {
        Tickets.remove(T);
        setCurrent_occupancy(getCurrent_occupancy() - 1);
    }

    /**
     * Removes tickets using an order
     * @param O The order of tickets
     */
    public void remove_Ticket(Order O)
    {
        for(Ticket T: O.Tickets)
            remove_Ticket(T);
    }

    /**
     * Returns true if a ticket order is contained in screening room
     * @param O The order of tickets
     * @return If the ticket order is contained in screening room
     */
    public boolean Contains_Tickets(Order O)
    {
        boolean contains = true;
        for(Ticket T : O.Tickets)
        {
            if(!this.Tickets.contains(T))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the screening room is full
     * @return If the screening room is full
     */
    public boolean isFull()
    {
        if(getCurrent_occupancy() > getMAX_OCCUPANCY())
            return true;
        else
            return false;
    }

    /**
     * Adds a ticket if screening room is not full
     * @param T The ticket to be added
     * @return If the ticket can be added
     */
    public boolean canAdd_Ticket(Ticket T)
    {
        if(!isFull())
        {
            if(T.type.min >= this.MovieAge.min) {
                return true;
            }
            else
            {
                System.out.println("Can't add " + T.getType() + " ticket to a " + getMovie_Rating() + " movie");
            }
        }
        return false;
    }

    /**
     * Returns if a number of tickets can be added
     * @param number The number of tickets
     * @return If a number of tickets can be added
     */
    public boolean canAdd_Ticket(int number)
    {
        if(getMAX_OCCUPANCY() >= current_occupancy + number)
            return true;
        else return false;
    }

    /**
     * Returns a string version of screening room
     * @return A string version of screening room
     */
    @Override
    public String toString()
    {
        return String.format("ScreeningRoom\nMovie:\t%s\tMAX:\t%d\tCURRENT:\t%d\tRATING:\t%s\n", getMovie_shown(),getMAX_OCCUPANCY(),getCurrent_occupancy(),getMovie_Rating());
    }

}
