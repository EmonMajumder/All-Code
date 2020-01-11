package ca.nscc;

//The extends keyword here means "I'm inheriting from Animal"
public class Elephant extends Animal{
    private int numOfTusks;
    private double trunkLength;

	//Elephant constructor, which takes in all 5 values as arguments, sets
	//two of them here in Elephant, and uses super() to pass the other 3
	//to the superclass constructor
    public Elephant(String species,
                    String color,
                    int weight,
                    int numOfTusks,
                    double trunkLength) {

        super(species, color, weight);	//Use super to pass vals to the super's constructor
        this.numOfTusks = numOfTusks;
        this.trunkLength = trunkLength;
    }
}
