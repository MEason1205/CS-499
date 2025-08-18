public class Task {

    // Fields to store task information
    private String taskID;
    private String taskName;
    private String description;

    // Constructor to initialize Task object with validation
    public Task(String taskID, String taskName, String description) {
        // Validate and set the taskID
        if (taskID == null || taskID.length() < 1 || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid taskID");
        }
        
        // Validate and set the taskName
        if (taskName == null || taskName.length() < 1 || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid taskName");
        }
        
        // Validate and set the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        
        // Initialize the fields
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
    }

    // Getter method to retrieve taskID
    public String getTaskID() {
        return taskID;
    }

    // Getter method to retrieve taskName
    public String getTaskName() {
        return taskName;
    }

    // Getter method to retrieve description
    public String getDescription() {
        return description;
    }

    // Setter method to update taskName with validation
    public void setTaskName(String taskName) {
        // Validate and update the taskName
        if (taskName == null || taskName.length() < 1 || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid taskName");
        }
        this.taskName = taskName;
    }

    // Setter method to update description with validation
    public void setDescription(String description) {
        // Validate and update the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
