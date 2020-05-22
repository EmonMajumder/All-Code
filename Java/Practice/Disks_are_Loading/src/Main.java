import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean isRadiusCorrect = false;
        double circleRadius = 0;
        String circleColor = "";

        /*Check constructor type 1*/
        Circle newCircle = new Circle();
        newCircle.radiusgetter();
        newCircle.colorgetter();
        System.out.println("Total area of the circle is "+newCircle.getArea());
        System.out.println(newCircle.toStrings());


        /*Check constructor type 2*/
        Scanner sc = new Scanner(System.in);
        do {
            isRadiusCorrect = false;
            System.out.println("\nRadius of the circle : ");
            try {
                circleRadius = sc.nextDouble();
                if (circleRadius>=0){
                    isRadiusCorrect = true;
                }
                else{
                    System.out.println("Number error");
                }
            }
            catch(Exception e){
                System.out.println("Data error");
            }
        }while(isRadiusCorrect == false);
        newCircle = new Circle(circleRadius);
        newCircle.radiusgetter();
        newCircle.colorgetter();
        System.out.println("Total area of the circle is "+newCircle.getArea());
        System.out.println(newCircle.toStrings());


        do {
            isRadiusCorrect = false;
            System.out.println("\nRadius of the circle : ");
            try {
                circleRadius = sc.nextDouble();
                if (circleRadius>=0){
                    isRadiusCorrect = true;
                }
                else{
                    System.out.println("Number error");
                }
            }
            catch(Exception e){
                System.out.println("Data error");
            }
        }while(isRadiusCorrect == false);
        System.out.println("Color of the circle : ");
        circleColor = sc.next();
        newCircle = new Circle(circleRadius,circleColor);
        newCircle.radiusgetter();
        newCircle.colorgetter();
        System.out.println("Total area of the circle is "+newCircle.getArea());
        System.out.println(newCircle.toStrings());

    }
}