import java.awt.*;

public class Diamond extends Shapes{

    private Color gradientColor;
    private Color color;

    public Diamond(int length,int xposition,int yposition,int xspeed,int yspeed){
        super(length,xposition,yposition,xspeed,yspeed);
    }
    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(this.getXposition(), this.getYposition(), color,
                this.getXposition() + this.getLength(), this.getYposition() + this.getLength(), gradientColor);

        g2d.setPaint(gradient);

        int[] xPoints={this.getXposition(), this.getXposition()+this.getLength(), this.getXposition()+this.getLength()+this.getLength()/2, this.getXposition()+this.getLength()/2};
        int[] yPoints={this.getYposition(), this.getYposition(), this.getYposition()+this.getLength(), this.getYposition()+this.getLength()};

        g2d.fillPolygon(xPoints, yPoints, 4);
        Rectangle Box =new Rectangle(this.getXposition(),this.getYposition(),this.getLength()+this.getLength()/2,this.getLength());
        this.setBoundBox(Box);
    }

    @Override
    public void moveshape(DrawingPanel dp) {

        this.setXposition(this.getXposition() + this.getXspeed());
        this.setYposition(this.getYposition() + this.getYspeed());

        if ((this.getXposition() + this.getLength()) >= dp.getWidth()) {

            this.setXspeed(this.getXspeed() * -1);
        } else if (this.getXposition() < 0)
        {
            this.setXspeed(this.getXspeed() * -1);
        }

        if ((this.getYposition() + this.getLength()) >= dp.getHeight()) {

            this.setYspeed(this.getYspeed() * -1);
        } else if (this.getYposition() < 0)
        {
            this.setYspeed(this.getYspeed() * -1);
        }
    }

    @Override
    public void setallColor(Color main,Color gradient){
        this.gradientColor=gradient;
        this.color=main;
    }
}