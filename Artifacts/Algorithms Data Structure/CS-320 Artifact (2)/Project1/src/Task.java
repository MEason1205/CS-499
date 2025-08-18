/**
 * Represents a single task with name and description.
 */
public class Task {
    public static final int MAX_NAME_LENGTH        = 20;
    public static final int MAX_DESCRIPTION_LENGTH = 50;

    private String taskID;
    private String taskName;
    private String description;

    public Task() {
    }

    public Task(String taskID, String taskName, String description) {
        setTaskID(taskID);
        setTaskName(taskName);
        setDescription(description);
    }

    // Getters
    public String getTaskID()       { return taskID;    }
    public String getTaskName()     { return taskName;  }
    public String getDescription()  { return description; }

    // Setters with validation
    public void setTaskID(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Task ID must not be null or empty");
        }
        this.taskID = id;
    }

    public void setTaskName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Task name must be 1–" + MAX_NAME_LENGTH + " chars");
        }
        this.taskName = name;
    }

    public void setDescription(String desc) {
        if (desc == null || desc.isBlank() || desc.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description must be 1–" + MAX_DESCRIPTION_LENGTH + " chars");
        }
        this.description = desc;
    }

    @Override
    public String toString() {
        return "Task[id=" + taskID +
               ", name=" + taskName +
               ", desc=" + description + "]";
    }
}
