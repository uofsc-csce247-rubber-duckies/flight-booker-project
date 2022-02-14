package com.rubberduckies.flytr;

import java.time.LocalDateTime;

public class Flight extends Booking {

    private final static char AVAILABLE = '_';
    private final static char TAKEN = 'X';

    private String airport;
    private boolean[][] seats;
    private Location from;
    private Location to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean allowsDogs;

    public Flight(String airport, Location from, Location to, boolean[][] seats) {
        super("id", BookingType.FLIGHT);
        this.airport = airport;
        this.from = from;
        this.to = to;
        this.seats = seats;
    }

    public boolean bookSeats(int[][] seats) {
        return true;
    }

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

    public String toString() {
        return "";
    }

    public String getAirport() {
        return airport;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public boolean allowsDogs() {
        return allowsDogs;
    }

    public void allowsDogs(boolean allowsDogs) {
        this.allowsDogs = allowsDogs;
    }

}
