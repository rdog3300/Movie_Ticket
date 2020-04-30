package MovieTheater_System;

import File_IO.ReadFile;
import File_IO.WriteFile;
import Screening_System.Order;
import Screening_System.Room_Types.LRG_Room;
import Screening_System.Room_Types.PRV_Room;
import Screening_System.Room_Types.SML_Room;
import Screening_System.Room_Types.STD_Room;
import Screening_System.ScreeningRoom;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * StorageSystem Class
 * @author Ryan Kruszewski
 * @author Ryan Beveridge
 */
public class StorageSystem implements Serializable {
    ArrayList<TheaterDay> PastDays = new ArrayList<>();
    ArrayList<ScreeningRoom> ScreeningRooms = new ArrayList<>();
    private TheaterDay currentDay, previousDay;
    private static WriteFile writeFile = new WriteFile();
    private static ReadFile readFile = new ReadFile();

    /*CONSTRUCTORS*/

    /**
     * Default Constructor
     */
    public StorageSystem()
    {
        currentDay = new TheaterDay();
        if(!PastDays.isEmpty())
            previousDay = PastDays.get(PastDays.size() - 1);
        else
            previousDay = new TheaterDay();
        add_ScreeningRoom(new STD_Room("AVENGERS_ENDGAME",13));
        add_ScreeningRoom(new STD_Room("ONWARD",0));
        add_ScreeningRoom(new LRG_Room("STARWARS_REVENGE_OF_THE_SITH",13));
        add_ScreeningRoom(new LRG_Room("SONIC_THE_HEDGEHOG",0));
        add_ScreeningRoom(new SML_Room("FAST_AND_FURIOUS_9",13));
        add_ScreeningRoom(new PRV_Room("SPIDERMAN_FAR_FROM_HOME",13));
    }

    /*METHODS*/

    /**
     * Adds a theater day to the list of theater days
     * @param T The day to be added
     */
    public void addTheaterDay(TheaterDay T) { PastDays.add(T); }

    /**
     * Removes a theater day from the list of theater days
     * @param T
     */
    public void removeTheaterDay(TheaterDay T) { PastDays.remove(T); }

    /**
     * Prints the previous day sales to the console
     */
    public void printPreviousDay(){System.out.println(previousDay);}

    /**
     * Prints the current day sales to the console
     */
    public void printCurrentDay() {System.out.println(currentDay);}

    /**
     * Returns the current theater day
     * @return The current theater day
     */
    public TheaterDay getCurrentDay() {return this.currentDay;}

    /**
     * Returns a screening room from a certain index
     * @param index The index of the screening room
     * @return A screening room from an index
     */
    public ScreeningRoom get_ScreeningRoom(int index) {return this.ScreeningRooms.get(index);}

    /**
     * Returns the number of screening rooms
     * @return The number of screening rooms
     */
    public int get_ScreeningRoom_Size(){return this.ScreeningRooms.size();}

    /**
     * Returns if there are screening rooms available
     * @return if there are screening rooms available
     */
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

    /**
     * Prints the screening rooms in the screening rooms list
     */
    public void printScreeningRooms()
    {
        for(int i = 0; i < ScreeningRooms.size(); i++)
            System.out.println((i + 1) + ". " + ScreeningRooms.get(i));
    }

    /**
     * Adds a screening room to the list of screening rooms
     * @param S
     */
    public void add_ScreeningRoom(ScreeningRoom S) { ScreeningRooms.add(S); }

    /**
     * Removes a screening room from the list of screening rooms
     * @param S
     */
    public void remove_ScreeningRoom(ScreeningRoom S)
    {
        for (int i = 0; i < this.PastDays.size(); i++) {
            for (int j = 0; j < PastDays.get(i).Orders.size(); j++)
                if (S.Contains_Tickets(PastDays.get(i).getOrder(j))) {
                    S.remove_Ticket(PastDays.get(i).getOrder(j));
                    PastDays.get(i).remove_Order(PastDays.get(i).getOrder(j));
                }
        }
        ScreeningRooms.remove(S);
    }

    /**
     * Removes an order from all screening rooms
     * @param O The order to be removed
     */
    public void remove_Order_Screen(Order O)
    {
        for(ScreeningRoom S : ScreeningRooms)
        {
            if(S.Contains_Tickets(O))
                S.remove_Ticket(O);
        }
        currentDay.remove_Order(O);
    }

    /**
     * Ends current day of theater sales
     * @param T The current theater day
     */
    public void end_CurrentDay(TheaterDay T)
    {
        T.setTotalSales();
        System.out.println("Ending Day:\n" + T);
        addTheaterDay(T);
        previousDay = T;
        currentDay = new TheaterDay();
    }

    /**
     * Returns a string version of the system
     * @return A string version of the system
     */
    @Override
    public String toString()
    {
        String return_String = "System";
        for(TheaterDay T : PastDays)
        {
            return_String += T;
        }
        return return_String;
    }

    /*FILE OPERATIONS*/

    /**
     * Loads system data from a .ser file
     */
    public static StorageSystem load_system()
    {
        return readFile.Read();
    }

    /**
     * Saves theater system data to a .ser file
     */
    public static void save_system(StorageSystem system)
    {
        writeFile.write(system);
    }
}
