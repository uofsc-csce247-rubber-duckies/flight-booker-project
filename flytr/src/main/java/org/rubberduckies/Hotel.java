package org.rubberduckies;

import java.util.ArrayList;
import java.time.LocalDateTime;
import org.json.simple.JSONObject;

public class Hotel {
    
    private String id;
    private String name;
    private boolean gym;
    private boolean pool;
    private Location location;
    private ArrayList<HotelRoom> rooms;


    /**
     * Initialize hotel from database information
     * @param name hotel name
     * @param location hotel location
     * @param rooms hotel rooms
     * @param gym Does the hotel have a gym
     * @param pool does the hotel have a pool
     */
    public Hotel(String name, Location location, ArrayList<HotelRoom> rooms, boolean gym, boolean pool) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.gym = gym;
        this.pool = pool;
    }

    //TODO add gym and
    public Hotel(JSONObject hotelData, ArrayList<HotelRoom> hotelRooms) {
        this.id = hotelData.get("id").toString();
        this.name = hotelData.get("name").toString();
        this.location = new Location(hotelData.get("location").toString());
        this.rooms = hotelRooms;
        //this.gym = hotelData.get("gym").toString();
        //this.pool = hotelData.get("pool").toString();
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
     * Gets gym availability
     * @return boolean hotel gym
     */
    public boolean getGym() {
        return this.gym;
    }

    /** 
     * Get pool availability
     * @return boolean hotel pool
     */
    public boolean getPool() {
        return this.pool;
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
     * adds unavailable dates to a hotel room when it cannot be booked
     * @param roomNumber hotel room number
     * @param checkIn checkin date
     * @param checkOut checkout date 
     */
    private void bookRoom(String roomNumber, LocalDateTime checkIn, LocalDateTime checkout) {
        //TODO impliment
    }

    
    /** 
     * Makes a hotel room available again
     * @param roomNumber hotel room number
     */
    private void unbookRoom(int roomNumber, LocalDateTime checkIn, LocalDateTime checkout) {
        //TODO: implement
    }
}