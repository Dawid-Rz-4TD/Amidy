import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {

    private final String[] columns = {"ID", "Tytuł", "Opis", "Zrobione"};
    private List<Task> tasks = new ArrayList<>();

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task t = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0: return t.getId();
            case 1: return t.getTitle();
            case 2: return t.getDescription();
            case 3: return t.isDone();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) return Boolean.class;
        if (columnIndex == 0) return Integer.class;
        return String.class;
    }
}
