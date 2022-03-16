/**
 * @author tyler beetle
 * @author james-thurlow
 */

package org.rubberduckies;

public class Dog {

    private String name;
    private String breed;
    private int weight;

    public Dog(String name, String breed, int weight){
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    } 

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
