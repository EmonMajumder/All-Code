public class Weapon {

    private int attackModifier;
    private int weight;
    private String description;
    private String imageLocation;
    private String name;

    public Weapon(String name,int attackModifier, int weight,String description, String imageLocation){
        this.attackModifier=attackModifier;
        this.weight=weight;
        this.description=description;
        this.imageLocation=imageLocation;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLocation() {
        return imageLocation;
    }
}
