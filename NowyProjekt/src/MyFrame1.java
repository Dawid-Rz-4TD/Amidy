import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame1 extends JFrame {

    public MyFrame1() {
        super( "Not Hello World" );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocation(50,50);
        setLayout(new GridLayout());

        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JButton("Przycisk 3"));

        setVisible(true);
    }

}
