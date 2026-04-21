package org.example;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    static String currentUser = null;
    static String currentRole = null;

    private JLabel statusPanel;
    private JMenu menuSprzedaz;
    private JMenu menuRaporty;
    private JMenu menuAdmin;

    public Main() {
        setTitle("System Sklepu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenu();
        initStatusBar();
    }

    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();


        menuSprzedaz = new JMenu("Sprzedaż");
        JMenuItem itemNowaSprzedaz = new JMenuItem("Nowa transakcja");
        JMenuItem itemHistoria = new JMenuItem("Historia dzisiejsza");

        itemNowaSprzedaz.addActionListener(e -> JOptionPane.showMessageDialog(this, "Otwieranie modułu sprzedaży..."));

        menuSprzedaz.add(itemNowaSprzedaz);
        menuSprzedaz.add(itemHistoria);


        menuRaporty = new JMenu("Raporty");
        JMenuItem itemRaportDzienny = new JMenuItem("Raport dobowy");
        JMenuItem itemRaportMiesieczny = new JMenuItem("Podsumowanie miesiąca");

        itemRaportDzienny.addActionListener(e -> JOptionPane.showMessageDialog(this, "Generowanie raportu dobowego..."));

        menuRaporty.add(itemRaportDzienny);
        menuRaporty.add(itemRaportMiesieczny);


        menuAdmin = new JMenu("Zarządzanie użytkownikami");
        JMenuItem itemListaUzytkownikow = new JMenuItem("Lista użytkowników");
        JMenuItem itemDodajUzytkownika = new JMenuItem("Dodaj nowego pracownika");
        JMenuItem itemUprawnienia = new JMenuItem("Zmień uprawnienia");

        itemListaUzytkownikow.addActionListener(e -> JOptionPane.showMessageDialog(this, "Ładowanie listy użytkowników z bazy..."));

        menuAdmin.add(itemListaUzytkownikow);
        menuAdmin.add(itemDodajUzytkownika);
        menuAdmin.addSeparator(); // Linia oddzielająca
        menuAdmin.add(itemUprawnienia);

        menuBar.add(menuSprzedaz);
        menuBar.add(menuRaporty);
        menuBar.add(menuAdmin);

        setJMenuBar(menuBar);
    }

    private void initStatusBar() {
        statusPanel = new JLabel("Proszę się zalogować...");
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void updateUiByRole() {
        if(currentRole.equals("USER")) {
            menuAdmin.setVisible(false);
            // Zablokujmy np. tylko raporty miesięczne dla zwykłego usera
            menuRaporty.getItem(1).setEnabled(false);
        } else {
            menuAdmin.setVisible(true);
            menuRaporty.getItem(1).setEnabled(true);
        }
        statusPanel.setText("Zalogowano jako: " + currentUser + " | Rola: " + currentRole);
    }

    private static void showLoginDialog(Main mainFrame){
        JDialog dialog = new JDialog(mainFrame, "Logowanie do systemu", true);
        dialog.setSize(300, 180);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));
        dialog.setLocationRelativeTo(null);

        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        dialog.add(new JLabel("  Użytkownik:"));
        dialog.add(loginField);
        dialog.add(new JLabel("  Hasło:"));
        dialog.add(passwordField);

        JButton loginButton = new JButton("Zaloguj");
        dialog.add(new JLabel());
        dialog.add(loginButton);

        loginButton.addActionListener(e ->  {
            String username = loginField.getText();
            String password = new String(passwordField.getPassword());

            if(username.equals("admin") && password.equals("admin123")) {
                currentUser = "Administrator";
                currentRole = "ADMIN";
                dialog.dispose();
                mainFrame.updateUiByRole();
                mainFrame.setVisible(true);
            } else if (username.equals("user") && password.equals("user123")) {
                currentUser = "Kasjer";
                currentRole = "USER";
                dialog.dispose();
                mainFrame.updateUiByRole();
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(dialog, "Błędny login lub hasło!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    public static void main(String[] args) {

        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            showLoginDialog(app);
        });
    }
}
