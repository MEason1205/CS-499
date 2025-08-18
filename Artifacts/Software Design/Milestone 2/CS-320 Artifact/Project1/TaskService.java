import java.util.Map;
import java.util.HashMap;

public class TaskService {
    // Map to store tasks with their unique IDs
    private Map<String, Task> tasks;

    // Constructor to initialize the TaskService with an empty task map
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Method to add a new task to the service
    public void addTask(Task task) {
        // Check if a task with the same ID already exists
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task with the same ID already exists");
        }
        // Add the task to the map using its ID as the key
        tasks.put(task.getTaskID(), task);
    }

    // Method to delete a task based on its ID
    public void deleteTask(String taskID) {
        // Check if a task with the specified ID exists
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task with the specified ID does not exist");
        }
        // Remove the task from the map using its ID as the key
        tasks.remove(taskID);
    }

    // Method to update task details based on its ID
    public void updateTask(String taskID, String taskName, String description) {
        // Check if a task with the specified ID exists
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task with the specified ID does not exist");
        }

        // Retrieve the existing task from the map
        Task existingTask = tasks.get(taskID);

        // Update taskName if the new value is valid
        if (taskName != null && taskName.length() <= 20) {
            existingTask.setTaskName(taskName);
        } else if (taskName == null) {
            throw new IllegalArgumentException("Task name must not be null");
        } else {
            throw new IllegalArgumentException("Task name should not exceed 20 characters");
        }

        // Update description if the new value is valid
        if (description != null && description.length() <= 50) {
            existingTask.setDescription(description);
        } else if (description == null) {
            throw new IllegalArgumentException("Description must not be null");
        } else {
            throw new IllegalArgumentException("Description should not exceed 50 characters");
        }
    }

    // Method to retrieve a task based on its ID
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
