import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class Animal extends SuperAnimal implements CommonData, ILoggable{

    private String Gender;
    private int Weight;
    private GPS GPS;

    public Animal (String Name, String Gender, int Weight, GPS GPS){
        super(Name);
        this.Gender=Gender;
        this.Weight=Weight;
        this.GPS=GPS;
    }
    public String toString(){
        return "Species: "+this.getname()+"\n"+
                "Gender: "+this.getgender()+"\n"+
                "Weight: "+this.getweight()+"\n";}

    public abstract String toString2();
    public String getgender(){
        return this.Gender;
    }
    public int getweight(){
        return this.Weight;
    }
    public GPS getcoordinate(){
        return this.GPS;
    }
    public void writeGPS(){
        try {
            Path filePath = Paths.get("./src/Files/co-ordinates.txt");
            byte[] data = GPS.getGPSpoint().getBytes();
            Files.write(filePath, data, StandardOpenOption.APPEND);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error occoured during writing the file.",
                    "Error!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
