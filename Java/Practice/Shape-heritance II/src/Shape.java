public abstract class Shape {
    private String bordercolor;
    private String insidecolor;

    public Shape() {}

    public Shape(String bordercolor, String insidecolor){
        this.bordercolor= bordercolor;
        this.insidecolor=insidecolor;
    }
    public abstract double getArea();

    public String Border(){
        return "with "+bordercolor+" border. ";
    }

    public String Inside(){
        return "I am a "+insidecolor;
    }
}
