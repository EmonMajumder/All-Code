import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;

public class Square extends Shapes{

    private TexturePaint texture;

    public Square(int length,int xposition,int yposition,int xspeed,int yspeed){
        super(length,xposition,yposition,xspeed,yspeed);
    }

    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(texture);

        g2d.fillRect(this.getXposition(), this.getYposition(), this.getLength(), this.getLength());
        Rectangle Box =new Rectangle(this.getXposition(),this.getYposition(),this.getLength(),this.getLength());
        this.setBoundBox(Box);
    }

    @Override
    public void setTexture(TexturePaint tex){
        this.texture=tex;
    }
}