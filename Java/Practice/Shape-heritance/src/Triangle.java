public class Triangle extends Shape {
    private int height;
    private int base;

    public Triangle(String bordercolor, String insidecolor, int height, int base) {
        super(bordercolor, insidecolor);
        this.height= height;
        this.base=base;
    }
    public double getArea () {
        double area = (height*base)/2;
        return area;
    }
}