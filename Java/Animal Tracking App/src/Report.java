import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Report extends JPanel {

    private JButton Back;
    private JButton shownewentries;
    private JButton showgpslogs;
    private JTextArea finalReport;
    private JScrollPane scrollPane;
    private JLabel reporttype;

    public Report(){

        setLayout(null);
        JLabel Reports =new JLabel("Reports: ");
        Reports.setBounds(10,10,70,20);
        Reports.setFont(new Font("",1,15));
        add(Reports);

        reporttype=new JLabel("");
        reporttype.setBounds(80,10,250,20);
        reporttype.setFont(new Font("",1,15));
        add(reporttype);

        scrollPane=new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        finalReport =new JTextArea();
        finalReport.setBounds(10,35,660,170);
        finalReport.setFont(new Font("",1,15));
        finalReport.setLineWrap(true);
        finalReport.setBorder(new LineBorder(Color.BLACK));

        scrollPane.setBounds(10,35,660,170);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(finalReport);
        add(scrollPane);

        shownewentries=new JButton("Show New Entries");
        shownewentries.setBounds(85,220,170,30);
        shownewentries.setFont(new Font("",1,15));
        add(shownewentries);

        showgpslogs=new JButton("Show GPS Logs");
        showgpslogs.setBounds(260,220,170,30);
        showgpslogs.setFont(new Font("",1,15));
        add(showgpslogs);

        Back=new JButton("Back");
        Back.setBounds(435,220,170,30);
        Back.setFont(new Font("",1,15));
        add(Back);

        showgpslogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reporttype.setText("All Logged GPS Position To Date");
                try {
                    Path filePath = Paths.get("./src/Files/co-ordinates.txt");
                    String allGPS=new String(Files.readAllBytes(filePath));
                    finalReport.setText(allGPS);
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Error occoured during reading the file.",
                            "Error!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    public void publishreport(ArrayList<Animal> animalarraylist){
        finalReport.setText("");
        for (Animal animal : animalarraylist) {
            finalReport.append(animal.toString2());
            }
    }

    public JButton getBack() {
        return Back;
    }
    public JButton getShownewentries(){return shownewentries;}

    public void setreporttype(){
        reporttype.setText("New Animal Entries");
    }

    public void setFinalReport(){
        this.finalReport.setText("");
        reporttype.setText("");
    }
}
