import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame3 extends JFrame {

    public MyFrame3() {
        super("Program obrazkowy");

        JPanel panele2 = new Panele2();
        add(panele2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
