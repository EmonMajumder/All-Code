import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mainframe extends JFrame{

    private Dataentry dataentrypage;

    public Mainframe(){
        setTitle("Antarctic Animal Tracking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,700,300);
        dataentrypage=new Dataentry();
        add(dataentrypage);
        Report reportpanel=new Report();
        add(reportpanel);
        setLayout(new CardLayout());
        setVisible(true);
        dataentrypage.setVisible(true);
        reportpanel.setVisible(false);

        JButton viewreport=dataentrypage.getViewreport();
        viewreport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reportpanel.setVisible(true);
                dataentrypage.setVisible(false);
            }
        });
        JButton back=reportpanel.getBack();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reportpanel.setVisible(false);
                dataentrypage.setVisible(true);
                dataentrypage.resetpagedata();
                reportpanel.setFinalReport();
            }
        });
        JButton insshownewentries=reportpanel.getShownewentries();
        insshownewentries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportpanel.setreporttype();
                reportpanel.publishreport(dataentrypage.getAnimals());
            }
        });
    }
    public Dataentry getDataentrypage() {
        return dataentrypage;
    }
}
