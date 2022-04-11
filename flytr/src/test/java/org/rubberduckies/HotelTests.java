package org.rubberduckies;

// import org.rubberduckies.BookingController;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.rubberduckies.flytr.BookingController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class BookingControllerTests {

    // Runs before first test is run
    @BeforeClass
    public static void oneTimeSetup() {
        BookingController.getController();
    }

    // Runs before each test
    @Before
    public static void setup() {
        BookingController controller = BookingController.getController();
        controller.backupDatabase();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
    }

    // Runs after each test
    @After
    public static void tearDown() {
        BookingController controller = BookingController.getController();
        controller.restoreDatabase();
    }

    // Runs after last test
    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Test
    public void testBookRoom_NormalCase() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == true);

    }

    @Test
    public void testBookRoom_Null() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = null;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testBookRoom_InvalidRoomNumber() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 17;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testBookRoom_NegRoomNumber() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = -1;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testUnBookRoom_NormalCase() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == true);
    }

    @Test
    public void testUnBookRoom_Null() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = null;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_RoomNotBooked() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        String wrongRoomNumber = 4;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(wrongRoomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_RoomDoesntExist() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullCheckin() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = null;
        LocalDateTime checkout = "2022-08-23";
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullCheckOut() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = "2022-08-23";
        LocalDateTime checkout = null;
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullDates() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        String roomNumber = 3;
        LocalDateTime checkIn = null;
        LocalDateTime checkout = null;
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unBookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }


}
