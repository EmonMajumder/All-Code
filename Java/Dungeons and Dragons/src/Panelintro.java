import javax.swing.*;
import java.awt.*;

public class Panelintro extends JPanel {

    private JButton buildAcharacter;

    public Panelintro () {

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));        //Panel layout set to Box Layout.

        //Add blank area for spacing between page elements.
        add(Box.createRigidArea(new Dimension(0, 20)));

        //Heading JLabel.
        JLabel gameName = new JLabel("Dungeons and Dragons");
        gameName.setPreferredSize(new Dimension(400,100));
        gameName.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameName.setFont(new Font("Old English Text MT",1,40));
        gameName.setForeground(Color.RED);
        add(gameName);

        add(Box.createRigidArea(new Dimension(0, 20)));
        //JLbael for center image.
        JLabel introPanelImage = new JLabel();
        introPanelImage.setIcon(new ImageIcon(getClass().getResource("/images/introPanelImage.jpg")));
        introPanelImage.setSize(300, 300); // Set Width/Height same as image
        introPanelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(introPanelImage);

        add(Box.createRigidArea(new Dimension(0, 30)));
        //Button to build a character.
        buildAcharacter = new JButton("Build A Character");
        buildAcharacter.setAlignmentX(Component.CENTER_ALIGNMENT);
        buildAcharacter.setFont(new Font("Close and Open",1,20));
        add(buildAcharacter);
    }
    public JButton getBuildAcharacter(){return buildAcharacter;}
}
