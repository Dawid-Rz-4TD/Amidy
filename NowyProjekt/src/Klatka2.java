import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Klatka2 extends JFrame {
    public Klatka2() {
        super("Komponenty tekstowe");
        LogListener listener = new LogListener(this);
        JPanel loginPanel = new PanelLogowania(listener);
        add(loginPanel);

        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
