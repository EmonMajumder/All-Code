public class Penguin extends Animal {

    private double BloodPressure;

    public Penguin(String Name, String Gender, int Weight, GPS GPS, double BloodPressure){
        super(Name,Gender,Weight,GPS);
        this.BloodPressure=BloodPressure;
    }

    public double getBloodPressure() {
        return BloodPressure;
    }

    public String toString2(){
        return this.toString()+"Blood Pressure: "+this.getBloodPressure()+
                "\nGPS Position: "+this.getcoordinate().getGPSpoint()+"\n--------------------------------------\n";
    }
}
