import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(25.50, "IBC32E", Color.BLUE, true);

        System.out.println("My Car "+ myCar.averageMilesPerGallon);
        myCar.changePaintColor(Color.RED);
        System.out.println("My Car "+ myCar.paintColor);
    }
}
