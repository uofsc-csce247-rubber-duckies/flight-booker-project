package org.rubberduckies;

import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONObject;

public class Hotel {
    
    private UUID id;
    private String name;
    private Location location;
    private ArrayList<HotelRoom> rooms;


    /**
     * Initialize hotel from database information
     * @param name hotel name
     * @param location hotel location
     * @param rooms hotel rooms
     */
    public Hotel(String name, Location location, ArrayList<HotelRoom> rooms) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }


    public Hotel(JSONObject hotelData, ArrayList<HotelRoom> hotelRooms) {
        this.id = UUID.fromString(hotelData.get("id").toString());
        this.name = hotelData.get("name").toString();
        this.location = new Location(hotelData.get("location").toString());
        this.rooms = hotelRooms;
    }

    public UUID getID() {
        return this.id;
    }

    public void setID(UUID id) {
        this.id = id;
    }


    /** 
     * Get hotel name
     * @return String hotel name
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * Sets hotel name
     * @param name hotel name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Gets hotel location
     * @return Location hotel location
     */
    public Location getLocation() {
        return this.location;
    }

    
    /** 
     * Sets hotel location
     * @param location hotel location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    
    /** 
     * Gets hotel rooms
     * @return ArrayList<HotelRoom> hotel rooms
     */
    public ArrayList<HotelRoom> getRooms() {
        return this.rooms;
    }

    
    /** 
     * Sets hotel rooms
     * @param rooms hotel rooms
     */
    public void setRooms(ArrayList<HotelRoom> rooms) {
        this.rooms = rooms;
    }

    
    /** 
     * Removes a hotel room from available rooms
     * @param roomNumber hotel room number 
     */
    private void bookRoom(int roomNumber) {
        //TODO: implement
    }

    
    /** 
     * Makes a hotel room available again
     * @param roomNumber hotel room number
     */
    private void readdRoom(int roomNumber) {
        //TODO: implement
    }

}
