package File_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import MovieTheater_System.StorageSystem;
import MovieTheater_System.TheaterDay;

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
    public StorageSystem Read()
    {
        StorageSystem sys = new StorageSystem();
        try(ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("MovSys.ser")))
        {
            try
            {
                sys = (StorageSystem) OIS.readObject();
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

        return sys;
    }
}
