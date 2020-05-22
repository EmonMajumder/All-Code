public class Salaried extends Employee {

    private int yearsOfService;

    public Salaried(String firstName,String lastName,int yearsOfService){
        super(firstName, lastName);
        this.yearsOfService=yearsOfService;
    }

    @Override
    public double calculateMonthlyPay() {
        double monthlypay=(50000/12)*(1+(0.01*yearsOfService));
        return monthlypay;
    }
}
