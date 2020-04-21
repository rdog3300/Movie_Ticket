package Screening_System;
import java.util.ArrayList;
/**
 * ScreeningRoom Class
 * Holds information about each movie theater screening room
 * @author Ryan Kruszewski
 */
public class ScreeningRoom
{
    /*ATTRIBUTES*/
    private String movie_shown;
    private final int MAX_OCCUPANCY;
    private int current_occupancy;
    private ArrayList<Ticket> Tickets = new ArrayList<>(); //maybe??

    /*CONSTRUCTORS*/

    /**
     * Default Constructor
     */
    public ScreeningRoom() {
        MAX_OCCUPANCY = 10;
        this.current_occupancy = 0;
        setMovie_shown("N/A");
    }

    /**
     * Overloaded Constructor
     * @param MAX The maximum occupancy
     * @param movie_shown the name of the movie being shown
     */
    public ScreeningRoom(int MAX, String movie_shown)
    {
        MAX_OCCUPANCY = MAX;
        this.current_occupancy = 0;
        setMovie_shown(movie_shown);
    }

    /*METHODS*/
    //setters

    /**
     * Sets the name of the movie shown
     * @param movie_shown The movie shown
     */
    public void setMovie_shown(String movie_shown) {this.movie_shown = movie_shown;}

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

    //Other functions

    /**
     * Adds customer to the screening room
     * @param T The customer to be added
     */
    public void add_Ticket(Ticket T)
    {
        Tickets.add(T);
        current_occupancy++;
    }

    /**
     * Removes customers from the screening room
     * @param T The customer to be removed
     */
    public void remove_Ticket(Ticket T)
    {
        Tickets.remove(T);
        current_occupancy --;
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
            add_Ticket(T);
            return true;
        }
        else
            return false;
    }

    /**
     * Returns a string version of screening room
     * @return A string version of screening room
     */
    @Override
    public String toString()
    {
        return String.format("ScreeningRoom\nMovie:\t%s\tMAX:\t%d\tCURRENT\t%d\n", getMovie_shown(),getMAX_OCCUPANCY(),getCurrent_occupancy());
    }

}
