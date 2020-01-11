package ca.nscc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame {

    public MainFrame() {

        Font theFont = new Font("Arial", Font.BOLD, 30);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 650, 400);
        setTitle("File I/O, Combos & Regex");

        JLabel comboLabel = new JLabel("Pick a file:");
        comboLabel.setFont(theFont);
        comboLabel.setBounds(10,10, 180, 30);

        String fileNames[]={"TestFile1.txt", "TestFile2.txt", "TestFile3.txt"};
        JComboBox filesCombo = new JComboBox(fileNames);
        filesCombo.setFont(theFont);
        filesCombo.setBounds(190, 10,220,30);

        JButton readTextButton = new JButton("Read File");
        readTextButton.setBounds(415, 10, 200, 30);
        readTextButton.setFont(theFont);

        JLabel regexLabel = new JLabel("Postal code:");
        regexLabel.setFont(theFont);
        regexLabel.setBounds(10,45, 180, 30);

        JTextField regexText = new JTextField();
        regexText.setFont(theFont);
        regexText.setBounds(190, 45,220,30);

        JButton regexButton = new JButton("Eval Text");
        regexButton.setBounds(415, 45, 200, 30);
        regexButton.setFont(theFont);

        JTextArea theText = new JTextArea();
        theText.setEnabled(false);
        theText.setFont(theFont);
        theText.setWrapStyleWord(true);
        theText.setLineWrap(true);
        theText.setBounds(10, 80, 600, 250);

        add(comboLabel);
        add(filesCombo);
        add(readTextButton);
        add(regexLabel);
        add(regexText);
        add(regexButton);
        add(theText);

        readTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String selected = (String)filesCombo.getSelectedItem();
            String textfromFile = readFile(selected);
            theText.setText(textfromFile);
            }
        });

        regexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userVal = regexText.getText().toUpperCase();

                String regexString = "^[ABCEGHJ-NPRSTVXY][0-9][ABCEGHJ-NPRSTV-Z] [0-9][ABCEGHJ-NPRSTV-Z][0-9]$";
                Pattern r = Pattern.compile(regexString);
                Matcher m = r.matcher(userVal);

                if (!m.find()) {
                    JOptionPane.showMessageDialog(null, "Enter a valid postal code. A1A 1A1");
                }
                else {
                    theText.setText("Valid postal code: " + userVal);
                }
            }
        });
    }

    public String readFile(String fileName) {
        try {
            Path filePath = Paths.get("./src/Files/" + fileName );
            return new String(Files.readAllBytes(filePath));
        }
        catch (Exception ex){
                return "Oh noes! Error reading file!";
            }
    }
}
