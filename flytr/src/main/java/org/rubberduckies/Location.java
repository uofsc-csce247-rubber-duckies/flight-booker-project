/**
 * @author james-thurlow
 */

package org.rubberduckies;

public class Location {
    
    private String city;
    private String state;
    
    public Location(String city, String state){
        city = this.city;
        state = this.state;

        System.out.println("Location Constructor");
    }

    public String getCity(){
        System.out.println("Location.getCity");
        return city;
    }

    public String getState(){
        System.out.println("Location.getState");
        return state;
    }
    
}
