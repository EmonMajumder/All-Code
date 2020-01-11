import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panelcharacter extends JPanel {

    private int characterSelected=0;
    private Warrior warrior;
    private Wizard wizard;
    private Cleric cleric;
    private JButton startBattle;
    private JTextField characterName;
    private ButtonGroup selectCharacter;
    private JLabel characterImage;
    private JTextArea characterDescription;
    private JLabel hitPointsScore;
    private JLabel defenseScore;
    private JLabel agilityScore;
    private JLabel baseAttackScore;
    private ButtonGroup selectWeapon;
    private JLabel weaponImage;
    private JTextArea weaponDescription;
    private JLabel attackModifierScore;
    private JLabel weightScore;
    private int weaponSelected=0;

    public Panelcharacter () {

        setBackground(Color.orange);                    //Set background color.
        setLayout(null);                                //Set panel layout to null.

        //Instance of Weapon, Warrior, Wizard, Cleric class.
        Weapon weapon=new Weapon("",0,0,"","");

        warrior=new Warrior("","Warrior is skilled in combat, and usually " +
                "can make use of some of the most powerful " + "heavy armor and weaponry in the game.",
                0,0,0,0,"/images/warrior.jpg",weapon);

        wizard=new Wizard("","Wizards are spellcasters who wield powerful spells, " +
                "but are often physically weak as a trade-off." + "heavy armor and weaponry in the game.",
                0,0,0,0,"/images/wizard.jpg",weapon);

        cleric=new Cleric("","Cleric is the paladin, who is typically a Lawful Good warrior " +
                "often aligned with a religious order, and who can use their " +
                "spellcasting skills along with physical strength." + "heavy armor and weaponry in the game.",
                0,0,0,0,"/images/cleric.jpg",weapon);

        //JLabel for page heading.
        JLabel characterGenerator =new JLabel("Character Generator");
        characterGenerator.setBounds(50,15,400,35);
        characterGenerator.setFont(new Font("Algerian",1,30));
        add(characterGenerator);

        //JLabel for name input.
        JLabel enterName =new JLabel("Enter Name");
        enterName.setBounds(50,55,150,25);
        enterName.setFont(new Font("Algerian",1,20));
        add(enterName);

        //Text field for entering Player name.
        characterName=new JTextField();
        characterName.setBounds(250,55,150,25);
        characterName.setFont(new Font("Arial",1,20));
        add(characterName);

        //JLabel for character type heading.
        JLabel characterType =new JLabel("Character Type");
        characterType.setBounds(50,90,200,25);
        characterType.setFont(new Font("Algerian",1,20));
        add(characterType);

        //Buttongroup for selecting player type.
        selectCharacter=new ButtonGroup();

        //Radio button for selecting warrior.
        JRadioButton warriortoselect =new JRadioButton("Warrior");
        warriortoselect.setBounds(50,120,100,20);
        warriortoselect.setBackground(Color.orange);
        selectCharacter.add(warriortoselect);

        //Radio button for selecting wizard.
        JRadioButton wizardtoselect =new JRadioButton("Wizard");
        wizardtoselect.setBounds(50,150,100,20);
        wizardtoselect.setBackground(Color.orange);
        selectCharacter.add(wizardtoselect);

        //Radio button for selecting cleric.
        JRadioButton clerictoselect =new JRadioButton("Cleric");
        clerictoselect.setBounds(50,180,100,20);
        clerictoselect.setBackground(Color.orange);
        selectCharacter.add(clerictoselect);

        //Add all radio button to panel
        add(warriortoselect);
        add(wizardtoselect);
        add(clerictoselect);

        //JLabel to display player image.
        characterImage = new JLabel();
        characterImage.setBounds(250,90,150,200);
        add(characterImage);

        //Text area to display discription about the selected player type.
        characterDescription=new JTextArea("");
        characterDescription.setLineWrap(true);
        characterDescription.setBounds(50,210,180,80);
        add(characterDescription);


        JLabel characterStats =new JLabel("Character Stats");
        characterStats.setBounds(500,90,200,25);
        characterStats.setFont(new Font("Algerian",1,20));
        add(characterStats);

        //JLabels to display hitpoint, defense, agility, baseattack and their points.
        JLabel hitPoints =new JLabel("Hit Points");
        hitPoints.setBounds(500,120,100,20);
        add(hitPoints);
        hitPointsScore=new JLabel();
        hitPointsScore.setBounds(620,120,50,20);
        hitPointsScore.setFont(new Font("Arial",1,20));
        hitPointsScore.setBackground(Color.WHITE);
        hitPointsScore.setForeground(Color.GREEN);
        hitPointsScore.setOpaque(true);
        add(hitPointsScore);

        JLabel defense =new JLabel("Defense");
        defense.setBounds(500,145,100,20);
        add(defense);
        defenseScore=new JLabel();
        defenseScore.setBounds(620,145,50,20);
        defenseScore.setFont(new Font("Arial",1,20));
        defenseScore.setBackground(Color.WHITE);
        defenseScore.setForeground(Color.GREEN);
        defenseScore.setOpaque(true);
        add(defenseScore);

        JLabel agility =new JLabel("Agility");
        agility.setBounds(500,170,100,20);
        add(agility);
        agilityScore=new JLabel();
        agilityScore.setBounds(620,170,50,20);
        agilityScore.setFont(new Font("Arial",1,20));
        agilityScore.setBackground(Color.WHITE);
        agilityScore.setForeground(Color.GREEN);
        agilityScore.setOpaque(true);
        add(agilityScore);

        JLabel baseAttack =new JLabel("Base Attack");
        baseAttack.setBounds(500,195,100,20);
        add(baseAttack);
        baseAttackScore=new JLabel();
        baseAttackScore.setBounds(620,195,50,20);
        baseAttackScore.setFont(new Font("Arial",1,20));
        baseAttackScore.setBackground(Color.WHITE);
        baseAttackScore.setForeground(Color.GREEN);
        baseAttackScore.setOpaque(true);
        add(baseAttackScore);


        //Action Listener for warrior, wizard and cleric Radiobutton.
        warriortoselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                characterSelected=1;
                characterImage.setIcon(new ImageIcon(getClass().getResource(warrior.getImageLocation())));
                characterDescription.setText(warrior.getDescription());
                warrior.setproperty();
                hitPointsScore.setText(Integer.toString(warrior.gethitpoint()));
                agilityScore.setText(Integer.toString(warrior.getagility()));
                defenseScore.setText(Integer.toString(warrior.getdefense()));
                baseAttackScore.setText(Integer.toString(warrior.getbaseAttack()));
            }
        });
        wizardtoselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                characterSelected=2;
                characterImage.setIcon(new ImageIcon(getClass().getResource(wizard.getImageLocation())));
                characterDescription.setText(wizard.getDescription());
                wizard.setproperty();
                hitPointsScore.setText(Integer.toString(wizard.gethitpoint()));
                agilityScore.setText(Integer.toString(wizard.getagility()));
                defenseScore.setText(Integer.toString(wizard.getdefense()));
                baseAttackScore.setText(Integer.toString(wizard.getbaseAttack()));
            }
        });
        clerictoselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                characterSelected=3;
                characterImage.setIcon(new ImageIcon(getClass().getResource(cleric.getImageLocation())));
                characterDescription.setText(cleric.getDescription());
                cleric.setproperty();
                hitPointsScore.setText(Integer.toString(cleric.gethitpoint()));
                agilityScore.setText(Integer.toString(cleric.getagility()));
                defenseScore.setText(Integer.toString(cleric.getdefense()));
                baseAttackScore.setText(Integer.toString(cleric.getbaseAttack()));
            }
        });

        //Three instance of weapon class- dagger, sword, hammer.
        Weapon dagger=new Weapon("Dagger",10,5,
                "A dagger is a weapon for stealth lover. " +
                "Due to its light weight it can make fast attack. But amount of damage is low.",
                "/images/dagger.jpg");
        Weapon sword=new Weapon("Sword",20,10,
                "A sword is a all-around weapon. "+
                "Due to its medium range of weight it inflicts faster and good amount of damage.",
                "/images/sword.jpg");
        Weapon hammer=new Weapon("Hammer",30,20,
                "A hammer is a tool for stronger. "+
                "Due to its heavy weight it does huge amount of damage with each attack.",
                "/images/hammer.jpg");

        JLabel weaponType =new JLabel("Weapon Type");
        weaponType.setBounds(50,320,300,25);
        weaponType.setFont(new Font("Algerian",1,20));
        add(weaponType);

        //Button group for weapon selection.
        selectWeapon =new ButtonGroup();

        //Radio buttons to select weapon.
        JRadioButton daggerButton =new JRadioButton("Dagger");
        daggerButton.setBounds(50,350,100,20);
        daggerButton.setBackground(Color.orange);
        selectWeapon.add(daggerButton);

        JRadioButton swordButton =new JRadioButton("Sword");
        swordButton.setBounds(50,380,100,20);
        swordButton.setBackground(Color.orange);
        selectWeapon.add(swordButton);

        JRadioButton hammerButton =new JRadioButton("Hammer");
        hammerButton.setBounds(50,410,100,20);
        hammerButton.setBackground(Color.orange);
        selectWeapon.add(hammerButton);

        //Add buttons to panel.
        add(daggerButton);
        add(swordButton);
        add(hammerButton);

        //JLabel to display weapon image.
        weaponImage = new JLabel();
        weaponImage.setBounds(250,320,150,200);
        add(weaponImage);

        //Text area to display weapon description.
        weaponDescription=new JTextArea("");
        weaponDescription.setLineWrap(true);
        weaponDescription.setBounds(50,440,180,80);
        add(weaponDescription);

        JLabel weaponStats =new JLabel("Weapon Stats");
        weaponStats.setBounds(500,320,200,25);
        weaponStats.setFont(new Font("Algerian",1,20));
        add(weaponStats);

        //JLabels to display attack modifier name and score.
        JLabel attackModifier =new JLabel("Attack Modifier");
        attackModifier.setBounds(500,360,120,20);
        add(attackModifier);
        attackModifierScore=new JLabel();
        attackModifierScore.setBounds(620,360,50,20);
        attackModifierScore.setFont(new Font("Arial",1,20));
        attackModifierScore.setBackground(Color.WHITE);
        attackModifierScore.setForeground(Color.GREEN);
        attackModifierScore.setOpaque(true);
        add(attackModifierScore);

        ////JLabels to display weight term and score.
        JLabel weight =new JLabel("Weight");
        weight.setBounds(500,385,120,20);
        add(weight);
        weightScore=new JLabel();
        weightScore.setBounds(620,385,50,20);
        weightScore.setFont(new Font("Arial",1,20));
        weightScore.setBackground(Color.WHITE);
        weightScore.setForeground(Color.GREEN);
        weightScore.setOpaque(true);
        add(weightScore);

        //Action listener for weapon selection radio button.
        daggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(getClass().getResource(dagger.getImageLocation())));
                weaponDescription.setText(dagger.getDescription());
                attackModifierScore.setText("+"+dagger.getAttackModifier());
                weightScore.setText(Integer.toString(dagger.getWeight()));
                warrior.setWeapon(dagger);
                wizard.setWeapon(dagger);
                cleric.setWeapon(dagger);
                weaponSelected=1;
            }
        });
        swordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(getClass().getResource(sword.getImageLocation())));
                weaponDescription.setText(sword.getDescription());
                attackModifierScore.setText("+"+sword.getAttackModifier());
                weightScore.setText(Integer.toString(sword.getWeight()));
                warrior.setWeapon(sword);
                wizard.setWeapon(sword);
                cleric.setWeapon(sword);
                weaponSelected=1;
            }
        });
        hammerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(getClass().getResource(hammer.getImageLocation())));
                weaponDescription.setText(hammer.getDescription());
                attackModifierScore.setText("+"+hammer.getAttackModifier());
                weightScore.setText(Integer.toString(hammer.getWeight()));
                warrior.setWeapon(hammer);
                wizard.setWeapon(hammer);
                cleric.setWeapon(hammer);
                weaponSelected=1;
            }
        });

        //JButton reroll to reset player stat.
        JButton reroll = new JButton("Reroll");
        reroll.setBounds(525,230,120,30);
        reroll.setFont(new Font("Close and Open",1,20));
        add(reroll);

        //Action listener for reroll button.
        reroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(characterSelected==1){
                    warrior.setproperty();
                    hitPointsScore.setText(Integer.toString(warrior.gethitpoint()));
                    agilityScore.setText(Integer.toString(warrior.getagility()));
                    defenseScore.setText(Integer.toString(warrior.getdefense()));
                    baseAttackScore.setText(Integer.toString(warrior.getbaseAttack()));
                }
                else if (characterSelected==2) {
                    wizard.setproperty();
                    hitPointsScore.setText(Integer.toString(wizard.gethitpoint()));
                    agilityScore.setText(Integer.toString(wizard.getagility()));
                    defenseScore.setText(Integer.toString(wizard.getdefense()));
                    baseAttackScore.setText(Integer.toString(wizard.getbaseAttack()));
                }
                else if (characterSelected==3) {
                    cleric.setproperty();
                    hitPointsScore.setText(Integer.toString(cleric.gethitpoint()));
                    agilityScore.setText(Integer.toString(cleric.getagility()));
                    defenseScore.setText(Integer.toString(cleric.getdefense()));
                    baseAttackScore.setText(Integer.toString(cleric.getbaseAttack()));
                }
            }
        });

        //Start battle button.
        startBattle = new JButton("Start Battle");
        startBattle.setBounds(485,460,200,60);
        startBattle.setFont(new Font("Close and Open",1,20));
        add(startBattle);
    }

    public int getCharacterSelected(){
        return characterSelected;
    }
    public void resetCharacterSelected(){this.characterSelected=0;}
    public int getWeaponSelected(){
        return weaponSelected;
    }
    public void resetWeaponSelected(){this.weaponSelected=0;}
    public JTextField getCharacterName(){
        return characterName;
    }
    public ButtonGroup getSelectCharacter(){
        return selectCharacter;
    }
    public JLabel getCharacterImage() {
        return characterImage;
    }
    public JTextArea getCharacterDescription() {
        return characterDescription;
    }
    public JLabel getHitPointsScore() {
        return hitPointsScore;
    }
    public JLabel getDefenseScore() {
        return defenseScore;
    }
    public JLabel getAgilityScore() {
        return agilityScore;
    }
    public JLabel getBaseAttackScore() {
        return baseAttackScore;
    }
    public ButtonGroup getSelectWeapon() {
        return selectWeapon;
    }
    public JLabel getWeaponImage() {
        return weaponImage;
    }
    public JTextArea getWeaponDescription() {
        return weaponDescription;
    }
    public JLabel getAttackModifierScore() {
        return attackModifierScore;
    }
    public JLabel getWeightScore() {
        return weightScore;
    }

    //getter for start battle button
    public JButton getStartBattle(){return startBattle;}

    //Getter for instance of the class warrior, wizard, cleric.
    public Warrior getWarrior(){
        return warrior;
    }
    public Wizard getWizard(){
        return wizard;
    }
    public Cleric getCleric(){
        return cleric;
    }
}
