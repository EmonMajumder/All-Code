import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {             //Initializing the program.
            public void run() {
                try {Gameframe frame = new Gameframe();     //Create an instance of the main frame (GameFrame).
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
