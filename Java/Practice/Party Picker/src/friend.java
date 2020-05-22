public class friend extends Person{
    private String foodtoBring;

    public String getfood(){
        return foodtoBring;
    }

    public friend() {}

    public friend(String firstName,String lastName,String isInvited,String foodtoBring){
        super(firstName,lastName,isInvited);
        this.foodtoBring=foodtoBring;
    }

    public String toString(){
        return "\n"+getFullName()+" is bringing "+getfood()+"."+" They are "+getisInvited()+" invited to the party.";
    }
}
