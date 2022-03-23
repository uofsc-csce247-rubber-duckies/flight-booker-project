package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import org.springframework.util.xml.TransformerUtils;

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
    /**
     * Welcomes the user by calling to mainMenu method
     */
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
    public void oneWay() {
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
        int travelers = keyboard.nextInt();

        //TODO move to database

        System.out.println("Enter number of Pets:");
        int pets = keyboard.nextInt();

        //TODO move to database 

        System.out.println("----- Flight Options -----");

        //TODO return out the flight options

        System.out.println(" Enter your Flight Choice: ");
        int flightDecision = keyboard.nextInt();

        if(travelers == 1) {
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
        int travelers = keyboard.nextInt();

        //TODO move to database

        System.out.println("Enter number of Pets:");
        int pets = keyboard.nextInt();

        //TODO move to database 

        System.out.println("----- Flight Options -----");

        //TODO return out the flight options

        System.out.println(" Enter your Flight Choice: ");
        int flightDecision = keyboard.nextInt();

        if(travelers == 1) {
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
        Scanner in = new Scanner(System.in);
        System.out.println("-----Create Account-----\nEnter First Name:");
        String firstName = in.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = in.nextLine();
        System.out.println("Enter email:");
        String email = in.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNum = in.nextLine();
        System.out.println("Enter Birthday (MM/DD/YYYY):");
        //LocalDateTime birthday = TODO 
        System.out.println("Enter Address:");
        String address = in.nextLine();
        System.out.println("Enter Passport ID:");
        String passportID = in.nextLine();
        boolean x = true;
        while(x)
        {
             System.out.println("Enter Username:");
             String username = in.nextLine();
             //if(username is in database)
             {
                 System.out.println("ERROR: Username already in use, please enter a new username.");
             }
             //else
             {
                x = false;
             } 
        }
        System.out.println("Enter Password:");
        String password = in.nextLine();
        //CREATE USER OBJECT
        boolean y = true;
        while(y)
        {
        System.out.println("Would you like to add a child?(y/n)");
        String choice = in.nextLine();
        if(choice.equalsIgnoreCase("y"))
        {
            System.out.println("-----Adding Child---");
            System.out.println("Enter First Name:");
            String cFirstName = in.nextLine();
            System.out.println("Enter Last Name:");
            String cLastName = in.nextLine();
            System.out.println("Enter Birthday:");
            //LocalDateTime cBirthday = TODO
            System.out.println("Enter PassportID:");
            String cPassportID = in.nextLine();
            System.out.println("Enter Address:");
            String cAddress = in.nextLine();
            //CREATE CHILD OBJECT
            System.out.println("Child added!");
        }
        else
        {
            y = false;
        }
    }
        boolean z = true;
        while(z)
        {
        System.out.println("Would you like to add a dog?(y/n)");
        String choice = in.nextLine();
        if(choice.equalsIgnoreCase("y"))
        {
            System.out.println("-----Adding Dog-----");
            System.out.println("Enter Name:");
            String name = in.nextLine();
            System.out.println("Enter Breed:");
            String breed = in.nextLine();
            System.out.println("Enter Weight:");
            int weight = in.nextInt();
            //CREATE DOG OBJECT
            System.out.println("Dog Added!");
        }
        
        else
        {
            z = false;
        }
    }
        boolean b = true;
        while(b)
        {
        System.out.println("Would you like to link an account?(y/n)");
        String choice2 = in.nextLine();
        if(choice2.equalsIgnoreCase("y"))
        {
        boolean a = true;
        while(a)
        {
            System.out.println("Enter username:");
            String username = in.nextLine();
            System.out.println("Enter password:");
            String pw = in.nextLine();
            /*
            if username doesnt exist
            System.out.println("ERROR: Account with username " + username + " does not exist.\nTry Again?(y/n)");
            else
            System.out.println("Account " + username + " linked successfully!");
            a = false;
            */
        }
        }
        else
        {
            b = false;
        }
        }
        System.out.println("Account Created Successfully!");
        manageAccount();
        return true;
    
    }
    
    
    
    /** 
     * Login user
     * @return boolean successful login
     */
    private boolean login() {
        boolean d = true;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("-----Account login-----\nEnter Username:");
        String username = keyboard.nextLine();
        while(d == true)
        {
        System.out.println("Enter Password:");
        String pw = keyboard.nextLine();
        //TODO Connect to database
        // if(pw == )
        // {
        //     x = false;
        //     mainMenu();
        // }
        // if(pw != )
        // {
        //     System.out.println("Wrong password, try again!");
        
        }
        return true;
    }

    private void bookingHistory() {
        //TODO TYLER
    }

    private void accountInfo() {
        //TODO JOE/TYLER 
    }



    /**
     * Main menu with 6 options 
     */
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
            manageAccount();
            break;
            case 4:
            settings();
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
    /**
     * User can make changes to their account information
     */
    private void manageAccount()
    {
        System.out.println("-----Manage Account-----\n1.Create Account\n2.Login\n3.Booking History\n4.Update Account Information\n5.Return to Main Menu\nWhat would you like to do?");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice)
        {
            case 1:
            createAccount(); //TODO JOE (in progress)
            break;
            case 2:
            login();
            break;
            case 3:
            //booking history - TODO TYLER 
            break;
            case 4:
            //update account information - TODO JOE/TYLER 
            break;
            case 5:
            mainMenu();
            break;
        }
    }

    private void settings()
    {

    }
    /**
     * User can view their bookings
     */
    private void viewBookings()
    {
        //TODO viewbookings
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
