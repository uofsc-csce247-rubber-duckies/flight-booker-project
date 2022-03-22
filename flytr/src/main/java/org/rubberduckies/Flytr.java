package org.rubberduckies;

import java.util.Scanner;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

public class Flytr {
  
    private Flytr instance;
    private BookingController bookingController;
    private UserController userController;
    public static Scanner keyboard = new Scanner(System.in);

    public Flytr() {
        this.userController = new UserController();
        this.bookingController = new BookingController();
    }

    
    /** 
     * Gets instance of application
     * @return Flytr application
     */
    public Flytr getInstance() {
        if (instance == null) {
            this.instance = new Flytr();
        }
        return this.instance;
    }

    /**
     * Runs application
     */
    public void run() {
        //TODO: run
    }

    


    /** 
     * Search for flight by choosing a type of flight
     * 
     */
    public static searchFlights() {
        System.out.println("----- Search Flights -----");
        System.out.println("Select Flight Type: \n 1. One Way Flight \n 2. Round-Trip Flight");
        int flightType = keyboard.nextInt();
        if (flightType == 1) {
            oneWay();
        }        
        else if (flightType == 2) {
            roundTrip();
        } 
        else if (flightType != 1 || flightType != 2) {
            System.out.println("Please select a type of Flight");
            searchFlights();
        } 
    }

    /**
     * Created a class to book a one way Flight
     */
    public void  oneWay() {
        System.out.println("-----Departure Information-----");
        System.out.println("\n Enter your Departure Location: ");
        String loc1 = keyboard.nextLine();     //make variable names consistent throughout program
        System.out.println("-----Results-----");

        //TODO Connect to Database and Display Available Results 

        System.out.println("----- Destination Information -----");
        System.out.println("\n Enter your Destination Location: ");
        String loc2 = keyboard.nextLine();     //make variable names consistent throughout program
        System.out.println("----- Results -----");

        //TODO Connect to Database and Display Available Results

        System.out.println("Enter your departure date(YYYY-MM-DD): ");
        String userDate = keyboard.nextLine();

        //TODO store as Date and Time Object and move to controller

        System.out.println("Enter number of Travelers:");
        int travelers = keyboard.nextLine();

        //TODO move to database

        System.out.println("Enter number of Pets:");
        int pets = keyboard.nextLine();

        //TODO move to database 

        System.out.println("----- Flight Options -----");

        //TODO return out the flight options

        System.out.println(" Enter your Flight Choice: ");
        int flightDecision = keyboard.nextInt();

        if(travelers = 1) {
            System.out.println("Choose your seat: ");
            String seat = keyboard.nextLine();
            //TODO If seats dont exist and pull through database
        }
        else {
            System.out.println("Choose your seats: ");
            String seat = keyboard.nextLine();
            //TODO If seats dont exist and pull through database
        }
        System.out.println("Confirm your flight?");
        String confirmation = keyboard.nextLine();
        if(confirmation.equalsIgnoreCase("yes")) {
            System.out.println("----- Your Ticket -----");
            //Return Ticket
        }
        else {
            System.out.println("What would you like to change?:");
            String changes = keyboard.nextLine();
            //TODO go back to instances of the ticket 
        }
            //TODO return back to the intial prompt class 
    } 
 /**
     * Created a class to book a round Trip Flight
     */
    public void roundTrip() {
        System.out.println("-----Departure Information-----");
        System.out.println("\n Enter your Departure Location: ");
        String loc1 = keyboard.nextLine();     //make variable names consistent throughout program
        System.out.println("-----Results-----");

        //TODO Connect to Database and Display Available Results 

        System.out.println("----- Destination Information -----");
        System.out.println("\n Enter your Destination Location: ");
        String loc2 = keyboard.nextLine();     //make variable names consistent throughout program
        System.out.println("----- Results -----");

        //TODO Connect to Database and Display Available Results

        System.out.println("Enter your departure date(YYYY-MM-DD): ");
        String userDate = keyboard.nextLine();

        //TODO store as Date and Time Object and move to controller

        System.out.println("Enter your return date(YYYY-MM-DD): ");
        String userreturnDate = keyboard.nextLine();

        //TODO store as Date and Time Object and move to controller


        System.out.println("Enter number of Travelers:");
        int travelers = keyboard.nextLine();

        //TODO move to database

        System.out.println("Enter number of Pets:");
        int pets = keyboard.nextLine();

        //TODO move to database 

        System.out.println("----- Flight Options -----");

        //TODO return out the flight options

        System.out.println(" Enter your Flight Choice: ");
        int flightDecision = keyboard.nextInt();

        if(travelers = 1) {
            System.out.println("Choose your seat: ");
            String seat = keyboard.nextLine();
            //TODO If seats dont exist and pull through database
        }
        else {
            System.out.println("Choose your seats: ");
            String seat = keyboard.nextLine();
            //TODO If seats dont exist and pull through database
        }
        System.out.println("Confirm your flight?");
        String confirmation = keyboard.nextLine();
        if(confirmation.equalsIgnoreCase("yes")) {
            System.out.println("----- Your Ticket -----");
            //Return Ticket
            System.out.println("\n Would you like to share your ticket?");
            if(confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Who would you like to share your ticket with?");
                String shareTicket = keyboard.nextLine();
                //TODO share to account
                System.out.println("Your account was shared with"+shareTicket);
            }
        }
        else {
            System.out.println("What would you like to change?:");
            String changes = keyboard.nextLine();
            //TODO go back to instances of the ticket 
        }
            //TODO return back to the intial prompt class 
         
    } 
    





    /** 
     * Search for hotel
     * @return 
     * @return boolean successful search
     */
    public void searchHotels() {
        
            String city;
            String state;
            int numOfRooms;
            int numOfOccupants;

            System.out.println("----- Search Hotels -----");
            System.out.println("Please search a location. \n City:");
            city = keyboard.nextLine();

            System.out.println("State");
            state = keyboard.nextLine();

            System.out.println("Enter the number of rooms you wish to book: ");
            numOfRooms = keyboard.nextInt();
            
            System.out.println("Enter the number of occupants per room:");
            numOfOccupants = keyboard.nextInt();

            //TODO search database with criteria given.
    }

    
    /** 
     * Create a new user account
     * @return boolean successful account creation
     */
    private boolean createAccount() {
        return false;
    }

    
    /** 
     * Login user
     * @return boolean successful login
     */
    private boolean login() {
        return false;
    }

    
    /** 
     * Checkout user cart
     * @return boolean successful checkout
     */
    private boolean checkout() {
        return false;
    }

    
    /** 
     * Cancel booking
     * @return boolean successful booking cancel
     */
    private boolean cancelBooking() {
        return false;
    }

}
