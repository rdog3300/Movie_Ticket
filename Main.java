import java.util.Scanner;
import java.util.ArrayList;


public class Main { //some of this stuff will go in the movie theater system class, just using as testing right now
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Add more screening room\n2. Remove a screening room\n3. Buy a ticket\n4. Sale of popcorn, snacks, and drinks\n5. Cancel a ticket\n6. End sales day\n-1. Exit");
            choice = in.nextInt();

            if(choice == 1){
                System.out.println("1.");
            }
            else if(choice == 2){
                System.out.println("2.");
            }
            else if(choice == 3){
                System.out.println("3.");
            }
            else if(choice == 4){
                System.out.println("4.");
            }
            else if(choice == 5){
                System.out.println("5.");
            }
            else if(choice == 6){
                System.out.println("6.");
            }
            else if(choice == -1){
                break;
            }
            else{
                System.out.println("Not a choice. Try again.");
            }
        }while(true);



    }
}
class Tickets{

}
class Customers{

}
class Screenings {

}
class Concessions{

}
class Popcorn{

}
class Soda{

}
class OutputFile{ //should this be a .ser file?

}
class ReadFile {

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