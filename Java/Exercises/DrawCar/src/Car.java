import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Car extends JPanel implements ActionListener {

    private Color bodyColor;
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    Timer t=new Timer (10, this);
    int x=0, velx=10;

    public Car(Color bodyColor, int height, int width, int xPosition, int yPosition){
        this.bodyColor=bodyColor;
        this.height=height;
        this.width=width;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }

    public void drawVehicle(Graphics2D g2d){
        /*int xValues[] = {0,200,0,200};
        int yValues[] = {0,200,200,0};
        GeneralPath path = new GeneralPath();
        path.moveTo(xValues[0],yValues[0]);
        path.lineTo(xValues[1],yValues[1]);
        path.closePath();
        g2d.draw(path);*/
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(this.bodyColor);
        g2d.fillRect(x+this.xPosition,this.yPosition,this.width,this.height-(this.height/2));
        g2d.drawLine(x+40,100,x+50,60);
        g2d.drawLine(x+50,60,x+120,60);
        g2d.drawLine(x+120,60,x+150,100);
        g2d.drawLine(x+90,60,x+90,100);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x+30,125,40,40);
        g2d.fillOval(x+130,125,40,40);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startorstopCar();
            }
        });
    }
    public void paintComponent(Graphics g){
        t.start();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        drawVehicle(g2d);
    }
    public void actionPerformed(ActionEvent e){
        x += velx;
        if (x>1600){
            x=0;
        }
        repaint();
    }
    private void startorstopCar(){
        if (t.isRunning()){
            t.stop();
        }
        else
            t.start();
    }
}
