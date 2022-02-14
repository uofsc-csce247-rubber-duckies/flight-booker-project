package com.rubberduckies.flytr;

public abstract class Booking {

    private String id;
    private BookingType type;

    public Booking(String id, BookingType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public BookingType getType() {
        return type;
    }

}
