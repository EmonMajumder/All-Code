import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //Declare variables
        int shippingFee = 10;

        //Welcome message
        System.out.println("Welcome to the online world of shopping!");

        //Ask for input from user
        System.out.print("Your total purchase amount: ");
        Scanner sc = new Scanner(System.in);
        double totalPrice = sc.nextDouble();

        //Calculate final bill amount
        if (totalPrice<50) {
            totalPrice += shippingFee ;
            //Display pretax total to user
            System.out.print("Your total is $");
            System.out.print(totalPrice);
            System.out.println(" including shipping charge.");
        }
        else {
            System.out.print("Your total is $");
            System.out.print(totalPrice);
            System.out.println(". You got free shipping.");
        }

    }
}
