package Concessions_System;
/**
 * Concessions Class
 * The user is able to purchase concession items
 * @author Ryan Beveridge
 */
import java.util.Scanner;
import java.lang.String;

public class Concessions {
    private static double itemPrice;
    static boolean ordering = true;
    static boolean orderingPopcorn = true;
    static boolean orderingSnacks = true;
    static boolean orderingDrinks = true;
    public static String Drink;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int selection, sel, select;
        int YN;
        int itemValue = -1;
        double totalPrice = 0;
        in = new Scanner(System.in);
        System.out.println("|------------------------------------|");
        System.out.println("|         Concession Stand           |");
        System.out.println("|------------------------------------|");
        do {
            System.out.println("\nPlease make a selection:");
            System.out.println("1) Popcorn");
            System.out.println("2) Snacks");
            System.out.println("3) Drinks");
            System.out.println("0) Exit");
            System.out.printf("Total: $%.2f\n", totalPrice);

            sel = in.nextInt();
            if (sel == 1) { //Popcorn
                orderingPopcorn = true;
                do {
                    System.out.println("Select popcorn size:\n1) Small   $4.00\n2) Medium  $5.00\n3) Large   $6.00\n0) Exit");
                    selection = in.nextInt();
                    switch (selection) {
                        case 0: {
                            orderingPopcorn = false;
                        }
                        break;
                        case 1:
                            itemValue = 1;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingPopcorn = false;
                            break;
                        case 2:
                            itemValue = 2;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingPopcorn = false;
                            break;
                        case 3:
                            itemValue = 3;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingPopcorn = false;
                            break;
                                /*case 4:
                                    done(runningTotal);
                                    break;*/
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    if (orderingPopcorn) {
                        int a;
                        do {
                            System.out.println("Would you like to buy more popcorn? (Y/N)");
                            YN = in.next().charAt(0);
                            if (YN == 'Y' | YN == 'y') {
                                //System.out.println("Okay");
                                a = 0;
                            } else if (YN == 'N' | YN == 'n') {
                                //System.out.println("Exiting popcorn...");
                                orderingPopcorn = false;
                                a = 0;
                            } else {
                                System.out.println("Invalid input. Try again.");
                                a = 1;
                            }
                        } while (a == 1);
                    }
                } while (orderingPopcorn);
            } else if (sel == 2) {
                orderingSnacks = true;
                do {
                    System.out.println("Select snack:\n1) Milk Duds  $3.25\n2) M&Ms       $3.50\n3) Skittles   $3.75");
                    selection = in.nextInt();
                    switch (selection) {
                        case 0: {
                            orderingSnacks = false;
                        }
                        break;
                        case 1:
                            itemValue = 4;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingSnacks = false;
                            break;
                        case 2:
                            itemValue = 5;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingSnacks = false;
                            break;
                        case 3:
                            itemValue = 6;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingSnacks = false;
                            break;
                                /*case 4:
                                    done(runningTotal);
                                    break;*/
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    if (orderingSnacks) {
                        int a;
                        do {
                            System.out.println("Would you like to buy more snacks? (Y/N)");
                            YN = in.next().charAt(0);
                            if (YN == 'Y' | YN == 'y') {
                                //System.out.println("Okay");
                                a = 0;
                            } else if (YN == 'N' | YN == 'n') {
                                //System.out.println("Exiting popcorn...");
                                orderingSnacks = false;
                                a = 0;
                            } else {
                                System.out.println("Invalid input. Try again.");
                                a = 1;
                            }
                        } while (a == 1);
                    }
                } while (orderingSnacks);
            } else if (sel == 3) {
                orderingDrinks = true;
                selection = 0;
                do {
                    int a = 1;
                    do{
                        System.out.println("Select drink:\n1) Pepsi\n2) Mountain Dew\n3) Dr. Pepper\n0) Exit");
                        select = in.nextInt();
                        if (select == 1) {
                            Drink = "Pepsi";
                            System.out.println("Select drink size:\n1) Small   $4.25\n2) Medium  $4.50\n3) Large   $4.75\n0) Exit");
                            selection = in.nextInt();
                            a = 0;
                        } else if (select == 2) {
                            Drink = "Mountain Dew";
                            System.out.println("Select drink size:\n1) Small   $4.25\n2) Medium  $4.50\n3) Large   $4.75\n0) Exit");
                            selection = in.nextInt();
                            a = 0;
                        } else if (select == 3) {
                            Drink = "Dr. Pepper";
                            System.out.println("Select drink size:\n1) Small   $4.25\n2) Medium  $4.50\n3) Large   $4.75\n0) Exit");
                            selection = in.nextInt();
                            a = 0;
                        } else if (select == 0) {
                            orderingDrinks = false;
                            break;
                        } else {
                            System.out.println("Invalid input. Try again.");
                            a = 0;
                        }
                    }while (a == 1);
                    //System.out.println("Select drink size:\n1) Small   $4.25\n2) Medium  $4.50\n3) Large   $4.75\n0) Exit");
                    //selection = in.nextInt();
                    switch (selection) {
                        case 0: {
                            orderingDrinks = false;
                        }
                        break;
                        case 1:
                            itemValue = 7;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingDrinks = false;
                            break;
                        case 2:
                            itemValue = 8;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingDrinks = false;
                            break;
                        case 3:
                            itemValue = 9;
                            totalPrice += itemPrice(itemValue);
                            System.out.print("TotalPrice is: " + totalPrice + "\n");
                            //orderingDrinks = false;
                            break;
                                /*case 4:
                                    done(runningTotal);
                                    break;*/
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    if (orderingDrinks) {
                        int b;
                        do {
                            System.out.println("Would you like to buy more drinks? (Y/N)");
                            YN = in.next().charAt(0);
                            if (YN == 'Y' | YN == 'y') {
                                //System.out.println("Okay");
                                b = 0;
                            } else if (YN == 'N' | YN == 'n') {
                                //System.out.println("Exiting popcorn...");
                                orderingDrinks = false;
                                b = 0;
                            } else {
                                System.out.println("Invalid input. Try again.");
                                b = 1;
                            }
                        } while (b == 1);
                    }
                } while (orderingDrinks);
            } else if (sel == 0) {
                ordering = false;
                System.out.printf("Your total for concessions is: $%.2f", totalPrice);
            }
        } while (ordering);
    }

    public static double itemPrice(int itemValue) {
        if (itemValue == 1) {
            System.out.println("You ordered a small");
            itemPrice = 4.00;
        } else if (itemValue == 2) {
            System.out.println("You ordered a medium");
            itemPrice = 5.00;
        } else if (itemValue == 3) {
            System.out.println("You ordered a large");
            itemPrice = 6.00;
        } else if (itemValue == 4) {
            System.out.println("You ordered Milk Duds");
            itemPrice = 3.25;
        } else if (itemValue == 5) {
            System.out.println("You ordered M&Ms");
            itemPrice = 3.50;
        } else if (itemValue == 6) {
            System.out.println("You ordered Skittles");
            itemPrice = 3.75;
        } else if (itemValue == 7) {
            System.out.println("You ordered a small");
            itemPrice = 4.25;
        } else if (itemValue == 8) {
            System.out.println("You ordered a medium");
            itemPrice = 4.50;
        } else if (itemValue == 9) {
            System.out.println("You ordered a large");
            itemPrice = 4.75;
        }
        return itemPrice * quantity();
    }

    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = in.nextDouble();
        subTotal(quantity, itemPrice);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
        System.out.printf("Subtotal: $%.2f\n", subTotal);
        return subTotal;
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

