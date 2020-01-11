public class Pieceworker extends Employee {

    private int unitsProduced;

    public Pieceworker(String firstName,String lastName,int unitsProduced){
        super(firstName, lastName);
        this.unitsProduced=unitsProduced;
    }

    @Override
    public double calculateMonthlyPay() {
        return unitsProduced;
    }
}
