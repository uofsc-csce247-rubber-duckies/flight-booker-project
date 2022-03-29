package org.rubberduckies;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HotelRoom {
    private int capacity;
    private String number;
    private boolean smoking;
    private ArrayList<LocalDateTime> takenDates;
    private BedType bedType;
    

    //TODO: Make get available check a specific date if is taken

    public HotelRoom(int capacity, String number, BedType bedType){
        this.capacity = capacity;
        this.number = number;
        this.bedType = bedType;
    }

    //TODO: add smoking to JSON
    public HotelRoom(JSONObject room) {
        this.number = (String)room.get("number");
        this.capacity = ((Long)room.get("capacity")).intValue();
        this.takenDates = convertTakenDates((JSONArray)room.get("takenDates"));
        this.bedType = BedType.valueOf(room.get("bedType").toString());
    }


    private ArrayList<LocalDateTime> convertTakenDates(JSONArray times) {
        ArrayList<LocalDateTime> timesList = new ArrayList<LocalDateTime>();
        for (Object time : times) {
            timesList.add(LocalDateTime.parse((String)time));
        }
        return timesList;
    }


    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setSmoking(boolean smoking){
        this.smoking = smoking;
    }

    public int getCapacity(){
        return capacity;
    }

    public String getNumber(){
      return number;      
    }

    public boolean getSmoking(){
        return smoking;
    }

    public boolean isAvailable(){
        return true;
    }

    public ArrayList<LocalDateTime> getTakenDates() {
        return this.takenDates;
    }

    public void setTakenDates(ArrayList<LocalDateTime> takenDates) {
        this.takenDates = takenDates;
    }

    public BedType getBedType() {
        return this.bedType;
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
