package org.rubberduckies;

public class Location {
    
    private String city;
    private String state;

    public Location(){
        city = "City: None";
        state = "State: None";
    }
    
    public Location(String location) {
        String[] split = location.split(", ");
        this.city = split[0];
        this.state = split[1];
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

    public String toString() {
        String location = city +", "+ state;
        return location;
    }

    public boolean equals(Location location) {
        if ((!this.city.equals(location.getCity()))) {
            return false;
        }
        if (!(this.state.equals(location.getState()))) {
            return false;
        }
        return true;
    }
    
}