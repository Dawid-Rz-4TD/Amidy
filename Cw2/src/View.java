import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public JTextField poleA = new JTextField(10);
    public JTextField poleB = new JTextField(10);
    public JButton btnOblicz = new JButton("Oblicz");
    public JLabel wynikLabel = new JLabel("Wynik: ");

    public View() {
        super("Kalkulator MVC");

        JPanel panel = new JPanel();
        panel.add(new JLabel("A:"));
        panel.add(poleA);
        panel.add(new JLabel("B:"));
        panel.add(poleB);
        panel.add(btnOblicz);
        panel.add(wynikLabel);

        add(panel);
        setSize(300, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void pokazBlad(String tekst) {
        JOptionPane.showMessageDialog(this, tekst, "Błąd", JOptionPane.ERROR_MESSAGE);
    }

    public void ustawWynik(int w) {
        wynikLabel.setText("Wynik: " + w);
    }
}
