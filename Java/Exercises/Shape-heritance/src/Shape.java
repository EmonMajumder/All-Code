public class Shape {
    private String bordercolor;
    private String insidecolor;

    public Shape() {}

    public Shape(String bordercolor, String insidecolor){
        this.bordercolor= bordercolor;
        this.insidecolor=insidecolor;
    }
    public String Borderandinside () {
        return "\nBorder Color: "+bordercolor+"\nInside Color: "+insidecolor;
    }
}
