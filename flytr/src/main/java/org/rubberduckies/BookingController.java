package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
            if (flight.getID().equals(UUID.fromString(id))) return flight; 
        }
        return null;
    }

    public Hotel getHotelByID(String id) {
        for (Hotel hotel : hotels) {
            if (hotel.getID().equals(UUID.fromString(id))) return hotel; 
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


    public void writeJSON() {
        writeFlightJSON();
        writeHotelJSON();
    }

    private void writeFlightJSON() {
        System.out.println("Writing Flight JSON to Database");
        for (Flight flight : flights) {
            JSONObject jsonFlight = new JSONObject();
            jsonFlight.put("id", flight.getID().toString());
            jsonFlight.put("airport", flight.getAirport());
            jsonFlight.put("from", flight.getFrom().toString());
            jsonFlight.put("to", flight.getTo().toString());
            jsonFlight.put("departure", flight.getDepartureTime().toString());
            jsonFlight.put("arrival", flight.getArrivalTime().toString());

            JSONArray seatsArray = new JSONArray();
            for (ArrayList<Boolean> seatRow : flight.getSeats()) {
                JSONArray rowArray = new JSONArray();
                for (Boolean available : seatRow) {
                    rowArray.add(available);
                }
                seatsArray.add(rowArray);
            }
            jsonFlight.put("seats", seatsArray);
            jsonFlight.put("allowsDogs", flight.getAllowsDogs());

           
            writeJson(BOOKING_DATABASE + "/flights/" + flight.getID() + ".json", jsonFlight);
            System.out.println("Finished writing Flight JSON");
        }
    }

    private void writeHotelJSON() {
        System.out.println("Writing Hotel JSON to Database");
        for (Hotel hotel : hotels) {
            String hotelID = hotel.getID().toString();
            String hotelFolder = BOOKING_DATABASE + "/hotels/" + hotelID;

            JSONObject hotelData = new JSONObject();
            hotelData.put("id", hotelID);
            hotelData.put("name", hotel.getName());
            hotelData.put("location", hotel.getLocation().toString());
            writeJson(hotelFolder + "/data.json", hotelData);

            for (HotelRoom room : hotel.getRooms()) {
                writeHotelRoomJSON(room, hotelFolder + "/rooms/");
            }
        }
        System.out.println("Finished writing Hotel JSON");
        
    }

    private void writeHotelRoomJSON(HotelRoom room, String folder) {
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("number", room.getNumber());
        dataMap.put("capacity", room.getCapacity());
        JSONArray takenDatesArray = new JSONArray();
        for (LocalDateTime date : room.getTakenDates()) {
            takenDatesArray.add(date.toString());
        }
        dataMap.put("takenDates", takenDatesArray);
        dataMap.put("bedType", room.getBedType().toString());
        JSONObject roomData = new JSONObject(dataMap);

        writeJson(folder + room.getNumber() + ".json", roomData);
    }


    public ArrayList<ArrayList<Flight>> searchFlight(Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        ArrayList<ArrayList<Flight>> results = new ArrayList<ArrayList<Flight>>();
        ArrayList<Flight> queue = new ArrayList<Flight>(flights);      
        for (Flight flight : queue) {

            // -------------- Get matching destination end-nodes -----------------
            if (!(to.equals(flight.getTo()))) {
                queue.remove(flight);
                continue; 
            }

            if (arrivalTime.getDayOfYear() != flight.getArrivalTime().getDayOfYear()) {
                queue.remove(flight);
                continue;
            }

            if (departureTime.getDayOfYear() > flight.getDepartureTime().getDayOfYear()) {
                queue.remove(flight);
                continue;
            }

            // ---------------------------------------------------------------------

            // Direct flight match
            if (from.equals(flight.getFrom()) && departureTime.getDayOfYear() == flight.getDepartureTime().getDayOfYear()) {
                ArrayList<Flight> directFlight = new ArrayList<Flight>();
                directFlight.add(flight);
                results.add(directFlight);
                queue.remove(flight);
                continue;
            }

            // Correct departure location but not correct time
            if (from.equals(flight.getFrom()) && departureTime.getDayOfYear() < flight.getDepartureTime().getDayOfYear()) {
                queue.remove(flight);
                continue;
            }

            // Correct departure time but not correct location
            if (!(from.equals(flight.getFrom())) && departureTime.getDayOfYear() == flight.getDepartureTime().getDayOfYear()) {
                queue.remove(flight);
                continue;
            }

        }

        ArrayList<ArrayList<Flight>> transferLists = new ArrayList<ArrayList<Flight>>();
        transferLists = transferSearch(from, to, departureTime, arrivalTime, queue);
        for (ArrayList<Flight> transfer : transferLists) {
            results.add(transfer);
        }
        return results;
    }


    public ArrayList<Hotel> searchHotels(Location location){
        ArrayList<Hotel> results = new ArrayList<Hotel>();

        for(Hotel hotel : hotels)
        {
            if(!(location == hotel.getLocation())) {
                continue; 
            }
            results.add(hotel);
        }
        return results;
    }



    private ArrayList<ArrayList<Flight>> transferSearch(Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime, ArrayList<Flight> endNodes) {
        if (endNodes.size() == 0) {
            return null;
        }
        ArrayList<ArrayList<Flight>> transferPaths = new ArrayList<ArrayList<Flight>>();
        for (Flight endNode : endNodes) {
            ArrayList<Flight> transferLayer = getNextTransferLayer(from, to, departureTime, arrivalTime, endNode);
            ArrayList<Flight> completeNodes = new ArrayList<Flight>();
            for (int i = 0; i < transferLayer.indexOf(null); i++) {
                completeNodes.add(transferLayer.get(i));
            }
            ArrayList<Flight> incompleteNodes = new ArrayList<Flight>();
                for (int i = transferLayer.indexOf(null) + 1; i < transferLayer.size(); i++) {
                    incompleteNodes.add(transferLayer.get(i));
                }
            ArrayList<ArrayList<Flight>> subPaths = transferSearch(from, to, departureTime, arrivalTime, incompleteNodes);

            if (subPaths == null) {
                if (completeNodes.size() == 0) {
                    continue;
                }
                for (Flight completeNode : completeNodes) {
                    ArrayList<Flight> completeList = new ArrayList<Flight>();
                    completeList.add(completeNode);
                    transferPaths.add(completeList);
                }
                continue;
            }
            for (int i = 0; i < subPaths.size(); i++) {
                ArrayList<Flight> subPath = subPaths.get(i);
                for (Flight transferFlight : transferLayer) {
                    if (!(subPath.get(subPath.size() - 1).equals(transferFlight))) {
                        continue;
                    }
                    subPath.add(endNode);
                    subPaths.set(i, subPath);
                }
                transferPaths.add(subPath);
            }
        }
        return transferPaths;
    }

    private ArrayList<Flight> getNextTransferLayer(Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime, Flight node) {
        ArrayList<Flight> transferLayer = new ArrayList<Flight>();
        transferLayer.add(null);
        for (Flight flight : flights) {
            if (completesTransfer(from, departureTime, node, flight)) {
                    transferLayer.add(0, flight);
            }
            else if (isIncompleteTransfer(from, departureTime, node, flight)) {
                transferLayer.add(flight);
            }
        }
        return transferLayer;
    }

    // Vomit -- flight matches to fill tranfer chain
    private boolean completesTransfer(Location from, LocalDateTime departureTime, Flight firstNode, Flight candidate) {
        if (candidate.getFrom().equals(from) && candidate.getDepartureTime().getDayOfYear() == departureTime.getDayOfYear()  
                && candidate.getTo().equals(firstNode.getFrom()) && candidate.getArrivalTime().getDayOfYear() == firstNode.getDepartureTime().getDayOfYear()) {
            return true;
        }
        return false;
    }

    private boolean isIncompleteTransfer(Location from, LocalDateTime departureTime, Flight firstNode, Flight candidate) {
        if (candidate.getDepartureTime().getDayOfYear() > departureTime.getDayOfYear() && candidate.getTo().equals(firstNode.getFrom()) 
                && candidate.getArrivalTime().getDayOfYear() == firstNode.getDepartureTime().getDayOfYear()) {
            return true;
        }
        return false;
    }


    public Booking getBookingByID(String bookingType, String id) {
        BookingType type = BookingType.valueOf(bookingType);
        switch(type) {
            case FLIGHT:
                return getFlightByID(id);
            case HOTEL:
                return getHotelByID(id);
            default:
                return null;
        }
        
    }

}