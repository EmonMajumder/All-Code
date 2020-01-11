import javax.swing.*;
import java.awt.*;
//This new class is inheriting from JFrame, so it essentially IS a JFrame
public class MyGUIClass extends JFrame {
    //Constructor
    public MyGUIClass (String Title) {//Add a button, show frame
        super (Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620,300);
        setLayout(null);

        JButton leftButton = new JButton("Toggle Left");
        JButton rightButton = new JButton("Toggle Right");
        leftButton.setBounds(50,0,200,50);
        rightButton.setBounds(350,0,200,50);
        add(leftButton);
        add(rightButton);

        JPanel leftpanel = new JPanel(new FlowLayout());
        JPanel rightpanel = new JPanel(new FlowLayout());
        leftpanel.setBounds(0,50,300,250);
        rightpanel.setBounds(300,50,300,250);
        leftpanel.setOpaque(true);
        rightpanel.setOpaque(true);
        leftpanel.setBackground(Color.BLUE);
        rightpanel.setBackground(Color.RED);
        add(leftpanel);
        add(rightpanel);


        JLabel leftLabel =new JLabel();
        JLabel rightLabel =new JLabel();
        leftLabel.setText("This is the Left Panel");
        rightLabel.setText("This is the right Panel");
        leftLabel.setFont(new Font("Verdana",1,20));
        rightLabel.setFont(new Font("Verdana",1,20));
        leftLabel.setForeground(Color.RED);
        rightLabel.setForeground(Color.BLUE);
        leftpanel.add(leftLabel);
        rightpanel.add(rightLabel);

        setVisible(true);
    }
}