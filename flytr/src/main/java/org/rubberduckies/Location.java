/**
 * @author james-thurlow
 * @author tyler beetle 
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

    public void setCity(String city){
        this.city = city;
        System.out.println("Location.setCity");
    }

    public void setState(String state){
        this.state = state;System.out.println("Location.setState");
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState(){
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
}
