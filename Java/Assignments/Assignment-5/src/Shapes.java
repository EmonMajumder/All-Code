import java.awt.*;

public abstract class Shapes implements Moveobject{
    private int length;
    private int xposition;
    private int yposition;
    private int xspeed;
    private int yspeed;
    private Rectangle boundBox;

    public Shapes(int length,int xposition,int yposition,int xspeed,int yspeed){
        this.length=length;
        this.xposition=xposition;
        this.yposition=yposition;
        this.xspeed=xspeed;
        this.yspeed=yspeed;
    }

    public abstract void drawshape(Graphics g);

    public void moveshape(DrawingPanel dp) {

        this.setXposition(this.getXposition() + this.getXspeed());          //Set new x position for the shape based on speed.
        this.setYposition(this.getYposition() + this.getYspeed());          //Set new y position for the shape based on speed.

        if ((this.getXposition() + this.getLength()) >= dp.getWidth())      //If shape collide with right wall.
        {
            this.setXspeed(this.getXspeed() * -1);                          //Multiply speed by -1 to change direction.
        }
        else if (this.getXposition() < 0)                                   //If shape collide with left wall.
        {
            this.setXspeed(this.getXspeed() * -1);                          //Multiply speed by -1 to change direction.
        }

        if ((this.getYposition() + this.getLength()) >= dp.getHeight())     //If shape collide with bottom wall.
        {
            this.setYspeed(this.getYspeed() * -1);                          //Multiply speed by -1 to change direction.
        }
        else if (this.getYposition() < 0)                                   //If shape collide with top wall.
        {
            this.setYspeed(this.getYspeed() * -1);                          //Multiply speed by -1 to change direction.
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getXposition() {
        return xposition;
    }

    public void setXposition(int xposition) {
        this.xposition = xposition;
    }

    public int getYposition() {
        return yposition;
    }

    public void setYposition(int yposition) {
        this.yposition = yposition;
    }

    public int getXspeed() {
        return xspeed;
    }

    public void setXspeed(int xspeed) {
        this.xspeed = xspeed;
    }

    public int getYspeed() {
        return yspeed;
    }

    public void setYspeed(int yspeed) {
        this.yspeed = yspeed;
    }

    public Rectangle getBoundBox() {
        return boundBox;
    }

    public void setBoundBox(Rectangle boundBox) {
        this.boundBox = boundBox;
    }

    public void setallColor(Color main,Color gradient){}           //Method to set color to shape.

    public void setTexture(TexturePaint tex){}                      //Method to set texture to shape.
}
