package ca.nscc;

public class Main {

    public static void main(String[] args) {

	//Create an elephant object. Note that we pass all 5 values to the Elephant constructor,
	//even though only 2 of the values are defined within that class
    Elephant dumbo = new Elephant("African White",
                        "white",
                        3500,
                        1,
                        7);

		//Elephant inherits from Animal, which is where this method is defined.
        System.out.println(dumbo.makeMySound());
    }
}
