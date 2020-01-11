public class Monster extends Character{

    private boolean strengthorspecllcast;

    public Monster(String name, int hitPoint, int agility, int defense, int baseAttack,
                   String imageLocation, boolean strengthorspecllcast){
        super(name,hitPoint,agility,defense,baseAttack,imageLocation);
        this.strengthorspecllcast=strengthorspecllcast;
    }
}
