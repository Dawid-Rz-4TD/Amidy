
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {


    private static final String URL = "jdbc:mysql://localhost:3306/mysqlite";
    private static final String USER = "root";
    private static final String PASS = "";

    public TaskRepository() {
        initDb();
    }

    private void initDb() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255) NOT NULL," +
                "description TEXT," +
                "is_done TINYINT(1) NOT NULL" +
                ")";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT id, title, description, is_done FROM tasks";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                boolean done = rs.getInt("is_done") == 1;
                tasks.add(new Task(id, title, desc, done));
            }
        }
        return tasks;
    }

    public boolean addTask(String title, String description, boolean isDone) throws SQLException {
        String sql = "INSERT INTO tasks (title, description, is_done) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, isDone ? 1 : 0);
            return ps.executeUpdate() == 1;
        }
    }
}
