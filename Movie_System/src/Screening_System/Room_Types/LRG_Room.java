package Screening_System.Room_Types;

import Screening_System.ScreeningRoom;

/**
 * Holds data for a Large screening room
 */
public class LRG_Room extends ScreeningRoom
{
    /**
     * Default Constructor
     * @param movie_name The name of the movie shown
     * @param age_limit The age limit of the movie
     */
    public LRG_Room(String movie_name, int age_limit)
    {
        super(100,movie_name,age_limit);
    }
}