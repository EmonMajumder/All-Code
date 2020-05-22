public class Person {
    private String firstName;
    private String lastName;
    private String isInvited;

    public String getisInvited(){
        return isInvited;
    }

    public Person(){}

    public Person(String firstName,String lastName,String isInvited){
        this.firstName=firstName;
        this.lastName=lastName;
        this.isInvited=isInvited;
    }
    public String getFullName(){
        return firstName+" "+lastName;
    }

}
