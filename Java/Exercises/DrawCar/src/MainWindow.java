import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

    private JPanel contentPane;
    private Car car;


    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 100, 1500, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        car = new Car(Color.RED,90,200,0,100);
        contentPane.add(car,BorderLayout.NORTH);
    }

}
