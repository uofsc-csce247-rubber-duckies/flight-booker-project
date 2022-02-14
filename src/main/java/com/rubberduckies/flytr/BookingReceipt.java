package com.rubberduckies.flytr;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingReceipt {

    private Booking booking;
    private User bookedBy;
    private LocalDateTime bookedOn;
    private ArrayList<UserData> users;

    public BookingReceipt(Booking booking, User user) {
        this.booking = booking;
        bookedBy = user;
        users = new ArrayList<UserData>();
    }

    public BookingReceipt(Booking booking, User user, ArrayList<UserData> users) {
        this.booking = booking;
        bookedBy = user;
        this.users = users;
    }

    public Booking getBooking() {
        return booking;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public ArrayList<UserData> getUsers() {
        return users;
    }

}
