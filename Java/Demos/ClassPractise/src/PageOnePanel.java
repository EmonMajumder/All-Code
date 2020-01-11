import javax.swing.*;
import java.awt.*;

public class PageOnePanel extends JPanel{
    public PageOnePanel(){
        ProgramWindowFrame.setCurrentpage(1);

        JLabel welcomeLabel =new JLabel("Welcome to page one!");
        add(welcomeLabel);
        setLayout(null);
        //setBounds(10,10,100,100);
        setVisible(true);
        JButton gotopagetwo=new JButton("Go to page two");
        add(gotopagetwo);
        gotopagetwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                PageTwoPanel.setVisible(true);
            }
        });
    }
}
