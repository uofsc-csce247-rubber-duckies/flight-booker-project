/**
 * @author james-thurlow
 * @author tyler beetle
 */
package org.rubberduckies;

public class HotelRoom {
    private int capacity;
    private int number;
    private boolean available;

    public HotelRoom(int capacity, int number){
        this.capacity = capacity;
        this.number = number;    
    }

    public void book(int number){
        System.out.println("HotelRoom.Book");
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable(){
        //TODO
        return false; 
    }
}
