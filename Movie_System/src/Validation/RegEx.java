package Validation;

/**
 * RegEx Class
 * @author Ryan Kruszewski
 */
public class RegEx {

    static public boolean isAlpha(String input)
    {
        if(input.matches("[0-9]+"))
            return true;
        else
        {
            System.out.println("Input is not a number");
            return false;
        }
    }

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
