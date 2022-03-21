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
     * @return boolean successful search
     */
    private boolean searchHotels() {
        return false;
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
