import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;


public class ĆwiczenieLook1 {

    public static void main(String[] args) {

        // Wypisanie wszystkich dostępnych stylów
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        System.out.println("Dostępne style Laf:");
        for (UIManager.LookAndFeelInfo info : looks) {
            System.out.println(info.getName() + " -> " + info.getClassName());
        }

        // Proste okno
        JFrame frame = new JFrame("Laf");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.FlowLayout());

        frame.add(new JButton("Przycisk 1"));
        frame.add(new JButton("Przycisk 2"));
        frame.add(new JButton("Przycisk 3"));

        frame.setVisible(true);
    }
}