public class SeaLion extends Animal{

    private int NumberofSpots;

    public SeaLion(String Name, String Gender, int Weight, GPS GPS, int NumberofSpots){
        super(Name,Gender,Weight,GPS);
        this.NumberofSpots=NumberofSpots;
    }

    public int getNumberofSpots() {
        return NumberofSpots;
    }

    public String toString2(){
        return this.toString()+"Number of Spots: "+this.getNumberofSpots()+
                "\nGPS Position: "+this.getcoordinate().getGPSpoint()+"\n--------------------------------------\n";
    }
}
