public class GPS implements ILoggable{

    private String GPSpoint;

    public GPS (String GPSpoint){
        this.GPSpoint=GPSpoint;
    }
    public String getGPSpoint(){
        return this.GPSpoint;
    }
    public void writeGPS(){
        System.out.println(GPSpoint);
    }
}
