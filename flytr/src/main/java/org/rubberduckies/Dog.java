/**
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
        System.out.println("Dog Constructor");
    } 

    public void setName(String name){
        this.name = name;
        System.out.println("Dog.setName");
    }

    public void setBreed(String breed){
        this.breed = breed;
        System.out.println("Dog.setBreed");
    }

    public void setWeight(int weight){
        this.weight = weight;
        System.out.println("Dog.setWeight");
    }

    public String getName(){
        System.out.println("Dog.getName");
        return name;
    }

    public String getBreed(){
        System.out.println("Dog.getBreed");
        return breed;
    }   

    public int getWeight(){
        System.out.println("Dog.getWeight");
        return weight;
    }
}
