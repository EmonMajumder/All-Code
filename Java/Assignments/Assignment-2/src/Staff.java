public class Staff extends Person {

    private int year;
    private int baseSalary=50000;
    private int salaryincrement=500;

    public Staff (){}
    public Staff (String name, String address, int year){
        super(name, address);
        this.year=year;
    }

    @Override
    public int getYear (){
        return this.year;
    }

    public float getTotal(){            //Method to get salary of a staff.
        float salary =baseSalary+salaryincrement*year;
        return salary;
    }

    public String toString(){           //Return a string containing data about a staff.
        return "Name: "+getName()+", Address: "+getAddress()+", Years of Service: "
                +getYear()+", Salary: "+formatter.format(getTotal())+"\n";
    }
}
