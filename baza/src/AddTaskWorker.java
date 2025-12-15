import javax.swing.*;

public class AddTaskWorker extends SwingWorker<Boolean, Void> {

    private final TaskRepository repo;
    private final String title;
    private final String description;
    private final boolean isDone;
    private final JLabel statusLabel;
    private final Runnable reloadAction;

    public AddTaskWorker(TaskRepository repo,
                         String title,
                         String description,
                         boolean isDone,
                         JLabel statusLabel,
                         Runnable reloadAction) {
        this.repo = repo;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.statusLabel = statusLabel;
        this.reloadAction = reloadAction;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        return repo.addTask(title, description, isDone);
    }

    @Override
    protected void done() {
        try {
            boolean ok = get();
            if (ok) {
                statusLabel.setText("Zadanie dodane poprawnie.");
                if (reloadAction != null) {
                    reloadAction.run();
                }
            } else {
                statusLabel.setText("Nie udało się dodać zadania.");
            }
        } catch (Exception e) {
            statusLabel.setText("Błąd podczas dodawania: " + e.getMessage());
        }
    }
}
