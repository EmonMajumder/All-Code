public class Student extends Person{

    private int year;
    private int baseTutionfee=3000;
    private int tuttionFeeincrement=100;

    public Student (){}
    public Student (String name, String address, int year){
        super(name, address);           //Call super/parent class for attribute.
        this.year=year;
    }

    @Override
    public int getYear (){
        return this.year;
    }      //Method override.

    public float getTotal() {           //Method to get tution fee of a student.
        float fee =baseTutionfee+tuttionFeeincrement*year;
        return fee;
    }

    public String toString(){           //Return a string containing data about a student.
        return "Name: "+getName()+", Address: "+getAddress()+", Year: "
                +getYear()+", Fee: "+formatter.format(getTotal())+"\n";
    }

}
