package ca.nscc;

public class Castle extends Building implements Insurable,Rentable{

    public int numOfTowers;

    public void lowerDrawbridge() {
        System.out.println("Abandon hope, all ye who enter here.");
    }

    public void raiseDrawbridge() {
        System.out.println("Bring out the trebuchets, siege time!");
    }

    public void setRentalRate(int amount){System.out.println("This castle can be rented for $"+amount+"/day");}
    public void setDuration(int day){System.out.println("Castle was rebted for "+day+" days");}
    public void setInsuranceRate(){}
    public void setInsDuration(){}
}
