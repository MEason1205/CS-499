import java.util.HashMap;
import java.util.Map;

/**
 * Manages Task records with O(1) operations.
 */
public class TaskService {
    private static final int MAX_NAME = 20, MAX_DESC = 50;
    private final Map<String,Task> tasks = new HashMap<>();

    public boolean addTask(Task t) {
        validateTask(t);
        String id = t.getTaskID();
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Task ID exists: " + id);
        }
        tasks.put(id, t);
        return true;
    }

    public Task getTask(String id) {
        validateId(id);
        return tasks.get(id);
    }

    public boolean deleteTask(String id) {
        validateId(id);
        if (tasks.remove(id) == null) {
            throw new IllegalArgumentException("No task with ID: " + id);
        }
        return true;
    }

    public boolean updateTask(String id, String name, String desc) {
        validateId(id);
        validateName(name);
        validateDesc(desc);
        Task e = tasks.get(id);
        if (e == null) throw new IllegalArgumentException("No task with ID: " + id);
        e.setTaskName(name);
        e.setDescription(desc);
        return true;
    }

    // -------------- Validation Helpers --------------

    private void validateTask(Task t) {
        if (t == null) throw new IllegalArgumentException("Task must not be null");
        validateId(t.getTaskID());
        validateName(t.getTaskName());
        validateDesc(t.getDescription());
    }

    private void validateId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID must not be null/empty");
    }

    private void validateName(String n) {
        if (n == null || n.isBlank() || n.length() > MAX_NAME) {
            throw new IllegalArgumentException("Name must be 1–" + MAX_NAME + " chars");
        }
    }

    private void validateDesc(String d) {
        if (d == null || d.isBlank() || d.length() > MAX_DESC) {
            throw new IllegalArgumentException("Description must be 1–" + MAX_DESC + " chars");
        }
    }
}
