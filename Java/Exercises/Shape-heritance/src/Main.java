public class Main {

    public static void main(String[] args) {
        Circle Circle = new Circle("Black","red",15);
        Triangle Triangle = new Triangle("Green", "Blue",10,15);
        Cube Cube = new Cube("Brown","Yellow",20,10,5);

        System.out.println(Circle.Borderandinside());
        System.out.println("Total area of the shape: "+Circle.getArea());
        System.out.println(Triangle.Borderandinside());
        System.out.println("Total area of the shape: "+Triangle.getArea());
        System.out.println(Cube.Borderandinside());
        System.out.println("Total area of the shape: "+Cube.getArea());
    }
}
