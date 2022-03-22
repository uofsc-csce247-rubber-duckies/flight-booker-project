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
        welcome();
        //TODO: run
        
    
    }
    public void welcome(){
        mainMenu();
       

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
    public static oneWay() {
        System.out.println("----- Departure Information -----");
        System.out.println("\n Enter your Departure Location: ");
        String loc1 = keyboard.nextLine();     //make variable names consistent throughout program
        //TODO Connect to Database and Display Available Results 
        System.out.println("\n Enter your Destination Location: ");
        String loc2 = keyboard.nextLine();     //make variable names consistent throughout program

        //TODO Connect to Database and Display Available Results 

    } 
 /**
     * Created a class to book a round Trip Flight
     */
    public static roundTrip() {
        System.out.println("----- Departure Information -----");
        System.out.println("\n Enter your Departure Location: ");
        String loc1 = keyboard.nextLine();     //make variable names consistent throughout program
        //TODO Connect to Database and Display Available Results 
        System.out.println("\n Enter your Destination Location: ");
        String loc2 = keyboard.nextLine();     //make variable names consistent throughout program
        //TODO Connect to Database and Display Available Results 

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
        boolean x = true;
        Scanner in = new Scanner(System.in);
        System.out.println("-----Account login-----\nUsername:");
        String username = in.nextLine();
        while(x == true)
        {
        System.out.println("Password:");
        String password = in.nextLine();
        //Connect to database
        // if(password == )
        // {
        //     x = false;
        //     mainMenu();
        // }
        // if(password != )
        // {
        //     System.out.println("Wrong password, try again!");

        // }
    }




    }
    private void mainMenu()
    {
        System.out.println("-----Flytr Main Menu-----\n1. Search for Flights\n2. Search for Hotels\n3. User Account\n4. Settings\n5. Exit\n6. View Bookings\nWhat would you like to do?");
        int choice = 0;
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        switch(choice)
        {
            case 1:
            searchFlights();
            break;
            case 2:
            searchHotels();
            break;
            case 3:
            //
            break;
            case 4:
            //
            break;
            case 5:
            System.out.println("Thank you for choosing Flytr!");
            System.exit(0);
            break;
            case 6:
            //viewBookings();
            break;
            
        }
    }
    private void manageAccount

    
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
