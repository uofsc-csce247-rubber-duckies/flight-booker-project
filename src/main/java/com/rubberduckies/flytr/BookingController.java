package com.rubberduckies.flytr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.File;

public class BookingController extends Controller {

    private ArrayList<Booking> bookings;

    public BookingController() {
        bookings = new ArrayList<Booking>();
        File file = new File("./database/");
        File[] files = file.listFiles();
        ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for (File f : files) {
            jsonObjects.add(readJson(f.getPath()));
        }
        parse(jsonObjects);
    }

    // TODO TESTING 
    public void displayBookings() {
        for (Booking b : bookings) {
            System.out.println(b.toString());
        }
    }

    public BookingReceipt book(Booking booking, User user) {
        return null;
    }

    public BookingReceipt book(Booking booking, User user, ArrayList<UserData> users) {
        return null;
    }

    public ArrayList<Booking> search(Search search) {
        return null;
    }

    protected void parse(ArrayList<JSONObject> jsonObjects) {
        for (JSONObject json : jsonObjects) {
            String type = json.get("type").toString();
            switch (type) {
                case "FLIGHT":
                    parseFlight(json);
                    break;
                case "HOTEL":
                    parseHotel(json);
                    break;
                default:
                    break;
            }
        }
    }

    private void parseFlight(JSONObject flight) {
        String id = flight.get("id").toString();
        String airport = flight.get("airport").toString();
        Location from = new Location(flight.get("from").toString());
        Location to = new Location(flight.get("to").toString());
        LocalDateTime departureTime = LocalDateTime.parse(flight.get("departureTime").toString());
        LocalDateTime arrivalTime = LocalDateTime.parse(flight.get("arrivalTime").toString());
        boolean allowsDogs = (boolean) flight.get("allowsDogs");

        // converting json seats array to boolean array
        Object[] seatsJson = ((JSONArray) flight.get("seats")).toArray();
        boolean[][] seats = new boolean[seatsJson.length][];
        for (int i = 0; i < seatsJson.length; i++) {
            Object[] rowJson = ((JSONArray) seatsJson[i]).toArray();
            boolean[] tmpRow = new boolean[rowJson.length];
            for (int j = 0; j < rowJson.length; j++) {
                tmpRow[j] = (boolean) rowJson[j];
            }
            seats[i] = tmpRow;
        }

        Flight newFlight = new Flight(id, airport, from, to, seats);
        newFlight.setDepartureTime(departureTime);
        newFlight.setArrivalTime(arrivalTime);
        newFlight.allowsDogs(allowsDogs);
        bookings.add(newFlight);
    }

    private void parseHotel(JSONObject hotel) {}

}
