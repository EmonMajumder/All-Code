import java.awt.*;

public class Mouseclick {

    private int xposition;
    private int yposition;
    private Color color;
    private int size;

    public Mouseclick(int xposition,int yposition,Color color){
        this.xposition=xposition;
        this.yposition=yposition;
        this.color=color;
        this.size=0;
    }

    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.color);
        g2d.fillOval(xposition-size/2, yposition-size/2, size, size);
    }

    public void setXposition(int xposition) {
        this.xposition = xposition;
    }

    public void setYposition(int yposition) {
        this.yposition = yposition;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
