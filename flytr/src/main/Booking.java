package org.rubberduckies;
/**
 * A class that accounts for the Booking type and ID 
 * @author Tyler Beetle 
 */
public class Booking {
    private String id;
    private BookingType type;

/**
 * method that creates an instance of the id and the type 
 * @param id
 * @param type
 */
    public Booking(String id, BookingType type) {
        this.id = id;
        this.type = type;
    }
/**
 * An Accessor for the ID 
 * @return
 */
    public String getId() {
        return id;
    }
/**
 * An Accessor for the type of Booking 
 * @return
 */
    public BookingType getType() {
        return type;
    }
    
}