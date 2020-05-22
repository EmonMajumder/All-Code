import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;

public class Triangle extends Shapes{

    private TexturePaint texture;

    public Triangle(int length,int xposition,int yposition,int xspeed,int yspeed){
        super(length,xposition,yposition,xspeed,yspeed);
    }

    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(texture);

        int[] xPoints={this.getXposition(), this.getXposition()+this.getLength(), this.getXposition()+this.getLength()/2};
        int[] yPoints={this.getYposition(), this.getYposition(), this.getYposition()+this.getLength()};

        g2d.fillPolygon(xPoints, yPoints,3);
        Rectangle Box =new Rectangle(this.getXposition(),this.getYposition(),this.getLength(),this.getLength());
        this.setBoundBox(Box);
    }

    @Override
    public void setTexture(TexturePaint tex){
        this.texture=tex;
    }
}