import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class DarkMode {

    private static JFrame frame;
    private static final String CONFIG_FILE = "config.properties";

    public static void main(String[] args) {

        loadTheme();

        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Dark Mode Laf");
            frame.setSize(600,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setJMenuBar(createMenu());

            frame.add(createMainPanel());

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JPanel createMainPanel(){

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.add(new JButton("Zapisz"));
        topPanel.add(new JTextField("Tekst",15));
        topPanel.add(new JCheckBox("Zaznacz"));

        panel.add(topPanel,BorderLayout.NORTH);

        String[] columns = {"ID","Nazwa","Status"};

        Object[][] data = {
                {1,"Task A","Done"},

        };

        JTable table = new JTable(data,columns);

        panel.add(new JScrollPane(table),BorderLayout.CENTER);

        return panel;
    }

    private static JMenuBar createMenu(){

        JMenuBar menuBar = new JMenuBar();

        JMenu viewMenu = new JMenu("Widok");

        JMenuItem light = new JMenuItem("Light Mode");
        JMenuItem dark = new JMenuItem("Dark Mode");

        light.addActionListener(e -> setTheme("light"));
        dark.addActionListener(e -> setTheme("dark"));

        viewMenu.add(light);
        viewMenu.add(dark);

        menuBar.add(viewMenu);

        return menuBar;
    }

    private static void setTheme(String theme){

        try{

            if(theme.equals("dark")){
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }else{
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            SwingUtilities.updateComponentTreeUI(frame);

            saveTheme(theme);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private static void saveTheme(String theme){

        try{
            Properties prop = new Properties();
            prop.setProperty("theme",theme);

            prop.store(new FileOutputStream(CONFIG_FILE),"App settings");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private static void loadTheme(){

        try{

            Properties prop = new Properties();
            prop.load(new FileInputStream(CONFIG_FILE));

            String theme = prop.getProperty("theme","light");

            if(theme.equals("dark")){
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }else{
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

        }catch(Exception e){

            try{
                UIManager.setLookAndFeel(new FlatLightLaf());
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }

    }

}