import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Declare an un initialized array
        char[] gradeLetters = {'A','B','C','D','F'};
        int[] gradePoint = {4,3,2,1,0};

        //Welcome message
        System.out.println("Welcome to grade point finder.");

        //Ask for user input
        System.out.print("Enter the Grade Letter: ");
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        for(int i=0;i<gradeLetters.length;i++){
            if (gradeLetters[i]==letter){
                System.out.println("Your Grade point is "+ gradePoint[i]);
                break;
            }
        }
    }
}