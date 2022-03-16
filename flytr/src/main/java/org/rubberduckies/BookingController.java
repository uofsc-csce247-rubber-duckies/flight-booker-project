package org.rubberduckies;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class BookingController extends Controller {
    private ArrayList<Booking> bookings;

    /**
     * Creates booking controller and loads bookings from database
     */
    public BookingController() {
        this.bookings = loadBookings();
    }

    /**
     * Loads bookings from database
     * @return bookings
     */
    private ArrayList<Booking> loadBookings() {
        //TODO: Load bookings from JSON
        return null;
    }

    /** 
     * Reads a JSON file
     * @param filename file to read
     * @return JSONObject loaded JSON object
     */
    protected JSONObject readJSON(String filename) {
        System.out.println("UserController.readJSON");
        return null;
    }

    
    /** 
     * Writes the users to the user database
     * @param filename filename to save to
     * @param json JSONObject to save
     * @return boolean if save is success
     */
    protected boolean writeJSON(String filename, JSONObject json) {
        System.out.println("UserController.writeJSON");
        return false;
    }

    /**
     * Parses JSON object
     * @param jsonObject json object to parse
     */
    protected void parse(JSONObject jsonObject) {
        //TODO: implement
        return;
    }

    /**
     * Books a desired booking
     * @param booking booking to book
     * @param user user to book booking for
     * @return Booking Receipt for booking
     */
    public BookingReceipt book(Booking booking, User user) {
        return null;
    }

    /**
     * Books a desired booking
     * @param booking to book
     * @param user to book booking for
     * @param users other users to book for
     * @return Booking Receipt for booking
     */
    public BookingReceipt book(Booking booking, User user, ArrayList<UserData> users) {
        return null;
    }

    /**
     * Search booking for keyword
     * @param search keyword
     * @return bookings results of search
     */
    public ArrayList<Booking> search(Search search) {
        return null;
    }


}
