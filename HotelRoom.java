package org.rubberduckies;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.cglib.core.Local;
import org.json.simple.JSONArray;

public class HotelRoom {
    private int numOfBeds;
    private int number;
    private boolean smoking;
    private ArrayList<LocalDateTime> takenDates;
    //TODO: Make get available check a specific date if is taken

    /** 
     * @param numOfBeds number of beds in the room
     * @param number hotel room identifier
     * @param smoking is smoking allowed
     * @param takenDates list of booked dates. Book method will return false if the user attempts to book this.
    */

    public HotelRoom(int numOfBeds, int number, boolean smoking, ArrayList<LocalDateTime> takenDates){
        this.numOfBeds = numOfBeds;
        this.number = number;
        this.smoking = smoking;
        this.takenDates = takenDates;
    }

    /**
     * @param room the JSON object containing the hotel room data
     */
    //TODO: add smoking to JSON
    public HotelRoom(JSONObject room) {
        this.number = (int)room.get("number");
        this.numOfBeds = ((Long)room.get("capacity")).intValue();
        this.takenDates = convertTakenDates((JSONArray)room.get("takenDates"));
    }

    /**
     * @param times parses JSON file times
     * @return LocalDateTime arraylist with booked dates
     */
    private ArrayList<LocalDateTime> convertTakenDates(JSONArray times) {
        ArrayList<LocalDateTime> timesList = new ArrayList<LocalDateTime>();
        for (Object time : times) {
            timesList.add(LocalDateTime.parse((String)time));
        }
        return timesList;
    }

    /**
     * Sets number of beds
     * @param numOfBeds hotel room beds
     */
    public void setNumOfBeds(int numOfBeds){
        this.numOfBeds = numOfBeds;
    }

    /**
     * Sets hotel room identifier
     * @param number hotel room
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     * Sets if smoking allowed
     * @param smoking hotel room smoking
     */
    public void setSmoking(boolean smoking){
        this.smoking = smoking;
    }

    /**
     * gets number of beds
     * @return boolean number of beds
     */
    public int getNumOfBeds(){
        return numOfBeds;
    }

    /**
     * gets identifier
     * @return int number
     */
    public int getNumber(){
      return number;      
    }

    /**
     * gets if smoking is allowed
     * @return boolean smoking
     */
    public boolean getSmoking(){
        return smoking;
    }

    /**
     * Adds dates in between checking in and checking out (including check in but not check out) to takenDates
     * @param checkIn LocalDateTime checkIn
     * @param checkOut LocalDateTime checkOut
     * @return boolean true/false, to see if the room was available to book.
     */
    public boolean book(LocalDateTime checkIn, LocalDateTime checkOut){
        //TODO improve the logic that checks availability
        if(takenDates.contains(checkIn) || takenDates.contains(checkOut)){
            System.out.println("That room is not available to book.");
            return false;
        }
        else{
            LocalDateTime toAdd = checkIn;      //Temp variable to iterate through days between chackIn and checkOut
            while(checkIn.equals(checkOut) == false){
                takenDates.add(toAdd);
                toAdd = toAdd.plusDays(1);
            }
            //TODO: Book receipt
            return true;
        }
    }

    /**
     * Removes dates in between checking in and checking out (including check in but not check out) to takenDates
     * @param checkIn LocalDateTime checkIn
     * @param checkOut LocalDateTime checkOut
     * @return boolean true/false, to see if the room was successfully unbooked.
     */
    public boolean unBook(LocalDateTime checkIn, LocalDateTime checkOut) {

        LocalDateTime toRemove = checkIn;   //Temp variable to iterate through days while removing them.

        while((toRemove.equals(checkOut) == false) && (takenDates.contains(toRemove))){
            takenDates.remove(checkIn);
            checkIn = checkIn.plusDays(1);
            System.out.println("HotelRoom.unBook");
        }

        if(toRemove == checkIn){
            return true;
        }
        else{        
            System.out.println("Warning: The date "+ checkIn.toString() + " was already available.");
            return false;
        }
    }
}