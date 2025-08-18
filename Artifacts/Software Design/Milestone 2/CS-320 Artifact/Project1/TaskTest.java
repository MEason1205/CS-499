import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    // Test for creating a valid Task
    @Test
    public void testValidTask() {
        Task task = new Task("123", "TaskName", "TaskDescription");
        assertEquals("123", task.getTaskID());
        assertEquals("TaskName", task.getTaskName());
        assertEquals("TaskDescription", task.getDescription());
    }

    // Test for setting the maximum allowed length for taskID
    @Test
    public void testTaskIDMaxLength() {
        Task task = new Task("1234567890", "TaskName", "TaskDescription");
        assertEquals("1234567890", task.getTaskID());
    }

    // Test for setting the minimum allowed length for taskID
    @Test
    public void testTaskIDMinLength() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        assertEquals("1", task.getTaskID());
    }

    // Test for attempting to set taskID exceeding the maximum allowed length
    @Test
    public void testTaskIDExceedsMaxLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new Task("12345678901", "TaskName", "TaskDescription"));
        assertEquals("Invalid taskID", exception.getMessage());
    }

    // Test for attempting to set taskID as null
    @Test
    public void testTaskIDNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new Task(null, "TaskName", "TaskDescription"));
        assertEquals("Invalid taskID", exception.getMessage());
    }

    // Similar tests for taskName and description...

    // Test for updating task with valid values
    @Test
    public void testTaskUpdateValidValues() {
        Task task = new Task("123", "TaskName", "TaskDescription");
        task.setTaskName("UpdatedName");
        task.setDescription("UpdatedDescription");
        assertEquals("UpdatedName", task.getTaskName());
        assertEquals("UpdatedDescription", task.getDescription());
    }

    // Test for updating taskName with an invalid value
    @Test
    public void testTaskUpdateInvalidName() {
        Task task = new Task("123", "TaskName", "TaskDescription");
        assertThrows(IllegalArgumentException.class, () ->
            task.setTaskName("ThisIsANameThatIsTooLong"));
    }

    // Test for updating description with an invalid value
    @Test
    public void testTaskUpdateInvalidDescription() {
        Task task = new Task("123", "TaskName", "TaskDescription");
        assertThrows(IllegalArgumentException.class, () ->
            task.setDescription("ThisIsADescriptionThatIsTooLong123456789123456789123"));
    }
}
