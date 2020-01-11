public class Commissioned extends Employee {

    private double grossSales;

    public Commissioned(String firstName,String lastName,double grossSales){
        super(firstName, lastName);
        this.grossSales=grossSales;
    }

    @Override
    public double calculateMonthlyPay() {
        double monthlypay=2000+(grossSales*0.1);
        return monthlypay;
    }
}
