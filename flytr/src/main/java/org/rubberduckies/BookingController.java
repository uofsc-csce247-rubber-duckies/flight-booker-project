package org.rubberduckies;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class BookingController extends Controller {

    private final String BOOKING_DATABASE = "database/bookings";

    private ArrayList<Booking> bookings;

    //TODO: Do we separate bookings into separate arraylists? they are stored separately in database. might make sense

    /**
     * Creates booking controller and loads bookings from database
     */
    public BookingController() {
        System.out.println("CREATING BOOKING CONTROLLER");
        System.out.println("------------------------");
        System.out.println("Creating list of Flights");
        
        System.out.println("Loading Flights into memory");
        loadBookings();
    }

    /**
     * Loads bookings from database
     * @return bookings
     */
    private void loadBookings() {

        String[] flightFiles = getFilesFromDirectory(BOOKING_DATABASE + "/flights");
        for (String flight : flightFiles) {
            System.out.println("  Flight Found: " + flight);
        }

        String[] hotelFiles = getFilesFromDirectory(BOOKING_DATABASE + "/hotels");
        for (String hotel : hotelFiles) {
            System.out.println("  Hotel Found: " + hotel);
        }

        ArrayList<Flight> flights = loadFlights(flightFiles);
        ArrayList<Hotel> hotels = loadHotels(hotelFiles);

    }

    private ArrayList<Flight> loadFlights(String[] flightFiles) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (String flight : flightFiles) {
            flight = BOOKING_DATABASE + "/flights/" + flight;
            flights.add(new Flight(readJson(flight)));
        }
        return flights;
    }

    private ArrayList<Hotel> loadHotels(String[] hotelFiles) {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        for (String hotel : hotelFiles) {
            hotel = BOOKING_DATABASE + "/hotels/" + hotel;
            JSONObject hotelData = readJson(hotel + "/data.json");
            String[] roomFiles = getFilesFromDirectory(hotel + "/rooms");
            ArrayList<HotelRoom> hotelRooms = loadHotelRooms(hotel, roomFiles);
            hotels.add(new Hotel(hotelData, hotelRooms));
        }
        return hotels;
    }

    private ArrayList<HotelRoom> loadHotelRooms(String rootDir, String[] roomFiles) {
        ArrayList<HotelRoom> hotelRooms = new ArrayList<HotelRoom>();
        for (String fileName : roomFiles) {
            fileName = rootDir + "/rooms/" + fileName;
            hotelRooms.add(new HotelRoom(readJson(fileName)));
        }
        return hotelRooms;
    }

    /**
     * Parses JSON object
     * @param jsonObject json object to parse
     */
    protected void parse(ArrayList<JSONObject> jsonObjects) {
        //TODO: implement
        return;
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
    public ArrayList<Booking> search(Search search) {
        return null;
    }


}
