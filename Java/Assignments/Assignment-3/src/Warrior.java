public class Warrior extends Player{

    private boolean strength;

    public Warrior(String name, String description, int hitPoint, int agility,
                   int defense, int baseAttack, String imageLocation,Weapon weapon){
        super(name,description,hitPoint,agility,defense,baseAttack,imageLocation,weapon);
        this.strength=true;
    }
    public boolean specialfeature(){return this.strength;}
}
