import javax.swing.*;
import java.awt.*;

public class ProgramWindowFrame extends JFrame{
    private static int currentpage;

    public ProgramWindowFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,600,400);
        setTitle("Demo in Class");
        setLayout(new CardLayout(0,0));

        PageOnePanel page1=new PageOnePanel();
        add(page1);
    }

    public static int getCurrentpage(int currentpage){
        ProgramWindowFrame.currentpage = currentpage;
    }

    public static void setCurrentpage(int currentpage) {
        ProgramWindowFrame.currentpage = currentpage;
    }
}
