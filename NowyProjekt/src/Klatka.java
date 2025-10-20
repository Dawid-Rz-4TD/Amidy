import java.awt.EventQueue;
import javax.swing.JFrame;

public class Klatka extends JFrame {
    public Klatka() {
        super("MouseTest");

        add(new MyszkaTest());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Klatka();
            }
        });
    }
}
