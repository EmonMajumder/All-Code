import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameframe extends JFrame {

    public Gameframe() {

        setTitle("DnD Game");                       //Set title of the frame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 600);      //Set area and boundary for the main frame.
        setLayout(new CardLayout());                            //set frame layout to CardLayout.
        setVisible(true);

        Panelintro page1 = new Panelintro();                    //Create an instance of the JPanel PanelIntro.
        Panelcharacter page2 = new Panelcharacter();            //Create an instance of the JPanel Panelcharacter.
        Panelbattle page3=new Panelbattle();                    //Create an instance of the JPanel Panelbattle.

        add(page1);                                             //Add panel to the main frame.
        add(page2);                                             //Add panel to the main frame.
        add(page3);                                             //Add panel to the main frame.

        page1.setVisible(true);                                 //set page1 to visible by default.

        JButton buildacharacter=page1.getBuildAcharacter();     //Get the Button from page 1.
        buildacharacter.addActionListener(new ActionListener() {        //Action listener for the button.
            @Override
            public void actionPerformed(ActionEvent arg0) {
                page1.setVisible(false);
                page2.setVisible(true);
            }
        });

        //Action listener for start battle Button.
        JButton startBattle=page2.getStartBattle();
        startBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (page2.getCharacterSelected()==0){                   //warning if no character selected.
                    JOptionPane.showMessageDialog(null,
                            "You must select a Player first to start the battle.",
                            "Warning!!!", JOptionPane.WARNING_MESSAGE);
                }
                else if (page2.getWeaponSelected()==0){                 //warning if no weapon selected.
                    JOptionPane.showMessageDialog(null,
                            "Monsters are too strong to fight without weapon.\nPick a Weapon.",
                            "Warning!!!", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    if (page2.getCharacterSelected() == 1) {
                        page2.getWarrior().setname(page2.getCharacterName().getText());  //Set Player name property.
                    } else if (page2.getCharacterSelected() == 2) {
                        page2.getWizard().setname(page2.getCharacterName().getText());
                    } else if (page2.getCharacterSelected() == 3) {
                        page2.getCleric().setname(page2.getCharacterName().getText());
                    }
                    page3.setMonsterinyourluck((int) (Math.random() * 40));     //Set a random number to choose monster.
                    page3.setMonster();                                         //Method call for selecting a random monster.
                    page3.display(page2.getWarrior(), page2.getWizard(), page2.getCleric(), page2.getCharacterSelected());
                    page3.setVisible(true);
                    page2.getSelectCharacter().clearSelection();                //Clear selection for character buttongroup.
                    page2.getCharacterImage().setIcon(new ImageIcon(getClass().getResource("")));
                    page2.getCharacterDescription().setText("");                //Clear input.
                    page2.getHitPointsScore().setText("");
                    page2.getAgilityScore().setText("");
                    page2.getDefenseScore().setText("");
                    page2.getBaseAttackScore().setText("");
                    page2.getSelectWeapon().clearSelection();
                    page2.getWeaponImage().setIcon(new ImageIcon(getClass().getResource("")));
                    page2.getWeaponDescription().setText("");
                    page2.getAttackModifierScore().setText("");
                    page2.getWeightScore().setText("");
                    page2.setVisible(false);
                    page3.BattleResult();
                }
            }
        });

        JButton playAgain=page3.getPlayAgain();
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                page3.setVisible(false);
                page1.setVisible(true);
                page2.resetCharacterSelected();
                page2.resetWeaponSelected();
                page3.resetdeterminewinner();
            }
        });
    }
}
