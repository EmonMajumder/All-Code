public abstract class Player extends Character{

    private String description;
    private Weapon weapon;

    public Player(String name,String description,int hitPoint, int agility,
                  int defense, int baseAttack, String imageLocation, Weapon weapon){
        super(name,hitPoint,agility,defense,baseAttack,imageLocation);
        this.description=description;
        this.weapon=weapon;
    }

    public String getDescription (){
        return description;
    }
    public Weapon getWeapon(){return weapon;}
    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
    }
    public abstract boolean specialfeature();
}
