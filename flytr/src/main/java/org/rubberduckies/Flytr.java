package org.rubberduckies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Flytr {
  
    private Flytr instance;
    private BookingController bookingController;
    private UserController userController;
    public static Scanner keyboard = new Scanner(System.in);

    public Flytr() {
        bookingController = BookingController.getController();
        userController = UserController.getController();
    }

    /** 
     * Gets instance of application
     *
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
        bookingController.writeJSON();
        manageAccount();
        //TODO: run
    }
    
    /** 
     * Search for flight by choosing a type of flight
     * 
     */
    public void searchFlights() {
        System.out.println("----- Search Flights -----");
        System.out.println("Select Flight Type: \n 1. One Way Flight \n 2. Round-Trip Flight");
        int flightType = keyboard.nextInt();
        keyboard.nextLine();
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
        System.out.println("-----Results-----");

        //TODO Connect to Database and Display Available Results

        System.out.println("Enter your departure date(YYYY-MM-DD): ");
        LocalDateTime userDate = convertStringToTime(keyboard.nextLine());

        //TODO store as Date and Time Object and move to controller

        System.out.println("Enter number of Travelers:");
        int travelers = keyboard.nextInt();

        //TODO move to database

        System.out.println("Enter number of Pets:");
        int pets = keyboard.nextInt();

        //TODO move to database 

        System.out.println("-----Flight Options-----");

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
            System.out.println("-----Your Ticket-----");
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
        System.out.println("-----Results-----");

        //TODO Connect to Database and Display Available Results

        System.out.println("Enter your departure date(YYYY-MM-DD): ");
        LocalDateTime userDate = convertStringToTime(keyboard.nextLine()); //TODO read DateTime

        //TODO store as Date and Time Object and move to controller

        System.out.println("Enter your return date(YYYY-MM-DD): ");
        LocalDateTime returnDate = convertStringToTime(keyboard.nextLine()); //TODO read DateTime

        //TODO store as Date and Time Object and move to controller


        System.out.println("Enter number of Travelers:");
        int travelers = keyboard.nextInt();

        //TODO move to database

       // System.out.println("Enter number of Pets:");
        //int pets = keyboard.nextInt();

        //TODO move to database 

        System.out.println("-----Flight Options-----");

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
            System.out.println("-----Your Ticket-----");
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
    public static void searchHotels() {
        
        String city;
        String state;
        String checkIn;
        String checkOut;
        boolean smoking;
        int numOfRooms;
        int numOfOccupants;
        boolean searchAgain = true;
        Location cityResult;
        int userChoice;
        String smokingChoice;

        System.out.println("");
        System.out.println("-----Search Hotels-----");
        
        while(searchAgain == true){
            System.out.println("Please enter your desired destination. \n City:");
            city = keyboard.nextLine();

            System.out.println("State: ");
            state = keyboard.nextLine();
            //TODO Search locations

            System.out.println("Please select a Location: \n`-0: Search Again \n -1: " /* TODO fix this -- + searchResult.getLocation()*/);
            System.out.println("Selected Option: ");
            userChoice = keyboard.nextInt();

            switch(userChoice){
                case 0:
                System.out.println("-----Searching Again-----");
                break;
                case 1:
                searchAgain = false;
                break;
            }
        }

        System.out.println("Enter your Check-In Date (MM/DD): ");        //TODO Check Date Format
        checkIn = keyboard.nextLine();
        System.out.println("Enter your Check-In Date (MM/DD): ");
        checkOut = keyboard.nextLine();
        System.out.println("Enter the number of rooms you wish to book: ");
        numOfRooms = keyboard.nextInt();
        System.out.println("Do you prefer a non smoking room? \n Y/n: ");
         smokingChoice = keyboard.nextLine();
        if(smokingChoice.equalsIgnoreCase("y")){
            smoking = false;
        }
        else if(smokingChoice.equalsIgnoreCase("n")){
            smoking = true;
        }
        else{
            System.out.println("Invalid Choice.");//TODO loop until correct input is given
        }


        //TODO search database
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
        UserController controller = UserController.getController();
        User user = controller.login(username, pw);
        if(user != null)
        {
            System.out.println("Wrong password, try again!");
        }
        else
        {
            d = false;
            mainMenu();
        }
    }
    return true;
        
    }

    private void updateAccountInfo() {
        System.out.println("-----Update Account Information-----");
        System.out.println("1.Change Password\n2.Update Email\n3.Update Phone Number\n4.Update Passport ID\n5.Update Address\n6.Return to Manage Account\nWhat would you like to do?");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice)
        {
            case 1:
            changePassword();
            break;
            case 2:
            updateEmail();
            break;
            case 3:
            updatePhoneNumber();
            break;
            case 4:
            updatePassportID();
            break;
            case 5: 
            updateAddress();
            break;
            case 6:
            manageAccount();
            break;
        }
    }
    /**
     * changes user's password
     */
    private void changePassword()
    {
        System.out.println("-----Change Password-----\nEnter New Password:");
        Scanner in = new Scanner(System.in);
        String newPass = in.nextLine();
        //TODO: update in database to their account
        System.out.println("Password Updated Successfully!");
        updateAccountInfo();
        }


    /**
     * updates user's email address
     */
    private void updateEmail()
    {
        System.out.println("-----Update Email-----\nEnter New Email:");
        Scanner in = new Scanner(System.in);
        String newEmail = in.nextLine();
        //TODO: update in database to their account
        System.out.println("Email updated successfully!");
        updateAccountInfo();
    }

    /**
     * updates user's phone number
     */
    private void updatePhoneNumber()
    {
        System.out.println("-----Update Phone Number-----\nEnter New Phone Number:");
        Scanner in = new Scanner(System.in);
        String newPhoneNumber = in.nextLine();
        //TODO: update in database to their account
        System.out.println("Phone number updated successfully!");
        updateAccountInfo();
    }

    /**
     * updates user's passport ID 
     */
    private void updatePassportID()
    {
        System.out.println("-----Update PassportID-----\nEnter new Passport ID:");
        Scanner in = new Scanner(System.in);
        String newPassportID = in.nextLine();
        //TODO: update in database to their account
        System.out.println("Passport ID updated successfully!");
        updateAccountInfo();
    }

    /**
     * updates user's address
     */
    private void updateAddress()
    {
        System.out.println("-----Update Address-----\nEnter New Address:");
        Scanner in = new Scanner(System.in);
        String newAddress = in.nextLine();
        //TODO: update in database to their account
        System.out.println("Address updated successfully!");
        updateAccountInfo();
    }


    /**
     * Main menu with 6 options 
     */
    private void mainMenu()
    {
        System.out.println("-----Flytr Main Menu-----\n1. Search for Flights\n2. Search for Hotels\n3. User Account\n4. Exit\n5. View Bookings\nWhat would you like to do?");
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
            System.out.println("Thank you for choosing Flytr!");
            System.exit(0);
            break;
            case 5:
            //viewBookings();
            break;
            
        }
    }
    /**
     * User can make changes to their account information
     */
    private void manageAccount()
    {
        System.out.println("-----Welcome to Flytr!-----\n1.Create Account\n2.Login\n3.Update Account Information\n4.Return to Main Menu\nWhat would you like to do?");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice)
        {
            case 1:
            createAccount(); 
            break;
            case 2:
            login();
            break;
            case 3:
            updateAccountInfo();
            break;
            case 4:
            mainMenu();
            break;
        }
    }

  
    /**
     * User can view their bookings
     */
    private void viewBookingHistory()
    {
        //TODO viewbookings
    }
    /** 
     * Checkout user cart
     * @return boolean successful checkout
     */
    private boolean checkout() {
        System.out.println("How many other people are you booking with?");
        Scanner in = new Scanner(System.in);
        int numppl = in.nextInt();
        int i = 0;
        while(i < numppl)
        {
        System.out.println("-----Requesting friend's information-----\nEnter First Name:");
        String firstName = in.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = in.nextLine();
        System.out.println("Enter email:");
        String email = in.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNum = in.nextLine();
        System.out.println("Enter Birthday (MM/DD/YYYY):");
        String birthday = in.nextLine();
        System.out.println("Enter Address:");
        String address = in.nextLine();
        System.out.println("Enter Passport ID:");
        String passportID = in.nextLine();
        
        
        }
        return true;
    }

    
    /** 
     * Cancel booking
     * @return boolean successful booking cancel
     */
    private boolean cancelBooking() {
        return  false;
    }

    /**
     * Converts a formatted date string to a localdatetime object
     * @param formattedDate date YYYY/MM/DD
     * @return local date time object
     */
    private LocalDateTime convertStringToTime(String formattedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        LocalDateTime timeObject = LocalDateTime.parse(formattedDate, formatter);
        return timeObject;
    }

    /**
     * Converts a date into a localdatetime object
     * @param year
     * @param month
     * @param day
     * @return local date time object
     */
    private LocalDateTime convertStringToTime(String year, String month, String day) {
        LocalDateTime timeObject = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), 0, 0, 0);
        return timeObject;
    }

    public static void main(String[] args) {
        Flytr flytr = new Flytr();
        flytr.run();
    }

}
