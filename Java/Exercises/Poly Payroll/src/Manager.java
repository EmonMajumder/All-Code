public class Manager extends Employee {

    private double monthlyBonusAmount;

    public Manager(String firstName,String lastName,double monthlyBonusAmount){
        super(firstName, lastName);
        this.monthlyBonusAmount=monthlyBonusAmount;
    }

    @Override
    public double calculateMonthlyPay() {
        double monthlypay=(100000/12)+monthlyBonusAmount;
        return monthlypay;
    }
}
