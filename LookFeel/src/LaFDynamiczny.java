import javax.swing.*;
import java.awt.*;

public class LaFDynamiczny {

    private static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame("Dynamiczny LaF");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        String[] lookNames = new String[looks.length];
        for(int i=0;i<looks.length;i++){
            lookNames[i] = looks[i].getName();
        }

        JComboBox<String> combo = new JComboBox<>(lookNames);

        combo.addActionListener(e -> {
            int index = combo.getSelectedIndex();

            try {
                UIManager.setLookAndFeel(looks[index].getClassName());
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.add(combo);
        frame.add(new JButton("Przycisk"));
        frame.add(new JTextField("Pole tekstowe",10));

        frame.setVisible(true);
    }
}