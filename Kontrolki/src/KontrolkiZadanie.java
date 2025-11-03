import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontrolkiZadanie extends JFrame{
    private JTextField wiek;
    private JCheckBox regulamin;
    private JButton confirm;

    public KontrolkiZadanie(){
        super("Formularz Weryfikacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 400);
        JLabel nazwaWiek = new JLabel("Podaj swoj wiek:");
        wiek = new JTextField(10);

        regulamin = new JCheckBox("Przeczytałem i akceptuje regulamin");
        confirm = new JButton("Zatwierdz");

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wiekText = wiek.getText();
                Integer.parseInt(wiekText);
                boolean accept = regulamin.isSelected();
           try {
               int wiekLiczba = Integer.parseInt(wiekText);

               if (wiekLiczba>=18 && wiekLiczba <= 100&& accept){
                   JOptionPane.showMessageDialog(KontrolkiZadanie.this,"Weryfikacja pomyślna",":)",JOptionPane.INFORMATION_MESSAGE);
               }

               else {
                   JOptionPane.showMessageDialog(KontrolkiZadanie.this, "Wymagany wiek 18+ i akceptacja regulaminu!", "Błąd.", JOptionPane.ERROR_MESSAGE);
               }

           }

           finally {

           }
           }




        });
this.add(nazwaWiek);
this.add(wiek);
this.add(regulamin);
this.add(confirm);


this.setLocationRelativeTo(null);
this.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(KontrolkiZadanie::new);
    }
}
