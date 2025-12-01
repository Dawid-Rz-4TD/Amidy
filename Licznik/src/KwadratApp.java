import javax.swing.*;
public class KwadratApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Kalkulator Kwadratu");


            KwadratModel model = new KwadratModel();
            KwadratView view = new KwadratView();


            new KwadratController(model, view);


            frame.add(view);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
