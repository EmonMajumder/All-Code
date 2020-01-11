package ca.nscc;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Car car=new Car();
        car.setRentalRate(75);
        car.setDuration(7);

        Boat boat=new Boat();
        boat.setRentalRate(90);
        boat.setDuration(3);

        Hotel hotel=new Hotel();
        hotel.setRentalRate(50);
        hotel.setDuration(2);

        Castle castle=new Castle();
        castle.setRentalRate(200);
        castle.setDuration(3);
    }
}
