/**
 * @author james-thurlow
 * @author tyler beetle
 */
package org.rubberduckies;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class HotelRoom {
    private int capacity;
    private int number;
    private boolean smoking;
    private ArrayList<LocalDateTime> bookedNights;

    public HotelRoom(){
        this.capacity = 0;
        this.number = 0;
        this.smoking = true;
    }

    public HotelRoom(int capacity, int number){
        this.capacity = capacity;
        this.number = number;
        smoking = true;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setSmoking(boolean smoking){
        this.smoking = smoking;
    }

    public int getCapacity(){
        return capacity;
    }
    
    public int getNumber(){
      return number;      
    }

    public boolean getSmoking(){
        return smoking;
    }

    public boolean isAvailable(){
        return true;
    }

    public void book(LocalDateTime date){
        if(bookedNights.contains(date)){
            System.out.println("The date "+ date.toString() + " is not available to book.");
        }
        else{
            bookedNights.add(date);
        }
    }

    public void unBook(LocalDateTime date){
        
        if(bookedNights.contains(date)){
            bookedNights.remove(date);
        }
        else{
            System.out.println("Warning: The date "+ date.toString() + " was already available.");
        } 
    }
}
