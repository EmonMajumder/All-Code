package ca.nscc;

public class Boat extends Vehicle implements Insurable,Rentable {

    @Override
    public void makeSound() {
        System.out.println("Boats go splishy splashy!");
    }

    public void doBoatStuff() {
        System.out.println("Doin some boat stuff.");
    }

    public void setRentalRate(int amount){System.out.println("This Boat can be rented for $"+amount+"/day");}
    public void setDuration(int day){System.out.println("Boat was rebted for "+day+" days");}
    public void setInsuranceRate(){}
    public void setInsDuration(){}
}
