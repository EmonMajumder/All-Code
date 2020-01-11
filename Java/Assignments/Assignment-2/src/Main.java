import javax.swing.*;           //Built in function library for JOptionpane.
import java.util.ArrayList;     //Built in function library to deal with Array and Arraylist.
import java.text.*;             //Built in function library to handle text types.

public class Main {

    public static void main(String[] args) {
        int select=0;
        String name="";
        String address="";
        int year=0;
        String yearSelect;
        boolean ifint;
        boolean isName;
        boolean isAddress;
        boolean moreinput=true;
        double totalIncoming=0;
        double totalOutgoing=0;
        String studentAcntInfo="";
        String staffAcntInfo="";
        Student studentEntry;
        Staff staffEntry;
        ArrayList<Student> studentArraylist =new ArrayList<Student>();
        ArrayList<Staff> staffArraylist =new ArrayList<Staff>();

        while(moreinput) {                 //A while loop for continuous user input as long as user wants to.
            isName=true;
            isAddress=true;
            ifint=false;

            Object[] selection = {"Student", "Staff", "Finish"};  //Option choices at the promt.
            select = JOptionPane.showOptionDialog(null, "Select Student or Staff?",
                    "Accounting Dept.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, selection, selection[2]);     //Ask user for selecting student or staff for data input.

            if (select == 0) {      //When student is selected

                while (isName) {        //Continuously asking for input if input is not valid
                    name = JOptionPane.showInputDialog(null, "Enter Student Name",
                            "Accounting for Student", JOptionPane.QUESTION_MESSAGE);
                    isName = Person.nameaddressVerify(name);     //Check user String input for validation.
                }

                while (isAddress) {     //Continuously asking for input if input is not valid
                    address = JOptionPane.showInputDialog(null, "Enter Student Address",
                            "Accounting for Student", JOptionPane.QUESTION_MESSAGE);
                    isAddress = Person.nameaddressVerify(address);     //Check user String input for validation.
                }

                while (!ifint) {        //Continuously asking for input if input is not valid.
                    yearSelect = JOptionPane.showInputDialog(null, "Enter Student Year(1-4)",
                            "Accounting for Student", JOptionPane.QUESTION_MESSAGE);
                    ifint=Person.intVerify(yearSelect);   //Check user String input for validation.
                    if (ifint){
                        year = Integer.parseInt(yearSelect);       //Convert user input from String to int.
                        if (year < 1 || year > 4) {              //Check user String input for validation.
                        JOptionPane.showMessageDialog(null,
                                "Please input a number within range (1-4)",
                                "ERROR!!!", JOptionPane.INFORMATION_MESSAGE);   //Pop up for invalid input.
                        ifint=false;
                        }
                    }
                }
                studentEntry = new Student(name, address, year);    //Instantaneous student object.
                studentArraylist.add(studentEntry);         //Add the student object to student arraylist.
            }
            else if (select == 1) {         //When staff is selected.

                while (isName) {
                    name = JOptionPane.showInputDialog(null, "Enter Staff Name",
                            "Accounting for Staff", JOptionPane.QUESTION_MESSAGE);
                    isName = Person.nameaddressVerify(name);
                }

                while (isAddress) {
                    address = JOptionPane.showInputDialog(null, "Enter Staff Address",
                            "Accounting for Staff", JOptionPane.QUESTION_MESSAGE);
                    isAddress = Person.nameaddressVerify(address);
                }

                while (!ifint) {
                    yearSelect = JOptionPane.showInputDialog(null,
                            "Enter Staff Year of Service",
                            "Accounting for Staff", JOptionPane.QUESTION_MESSAGE);
                    ifint=Person.intVerify(yearSelect);
                    if(ifint) {
                        year = Integer.parseInt(yearSelect);
                        if (year < 1 || year >= 30) {
                            JOptionPane.showMessageDialog(null,
                                    "Please input a number within range (1-30)",
                                    "ERROR!!!", JOptionPane.INFORMATION_MESSAGE);
                            ifint = false;
                        }
                    }

                }
                staffEntry = new Staff(name, address, year);    //Instantaneous staff object.
                staffArraylist.add(staffEntry);
            }
            else {          //When finish is selected.
                moreinput = false;
            }
        }

        for (int i = 0; i < studentArraylist.size(); i++) {
            studentAcntInfo = studentAcntInfo + (i + 1) + ". " + studentArraylist.get(i).toString();
            totalIncoming = totalIncoming + studentArraylist.get(i).getTotal() / 2;
        }

        for (int j=0;j<staffArraylist.size();j++) {
            staffAcntInfo = staffAcntInfo +(j + 1)+ ". " + staffArraylist.get(j).toString();
            totalOutgoing=totalOutgoing+staffArraylist.get(j).getTotal()/24;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        if (studentArraylist.size()>0 || staffArraylist.size()>0) {
            JOptionPane.showMessageDialog(null, "Students[Total:"
                            + studentArraylist.size() + "]\n" + studentAcntInfo + "\nStaff[Total:"
                            + staffArraylist.size() + "]\n" + staffAcntInfo + "\n\nResults:\nOutgoing: "
                            + formatter.format(totalOutgoing) + "\nIncoming: " + formatter.format(totalIncoming)
                            + "\nTotal: "+ formatter.format(totalIncoming-totalOutgoing),
                    "Final Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
