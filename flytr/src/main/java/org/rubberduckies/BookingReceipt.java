package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingReceipt {
    
    private Booking booking;
    private User bookedBy;
    private LocalDateTime bookedOn;
    private ArrayList<UserData> users;

    public BookingReceipt(Booking booking, User bookedBy, LocalDateTime bookedOn, ArrayList<UserData> users)
    {
        this.booking = booking;
        this.bookedBy = bookedBy;
        this.bookedOn = bookedOn;
        this.users = users;
    }
    public Booking getBooking()
    {
        return booking;
    }
    public User getBookedBy()
    {
        return this.bookedBy;
    }
    public LocalDateTime getBookedOn()
    {
        return bookedOn;
    }
    public ArrayList<UserData> getUsers()
    {
        return users; 
    }
    public void setBooking(Booking booking)
    {
        this.booking = booking;
    }
    public void setBookedBy(User user)
    {
        this.bookedBy = user;
    }
    public void setBookedOn(LocalDateTime time)
    {
        this.bookedOn = time;
    }
    public void setUsers(ArrayList<UserData> users)
    {
        this.users = users;
    }

}
