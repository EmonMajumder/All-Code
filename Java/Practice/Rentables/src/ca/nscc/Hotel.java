package ca.nscc;

public class Hotel extends Building implements Insurable,Rentable{

    public String franchiseName;

    public void orderRoomService() {
        System.out.println("Order breakfast from room service");
    }

    public void requestWakeUpCall() {

        System.out.println("Wake-up call for 5:30 AM, please.");
    }
    public void setRentalRate(int amount){
        System.out.println("This hotel can be rented for $"+amount+"/day");
    }
    public void setDuration(int day){System.out.println("Hotel was rebted for "+day+" days");}
    public void setInsuranceRate(){}
    public void setInsDuration(){}
}
