package org.rubberduckies;

import java.util.ArrayList;
import java.time.LocalDateTime;
import org.json.simple.JSONObject;
import java.util.UUID;

public class Hotel {
    
    private String id;
    private String name;
    private boolean hasGym;
    private boolean hasPool;
    private Location location;
    private ArrayList<HotelRoom> rooms;
    private int rating;


    /**
     * Initialize hotel from database information
     * @param name hotel name
     * @param location hotel location
     * @param rooms hotel rooms
     * @param gym Does the hotel have a gym
     * @param pool does the hotel have a pool
     */

    public Hotel(String name, Location location, ArrayList<HotelRoom> rooms, boolean gym, boolean pool, int rating) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.hasGym = gym;
        this.hasPool = pool;
        this.rating = rating;
    }

    public Hotel(JSONObject hotelData, ArrayList<HotelRoom> hotelRooms) {
        this.id = hotelData.get("id").toString();
        this.name = hotelData.get("name").toString();
        this.location = new Location(hotelData.get("location").toString());
        this.rooms = hotelRooms;
        this.hasGym = (Boolean) hotelData.get("hasGym");
        this.hasPool = (Boolean) hotelData.get("hasPool");
        this.rating = Integer.parseInt(hotelData.get("rating").toString());
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
     * Gets gym availability
     * @return boolean hotel gym
     */
    public boolean getGym() {
        return this.hasGym;
    }

    /** 
     * Get pool availability
     * @return boolean hotel pool
     */
    public boolean getPool() {
        return this.hasPool;
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

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
    /** 
     * adds unavailable dates to a hotel room when it cannot be booked
     * @param roomNumber hotel room number
     * @param checkIn checkin date
     * @param checkOut checkout date 

     */
     * @return if the room was successfully booked
     */
    public boolean bookRoom(String roomNumber, LocalDateTime checkIn, LocalDateTime checkout) {
        for (int i = 0; i < this.rooms.size(); i++) {
            HotelRoom room = this.rooms.get(i);
            if (room.getNumber().equals(roomNumber)) {
                for (LocalDateTime takenDate : room.getTakenDates()) {
                    if (takenDate.getDayOfYear() >= checkIn.getDayOfYear() && takenDate.getDayOfYear() < checkout.getDayOfYear()) {
                        return false;
                    }
                }
                for (LocalDateTime date = checkIn; date.isBefore(checkout); date.plusDays(1)) {
                    room.addTakenDate(date);
                }
                this.rooms.set(i, room);
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Makes a hotel room available again
     * @param roomNumber hotel room number
     */
    public void unbookRoom(String roomNumber, LocalDateTime checkIn, LocalDateTime checkout) {
        for (int i = 0; i < this.rooms.size(); i++) {
            HotelRoom room = this.rooms.get(i);
            if (room.getNumber().equals(roomNumber)) {
                for (LocalDateTime date = checkIn; date.isBefore(checkout); date.plusDays(1)) {
                    if (room.getTakenDates().contains(date)) {
                        room.removeTakenDate(date);
                    }
                }
                this.rooms.set(i, room);
            }
        }
    }
  
}