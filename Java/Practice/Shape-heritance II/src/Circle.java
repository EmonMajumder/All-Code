public class Circle extends Shape{

    private int radius;

    public Circle(String bordercolor, String insidecolor, int radius) {
        super(bordercolor, insidecolor);
        this.radius= radius;
    }

    @Override
    public double getArea () {
        double area = Math.PI*(radius*radius);
        return area;
    }
}
