package org.rubberduckies;

// import org.rubberduckies.BookingController;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class HotelTests {

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
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "003";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T00:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-04T00:00:00");
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == true);

    }

    @Test
    public void testBookRoom_Null() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = null;
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testBookRoom_InvalidRoomNumber() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "17";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testBookRoom_NegRoomNumber() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "-1";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        boolean result = hotel.bookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);

    }

    @Test
    public void testUnBookRoom_NormalCase() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == true);
    }

    @Test
    public void testUnBookRoom_Null() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = null;
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_RoomNotBooked() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        String wrongRoomNumber = "4";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(wrongRoomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_RoomDoesntExist() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullCheckin() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        LocalDateTime checkIn = null;
        LocalDateTime checkOut = LocalDateTime.parse("2022-04-03T14:00:00");
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullCheckOut() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        LocalDateTime checkIn = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime checkOut = null;
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }

    @Test
    public void testUnBookRoom_NullDates() {
        BookingController controller = BookingController.getController();
        UUID id = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(id);
        String roomNumber = "3";
        LocalDateTime checkIn = null;
        LocalDateTime checkOut = null;
        hotel.bookRoom(roomNumber, checkIn, checkOut);
        boolean result = hotel.unbookRoom(roomNumber, checkIn, checkOut);
        assertTrue(result == false);
    }


}
