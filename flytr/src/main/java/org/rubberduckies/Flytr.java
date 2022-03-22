package org.rubberduckies;

public class Flytr {
  
    private Flytr instance;
    private BookingController bookingController;
    private UserController userController;

    public Flytr() {
        // userController = UserController.createController();
        this.bookingController = new BookingController();
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
        UserController userController = UserController.createController();
    }

    
    /** 
     * Search for flight
     * @return boolean successful search
     */
    private boolean searchFlights() {
        return false;
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

    public static void main(String[] args) {
        Flytr flytr = new Flytr();
        flytr.run();
    }

}
