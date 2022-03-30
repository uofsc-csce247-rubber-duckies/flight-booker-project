package org.rubberduckies;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HotelRoom {
    private int capacity;
    private String number;
    private boolean available;
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

    public void book(LocalDateTime date){
        if(takenDates.contains(date)){
            System.out.println("The date "+ date.toString() + " is not available to book.");
        }
        else{
            takenDates.add(date);
            //TODO: Book receipt
        }
    }

    public void unBook(LocalDateTime date) {
        if(takenDates.contains(date)) {
            takenDates.remove(date);
        }
        else{
            System.out.println("Warning: The date "+ date.toString() + " was already available.");
        } 
    }

    public void addTakenDate(LocalDateTime date) {
        this.takenDates.add(date);
    }

    public void removeTakenDate(LocalDateTime date) {
        this.takenDates.remove(date);
    }
}
