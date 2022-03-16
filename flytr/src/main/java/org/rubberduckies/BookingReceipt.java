@author Joe
import java.time.LocalDateTime;

public class BookingReceipt{
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
    public setBooking(Booking b)
    {
        this.booking = b;
    }
    public setBookedBy(User b)
    {
        this.bookedBy = b;
    }
    public setBookedOn(LocalDateTime b)
    {
        this.bookedOn = b;
    }
    public setUsers(ArrayList<UserData> b)
    {
        this.users = b;
    }

}
