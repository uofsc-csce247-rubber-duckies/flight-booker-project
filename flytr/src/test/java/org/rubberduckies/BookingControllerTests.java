package org.rubberduckies;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONObject;
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
    public void testBookingControllerNotNull() {
        BookingController controller = BookingController.getController();
        assertNotNull(controller);
    }

    @Test
    public void testFlightsLoaded() {
        BookingController controller = BookingController.getController();
        assertTrue(controller.getFlightsDB().size() > 0);
    }

    @Test
    public void testHotelsLoaded() {
        BookingController controller = BookingController.getController();
        assertTrue(controller.getHotelsDB().size() > 0);
    }

    @Test
    public void testFlightsBackupSize() {
        BookingController controller = BookingController.getController();
        controller.backupDatabase();
        assertTrue(controller.getBackupFlightsDB().size() == controller.getFlightsDB().size());
    }

    @Test
    public void testHotelsBackupSize() {
        BookingController controller = BookingController.getController();
        controller.backupDatabase();
        assertTrue(controller.getBackupHotelDB().size() == controller.getHotelsDB().size());
    }

    @Test
    public void testFlightBackupCorrect() {
        BookingController controller = BookingController.getController();
        ArrayList<Flight> flightDB = controller.getFlightsDB();
        controller.backupDatabase();
        assertTrue(flightDB.get(0) == controller.getBackupFlightsDB().get(0));
    }

    @Test
    public void testHotelBackupCorrect() {
        BookingController controller = BookingController.getController();
        ArrayList<Hotel> hotelDB = controller.getHotelsDB();
        controller.backupDatabase();
        assertTrue(hotelDB.get(0) == controller.getBackupHotelDB().get(0));
    }

    @Test
    public void testFlightIDNotMatching() {
        BookingController controller = BookingController.getController();
        Flight flight = controller.getFlightByID(null);
        assertNull(flight);
    }

    @Test
    public void testFlightIDMatching() {
        BookingController controller = BookingController.getController();
        UUID uuid = UUID.fromString("2b46a852-b08b-11ec-b909-0242ac120002");
        Flight flight = controller.getFlightByID(uuid);
        assertTrue(flight.getID().equals(uuid));
    }

    @Test
    public void testHotelIDMatching() {
        BookingController controller = BookingController.getController();
        UUID uuid = UUID.fromString("b42dbd93-90f5-445e-9f49-bffea3dfbbaa");
        Hotel hotel = controller.getHotelByID(uuid);
        assertTrue(hotel.getID().equals(uuid));
    }

    @Test
    public void testFlightSearchDirect() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 1);
    }

    @Test
    public void testFlightSearchIndirect() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T00:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T22:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        System.out.println(results.size());
        assertTrue(results.size() == 4);
    }

    @Test
    public void testFlightSearchFromInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location from = new Location();
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchFromNull() {
        BookingController controller = BookingController.getController();
        Location from = null;
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchToInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location to = new Location();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchToNull() {
        BookingController controller = BookingController.getController();
        Location to = null;
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchInvalidDepartureTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.now();
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchInvalidArrivalTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.now();
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchDepartureTimeNull() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = null;
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightSearchArrivalTimeNull() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Chicago, IL");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = null;
        ArrayList<ArrayList<Flight>> results = controller.searchFlight(from, to, departure, arrival);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testFlightTransferSearchValid() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<ArrayList<Flight>> results = controller.transferSearch(from, to, departure, arrival, endNodes);
        assertTrue(results.size() == 3);
    }

    @Test
    public void testHotelSearchValid() {
        BookingController controller = BookingController.getController();
        Location location = new Location("Seattle, WA");
        ArrayList<Hotel> results = controller.searchHotels(location);
        assertTrue(results.size() == 4);
    }

    @Test
    public void testFlightTransferSearchFromInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Charlotte, NC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<ArrayList<Flight>> results = controller.transferSearch(from, to, departure, arrival, endNodes);
        assertNull(results);
    }

    @Test
    public void testFlightTransferSearchToInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Cincinatti, OH");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<ArrayList<Flight>> results = controller.transferSearch(from, to, departure, arrival, endNodes);
        assertNull(results);
    }

    @Test
    public void testFlightTransferSearchInvalidDepartureTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-01T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<ArrayList<Flight>> results = controller.transferSearch(from, to, departure, arrival, endNodes);
        assertNull(results);
    }

    @Test
    public void testFlightTransferSearchInvalidArrivalTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-01T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<ArrayList<Flight>> results = controller.transferSearch(from, to, departure, arrival, endNodes);
            assertNull(results);
    }

    @Test
    public void testFlightTransferLayerCompleteMatch() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<Flight> transferLayer = controller.getNextTransferLayer(from, to, departure, arrival, endNodes.get(0));
        assertTrue(transferLayer.indexOf(null) == 1 && transferLayer.size() == 2);
    }

    @Test
    public void testFlightTransferLayerIncompleteMatch() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> endNodes = controller.getTransferEndNodes(from, to, departure, arrival);
        ArrayList<Flight> transferLayer = controller.getNextTransferLayer(from, to, departure, arrival, endNodes.get(1));
        assertTrue(transferLayer.indexOf(null) == 0 && transferLayer.size() == 2);
    }

    @Test
    public void testFlightTransferLayerNoMatch() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        Location to = new Location("Seattle, WA");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        LocalDateTime arrival = LocalDateTime.parse("2022-04-03T14:00:00");
        ArrayList<Flight> transferLayer = controller.getNextTransferLayer(from, to, departure, arrival, controller.getFlightsDB().get(0));
        assertTrue(transferLayer.indexOf(null) == 0 && transferLayer.size() == 1);
    }

    @Test
    public void testFlightCompletesTransferValid() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("3fe1743e-b08d-11ec-b909-0242ac120002"));
        Flight origin = controller.getFlightByID(UUID.fromString("2b46a852-b08b-11ec-b909-0242ac120002"));
        boolean completesTransfer = controller.completesTransfer(from, departure, endNode, origin);
        assertTrue(completesTransfer);
    }

    @Test
    public void testFlightCompletesTransferInvalidSourceNode() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("3fe1743e-b08d-11ec-b909-0242ac120002"));
        Flight origin = controller.getFlightByID(UUID.fromString("f310f77c-fa15-4624-b118-7531476c3051"));
        boolean completesTransfer = controller.completesTransfer(from, departure, endNode, origin);
        assertFalse(completesTransfer);
    }

    @Test
    public void testFlightCompletesTransferFromInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Charlotte, NC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("3fe1743e-b08d-11ec-b909-0242ac120002"));
        Flight origin = controller.getFlightByID(UUID.fromString("2b46a852-b08b-11ec-b909-0242ac120002"));
        boolean completesTransfer = controller.completesTransfer(from, departure, endNode, origin);
        assertFalse(completesTransfer);
    }

    @Test
    public void testFlightCompletesTransferInvalidDepartureTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-01T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("3fe1743e-b08d-11ec-b909-0242ac120002"));
        Flight origin = controller.getFlightByID(UUID.fromString("2b46a852-b08b-11ec-b909-0242ac120002"));
        boolean completesTransfer = controller.completesTransfer(from, departure, endNode, origin);
        assertFalse(completesTransfer);
    }

    @Test
    public void testFlightIncompleteTransferValid() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("a310f77c-fa15-4624-b118-7531476c3051"));
        Flight origin = controller.getFlightByID(UUID.fromString("f310f77c-fa15-4624-b118-7531476c3051"));
        boolean isIncompleteTransfer = controller.isIncompleteTransfer(from, departure, endNode, origin);
        assertTrue(isIncompleteTransfer);
    }

    @Test
    public void testFlightIncompleteTransferCompletesTransfer() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("3fe1743e-b08d-11ec-b909-0242ac120002"));
        Flight origin = controller.getFlightByID(UUID.fromString("2b46a852-b08b-11ec-b909-0242ac120002"));
        boolean isIncompleteTransfer = controller.isIncompleteTransfer(from, departure, endNode, origin);
        assertFalse(isIncompleteTransfer);
    }

    @Test
    public void testFlightIncompleteTransferFromInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Austin, TX");
        LocalDateTime departure = LocalDateTime.parse("2022-04-03T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("a310f77c-fa15-4624-b118-7531476c3051"));
        Flight origin = controller.getFlightByID(UUID.fromString("f310f77c-fa15-4624-b118-7531476c3051"));
        boolean isIncompleteTransfer = controller.isIncompleteTransfer(from, departure, endNode, origin);
        assertFalse(isIncompleteTransfer);
    }

    @Test
    public void testFlightIncompleteTransferInvalidDepartureTime() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-06T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("a310f77c-fa15-4624-b118-7531476c3051"));
        Flight origin = controller.getFlightByID(UUID.fromString("f310f77c-fa15-4624-b118-7531476c3051"));
        boolean isIncompleteTransfer = controller.isIncompleteTransfer(from, departure, endNode, origin);
        assertFalse(isIncompleteTransfer);
    }

    @Test
    public void testFlightIncompleteTransferSameFlight() {
        BookingController controller = BookingController.getController();
        Location from = new Location("Columbia, SC");
        LocalDateTime departure = LocalDateTime.parse("2022-04-06T13:00:00");
        Flight endNode = controller.getFlightByID(UUID.fromString("a310f77c-fa15-4624-b118-7531476c3051"));
        Flight origin = controller.getFlightByID(UUID.fromString("a310f77c-fa15-4624-b118-7531476c3051"));
        boolean isIncompleteTransfer = controller.isIncompleteTransfer(from, departure, endNode, origin);
        assertFalse(isIncompleteTransfer);
    }

    @Test
    public void testHotelSearchFromInvalidLocation() {
        BookingController controller = BookingController.getController();
        Location location = new Location("Orlando, FL");
        ArrayList<Hotel> results = controller.searchHotels(location);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testHotelSearchFromNull() {
        BookingController controller = BookingController.getController();
        Location location = null;
        ArrayList<Hotel> results = controller.searchHotels(location);
        assertTrue(results.size() == 0);
    }

    @Test
    public void testHotelIDNotMatching() {
        BookingController controller = BookingController.getController();
        Hotel hotel = controller.getHotelByID(null);
        assertNull(hotel);
    }
    
}
