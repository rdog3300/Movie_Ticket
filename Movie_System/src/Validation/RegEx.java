package Validation;

/**
 * RegEx Class
 * @author Ryan Kruszewski
 */
public class RegEx {
    /**
     * Checks if input is a digit
     * @param input The input string
     * @return If the input is a digit
     */
    static public boolean isDigit(String input)
    {
        if(input.matches("[0-9]+"))
            return true;
        else
        {
            System.out.println("Input is not a number");
            return false;
        }
    }

    /**
     * Checks if input is in Movie format
     * @param input The input string
     * @return If the input is in Movie format
     */
    static public boolean isMovie(String input)
    {
        if(input.matches("[ a-zA-Z1-9:', ]+"))
            return true;
        else
        {
            System.out.println("Movie titles can only have letters, numbers, apostrophe, colon and spaces");
            return false;
        }
    }

    /**
     * Sets input to Movie tile string
     * @param input The input string
     * @return The Movie title format string
     */
    static public String set_to_Movie(String input)
    {
            input = input.toUpperCase();
            char Chars[] = input.toCharArray();
            for(int i = 0; i < Chars.length; i++)
            {
                if ((int)Chars[i] == 32)
                    Chars[i] = '_';
            }
            input = new String(Chars);
            return input;
    }

    /**
     * Checks if the input is in yes / no format
     * @param input The input string
     * @return If the input is in yes / no format
     */
    static public boolean isYesNo(String input)
    {
        if(input.matches("[yYnN]{1}"))
            return true;
        else
        {
            System.out.println("Input is not Y/N");
            return false;
        }
    }
}
