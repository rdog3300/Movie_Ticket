/**
 * Movie System main class
 * @author Ryan Beveridge
 * @author Ryan Kruszewski
 */

import java.util.Scanner;
import Screening_System.*;
import Screening_System.Ticket;

import MovieTheater_System.*;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        TheaterSystem theater = new TheaterSystem();
        Order.NumOrders = theater.get_Order_Size();

        int userEntry;
        do {
            System.out.println("MOVIE_SYSTEM");
            do {

                System.out.println("\n1. Add Screening Room");
                System.out.println("2. Add Ticket Order");
                System.out.println("3. Remove Ticket Order");
                System.out.println("4. Remove Screening Room");
                System.out.println("5. Load Data");
                System.out.println("6. Save Data");
                System.out.println("7. Exit");
                System.out.print("\nEnter choice: ");
                userEntry = input.nextInt();
                if (userEntry < 1 || userEntry > 7)
                    System.out.println("\nINVALID ENTRY, Try again.\n");
            } while (userEntry < 1 || userEntry > 7);

            switch (userEntry) {

                case 1: {
                    String temp;
                    System.out.print("Enter MAX occupancy of screening room: ");
                    ScreeningRoom tempRoom = new ScreeningRoom(input.nextInt(), "");
                    System.out.println("Enter the name of the movie shown:");
                    temp = input.nextLine();
                    tempRoom.setMovie_shown(SingleString(input.nextLine()));
                    System.out.println(tempRoom);
                        System.out.print("Ready to add? (Y/N): ");
                        if (input.next().toUpperCase().charAt(0) == 'Y')
                            theater.add_ScreeningRoom(tempRoom);

                    break;
                }
                case 2: {
                    String temp = "";
                    int num, entry;
                    Order tempOrder = new Order();
                    if(!theater.Screens_empty())
                    {
                        System.out.println("Enter number of tickets: ");
                        num = input.nextInt();
                        do {
                            System.out.println("Choose the movie showing:");
                            System.out.println(theater.getMovies());
                            System.out.print("Enter choice: ");
                            entry = input.nextInt();
                            if (entry < 1 || entry > theater.get_ScreeningRoom_Size())
                                System.out.println("Invalid Entry\n");
                        } while (entry < 1 || entry > theater.get_ScreeningRoom_Size());
                        ScreeningRoom tempScreen = theater.get_ScreeningRoom(entry - 1);
                        if (tempScreen.isFull())
                            System.out.println("Room is full! Can't add any more Tickets\n");
                        else if (!tempScreen.canAdd_Ticket(num))
                        {
                            System.out.println("Room can't add " + num + " more Tickets\n");
                            Order.NumOrders--;
                        }
                        else
                        {
                            for (int i = 0; i < num; i++) {
                                Ticket tempTicket = new Ticket();
                                do {
                                    System.out.println("Choose a ticket type\n1. Adult\n2. Senior\n3. Teen\n4. Child\n");
                                    System.out.print("Enter a choice: ");
                                    entry = input.nextInt();
                                    if (entry < 1 || entry > 4)
                                        System.out.println("Choice not available\n");
                                } while (entry < 1 || entry > 4);
                                switch (entry) {
                                    case 1: {
                                        tempTicket = new Ticket(temp, 17);
                                        break;
                                    }
                                    case 2: {
                                        tempTicket = new Ticket(temp, 59);
                                        break;
                                    }
                                    case 3: {
                                        tempTicket = new Ticket(temp, 13);
                                        break;
                                    }
                                    case 4: {
                                        tempTicket = new Ticket(temp, 1);
                                        break;
                                    }
                                }
                                tempOrder.addTicket(tempTicket);
                            }

                        tempOrder.setPrice_total();
                        System.out.println(tempOrder);
                        do {
                            System.out.print("\nConfirm placing " + tempOrder.getOrderName() + " (Y/N): ");
                            temp = input.next();
                            if(temp.toUpperCase().charAt(0) != 'Y' && temp.toUpperCase().charAt(0) != 'N')
                                System.out.println("Invalid input\n");
                        }while(temp.toUpperCase().charAt(0) != 'Y' && temp.toUpperCase().charAt(0) != 'N');
                        if(temp.toUpperCase().charAt(0) == 'Y')
                        {
                            theater.add_Order(tempOrder);
                            tempScreen.add_Ticket(tempOrder);
                        }
                        }
                    }
                    else
                System.out.println("No Available Screening Rooms\n");
                    break;
                }

                case 3:
                {
                    int entry = 0;
                    String temp;
                    if(!theater.Orders_empty()) {
                        do {
                            theater.printOrders();
                            System.out.print("\nEnter the order number you would like to cancel: Order_");
                            entry = input.nextInt();
                            if (entry < 1 || entry > theater.get_Order_Size())
                                System.out.println("Invalid Entry, Number out of range. Try again.\n");
                        } while (entry < 1 || entry > theater.get_Order_Size());
                        temp = "Order_" + entry;
                        System.out.println(theater.getOrder(entry - 1).getOrderName() + " was successfully removed\n");
                        theater.remove_Order_Screen(theater.getOrder(temp));
                    }
                    else
                        System.out.println("No Available Ticket Orders\n");
                    break;
                }
                case 4:
                {
                    int entry;
                    if(!theater.Screens_empty())
                    {
                        theater.printScreeeningRooms();
                        System.out.print("Enter the choice of screening room to remove: ");
                        entry = input.nextInt();
                        System.out.println("ScreeningRoom " + entry + " successfully removed\n");
                        theater.remove_ScreeningRoom(theater.get_ScreeningRoom(entry));
                    }
                    else
                        System.out.println("No Available Screening Rooms\n");
                    break;
                }
                case 5:
                {
                    System.out.println("Loading Data......");
                    theater = TheaterSystem.load_system();
                    System.out.println("Load successful");
                    break;
                }
                case 6:
                {
                    System.out.println("Saving Data......");
                    TheaterSystem.save_system(theater);
                    break;
                }
                case 7:
                {
                    System.out.println("Saving Data......");
                    TheaterSystem.save_system(theater);
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
        for(int i = 0; i < Chars.length; i++) {
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
