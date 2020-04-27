/**
 * Movie System main class
 * @author Ryan Beveridge
 * @author Ryan Kruszewski
 */

import java.util.Scanner;
import Screening_System.*;
import Screening_System.Ticket;

import MovieTheater_System.*;
import Validation.RegEx;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        StorageSystem sys = StorageSystem.load_system();
        TheaterDay theater = sys.getCurrentDay();
        Order.NumOrders = theater.get_Order_Size();

        String userEntry;
        System.out.println("MOVIE_SYSTEM");
        sys.printPreviousDay();
        do {
            sys.printCurrentDay();
            do {
                System.out.println("\n1. Add Screening Room");
                System.out.println("2. Add Ticket Order");
                System.out.println("3. Remove Ticket Order");
                System.out.println("4. Remove Screening Room");
                System.out.println("5. Load Data");
                System.out.println("6. Save Data");
                System.out.println("7. End Current Day");
                System.out.println("8. Exit");
                System.out.print("\nEnter choice: ");
                userEntry = input.next();
                if(RegEx.isAlpha(userEntry))
                    if (Integer.parseInt(userEntry) < 1 || Integer.parseInt(userEntry) > 8)
                        System.out.println("\nINVALID ENTRY, Try again.\n");
            } while (!RegEx.isAlpha(userEntry) || Integer.parseInt(userEntry) < 1 || Integer.parseInt(userEntry) > 8);

            switch (Integer.parseInt(userEntry)) {

                case 1: {
                    String temp;
                    ScreeningRoom tempRoom = new ScreeningRoom();
                    do
                    {
                        System.out.print("Enter MAX occupancy of screening room: ");
                        temp = input.next();
                        if(RegEx.isAlpha(temp))
                            tempRoom = new ScreeningRoom(Integer.parseInt(temp),"");
                    }while(!RegEx.isAlpha(temp));
                    do {
                        System.out.println("Enter the name of the movie shown:");
                        input.nextLine();
                        temp = input.nextLine();
                        if(RegEx.isMovie(temp))
                        {
                            tempRoom.setMovie_shown(SingleString(temp));
                            do
                            {
                                System.out.println(tempRoom);
                                System.out.print("Ready to add? (Y/N): ");
                                temp = input.next();
                                temp.trim();
                                if(RegEx.isYesNo(temp))
                                {
                                    if(temp.toUpperCase().charAt(0) == 'Y')
                                        sys.add_ScreeningRoom(tempRoom);
                                }
                            }while(!RegEx.isYesNo(temp));
                            break;
                        }
                    }while(!RegEx.isMovie(temp));
                    break;
                }
                case 2: {
                    String entry, numTicks = "";
                    Order tempOrder = new Order();
                    if(!sys.Screens_empty())
                    {
                        do {
                            System.out.print("Enter number of tickets: ");
                            numTicks = input.next();
                        }while(!RegEx.isAlpha(numTicks));


                            System.out.println("Choose the movie showing:");
                            System.out.println(sys.getMovies());
                            do
                            {
                                System.out.print("Enter choice: ");
                                entry = input.next();
                                if (RegEx.isAlpha(entry)) {
                                    if (Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > sys.get_ScreeningRoom_Size())
                                        System.out.println("Invalid Entry. Try again");
                                    else
                                        break;
                                }
                            }while(!RegEx.isAlpha(entry) || Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > sys.get_ScreeningRoom_Size());
                        ScreeningRoom tempScreen = sys.get_ScreeningRoom(Integer.parseInt(entry) - 1);
                        if (tempScreen.isFull())
                            System.out.println("Room is full! Can't add any more Tickets\n");
                        else if (!tempScreen.canAdd_Ticket(Integer.parseInt(numTicks)))
                        {
                            System.out.println("Room can't add " + numTicks + " more Tickets\n");
                            Order.NumOrders--;
                        }
                        else
                        {
                            for (int i = 0; i < Integer.parseInt(numTicks); i++) {
                                Ticket tempTicket = new Ticket();
                                do {
                                    System.out.println("Choose a ticket type\n1. Adult\n2. Senior\n3. Teen\n4. Child\n");
                                    System.out.print("Enter a choice: ");
                                    entry = input.next();
                                    if(RegEx.isAlpha(entry)) {
                                        if (Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > 4)
                                            System.out.println("Choice not available\n");
                                    }
                                } while (!RegEx.isAlpha(entry) || Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > 4 );
                                switch (Integer.parseInt(entry)) {
                                    case 1: {
                                        tempTicket = new Ticket(tempScreen.getMovie_shown(), 17);
                                        break;
                                    }
                                    case 2: {
                                        tempTicket = new Ticket(tempScreen.getMovie_shown(), 59);
                                        break;
                                    }
                                    case 3: {
                                        tempTicket = new Ticket(tempScreen.getMovie_shown(), 13);
                                        break;
                                    }
                                    case 4: {
                                        tempTicket = new Ticket(tempScreen.getMovie_shown(), 1);
                                        break;
                                    }
                                }
                                tempOrder.addTicket(tempTicket);
                            }

                            tempOrder.setPrice_total();
                            System.out.println(tempOrder);
                            do {
                                System.out.print("\nConfirm placing " + tempOrder.getOrderName() + " (Y/N): ");
                                entry = input.next();
                                entry.trim();
                            }while(!RegEx.isYesNo(entry));
                            if(entry.toUpperCase().charAt(0) == 'Y')
                            {
                                theater.add_Order(tempOrder);
                                tempScreen.add_Ticket(tempOrder);
                                System.out.println(tempOrder.getOrderName() + " added successfully");
                            }
                        }
                    }
                    else
                        System.out.println("No Available Screening Rooms\n");
                    break;
                }

                case 3:
                {
                    String entry = "";
                    if(!theater.Orders_empty()) {
                        do {
                            theater.printOrders();
                            System.out.print("\nEnter the order number you would like to cancel: Order_");
                            entry = input.next();
                            if(RegEx.isAlpha(entry))
                            {
                                if (Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > theater.get_Order_Size())
                                    System.out.println("Invalid Entry, Number out of range. Try again.\n");
                            }


                        } while (!RegEx.isAlpha(entry) || Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > theater.get_Order_Size());
                        entry = "Order_" + entry;
                        System.out.println(theater.getOrder(Integer.parseInt(entry.substring(entry.length() - 1)) - 1).getOrderName() + " was successfully removed\n");
                        sys.remove_Order_Screen(theater.getOrder(entry));
                    }
                    else
                        System.out.println("No Available Ticket Orders\n");
                    break;
                }
                case 4:
                {
                    String entry;
                    if(!sys.Screens_empty())
                    {
                        do
                        {
                            sys.printScreeningRooms();
                            System.out.print("Enter the choice of screening room to remove: ");
                            entry = input.next();
                            if(RegEx.isAlpha(entry))
                                if(Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > sys.get_ScreeningRoom_Size())
                                    System.out.println("Invalid Entry, Number out of range. Try again.\n");
                        }while(!RegEx.isAlpha(entry) || Integer.parseInt(entry) < 1 || Integer.parseInt(entry) > sys.get_ScreeningRoom_Size());

                        System.out.println("ScreeningRoom " + entry + " successfully removed\n");
                        sys.remove_ScreeningRoom(sys.get_ScreeningRoom(Integer.parseInt(entry) - 1));
                    }
                    else
                        System.out.println("No Available Screening Rooms\n");
                    break;
                }
                case 5:
                {
                    System.out.println("Loading Data......");
                    sys = StorageSystem.load_system();
                    System.out.println("Load successful");
                    break;
                }
                case 6:
                {
                    System.out.println("Saving Data......");
                    StorageSystem.save_system(sys);
                    break;
                }
                case 7:
                {
                    sys.end_CurrentDay(theater);
                    break;
                }
                case 8:
                {
                    System.out.println("Saving Data......");
                    sys.addTheaterDay(theater);
                    StorageSystem.save_system(sys);
                    System.out.println("\tEXITING.....");
                    System.exit(0);
                }
            }
        }while(true);
    }

    /**
     * Changes string to not accept space characters
     * @param S The string to change
     * @return The changed string
     */
    public static String SingleString(String S)
    {
        S = S.toUpperCase();
        char Chars[] = S.toCharArray();
        for(int i = 0; i < Chars.length; i++)
        {
            if ((int)Chars[i] == 32)
                Chars[i] = '_';
        }
        S = new String(Chars);
        return S;
    }
}


/*
4. Movie Theater System
        Movie Theater is shifting towards using online system to book tickets, they need a
        software to keep track on how many tickets sold vs the number of seats available
        in each screening room. There are 6 screening rooms, each room has a different
        maximum occupant capacity, and the system needs to ensure that the number of
        tickets sold per screening room does not exceed the maximum number of occupant
        for this room.
        The System would like to keep track of the sales of popcorn and drinks sold in
        the theater as well as the total tickets sold each night. At the end of each day, the
        cashier will indicate the end of day and the system will calculate the total sales
        for this day.
        Movie theater system should:
        • Add more screening room.
        • Remove a screening room.
        • Buy a ticket.
        • Sale of popcorn, snake or drinks (Add a list)
        • Cancel a ticket.
        • Start a new sales Day and calculate the total of sales of the previous day. o
        • Show how much each movie sold in sales to report to the production
        company.
 */
