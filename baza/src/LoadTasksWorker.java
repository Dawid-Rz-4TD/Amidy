import javax.swing.*;
        import java.util.List;

public class LoadTasksWorker extends SwingWorker<List<Task>, Void> {

    private final TaskRepository repo;
    private final TaskTableModel tableModel;
    private final JLabel statusLabel;
    private final JButton loadButton;
    private final JProgressBar progressBar;

    public LoadTasksWorker(TaskRepository repo,
                           TaskTableModel tableModel,
                           JLabel statusLabel,
                           JButton loadButton,
                           JProgressBar progressBar) {
        this.repo = repo;
        this.tableModel = tableModel;
        this.statusLabel = statusLabel;
        this.loadButton = loadButton;
        this.progressBar = progressBar;
    }

    @Override
    protected List<Task> doInBackground() throws Exception {
        Thread.sleep(4000);
        return repo.getAllTasks();
    }

    @Override
    protected void done() {
        try {
            List<Task> tasks = get();
            tableModel.setTasks(tasks);
            statusLabel.setText("Gotowe. Wczytano " + tasks.size() + " zadań.");
        } catch (Exception e) {
            statusLabel.setText("Błąd podczas wczytywania: " + e.getMessage());
        } finally {
            loadButton.setEnabled(true);
            if (progressBar != null) {
                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
            }
        }
    }
}
