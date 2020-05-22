import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panelbattle extends JPanel {

    private JLabel player;
    private JLabel monster;
    private String playerType="";
    private String playerName="";
    private String fighterImage = "";
    private String monsterName;
    private String monsterImagelocation;
    private int hitpoint=0;
    private int agility=0;
    private int baseattack=0;
    private int defense=0;
    private JLabel characterImage;
    private JLabel monsterImage;
    private JTextArea result;
    private JButton playAgain;
    private int monsterinyourluck;
    private ArrayList<Monster> monsterArrayList=new ArrayList<Monster>();
    private Weapon weapon;
    private int determinewinner=0;
    private static JLabel battleToTheDeath;             //Static property.


    public Panelbattle() {

        setBackground(Color.RED);
        setLayout(null);

        //JLabel for heading.
        battleToTheDeath = new JLabel("Battle To Death And Glory!");
        battleToTheDeath.setBounds(100, 0, 600, 60);
        battleToTheDeath.setFont(new Font("Old English Text MT", 1, 40));
        battleToTheDeath.setHorizontalAlignment(SwingConstants.CENTER);
        battleToTheDeath.setForeground(Color.BLACK);
        add(battleToTheDeath);

        //JPanel to hold player and monster name.
        JPanel fightBetweenName = new JPanel(new GridLayout(1, 2, 10, 10));
        fightBetweenName.setBounds(100, 60, 600, 30);
        fightBetweenName.setBackground(Color.RED);
        add(fightBetweenName);

        player = new JLabel();
        player.setFont(new Font("Arial", 1, 25));
        player.setHorizontalAlignment(SwingConstants.CENTER);
        fightBetweenName.add(player);

        monster = new JLabel();
        monster.setFont(new Font("Arial", 1, 25));
        monster.setHorizontalAlignment(SwingConstants.CENTER);
        fightBetweenName.add(this.monster);

        //JPanel to hold player and monster image.
        JPanel fightBetweenImage = new JPanel(new GridLayout(1, 2, 10, 10));
        fightBetweenImage.setBounds(100, 90, 600, 200);
        fightBetweenImage.setBackground(Color.RED);
        add(fightBetweenImage);

        //JLabel to show player and monster image.
        characterImage = new JLabel();
        characterImage.setHorizontalAlignment(SwingConstants.CENTER);
        fightBetweenImage.add(characterImage);
        monsterImage = new JLabel();
        monsterImage.setHorizontalAlignment(SwingConstants.CENTER);
        fightBetweenImage.add(monsterImage);

        //Text area to show battle result.
        result = new JTextArea();
        result.setBounds(75, 300, 650, 200);
        result.setBackground(Color.WHITE);
        result.setForeground(Color.BLACK);
        add(result);

        //Play again button to navigate to first page.
        playAgain = new JButton("Play Again");
        playAgain.setBounds(300, 520, 180, 30);
        playAgain.setFont(new Font("Close and Open", 1, 20));
        add(playAgain);
    }

    //Method to get and set properties, image or text to display on the Panelbattle screen based on character selected.
    public void display(Warrior warrior,Wizard wizard,Cleric cleric,int characterSelected){

        if (characterSelected==1){
            playerType="Warrior";
            fighterImage=warrior.getImageLocation();
            playerName=warrior.getname();
            hitpoint=warrior.gethitpoint();
            agility =warrior.getagility();
            baseattack=warrior.getbaseAttack();
            defense=warrior.getdefense();
            weapon=warrior.getWeapon();
        }
        else if (characterSelected==2){
            playerType="Wizard";
            fighterImage=wizard.getImageLocation();
            playerName=wizard.getname();
            hitpoint=wizard.gethitpoint();
            agility =wizard.getagility();
            baseattack=wizard.getbaseAttack();
            defense=wizard.getdefense();
            weapon=wizard.getWeapon();
        }
        else if (characterSelected==3){
            playerType="Cleric";
            fighterImage=cleric.getImageLocation();
            playerName=cleric.getname();
            hitpoint=cleric.gethitpoint();
            agility =cleric.getagility();
            baseattack=cleric.getbaseAttack();
            defense=cleric.getdefense();
            weapon=cleric.getWeapon();
        }

        player.setText("Player: "+playerType);
        monster.setText("Player: "+monsterName);
        characterImage.setIcon(new ImageIcon(getClass().getResource(fighterImage)));
        monsterImage.setIcon(new ImageIcon(getClass().getResource(monsterImagelocation)));
        result.setText("Player: "+playerName+"\n" +
                "-----------------------------------------------\n" +
                "Class: "+playerType+"\n" +
                "HP: "+hitpoint+"\t\tDefense: "+defense+
                "\t\tAgility: "+agility+"\t\tBase Attack: "+baseattack+"\n\n" +
                "Weapon: "+weapon.getName()+"\n" +
                "Weight: "+weapon.getWeight()+"\t\tAttack Mod: +"+weapon.getAttackModifier()+"\n\n" +
                "Monster: \n" +
                "-----------------------------------------------\n" +
                "HP: "+monsterArrayList.get(monsterinyourluck).gethitpoint()+
                "\t\tDefense: "+monsterArrayList.get(monsterinyourluck).getdefense()+
                "\t\tAgility: "+monsterArrayList.get(monsterinyourluck).getagility()+
                "\t\tBase Attack: "+monsterArrayList.get(monsterinyourluck).getbaseAttack()+"\n");

        if(hitpoint>monsterArrayList.get(monsterinyourluck).gethitpoint()){determinewinner=determinewinner+1;}
        if(defense>monsterArrayList.get(monsterinyourluck).getdefense()){determinewinner=determinewinner+1;}
        if(agility>monsterArrayList.get(monsterinyourluck).getagility()){determinewinner=determinewinner+1;}
        if(baseattack>monsterArrayList.get(monsterinyourluck).getbaseAttack()){determinewinner=determinewinner+1;}
    }
    //Method to get properties of randomly selected monster on screen.
    public void setMonster(){

        Monster monster1=new Monster("Nightgoat",0,0,0,0,
                "images/nightgoat.jpg",true);
        Monster monster2=new Monster("SoulTaker",0,0,0,0,
                "images/soultaker.jpg",false);
        Monster monster3=new Monster("Spider",0,0,0,0,
                "images/spider.jpg",true);
        Monster monster4=new Monster("Wolf",0,0,0,0,
                "images/wolf.jpg",false);

        monsterArrayList.add(monster1);
        monsterArrayList.add(monster2);
        monsterArrayList.add(monster3);
        monsterArrayList.add(monster4);

        if (monsterinyourluck<=10){
            monsterinyourluck=0;
        }
        else if (monsterinyourluck<=20){
            monsterinyourluck=1;
        }
        else if (monsterinyourluck<=30){
            monsterinyourluck=2;
        }
        else {
            monsterinyourluck=3;
        }
        monsterArrayList.get(monsterinyourluck).setproperty();
        monsterName=monsterArrayList.get(monsterinyourluck).getname();
        monsterImagelocation=monsterArrayList.get(monsterinyourluck).getImageLocation();
    }
    public void BattleResult(){             //Method to show battle result with a pop up window.
        if(determinewinner>2){
            JOptionPane.showMessageDialog(null,
                    "You just slayed the monster. \nYou stand on the path to glory.",
                    "You Won!!!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (determinewinner<2){
            JOptionPane.showMessageDialog(null,
                    "The monster showed you no mercy. \nBetter luck next time.",
                    "You Lost!!!", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Monster awaits for your return.",
                    "Draw", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setMonsterinyourluck(int monsterinyourluck) {
        this.monsterinyourluck = monsterinyourluck;
    }
    public JButton getPlayAgain(){
        return playAgain;
    }
    public void resetdeterminewinner(){this.determinewinner=0;}
}
