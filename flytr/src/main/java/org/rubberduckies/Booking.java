package org.rubberduckies;

public abstract class Booking {
    private String id;
    private BookingType type;

    /**
     * An Accessor for the ID 
     * @return Booking UUID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the Booking ID
     * @param id ID to set
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * An Accessor for the type of Booking 
     * @return Booking type
     */
    public BookingType getType() {
        return type;
    }
    
    /**
     * Sets the BookingType member variable
     * @param type the BookingType to set
     */
    public void setType(BookingType type) {
        this.type = type;
    }
}