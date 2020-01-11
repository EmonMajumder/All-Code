import javax.swing.*;
import java.lang.reflect.Array;    //Java Built in library for String array convertion.
import java.text.NumberFormat;      //Java Built in library to Format String.

public abstract class Person {         //Abstract class.

    private String name;
    private String address;
   //

    public Person (){}

    public Person (String name,String address){
        this.name=name;
        this.address=address;
    }

    public String getName(){
        return this.name;
    }           //Getter function

    public String getAddress(){
        return this.address;
    }

    public abstract int getYear();          //Abstract method to get year.
    public abstract String toString();      //Abstract method.
    public abstract float getTotal();       //Abstract method.

    NumberFormat formatter = NumberFormat.getCurrencyInstance();        //Format String (number) a currency.

    public static boolean nameaddressVerify(String NameorAddress){      //Function to check user input validity
                                                                //for name and address. Empty String not acceptable.
        boolean checkString=true;
        String[] nameArray=NameorAddress.split("");
        if (NameorAddress.equals("")) {
            checkString= true;
        }else if (nameArray.length>0){
            for (int k=0;k<nameArray.length;k++){
                if(Array.get(nameArray,k).equals(" ")){
                    checkString= true;
                }
                else{
                    checkString=false;
                    break;
                }
            }
        }
        if(checkString==true){
            JOptionPane.showMessageDialog(null,
                    "No input given.\nPlease Give a valid input",
                    "ERROR!!!", JOptionPane.INFORMATION_MESSAGE);
        }
        return checkString;
    }

    public static boolean intVerify(String YeartoCheck){          //Function to check user input for integer validity.
        try {
            int year = Integer.parseInt(YeartoCheck);
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please input a integer number",
                    "ERROR!!!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
