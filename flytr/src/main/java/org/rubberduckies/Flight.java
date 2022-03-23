package org.rubberduckies;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Flight class
 * @author Daniel Gleaves
 */
public class Flight extends Booking {

    private final static char AVAILABLE = '_';
    private final static char TAKEN = 'X';

    private String id;
    private String airport;
    private boolean[][] seats;
    private Location from;
    private Location to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean allowsDogs;

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
    public Flight(String id, String airport, Location from, Location to, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean[][] seats, boolean allowsDogs) {
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
        this.id = flight.get("id").toString();
        this.airport = flight.get("airport").toString();
        this.from = new Location(flight.get("from").toString());
        this.to = new Location(flight.get("to").toString());
        this.departureTime = LocalDateTime.parse(flight.get("departure").toString());
        this.arrivalTime = LocalDateTime.parse(flight.get("arrival").toString());
        this.allowsDogs = (boolean) flight.get("allowsDogs");

        JSONArray seatsJson = (JSONArray)flight.get("seats");
        int seatRows = seatsJson.size();
        if (seatRows <= 0) return;
        int seatCols = ((JSONArray)seatsJson.get(0)).size();
        if (seatCols <= 0) return;
        this.seats = new boolean[seatRows][seatCols];
        for (int i = 0; i < seatsJson.size(); i++) {
            JSONArray rowJson = (JSONArray)seatsJson.get(i);
            for (int j = 0; j < rowJson.size(); j++) {
                this.seats[i][j] = (boolean)rowJson.get(j);
            }
        }

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
        for (boolean[] arr : seats) {
            for (boolean seat : arr) {
                char c = seat ? AVAILABLE : TAKEN;
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    
    /** 
     * Returns UI view of available seats
     * @return String seats display
     */
    public String seatDisplayString() {
        String ret = "";
        for (boolean[] arr : seats) {
            for (boolean seat : arr) {
                char c = seat ? AVAILABLE : TAKEN;
                ret += c + " ";
            }
            ret += "\n\n";
        }
        return ret;
    }

    
    /** 
     * Returns Flight information
     * @return String of flight information
     */
    public String toString() {
        return "id: " + getId() +
               "\nairport: " + airport +
               "\nfrom: " + from.toString() +
               "\nto: " + to.toString() +
               "\ndepartureTime: " + departureTime.toString() +
               "\narribalTime: " + arrivalTime.toString() +
               "\nallowsDogs: " + allowsDogs +
               "\nseats:\n" + seatDisplayString();
    }


    /**
     * Returns the flight id
     * @return String flight id
     */
    public String getID() {
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
}
