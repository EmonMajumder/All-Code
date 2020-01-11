import java.awt.*;

public class Plus extends Shapes{

    private Color color;

    public Plus(int length,int xposition,int yposition,int xspeed,int yspeed){
        super(length,xposition,yposition,xspeed,yspeed);
    }

    public void drawshape(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(this.color);

        int[] xPoints={this.getXposition(), this.getXposition()+this.getLength(), this.getXposition()+this.getLength(),
                this.getXposition()+this.getLength()+this.getLength()/4,this.getXposition()+this.getLength()+this.getLength()/4,
                this.getXposition()+2*this.getLength()+this.getLength()/4,this.getXposition()+2*this.getLength()+this.getLength()/4,
                this.getXposition()+this.getLength()+this.getLength()/4,this.getXposition()+this.getLength()+this.getLength()/4,
                this.getXposition()+this.getLength(),this.getXposition()+this.getLength(),this.getXposition()};

        int[] yPoints={this.getYposition()+this.getLength(),this.getYposition()+this.getLength(),this.getYposition(),
                this.getYposition(),this.getYposition()+this.getLength(),this.getYposition()+this.getLength(),
                this.getYposition()+this.getLength()+this.getLength()/4,this.getYposition()+this.getLength()+this.getLength()/4,
                this.getYposition()+2*this.getLength()+this.getLength()/4,this.getYposition()+2*this.getLength()+this.getLength()/4,
                this.getYposition()+this.getLength()+this.getLength()/4, this.getYposition()+this.getLength()+this.getLength()/4};

        g2d.fillPolygon(xPoints, yPoints, 12);
        Rectangle Box =new Rectangle(this.getXposition(),this.getYposition(),2*this.getLength()+this.getLength()/4,2*this.getLength()+this.getLength()/4);
        this.setBoundBox(Box);
    }

    @Override
    public void moveshape(DrawingPanel dp) {

        this.setXposition(this.getXposition() + this.getXspeed());
        this.setYposition(this.getYposition() + this.getYspeed());

        if ((this.getXposition()+2*this.getLength()+this.getLength()/4) >= dp.getWidth())
        {
            this.setXspeed(this.getXspeed() * -1);
        }
        else if (this.getXposition() < 0)
        {
            this.setXspeed(this.getXspeed() * -1);
        }

        if (this.getYposition()+2*this.getLength()+(this.getLength()/4) >= dp.getHeight())
        {
            this.setYspeed(this.getYspeed() * -1);
        }
        else if (this.getYposition() < 0)
        {
            this.setYspeed(this.getYspeed() * -1);
        }
    }

    @Override
    public void setallColor(Color main,Color gradient){
        this.color=main;
    }
}