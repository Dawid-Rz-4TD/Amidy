import javax.swing.*;
import java.awt.*;

public class KwadratView extends JPanel {
    private JTextField poleLiczby;
    private JLabel etykietaWynik;
    private JButton przyciskOblicz;

    public KwadratView() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 100));

        add(new JLabel("Liczba:"));
        poleLiczby = new JTextField(10);
        add(poleLiczby);

        przyciskOblicz = new JButton("Oblicz");
        add(przyciskOblicz);

        etykietaWynik = new JLabel("Wynik: ");
        add(etykietaWynik);
    }

    public String pobierzLiczbe() {
        return poleLiczby.getText();
    }

    public void ustawWynik(String wynik) {
        etykietaWynik.setText("Wynik: " + wynik);
    }

    public JButton getPrzyciskOblicz() {
        return przyciskOblicz;
    }
}
