package org.rubberduckies;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BookingController extends Controller {

    private final String BOOKING_DATABASE = "database/bookings";

    private static BookingController instance;
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;
    private ArrayList<Booking> cart;

    //TODO: Do we separate bookings into separate arraylists? they are stored separately in database. might make sense
    // note from alex: probably

    /**
     * Creates booking controller and loads bookings from database
     */
    private BookingController() {
        this.cart = new ArrayList<Booking>();
        System.out.println("---------------------------");
        System.out.println("INITIALIZING BOOKING CONTROLLER");
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

    public Flight getFlightByID(UUID id) {
        for (Flight flight : flights) {
            if (flight.getID().equals(id)) return flight; 
        }
        return null;
    }

    public Hotel getHotelByID(UUID id) {
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

    public boolean printBookingReceipt(BookingReceipt receipt) {
        Booking receiptBooking = receipt.getBooking();
        User receiptUser = receipt.getBookedBy();
        String receiptText = 
            "Receipt " + receiptBooking.getID() + 
            " for " + receiptUser.getData().getFirstName() + 
            " " + receiptUser.getData().getLastName() +
            "\n";
        receiptText += "Booked On " + receipt.getBookedOn().toString() + "\n\n";
        receiptText += "ID: " + receiptBooking.getID() + "\n";
        receiptText += "Type: " + receiptBooking.getType().toString() + "\n";
        ArrayList<UserData> receiptUsers = receipt.getUsers();
        receiptText += "Number of People: " + receiptUsers.size() + "\n";
        for (UserData receiptUserData : receiptUsers) {
            receiptText += 
                "\t" + receiptUserData.getFirstName() + 
                " " + receiptUserData.getLastName() + 
                "\n";
        }
        receiptText += "\n";
        if (receiptBooking.getType() == BookingType.FLIGHT) {
            Flight receiptFlight = (Flight)receiptBooking;
            receiptText += "Flight Information\n";
            receiptText += "Airport: " + receiptFlight.getAirport() + "\n";
            receiptText += 
                "Departure: " + receiptFlight.getFrom().toString() + 
                " " + receiptFlight.getDepartureTime().toString() +
                "\n";
            receiptText += 
                "Arrival: " + receiptFlight.getTo().toString() + 
                " " + receiptFlight.getArrivalTime().toString() +
                "\n";
        }
        if (receiptBooking.getType() == BookingType.HOTEL) {
            Hotel receiptHotel = (Hotel)receiptBooking;
            receiptText += "Hotel Information\n";
            receiptText += "Hotel: " + receiptHotel.getName() + "\n";
            receiptText += "Location: " + receiptHotel.getLocation().toString() + "\n";
            receiptText += "Rating: " + receiptHotel.getRating() + "\n";
        }
        try {
            FileWriter file = new FileWriter("./receipt_" + receiptBooking.getID() + ".txt");
            file.write(receiptText);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false;
        }
    }


    public void writeJSON() {
        writeFlightJSON();
        writeHotelJSON();
    }

    @SuppressWarnings("unchecked")
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
        ArrayList<Flight> copy_queue = new ArrayList<Flight>(queue);      
        for (Flight flight : copy_queue) {

            // -------------- Get matching destination end-nodes -----------------
            if (!(to.equals(flight.getTo()))) {
                queue.remove(flight);
                continue; 
            }

            if (departureTime.getDayOfYear() > flight.getDepartureTime().getDayOfYear()) {
                queue.remove(flight);
                continue;
            }

            // ---------------------------------------------------------------------

            // Direct flight match
            if (from.equals(flight.getFrom()) && departureTime.getDayOfYear() == flight.getDepartureTime().getDayOfYear() && to.equals(flight.getTo())) {
                ArrayList<Flight> directFlight = new ArrayList<Flight>();
                directFlight.add(flight);
                results.add(directFlight);
                queue.remove(flight);
                continue;
            }

            // // Correct departure location but not correct time
            // if (from.equals(flight.getFrom()) && departureTime.getDayOfYear() < flight.getDepartureTime().getDayOfYear()) {
            //     queue.remove(flight);
            //     continue;
            // }

            // // Correct departure time but not correct location
            // if (!(from.equals(flight.getFrom())) && departureTime.getDayOfYear() == flight.getDepartureTime().getDayOfYear()) {
            //     queue.remove(flight);
            //     continue;
            // }

        }

        for (Flight flight : queue) {
            System.out.println();
            System.out.println("ENDNODE: " + flight);
        }

        System.out.println(":SIZE:" + queue.size());


        ArrayList<ArrayList<Flight>> transferLists = new ArrayList<ArrayList<Flight>>();
        transferLists = transferSearch(from, to, departureTime, arrivalTime, queue);
        for (ArrayList<Flight> transfer : transferLists) {
            results.add(transfer);
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
                ArrayList<Flight> completeList = new ArrayList<Flight>();
                for (Flight completeNode : completeNodes) {
                    completeList.add(completeNode);
                }
                completeList.add(endNode);
                transferPaths.add(completeList);
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
        // System.out.println("SOURCE: " + node);
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
        
        // for (Flight flight : transferLayer) {
        //     System.out.println("FLIGHT: " + flight);
        // }
        return transferLayer;
    }

    // Vomit -- flight matches to fill tranfer chain
    private boolean completesTransfer(Location from, LocalDateTime departureTime, Flight firstNode, Flight candidate) {
        if (candidate.getFrom().equals(from) && candidate.getDepartureTime().getDayOfYear() == departureTime.getDayOfYear()  
                && candidate.getTo().equals(firstNode.getFrom()) && candidate.getArrivalTime().getDayOfYear() == firstNode.getDepartureTime().getDayOfYear()) {
            return true;
        }
        // System.out.println("From: " + candidate.getFrom() + " " + from);
        // System.out.println("To: " + candidate.getTo() + " " + firstNode.getFrom());
        // System.out.println("DEPTIME: " + candidate.getDepartureTime().getDayOfYear() + " " + departureTime.getDayOfYear());
        // System.out.println("ARRIA: " + candidate.getArrivalTime().getDayOfYear() + " " + firstNode.getDepartureTime().getDayOfYear());
        return false;
    }

    private boolean isIncompleteTransfer(Location from, LocalDateTime departureTime, Flight firstNode, Flight candidate) {
        if (candidate.getDepartureTime().getDayOfYear() >= departureTime.getDayOfYear() && candidate.getTo().equals(firstNode.getFrom()) 
                && candidate.getArrivalTime().getDayOfYear() == firstNode.getDepartureTime().getDayOfYear()) {
            // System.out.println("INCOMPLETE: " + candidate);
            return true;
        }
        return false;
    }

    public ArrayList<Hotel> searchHotels(Location location){
        ArrayList<Hotel> results = new ArrayList<Hotel>();

        for(Hotel hotel : hotels){
            if(location.equals(hotel.getLocation())){
                results.add(hotel);
            }
        }

        return results;
    }

    public BookingReceipt bookHotel(User user, ArrayList<UserData> friends, Hotel hotel) {
        Hotel toReplace = getHotelByID(hotel.getID());
        this.hotels.set(this.hotels.indexOf(toReplace), hotel);
        BookingReceipt receipt = new BookingReceipt(hotel, user, LocalDateTime.now(), friends);
        return receipt;
    }

    public Hotel getHotelByID(UUID id) {
        for (Hotel hotel : hotels) {
            if (hotel.getID().equals(id)) return hotel; 
        }
        return null;
    }

    public Booking getBookingByID(String bookingType, UUID id) {
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

    private String getTransferDuration(ArrayList<Flight> transferList) {
        Duration duration = Duration.between(transferList.get(0).getDepartureTime(), transferList.get(transferList.size() - 1).getArrivalTime());
        return String.format("%02d:%02d", duration.toHoursPart(), duration.toMinutesPart());
    }

    public String transferToString(ArrayList<Flight> transferList) {
        String ret = "\nDeparture Location: " + transferList.get(0).getFrom() +
               "\nArrival Location: " + transferList.get(transferList.size()-1).getTo() +
               "\nNumber of Transfers: " + (transferList.size() - 1) + "\nTransfers: ";

        for (Flight flight : transferList) {
            ret += "\n    " + flight.getFrom() + " --> " + flight.getTo();
        }
        ret += "\nDuration: " + getTransferDuration(transferList);
        ret += "\nPrice: $" + getTransferPrice(transferList);
        return ret;
    }

    private int getTransferPrice(ArrayList<Flight> transferList) {
        int sum = 0;
        for (Flight flight : transferList) {
            sum += flight.getPrice();
        }
        return sum / transferList.size();
    }


    public BookingReceipt bookFlight(User user, ArrayList<UserData> friends, Flight flight) {
        Flight toReplace = getFlightByID(flight.getID());
        this.flights.set(this.flights.indexOf(toReplace), flight);
        BookingReceipt receipt = new BookingReceipt(flight, user, LocalDateTime.now(), friends);
        return receipt;
    }

    public void addBookingToCart(Booking booking) {
        this.cart.add(booking);
    }

    public ArrayList<BookingReceipt> checkoutCart(User user, ArrayList<UserData> bookees) {
        ArrayList<BookingReceipt> receipts = new ArrayList<BookingReceipt>(); 
        for (Booking booking : this.cart)
        if (this.flights.contains(booking)) {
            BookingReceipt receipt = new BookingReceipt(booking, user, LocalDateTime.now(), bookees);
            receipts.add(receipt);
        }
        return receipts;
    }

}
