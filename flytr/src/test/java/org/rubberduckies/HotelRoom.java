/**
 * @author james-thurlow
 */

package test.java.org.rubberduckies;

public class HotelRoom {
    private int capacity;
    private int number;
    private boolean available;

    public HotelRoom(int capacity, int number){
        System.out.println("HotelRoom constructor");     
    }

    public void book(int number){
        System.out.println("HotelRoom.Book");
    }

    public int getCapacity(){
        System.out.println("HotelRoom.getCapacity");
        return null;
    }

    public int getNumber(){
        System.out.println("HotelRoom.getNumber");
        return null;
    }

    public boolean isAvailable(){
        System.out.println("HotelRoom.isAvailable");
        return null;
    }
}
