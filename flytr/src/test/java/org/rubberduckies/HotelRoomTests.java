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
        HotelRoom room = hotel.getRooms().get(1);
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
    public void testAddTakenDate_NormalCase() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        HotelRoom room = hotel.getRooms().get(1);
        LocalDateTime checkIn = "2022-08-21";
        LocalDateTime checkout = "2022-08-23";
        ArrayList<HotelRoom> result = getTakenDates();
        assertTrue(result.size == 2);
    }

    //Invalid dates means the check in date is after the check out date
    @Test
    public void testAddTakenDate_InvalidDates() {
        BookingController controller = BookingController.getController();
        loadBookings();
        UUID id = "b42dbd93-90f5-445e-9f49-bffea3dfbbaa";
        Hotel hotel = BookingController.getHotelByID(id);
        HotelRoom room = hotel.getRooms().get(1);
        LocalDateTime checkIn = "2022-08-23";
        LocalDateTime checkout = "2022-08-21";
        ArrayList<HotelRoom> result = getTakenDates();
        assertTrue(result.size == 0);
    }

}
