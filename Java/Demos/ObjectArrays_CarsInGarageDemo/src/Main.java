package ca.nscc;

public class Main {

    public static void main(String[] args) {

        //Create a car
        Car geoffsCar  = new Car("Ford", "Tundra",
                2018, true);

        Car bensCar = new Car("Saturn", "SL2",
                1995, true);

        Car tomsCar = new Car("Lamborghini", "Countache",
                2020, false);

        Car[] geoffsGarage = new Car[3];

        geoffsGarage[0] = geoffsCar;
        geoffsGarage[1] = bensCar;
        geoffsGarage[2] = tomsCar;

        //Show off all my cars
        for (int i = 0; i < geoffsGarage.length; i++) {
            Car todaysCar = geoffsGarage[i];
            String msg = todaysCar.shoutOut();
            System.out.println(msg);
        }

        System.out.println(geoffsCar.make);

    }
}
