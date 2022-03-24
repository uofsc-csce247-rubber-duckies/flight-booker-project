package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BookingController extends Controller {

    private final String BOOKING_DATABASE = "database/bookings";

    private static BookingController instance;
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;

    //TODO: Do we separate bookings into separate arraylists? they are stored separately in database. might make sense
    // note from alex: probably

    /**
     * Creates booking controller and loads bookings from database
     */
    private BookingController() {
        System.out.println("---------------------------");
        System.out.println("CREATING BOOKING CONTROLLER");
        System.out.println("------------------------");
        System.out.println("---------------------------");
        System.out.println("Creating list of Flights");
        System.out.println("Loading Flights into memory");
        loadBookings();
        System.out.println("Booking Controller Initialized\n");
    }

    public static BookingController getController() {
        if (instance == null) instance = new BookingController();
        return instance;
    }

    /**
     * Loads bookings from database
     * @return bookings
     */
    private void loadBookings() {

        System.out.println("Loading Flights into memory");

        String[] flightFiles = getFilesFromDirectory(BOOKING_DATABASE + "/flights");
        for (String flight : flightFiles) {
            System.out.println("  Flight Found: " + flight);
        }

        System.out.println("Loading Hotels into memory");

        String[] hotelFiles = getFilesFromDirectory(BOOKING_DATABASE + "/hotels");
        for (String hotel : hotelFiles) {
            System.out.println("  Hotel Found: " + hotel);
        }

        this.flights = loadFlights(flightFiles);
        this.hotels = loadHotels(hotelFiles);

    }

    private ArrayList<Flight> loadFlights(String[] flightFiles) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (String flight : flightFiles) {
            flights.add(new Flight(readJson(BOOKING_DATABASE + "/flights/" + flight)));
        }
        return flights;
    }

    private ArrayList<Hotel> loadHotels(String[] hotelFiles) {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        for (String hotel : hotelFiles) {
            JSONObject hotelData = readJson(BOOKING_DATABASE + "/hotels/" + hotel + "/data.json");
            String[] roomFiles = getFilesFromDirectory(BOOKING_DATABASE + "/hotels/" + hotel + "/rooms/");
            ArrayList<HotelRoom> hotelRooms = loadHotelRooms(hotel, roomFiles);
            hotels.add(new Hotel(hotelData, hotelRooms));
        }
        return hotels;
    }

    private ArrayList<HotelRoom> loadHotelRooms(String hotel, String[] roomFiles) {
        ArrayList<HotelRoom> hotelRooms = new ArrayList<HotelRoom>();
        for (String fileName : roomFiles) {
            hotelRooms.add(new HotelRoom(readJson(BOOKING_DATABASE + "/hotels/" + hotel + "/rooms/" + fileName)));
        }
        return hotelRooms;
    }

    /**
     * Parses JSON object
     * @param jsonObject json object to parse
     */
    protected void parse(JSONObject jsonObject) {
        //TODO: implement
        return;
    }

    public Flight getFlightByID(String id) {
        for (Flight flight : flights) {
            if (flight.getId().equals(id)) return flight; 
        }
        return null;
    }

    public Hotel getHotelByID(String id) {
        for (Hotel hotel : hotels) {
            if (hotel.getID().equals(id)) return hotel; 
        }
        return null;
    }

    /**
     * Books a desired booking
     * @param booking booking to book
     * @param user user to book booking for
     * @return Booking Receipt for booking
     */
    public BookingReceipt book(Booking booking, User user) {
        return null;
    }

    /**
     * Books a desired booking
     * @param booking to book
     * @param user to book booking for
     * @param users other users to book for
     * @return Booking Receipt for booking
     */
    public BookingReceipt book(Booking booking, User user, ArrayList<UserData> users) {
        return null;
    }

    /**
     * Search booking for keyword
     * @param search keyword
     * @return bookings results of search
     */

    private void writeJSON() {
        writeFlightJSON();
    }

    private void writeFlightJSON() {

        for (Flight flight : flights) {
            HashMap<String, Object> hashmapFlight = new HashMap<String, Object>();
            hashmapFlight.put("id", flight.getID());
            hashmapFlight.put("airport", flight.getAirport());
            hashmapFlight.put("from", flight.getFrom().toString());
            hashmapFlight.put("to", flight.getTo().toString());
            hashmapFlight.put("departure", flight.getDepartureTime().toString());
            hashmapFlight.put("arrival", flight.getArrivalTime().toString());

            JSONArray seatsArray = new JSONArray();
            for (ArrayList<Boolean> seatRow : flight.getSeats()) {
                JSONArray rowArray = new JSONArray();
                for (Boolean available : seatRow) {
                    rowArray.add(available);
                }
                seatsArray.add(rowArray);
            }
            hashmapFlight.put("seats", seatsArray);
            hashmapFlight.put("allowsDogs", flight.getAllowsDogs());

            JSONObject jsonFlight = new JSONObject(hashmapFlight);
            writeJson(BOOKING_DATABASE + "/flights/" + flight.getID().substring(7) + ".json", jsonFlight);
        }
    }

    public ArrayList<Flight> searchFlight(Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        ArrayList<Flight> results = new ArrayList<Flight>();      
        for (Flight flight : flights) {
            if (!(from == flight.getFrom())) {
                continue; 
            }
            if (!(to == flight.getTo())) {
                continue; 
            }
            if (!(departureTime == flight.getDepartureTime())) {
                continue; 
            }
            if (!(arrivalTime == flight.getArrivalTime())) {
                continue; 
            }
            results.add(flight);
        }
        return results;
    }

}