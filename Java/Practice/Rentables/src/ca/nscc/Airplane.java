package ca.nscc;

public class Airplane extends Vehicle implements Insurable{

    public double wingLength;

    @Override
    public void makeSound() {
        System.out.println("Planes go swoosh!!");
    }

    public void doPlaneStuff() {
        System.out.println("Doin some plane stuff.");
    }

    @Override
    public void setInsDuration() {

    }

    @Override
    public void setInsuranceRate() {

    }
}
