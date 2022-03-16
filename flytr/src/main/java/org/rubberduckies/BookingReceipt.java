package org.rubberduckies;

import java.time.LocalDateTime;

public class BookingReceipt {
    
    private Booking booking;
    private User bookedBy;
    private LocalDateTime bookedOn;
    private ArrayList<UserData> users;

    public BookingReceipt(Booking booking, User user)
    {
        this.booking = booking;
        this.user = user;
    }
    public BookingReceipt(Booking booking, User user, UserData users)
    {
        return BookingReceipt;
    }
    public getBooking()
    {
        return booking;
    }
    public User getBookedBy()
    {
        return this.bookedBy;
    }
    public getBookedOn()
    {
        return bookedOn;
    }
    public getUsers()
    {
        return users; 
    }
    public setBooking(Booking booking)
    {
        this.booking = booking;
    }
    public setBookedBy(User user)
    {
        this.bookedBy = user;
    }
    public setBookedOn(LocalDateTime time)
    {
        this.bookedOn = time;
    }
    public setUsers(ArrayList<UserData> users)
    {
        this.users = users;
    }

}
