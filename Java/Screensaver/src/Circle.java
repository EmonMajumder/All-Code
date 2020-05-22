import java.awt.*;

public class Circle extends Shapes{

    private Color gradientColor;
    private Color color;

    public Circle(int length,int xposition,int yposition,int xspeed,int yspeed){
        super(length,xposition,yposition,xspeed,yspeed);
    }
    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(this.getXposition(), this.getYposition(), color,
                this.getXposition() + this.getLength(), this.getYposition() + this.getLength(), gradientColor);

        g2d.setPaint(gradient);

        g2d.fillOval(this.getXposition(), this.getYposition(), this.getLength(), this.getLength());
        Rectangle Box =new Rectangle(this.getXposition(),this.getYposition(),this.getLength(),this.getLength());
        this.setBoundBox(Box);
    }


    @Override
    public void setallColor(Color main,Color gradient){
        this.gradientColor=gradient;
        this.color=main;
    }
}
