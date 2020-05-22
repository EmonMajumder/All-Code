public class Cleric extends Player {

    private boolean godFear;

    public Cleric(String name,String description, int hitPoint, int agility,
                  int defense, int baseAttack, String imageLocation,Weapon weapon){
        super(name,description, hitPoint,agility,defense,baseAttack,imageLocation,weapon);
        this.godFear=true;
    }
    public boolean specialfeature(){return this.godFear;}
}
