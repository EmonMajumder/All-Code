public class Circle {
    private double radius;
    private String color;

    public double radiusgetter() {
       return this.radius;
    }

    public String colorgetter() {
        return this.color;
    }

    public double getArea () {
        double area = Math.PI*(radius*radius);
        return area;
    }

    public String toStrings (){
        String printonScreen = "Radius: "+radius+"\nColor: "+color;
        return printonScreen;
    }

    public Circle() {
        this.radius = 2;
        this.color = "Green";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "Yellow";
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }


}
