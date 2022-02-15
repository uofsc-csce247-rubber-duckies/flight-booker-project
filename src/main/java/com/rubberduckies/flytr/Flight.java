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

    public Flight(String id, String airport, Location from, Location to, boolean[][] seats) {
        super(id, BookingType.FLIGHT);
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

    public String getAirport() {
        return airport;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
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
