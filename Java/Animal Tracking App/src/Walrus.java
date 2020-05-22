public class Walrus extends Animal{

    private String Dentalcondition;

    public Walrus(String Name, String Gender, int Weight, GPS GPS, String Dentalcondition){
        super(Name,Gender,Weight,GPS);
        this.Dentalcondition=Dentalcondition;
    }

    public String getDentalcondition() {
        return Dentalcondition;
    }
    public String toString2(){
        return this.toString()+"Dental condition: "+this.getDentalcondition()+
                "\nGPS Position: "+this.getcoordinate().getGPSpoint()+"\n--------------------------------------\n";
    }
}