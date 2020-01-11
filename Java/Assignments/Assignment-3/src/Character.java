public abstract class Character {

    private String name;
    private int hitPoint;
    private int agility;
    private int defense;
    private int baseAttack;
    private String imageLocation;

    public Character(String name, int hitPoint, int agility, int defense, int baseAttack, String imageLocation) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.agility = agility;
        this.defense = defense;
        this.baseAttack = baseAttack;
        this.imageLocation = imageLocation;
    }

    public void setname(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }

    public void setproperty() {
        this.hitPoint = (int)(Math.random()*100+1);
        this.agility = (int)(Math.random()*100+1);
        this.defense = (int)(Math.random()*100+1);
        this.baseAttack = (int)(Math.random()*100+1);
    }
    public int gethitpoint(){ return hitPoint;}
    public int getagility(){
        return agility;
    }
    public int getdefense(){
        return defense;
    }
    public int getbaseAttack(){ return baseAttack; }
    public String getImageLocation (){ return imageLocation; }
}
