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
        this.available = true;
        System.out.println("HotelRoom constructor");     

    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
        System.out.println("HotelRoom.setCapacity");
    }

    public void setNumber(int number){
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
    public int getNumber(){
      System.out.println("HotelRoom.getNumber");
      return number;      
    }

    public boolean isAvailable(){
        System.out.println("HotelRoom.isAvailable");
        return true;
    }
}
