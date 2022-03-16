/**
 * @author james-thurlow
 */

package test.java.org.rubberduckies;

public class Dog {

    private string name;
    private string age;
    private int weight;

    public Dog(string name, string breed, int weight){
        name = this.name;
        breed = this.breed;
        weight = this.weight;

        System.out.println("Dog Constructor");
    } 

    public int getWeight(){
        System.out.println("Dog.getWeight");
        return weight;
    }
}
