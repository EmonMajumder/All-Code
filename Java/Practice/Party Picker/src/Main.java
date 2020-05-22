import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String Firstname;
        String Lastname;
        String Isinvited;
        int invited;
        String Food;
        int Morecoming=0;
        String output="";


        ArrayList<friend> partypeople = new ArrayList<friend>();
        JOptionPane.showMessageDialog(null,
                "Welcome to Party Picker."+"\n\nYou have to provide following information." +
                        "\n1. First Name\n2.Last Name\n3.If invited\n4.Food he/she brings",
                "Message", JOptionPane.INFORMATION_MESSAGE);

        while(Morecoming==0) {
            Firstname=JOptionPane.showInputDialog(null,"Enter First Name"
            ,"Party Picker",JOptionPane.INFORMATION_MESSAGE);

            Lastname=JOptionPane.showInputDialog(null,"Enter Last Name"
                    ,"Party Picker",JOptionPane.INFORMATION_MESSAGE);

            Object[] invitation = {"Invited","Not Invited"};
            invited=JOptionPane.showOptionDialog(null,"Was he/she invited?",
                    "Party Picker",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null, invitation,invitation[0]);
            if(invited==0){
                Isinvited="";
            }
            else{
                Isinvited="not";
            }

            Food=JOptionPane.showInputDialog(null,"Which food he/she bringing?"
                    ,"Party Picker",JOptionPane.INFORMATION_MESSAGE);

            Morecoming=JOptionPane.showConfirmDialog(null,"More friend coming to the party?",
                    "Party Picker", JOptionPane.YES_NO_OPTION);

            friend friendinParty=new friend(Firstname,Lastname,Isinvited,Food);
            partypeople.add(friendinParty);
        }

        for(int i=0;i<partypeople.size();i++){
            output=output+partypeople.get(i).toString();
        }
        JOptionPane.showMessageDialog(null,"Party Guest List\n"+output,
                "Final list of Guest", JOptionPane.INFORMATION_MESSAGE);
    }
}
