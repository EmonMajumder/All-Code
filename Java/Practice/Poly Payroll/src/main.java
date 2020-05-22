import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        ArrayList<Employee> employee=new ArrayList<Employee>();
        Employee commissioned=new Commissioned("Bob","Loblow",40000);
        employee.add(commissioned);
        Employee salaried=new Salaried("Sue","Me",10);
        employee.add(salaried);
        Employee pieceworker=new Pieceworker("Tina","Zena",1000);
        employee.add(pieceworker);
        Employee manager=new Manager("Richard","Rich",2000);
        employee.add(manager);


        for (Employee employee1 : employee) {
            System.out.println("Name\t\t: "+employee1.getFirstName()+" "+employee1.getLastName());
            System.out.println("Pay Type\t: "+employee1.getClass().getSimpleName());
            System.out.println("Monthly Pay\t: $"+employee1.calculateMonthlyPay()+"\n");
        }
    }
}
