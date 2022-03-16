/**
 * @author james-thurlow
 */

package test.java.org.rubberduckies;

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
        System.out.println("Location.getCity");
        return city;
    }

    public String getState(){
        System.out.println("Location.getState");
        return state;
    }
    
}
