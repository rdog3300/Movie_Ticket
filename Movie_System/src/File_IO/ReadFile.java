package File_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import MovieTheater_System.TheaterSystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ReadFile Class
 * Reads in data from a .txt file
 * @author Ryan Kruszewski
 */
public class ReadFile {
    ObjectInputStream OIS;

    //Uses Default Constructor

    /**
     * Reads in screening room data
     * @return A theater system
     */
    public TheaterSystem Read()
    {
        TheaterSystem newTest = new TheaterSystem();
        try(ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("MovSys.ser")))
        {
            try
            {
                newTest = (TheaterSystem) OIS.readObject();
            }
            catch (ClassNotFoundException E)
            {
                System.out.println(E);
            }
        }
        catch(IOException E)
        {
            System.out.println(E.getMessage());
        }

        return newTest;
    }
}
