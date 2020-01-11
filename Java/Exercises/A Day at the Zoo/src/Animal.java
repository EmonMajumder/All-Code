public class Animal {

    private String Species;
    private double MaxWeight;
    private String Habitat;
    private Boolean IsEndangered;

    public String Speciesgetter() {return this.Species;}
    public void Speciessetter() {this.Species = Species;}
    public double MaxWeightgetter() {return this.MaxWeight;}
    public void MaxWeightsetter() {this.MaxWeight = MaxWeight;}
    public String habitatgetter() {return this.Habitat;}
    public void habitatsetter() {this.Habitat = Habitat;}
    public Boolean IsEndangeredgetter() {return this.IsEndangered;}
    public void IsEndangeredsetter() {this.IsEndangered = IsEndangered;}



    public String feedme(String feedtype) {
        return "The "+this.Species+" just ate "+feedtype;
    }
    public String Sound(String Sounditmakes) {
        return "It made a "+Sounditmakes+" sound in front of all.\n\n";
    }
    public String report() {
        String stringEndangered = "";
        if (this.IsEndangered== false){
            stringEndangered = "not ";
        }
        return this.Species+":\nI am a "+this.MaxWeight+" lb "+this.Species+" that lives in the "+this.Habitat+". I am "+stringEndangered+"an Enangered species.";
    }



    public Animal() {
        this.Species = "Royal Bengal Tiger";
        this.MaxWeight = 220;
        this.Habitat = "Jungle";
        this.IsEndangered = true;
    }

    public Animal(String Species, double MaxWeight, String Habitat, Boolean IsEndangered){
        this.Species = Species;
        this.MaxWeight = MaxWeight;
        this.Habitat = Habitat;
        this.IsEndangered = IsEndangered;
    }

}

