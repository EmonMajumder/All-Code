public class Wizard extends Player{

    private boolean spellCast;

    public Wizard(String name,String description, int hitPoint, int agility,
                  int defense, int baseAttack, String imageLocation,Weapon weapon){
        super(name,description,hitPoint,agility,defense,baseAttack,imageLocation,weapon);
        this.spellCast=true;
    }
    public boolean specialfeature(){return this.spellCast;}
}
