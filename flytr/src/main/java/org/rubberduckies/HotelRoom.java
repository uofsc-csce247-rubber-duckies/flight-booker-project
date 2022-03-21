package org.rubberduckies;

import java.time.LocalDateTime;
import org.json.simple.JSONObject;

public class HotelRoom {
    private int capacity;
    private String number;
    private boolean available;
    private LocalDateTime[] takenDates;
    //TODO: Make get available check a specific date if is taken

    public HotelRoom(int capacity, String number){
        this.capacity = capacity;
        this.number = number;    
        this.available = true;
        System.out.println("HotelRoom constructor");     

    }

    public HotelRoom(JSONObject room) {
        this.number = (String)room.get("number");
        this.capacity = (Integer)room.get("capacity");
        this.takenDates = (LocalDateTime[])room.get("takenDates");
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
        System.out.println("HotelRoom.setCapacity");
    }

    public void setNumber(String number){
        this.number = number;
        System.out.println("HotelRoom.setNumber");
    }

    public void book(int number){
        available = false;
        System.out.println("HotelRoom.Book");
    }

    public int getCapacity(){
        System.out.println("HotelRoom.getCapacity");
        return capacity;

    }
    public String getNumber(){
      System.out.println("HotelRoom.getNumber");
      return number;      
    }

    public boolean isAvailable(){
        System.out.println("HotelRoom.isAvailable");
        return true;
    }
}
