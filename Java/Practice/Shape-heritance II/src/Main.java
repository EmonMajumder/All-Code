import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int objectNumber;
        int totalShape = 0;
        String output = "";
        String[] Colors = {"Red", "Blue", "Green", "Yellow", "Pink", "Brown", "Black", "Lime", "Orange", "Gray"};
        Random randColor = new Random();
        Random randDimension = new Random();
        ArrayList<Circle> circleShape = new ArrayList<Circle>();
        ArrayList<Triangle> triangleShape = new ArrayList<Triangle>();
        ArrayList<Cube> cubeShape = new ArrayList<Cube>();

        objectNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of shape elements",
                "Shape Heritance II", JOptionPane.INFORMATION_MESSAGE));


        for (int i = 0; i < objectNumber; i++) {
            Circle Circle = new Circle(Colors[randColor.nextInt(10)], Colors[randColor.nextInt(10)],
                    randDimension.nextInt(50));
            circleShape.add(Circle);

            Triangle Triangle = new Triangle(Colors[randColor.nextInt(10)], Colors[randColor.nextInt(10)],
                    randDimension.nextInt(50), randDimension.nextInt(50));
            triangleShape.add(Triangle);

            Cube Cube = new Cube(Colors[randColor.nextInt(10)], Colors[randColor.nextInt(10)],
                    randDimension.nextInt(50), randDimension.nextInt(50), randDimension.nextInt(50));
            cubeShape.add(Cube);
        }
        output=output+"\nCircles:";
        for (Circle currentCircle : circleShape) {
            output = output +"\n"+ currentCircle.Inside() + " circle "
                    + currentCircle.Border() + "Total area of the shape: "
                    + currentCircle.getArea();
            totalShape++;
        }
        output=output+"\n\nTriangles:";
        for (Triangle currentTriangle : triangleShape){
            output = output + "\n" + currentTriangle.Inside() + " triangle "
                    + currentTriangle.Border() + "Total area of the shape: "
                    + currentTriangle.getArea();
            totalShape++;
        }
        output=output+"\n\nCubes:";
        for (Cube currentCube : cubeShape){
            output = output + "\n" + currentCube.Inside() + " cube "
                    + currentCube.Border() + "Total area of the shape: "
                    + currentCube.getArea();
            totalShape++;
        }

        JOptionPane.showMessageDialog(null,"List of all Shapes:\n"
                +output+"\n\nTotal number of shape printed on screen: "+totalShape,
                "Shape Heritance II",JOptionPane.INFORMATION_MESSAGE);
    }
}
