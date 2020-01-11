import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class DrawingPanel extends JPanel {

    private ArrayList<Shapes> shapes = new ArrayList<Shapes>();           //Arraylist to save shapes after they have been created.
    private Timer timer = new Timer(50, new TimerAction());         //Set the timer.
    private Mouseclick click=new Mouseclick(0,0,Color.WHITE);
    private int clicktime;

    public DrawingPanel() {

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int xp = e.getX();
                int yp = e.getY();
                clicktime=0;
                click.setXposition(xp);
                click.setYposition(yp);
                int l=(int)(Math.random()*50+10);
                int xs=(int)(Math.random()*20+0);
                int ys=(int)(Math.random()*20+0);
                int a=(int)(Math.random()*5+1);
                if(a==1){
                    Circle circle = new Circle(l,xp,yp,xs,ys);
                    circle.setallColor(getshapeColor(),getshapeColor());
                    shapes.add(circle);}
                else if(a==2){
                    Triangle triangle=new Triangle(l,xp,yp,xs,ys);
                    triangle.setTexture(getTex());
                    shapes.add(triangle);}
                else if(a==3){
                    Square square=new Square(l,xp,yp,xs,ys);
                    square.setTexture(getTex());
                    shapes.add(square);}
                else if(a==4){
                    Diamond diamond=new Diamond(l,xp,yp,xs,ys);
                    diamond.setallColor(getshapeColor(),getshapeColor());
                    shapes.add(diamond);}
                else if(a==5){
                    Plus plus=new Plus(l,xp,yp,xs,ys);
                    plus.setallColor(getshapeColor(),getshapeColor());
                    shapes.add(plus);}
                timer.start();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shapes shape : shapes) {
            shape.drawshape(g);
        }
        click.drawshape(g);
        checkcollision();
    }

    public void moveTheshape()
    {
        for (Shapes shape : shapes) {
            shape.moveshape(this);
        }
        flashclickpoint();
        DrawingPanel.this.repaint();
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveTheshape();
        }
    }

    private void checkcollision(){
        for (int i=0;i<shapes.size();i++){
            for (int j=i+1;j<shapes.size();j++){
                if(shapes.get(i).getBoundBox().intersects(shapes.get(j).getBoundBox())){
                    shapes.get(i).setYspeed(shapes.get(i).getYspeed()* -1);
                    shapes.get(i).setXspeed(shapes.get(i).getXspeed()* -1);
                    shapes.get(j).setYspeed(shapes.get(j).getYspeed()* -1);
                    shapes.get(j).setXspeed(shapes.get(j).getXspeed()* -1);
                    if(shapes.get(i).getClass().getName()=="Circle" || shapes.get(i).getClass().getName()=="Diamond" || shapes.get(i).getClass().getName()=="Plus"){
                        shapes.get(i).setallColor(getshapeColor(),getshapeColor());
                    }
                    else{shapes.get(i).setTexture(getTex());}
                    if(shapes.get(j).getClass().getName()=="Circle" || shapes.get(j).getClass().getName()=="Diamond" || shapes.get(j).getClass().getName()=="Plus"){
                        shapes.get(j).setallColor(getshapeColor(),getshapeColor());
                    }
                    else{shapes.get(j).setTexture(getTex());}
                    shapes.get(i).setLength((int)(Math.random()*50+10));
                    shapes.get(j).setLength((int)(Math.random()*50+10));
                }
            }
        }
    }
    public Color getshapeColor() {
        int r = (int) (Math.random() * 255 + 1);
        int gr = (int) (Math.random() * 255 + 1);
        int b = (int) (Math.random() * 255 + 1);
        Color col = new Color(r, gr, b);
        return col;
    }

    public TexturePaint getTex() {

        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        BufferedImage image1;
        BufferedImage image2;
        BufferedImage image3;
        BufferedImage image4;
        BufferedImage image5;
        BufferedImage image6;
        try {
            image1 = ImageIO.read(new File("src/image1.jpg"));
            images.add(image1);
            image2 = ImageIO.read(new File("src/image2.jpg"));
            images.add(image2);
            image3 = ImageIO.read(new File("src/image3.jpg"));
            images.add(image3);
            image4 = ImageIO.read(new File("src/image4.jpg"));
            images.add(image4);
            image5 = ImageIO.read(new File("src/image5.jpg"));
            images.add(image5);
            image6 = ImageIO.read(new File("src/image6.jpg"));
            images.add(image6);

        } catch (IOException ex) {

            Logger.getLogger(Square.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        int im = (int) (Math.random() * 5 + 0);
        TexturePaint tex = new TexturePaint(images.get(im), new Rectangle(0, 0, 25, 25));
        return tex;
    }
    public void flashclickpoint(){
        click.setColor(Color.red);
        clicktime=clicktime+1;
        if (clicktime<=3){
            click.setSize(10*clicktime);
        }else
            click.setSize(0);
    }
}
