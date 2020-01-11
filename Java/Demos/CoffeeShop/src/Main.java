import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double priceofcoffee = 1.25;
        double taxrate=1.15;

        System.out.println("Welcome to coffee shop");
        Scanner sc = new Scanner(System.in);
        int numofcups = sc.nextInt();
        double pretaxtotal = priceofcoffee * numofcups;
        System.out.print("your pretax total is $");
        System.out.println(pretaxtotal);
        double finaltotal = pretaxtotal * taxrate;
        System.out.print("your final total is $");
        System.out.println(finaltotal);
    }
}
