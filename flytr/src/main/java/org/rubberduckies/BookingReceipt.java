/**
 * @author tyler beetle
 * @author joe comiskey
 */
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingReceipt{
    private Booking booking;
    private User bookedBy;
    private LocalDateTime bookedOn;
    private ArrayList<UserData> users;

    public BookingReceipt(Booking booking, User bookedBy)
    {
        this.booking = booking;
        this.bookedBy = bookedBy;
    }
    public BookingReceipt(Booking booking, User bookedBy, UserData users)
    {
        this.booking = booking;
        this.bookedBy = bookedBy;
        this.users = users;
    }
    public Booking getBooking()
    {
        return booking;
    }
    public User getBookedBy()
    {
        return bookedBy;
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
    public void setBookedBy(User booking)
    {
        this.bookedBy = bookedBy;
    }
    public void setBookedOn(LocalDateTime b)
    {
        this.bookedOn = bookedOn;
    }
    public void setUsers(ArrayList<UserData> b)
    {
        this.users = users;
    }

}
