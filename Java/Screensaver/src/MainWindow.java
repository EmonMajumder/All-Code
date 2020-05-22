import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel contentPane;

    public MainWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Screen Saver");
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        DrawingPanel drawing = new DrawingPanel();

        drawing.setBackground(Color.WHITE);

        contentPane.add(drawing, "name_257973040435998");

        drawing.setLayout(null);
    }
}
