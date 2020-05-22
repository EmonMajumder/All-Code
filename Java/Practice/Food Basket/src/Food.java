public class Food {

    //Declaring the properties of the food
    String name;
    String type;

    //Constructor
    public Food(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String eatit() {
        return "I just ate the " + this.name+".";
    }
    public String denyit() {
        return "I am not going to eat that! I hate " + this.type +".";
    }
}