package Screening_System.Room_Types;

import Screening_System.ScreeningRoom;

/**
 * Holds data for a Private screening room
 */
public class PRV_Room extends ScreeningRoom
{
    /**
     * Default Constructor
     * @param movie_name The name of the movie shown
     * @param age_limit The age limit of the movie
     */
    public PRV_Room(String movie_name, int age_limit)
    {
        super(10,movie_name,age_limit);
    }
}
