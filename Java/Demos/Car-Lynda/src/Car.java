import java.awt.*;

public class Car {
    double averageMilesPerGallon;
    String licensePlate;
    Color paintColor;
    boolean areTailLightWorking;

    public Car(double inputaverageMPG,
              String inputlicensePlate,
              Color inputpaintColor,
              boolean inputareTailLightWorking) {
        this.averageMilesPerGallon = inputaverageMPG;
        this.licensePlate = inputlicensePlate;
        this.paintColor = inputpaintColor;
        this.areTailLightWorking = inputareTailLightWorking;
    }

    public void changePaintColor(Color newPaintColor) {
        this.paintColor= newPaintColor;
    }
}

