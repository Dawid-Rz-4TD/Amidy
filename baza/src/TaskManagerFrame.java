import javax.swing.*;
import java.awt.*;

public class TaskManagerFrame extends JFrame {

    private final TaskRepository repo = new TaskRepository();
    private final TaskTableModel tableModel = new TaskTableModel();

    private JTable table;
    private JButton loadButton;
    private JButton addButton;
    private JLabel statusLabel;
    private JProgressBar progressBar;

    private JTextField titleField;
    private JTextField descField;
    private JCheckBox doneCheckBox;

    public TaskManagerFrame() {
        super("Prosty Menedżer Zadań");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("Tytuł:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Opis:"));
        descField = new JTextField();
        formPanel.add(descField);

        formPanel.add(new JLabel("Zrobione:"));
        doneCheckBox = new JCheckBox();
        formPanel.add(doneCheckBox);

        add(formPanel, BorderLayout.NORTH);


        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        loadButton = new JButton("Wczytaj Zadania");
        addButton = new JButton("Dodaj Zadanie");
        buttonPanel.add(loadButton);
        buttonPanel.add(addButton);

        bottomPanel.add(buttonPanel, BorderLayout.WEST);

        statusLabel = new JLabel("Gotowe.");
        bottomPanel.add(statusLabel, BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setVisible(false);
        bottomPanel.add(progressBar, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);


        initActions();

        pack();
        setLocationRelativeTo(null);
    }

    private void initActions() {

        loadButton.addActionListener(e -> {

            statusLabel.setText("Ładowanie danych... Proszę czekać.");
            loadButton.setEnabled(false);
            progressBar.setIndeterminate(true);
            progressBar.setVisible(true);

            LoadTasksWorker worker =
                    new LoadTasksWorker(repo, tableModel, statusLabel, loadButton, progressBar);
            worker.execute();
        });


        addButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String desc = descField.getText().trim();
            boolean done = doneCheckBox.isSelected();

            if (title.isEmpty()) {
                statusLabel.setText("Tytuł nie może być pusty.");
                return;
            }

            statusLabel.setText("Dodawanie zadania...");

            Runnable reload = () -> {
                SwingUtilities.invokeLater(() -> {
                    loadButton.setEnabled(false);
                    statusLabel.setText("Odświeżanie danych...");
                    progressBar.setIndeterminate(true);
                    progressBar.setVisible(true);
                    new LoadTasksWorker(repo, tableModel, statusLabel, loadButton, progressBar).execute();
                });
            };

            AddTaskWorker addWorker = new AddTaskWorker(repo, title, desc, done, statusLabel, reload);
            addWorker.execute();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerFrame().setVisible(true));
    }
}
