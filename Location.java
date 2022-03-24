/**
 * @author james-thurlow
 * @author tyler beetle 
 */

package org.rubberduckies;

public class Location {
    
    private String city;
    private String state;

    public Location(){
        city = "City: None";
        state = "State: None";
    }
    
    public Location(String city, String state){
        city = this.city;
        state = this.state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return this.state;
    }

    public String getLocation(){
        String location = city +", "+ state;
        return location;
    }
    
}