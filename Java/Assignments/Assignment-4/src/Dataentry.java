import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dataentry extends JPanel {

    private JTextArea GPSinputconfirmation;
    private JButton addentry;
    private JTextField Wightinput;
    private JTextField Bloodpressureinput;
    private JButton Viewreport;
    private JTextField numberofspotsinput;
    private JComboBox options;
    private JComboBox Genderopt;
    private JComboBox dentalhealthinput;
    private JLabel bloodpressure;
    private JLabel numberofspots;
    private JLabel dentalhealth;
    private JTextField GPSCooordinatesinput;

    private ArrayList<Animal> animals =new ArrayList<Animal>();

    public Dataentry(){

        setLayout(null);
        JLabel animalObserved =new JLabel();
        animalObserved.setText("Animal Observed: ");
        animalObserved.setBounds(10,10,150,20);
        animalObserved.setFont(new Font("",1,15));
        add(animalObserved);

        JLabel animal =new JLabel();
        animal.setText("Animal: ");
        animal.setBounds(10,40,150,20);
        animal.setFont(new Font("",1,15));
        add(animal);
        String[] animaloptions={"","Penguin","Sea Lion","Walrus"};
        options=new JComboBox(animaloptions);
        options.setBounds(165,40,100,20);
        options.setFont(new Font("",1,15));
        add(options);

        JLabel gender =new JLabel();
        gender.setText("Gender: ");
        gender.setBounds(10,70,150,20);
        gender.setFont(new Font("",1,15));
        add(gender);
        String[] genderoptions={"","Male","Female"};
        Genderopt=new JComboBox(genderoptions);
        Genderopt.setBounds(165,70,100,20);
        Genderopt.setFont(new Font("",1,15));
        add(Genderopt);

        JLabel weightinkg =new JLabel();
        weightinkg.setText("Weight in Kg: ");
        weightinkg.setBounds(10,100,150,20);
        weightinkg.setFont(new Font("",1,15));
        add(weightinkg);
        Wightinput= new JTextField();
        Wightinput.setBounds(165,100,100,20);
        Wightinput.setFont(new Font("",1,15));
        add(Wightinput);

        bloodpressure =new JLabel();
        bloodpressure.setText("Blood Pressure: ");
        bloodpressure.setBounds(10,130,150,20);
        bloodpressure.setFont(new Font("",1,15));
        add(bloodpressure);
        bloodpressure.setVisible(false);
        Bloodpressureinput= new JTextField();
        Bloodpressureinput.setBounds(165,130,100,20);
        Bloodpressureinput.setFont(new Font("",1,15));
        add(Bloodpressureinput);
        Bloodpressureinput.setVisible(false);

        numberofspots  =new JLabel();
        numberofspots.setText("Number of Spots: ");
        numberofspots.setBounds(10,130,150,20);
        numberofspots.setFont(new Font("",1,15));
        add(numberofspots);
        numberofspots.setVisible(false);
        numberofspotsinput= new JTextField();
        numberofspotsinput.setBounds(165,130,100,20);
        numberofspotsinput.setFont(new Font("",1,15));
        add(numberofspotsinput);
        numberofspotsinput.setVisible(false);

        dentalhealth =new JLabel();
        dentalhealth.setText("Dental Health: ");
        dentalhealth.setBounds(10,130,150,20);
        dentalhealth.setFont(new Font("",1,15));
        add(dentalhealth);
        dentalhealth.setVisible(false);
        String[] dentalhealthoptions = {"","Good","Average","Poor"};
        dentalhealthinput= new JComboBox(dentalhealthoptions);
        dentalhealthinput.setBounds(165,130,100,20);
        dentalhealthinput.setFont(new Font("",1,15));
        add(dentalhealthinput);
        dentalhealthinput.setVisible(false);

        numberofspots.setVisible(false);
        dentalhealth.setVisible(false);
        numberofspotsinput.setVisible(false);
        dentalhealthinput.setVisible(false);

        addentry=new JButton();
        addentry.setText("Add Entry");
        addentry.setBounds(70,160,125,30);
        addentry.setFont(new Font("",1,15));
        add(addentry);

        options.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event){
                if(event.getSource()==options){
                    if(options.getSelectedItem().equals("Penguin")){
                        bloodpressure.setVisible(true);
                        numberofspots.setVisible(false);
                        dentalhealth.setVisible(false);
                        Bloodpressureinput.setVisible(true);
                        numberofspotsinput.setVisible(false);
                        dentalhealthinput.setVisible(false);
                    }
                    if(options.getSelectedItem().equals("Sea Lion")){
                        bloodpressure.setVisible(false);
                        numberofspots.setVisible(true);
                        dentalhealth.setVisible(false);
                        Bloodpressureinput.setVisible(false);
                        numberofspotsinput.setVisible(true);
                        dentalhealthinput.setVisible(false);
                    }
                    if(options.getSelectedItem().equals("Walrus")){
                        bloodpressure.setVisible(false);
                        numberofspots.setVisible(false);
                        dentalhealth.setVisible(true);
                        Bloodpressureinput.setVisible(false);
                        numberofspotsinput.setVisible(false);
                        dentalhealthinput.setVisible(true);
                    }
                }
            }
        });

        JLabel GPSCooordinates =new JLabel();
        GPSCooordinates.setText("GPS Co-ordinates: (-)##.####### (-)(## or ###).#######");
        GPSCooordinates.setBounds(300,10,400,20);
        GPSCooordinates.setFont(new Font("",1,15));
        add(GPSCooordinates);
        GPSCooordinatesinput= new JTextField();
        GPSCooordinatesinput.setBounds(300,40,250,20);
        GPSCooordinatesinput.setFont(new Font("",1,15));
        add(GPSCooordinatesinput);

        JButton addGPS=new JButton();
        addGPS.setText("Add GPS");
        addGPS.setBounds(560,40,100,20);
        addGPS.setFont(new Font("",1,15));
        add(addGPS);

        GPSinputconfirmation =new JTextArea();
        GPSinputconfirmation.setText("");
        GPSinputconfirmation.setBounds(300,70,360,120);
        GPSinputconfirmation.setFont(new Font("",1,15));
        GPSinputconfirmation.setLineWrap(true);
        add(GPSinputconfirmation);

        Viewreport=new JButton();
        Viewreport.setText("View Report");
        Viewreport.setBounds(540,205,120,30);
        Viewreport.setFont(new Font("",1,15));
        add(Viewreport);

        addGPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean GPSvalid;
                GPSvalid = GPSrecordcreation(GPSCooordinatesinput.getText());
                if (GPSvalid) {
                    GPSinputconfirmation.append(GPSCooordinatesinput.getText() + "\n");
                    GPSCooordinatesinput.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please input a valid Co-ordinate.",
                            "Error!!!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        addentry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String insgender="";
                int insweight;
                double insbloodpressure;
                int insnumberofspots;
                String insdentalcondition;
                GPS newgpsinput = new GPS(GPSinputconfirmation.getText());
                if (newgpsinput.getGPSpoint().equals("")) {
                    JOptionPane.showMessageDialog(null, "GPS location missing", "Error - Location", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    insgender=Genderopt.getSelectedItem().toString();
                    if (!insgender.equals("")) {
                        String weightvalidation = "^[1-9]\\d*$";
                        Pattern weightp = Pattern.compile(weightvalidation);
                        Matcher weightm = weightp.matcher(Wightinput.getText());
                        if (!weightm.find()) {
                            JOptionPane.showMessageDialog(null, "Incorrect input for weight!", "Error in Weight!!!", JOptionPane.ERROR_MESSAGE);
                        } else {
                            insweight = Integer.parseInt(Wightinput.getText());
                            if (options.getSelectedItem().equals("Penguin")) {
                                String bpvalidation = "^(([1-9]\\d*)|[0])(\\.[0-9]{1,7})?$";
                                Pattern bpp = Pattern.compile(bpvalidation);
                                Matcher bpm = bpp.matcher(Bloodpressureinput.getText());
                                if (!bpm.find()) {
                                    JOptionPane.showMessageDialog(null, "Please insert an valid number for Blood Pressure!", "Error in Blood Pressure!!!", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    insbloodpressure = Double.parseDouble(Bloodpressureinput.getText());
                                    Penguin instantPenguin = new Penguin("Penguin", insgender, insweight, newgpsinput, insbloodpressure);
                                    animals.add(instantPenguin);
                                    resetpagedata();
                                    JOptionPane.showMessageDialog(null, "Penguin saved as new entry!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                                    instantPenguin.writeGPS();
                                }
                            } else if (options.getSelectedItem().equals("Sea Lion")) {
                                String nsvalidation = "^[1-9]\\d*$";
                                Pattern nsp = Pattern.compile(nsvalidation);
                                Matcher nsm = nsp.matcher(numberofspotsinput.getText());
                                if (!nsm.find()) {
                                    JOptionPane.showMessageDialog(null, "Please insert an valid number for number of spots !", "Error in Blood Pressure!!!", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    insnumberofspots = Integer.parseInt(numberofspotsinput.getText());
                                    SeaLion instantSealion = new SeaLion("Sea Lion", insgender, insweight, newgpsinput, insnumberofspots);
                                    animals.add(instantSealion);
                                    resetpagedata();
                                    JOptionPane.showMessageDialog(null, "Sea lion saved as new entry!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                                    instantSealion.writeGPS();
                                }
                            } else if (options.getSelectedItem().equals("Walrus")) {
                                insdentalcondition = String.valueOf(dentalhealthinput.getSelectedItem());
                                if (insdentalcondition.equals("")){
                                    JOptionPane.showMessageDialog(null, "Dental condition was not selected.", "Error", JOptionPane.WARNING_MESSAGE);
                                }
                                else {
                                    Walrus instantWalrus = new Walrus("Walrus", insgender, insweight, newgpsinput, insdentalcondition);
                                    animals.add(instantWalrus);
                                    resetpagedata();
                                    JOptionPane.showMessageDialog(null, "Walrus saved as new entry!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                                    instantWalrus.writeGPS();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No animal was selected.\nPlease select an animal.", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Gender was not selected!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public boolean GPSrecordcreation(String check) {
        /*String GPScoordinate[] = check.split(" ");
        try {
            float latitudefloat = Float.parseFloat(GPScoordinate[0]);
            float longitudefloat = Float.parseFloat(GPScoordinate[1]);
            if ((latitudefloat>=-90 && latitudefloat<=90) && (longitudefloat>=-180 && longitudefloat<=180)){
                String latitude1[]=GPScoordinate[0].split("\\.");
                String longitude1[]=GPScoordinate[1].split("\\.");
                char latitudedecimal[]=latitude1[1].toCharArray();
                char longitudedecimal[]=longitude1[1].toCharArray();
                if(latitudedecimal.length==7 && longitudedecimal.length==7){
                    return (true);
                }else
                    return (false);
            }else
                return (false);
        }
        catch (Exception e) {
            return (false);
        }*/
        String regexcoordinate = "^[-+]?([1-8]?\\d(\\.\\d{7})|90(\\.0{7}))\\s[-+]?(180(\\.0{7})|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d{7}))$";
        Pattern r = Pattern.compile(regexcoordinate);
        Matcher m = r.matcher(check);
        if (!m.find()) {
            return (false);
        }
        else {
            return (true);
        }
    }
    public JButton getViewreport(){
        return Viewreport;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void resetpagedata(){
        GPSinputconfirmation.setText("");
        GPSCooordinatesinput.setText("");
        Wightinput.setText("");
        Bloodpressureinput.setText("");
        numberofspotsinput.setText("");
        options.setSelectedIndex(0);
        Genderopt.setSelectedIndex(0);
        dentalhealthinput.setSelectedIndex(0);
        bloodpressure.setVisible(false);
        numberofspots.setVisible(false);
        dentalhealth.setVisible(false);
        Bloodpressureinput.setVisible(false);
        numberofspotsinput.setVisible(false);
        dentalhealthinput.setVisible(false);
    }
}
