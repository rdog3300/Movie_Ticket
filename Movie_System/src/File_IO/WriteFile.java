package File_IO;

import MovieTheater_System.StorageSystem;

import java.io.*;

/**
 * WriteFile Class
 * Writes data to file
 * @author Ryan Kruszeski
 */
public class WriteFile {
    ObjectOutputStream OOS;
    //Uses Default constructor;

    /**
     * Writes theater system data to a .ser file
     * @param SYS The theater system to be saved
     */
    public void write(StorageSystem SYS)
    {
        try(ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("MovSys.ser")))
        {
            OOS.writeObject(SYS);
        }
        catch (IOException E)
        {
            System.out.println(E.getMessage());
        }

        System.out.println("System was saved");
    }
}
