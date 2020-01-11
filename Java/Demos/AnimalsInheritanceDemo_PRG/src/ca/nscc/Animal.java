package ca.nscc;

//Animal is our superclass
public class Animal {
    private String species;
    private String color;
    private int weight;

    public Animal() {}	//Default constructor (no params)

    public Animal(String species,String color, int weight) {	//Constructor
        this.species = species;
        this.color = color;
        this.weight = weight;
    }

    public String makeMySound() {	//This method is inherited by all subclasses
        return "I made a sound!!!!";
    }
}
