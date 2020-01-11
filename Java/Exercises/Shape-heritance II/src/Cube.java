public class Cube extends Shape{
    private int height;
    private int length;
    private int width;

    public Cube(String bordercolor, String insidecolor, int length, int width, int height) {
        super(bordercolor, insidecolor);
        this.height= height;
        this.length=length;
        this.width=width;
    }

    @Override
    public double getArea () {
        double area = 2*(length*width+length*height+width*height);
        return area;
    }
}