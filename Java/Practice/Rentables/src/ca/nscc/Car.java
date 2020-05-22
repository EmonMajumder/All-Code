package ca.nscc;

public class Car extends Vehicle implements Insurable, Rentable {

    @Override
    public void makeSound() {
        System.out.println("Cars go Beep Beep!");
    }

    public void doCarStuff() {
        System.out.println("Doin some car stuff.");
    }

    @Override
    public void setInsDuration() {

    }

    @Override
    public void setInsuranceRate() {

    }
    public void setRentalRate(int amount){
        System.out.println("This car can be rented for $"+amount+"/day");
    }
    public void setDuration(int day){
        System.out.println("car was rebted for "+day+" days");
    }
}
