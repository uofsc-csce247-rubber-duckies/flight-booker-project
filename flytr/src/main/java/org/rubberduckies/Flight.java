package org.rubberduckies;

import java.time.Duration;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Flight class
 * @author Daniel Gleaves
 */
public class Flight extends Booking {

    private final static String[] SEAT_ROWS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG" };
    private final static char AVAILABLE = '_';
    private final static char TAKEN = 'X';

    private UUID id;
    private String airport;
    private ArrayList<ArrayList<Boolean>> seats;
    private Location from;
    private Location to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean allowsDogs;
    private int price;

    /**
     * Creates a new Flight object
     * @param id Flight ID
     * @param airport Flight Departure Airport
     * @param from Departure location
     * @param to Arrival location
     * @param departureTime Departure time
     * @param arrivalTime Arrival time
     * @param seats 2D array of seat booleans for seat availability
     * @param allowsDogs Boolean if flight allows dogs
     */
    public Flight(UUID id, String airport, Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime, ArrayList<ArrayList<Boolean>> seats, boolean allowsDogs) {
        //super(id, BookingType.FLIGHT);
        this.id = id;
        this.airport = airport;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.allowsDogs = allowsDogs;
    }

    public Flight(JSONObject flight) {
        this.id = UUID.fromString(flight.get("id").toString());
        this.airport = flight.get("airport").toString();
        this.from = new Location(flight.get("from").toString());
        this.to = new Location(flight.get("to").toString());
        this.departureTime = LocalDateTime.parse(flight.get("departure").toString());
        this.arrivalTime = LocalDateTime.parse(flight.get("arrival").toString());
        this.seats = convertJSONArraytoBooleanArray((JSONArray)flight.get("seats"));
        this.allowsDogs = (Boolean) flight.get("allowsDogs");
        this.price = Integer.parseInt(flight.get("price").toString());
    }

    private ArrayList<ArrayList<Boolean>> convertJSONArraytoBooleanArray(JSONArray array) {
        ArrayList<ArrayList<Boolean>> seatsArrayList = new ArrayList<ArrayList<Boolean>>();
        for (Object row : array) {
            ArrayList<Boolean> rowArrayList = new ArrayList<Boolean>();
            for (Object value : (JSONArray)row) {
                rowArrayList.add((Boolean)value);
            }
            seatsArrayList.add(rowArrayList);
        }
        return seatsArrayList;
    }

    
    /** 
     * Books the given seats
     * @param seats seats to book
     * @return boolean if seat booked
     */
    public boolean bookSeats(int[][] seats) {
        return true;
    }

    /**
     * Prints UI view of available seats
     * NOTE: For debugging
     */
    public void displaySeats() {
        if (seats.size() <= 0) return;
        System.out.print("   ");
        for (int i = 0; i < seats.get(0).size(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < seats.size(); i++) {
            ArrayList<Boolean> arr = seats.get(i);
            System.out.print(SEAT_ROWS[i] + " ");
            if (SEAT_ROWS[i].length() == 1) System.out.print(" ");
            for (boolean seat : arr) {
                char c = seat ? AVAILABLE : TAKEN;
                System.out.print(c + " ");
            }
            System.out.println("\n");
        }
    }

    
    /** 
     * Returns UI view of available seats
     * @return String seats display
     */
    public String seatDisplayString() {
        String ret = "  " + (seats.size() > 9 ? " " : "");
        int width = 0;
        for (ArrayList<Boolean> arr : seats) {
            width = Math.max(width, arr.size());
        }

        for (int i = 0; i < width; i ++) {
            ret += (char)('A' + i);
            ret += " ";
        }
        ret += "\n";

        int row = 1;
        for (ArrayList<Boolean> arr : seats) {
            ret += row + (row > 9 ? " " : "  ");
            for (boolean seat : arr) {
                char c = seat ? AVAILABLE : TAKEN;
                ret += c + " ";
            }
            ret += "\n";
            row += 1;
        }
        return ret;
    }

    
    /** 
     * Returns Flight information
     * @return String of flight information
     */
    public String toString() {
        return "Airport: " + airport +
               "\nDeparture Location: " + from.toString() +
               "\nArrival Location: " + to.toString() +
               "\nDeparture Time: " + departureTime.toString() +
               "\nArrival Time: " + arrivalTime.toString() +
               "\nDuration: " + getDuration() +
               "\nPrice: $" + this.price;
    }


    /**
     * Returns the flight id
     * @return String flight id
     */
    public UUID getID() {
        return this.id;
    }

    
    /** 
     * Returns the departure airport name
     * @return String departure airport
     */
    public String getAirport() {
        return this.airport;
    }

    
    /** 
     * Sets the departure airport
     * @param airport departure airport
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    
    /** 
     * Gets Departure location
     * @return Location Departure location
     */
    public Location getFrom() {
        return this.from;
    }

    
    /** 
     * Sets Departure location
     * @param from Departure location
     */
    public void setFrom(Location from) {
        this.from = from;
    }

    
    /** 
     * Returns arrival location
     * @return Location arrival location
     */
    public Location getTo() {
        return this.to;
    }

    
    /** 
     * Sets arrival location
     * @param to arrival location
     */
    public void setTo(Location to) {
        this.to = to;
    }

    
    /** 
     * Gets departure time
     * @return LocalDateTime departure time
     */
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    
    /** 
     * Sets departure time
     * @param departureTime departure time
     */
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    
    /** 
     * Gets arrival time
     * @return LocalDateTime arrival time
     */
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    
    /** 
     * Sets arrival time
     * @param arrivalTime arrival time
     */
    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    
    /** 
     * Gets if flight allows dogs
     * @return boolean if flight allows dogs
     */
    public boolean getAllowsDogs() {
        return allowsDogs;
    }

    
    /** 
     * Sets if flight allows dogs
     * @param allowsDogs if flight allows dogss
     */
    public void setAllowsDogs(boolean allowsDogs) {
        this.allowsDogs = allowsDogs;
    }

    public ArrayList<ArrayList<Boolean>> getSeats() {
        return this.seats;
    }

    public String getDuration() {
        Duration duration = Duration.between(this.departureTime, this.arrivalTime);
        return String.format("%02d:%02d", duration.toHoursPart(), duration.toMinutesPart());
    }

    public void bookSeat(int row, int col) {
        ArrayList<Boolean> seatRow = this.seats.get(row);
        seatRow.set(col, true);
        this.seats.set(row, seatRow);
    }

    public int getPrice() {
        return this.price;
    }

}
