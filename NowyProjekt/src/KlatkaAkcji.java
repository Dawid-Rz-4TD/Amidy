import javax.swing.*;

public class KlatkaAkcji extends JFrame {

    public KlatkaAkcji() {
        super("Test akcji");

        JPanel buttonPanel = new PrzyciskPanel();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
