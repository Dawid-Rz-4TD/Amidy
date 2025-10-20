import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LogListener implements ActionListener {
    //Główna ramka programu
    private final JFrame frame;
    //Panel logowania, potrzebny do pobrania loginu i hasła
    private PanelLogowania loginPanel;

    public void setPanel(PanelLogowania panelLogowania) {
        this.loginPanel = panelLogowania;
    }

    public LogListener(JFrame klatka2) {
        this.frame = klatka2;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if (Walidacja.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // panel z edytorem html
                    JPanel htmlPanel = new PanelHTML();
                    // usuwamy panel logowania
                    frame.getContentPane().removeAll();
                    // dodajemy panel html i odświeżamy widok
                    frame.add(htmlPanel);
                    frame.validate();
                }
            });
        }
    }
}
