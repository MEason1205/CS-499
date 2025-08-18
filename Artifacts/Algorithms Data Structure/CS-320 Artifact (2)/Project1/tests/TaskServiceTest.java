import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Task;
import TaskService;

class TaskServiceTest {
    
    @Test
    void testAddTask() {
        // Create a TaskService and a new Task
        TaskService taskService = new TaskService();
        Task task = new Task("123", "TaskName", "TaskDescription");

        // Add the task to the service and assert it can be retrieved by ID
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("123"));
    }

    @Test
    void testDeleteTask() {
        // Create a TaskService and a new Task
        TaskService taskService = new TaskService();
        Task task = new Task("123", "TaskName", "TaskDescription");

        // Add the task to the service, delete it, and assert it cannot be retrieved anymore
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.getTask("123"));
    }

    @Test
    void testUpdateTask() {
        // Create a TaskService and a new Task
        TaskService taskService = new TaskService();
        Task task = new Task("123", "TaskName", "TaskDescription");

        // Add the task to the service, update it, and assert the updates are reflected
        taskService.addTask(task);
        taskService.updateTask("123", "UpdatedTaskName", "UpdatedTaskDescription");
        Task updatedTask = taskService.getTask("123");

        assertEquals("UpdatedTaskName", updatedTask.getTaskName());
        assertEquals("UpdatedTaskDescription", updatedTask.getDescription());
    }

    @Test
    void testUpdateNonExistentTask() {
        // Create a TaskService and attempt to update a non-existent task, expecting an exception
        TaskService taskService = new TaskService();

        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTask("nonExistentID", "UpdatedTaskName", "UpdatedTaskDescription"));
    }

    @Test
    void testAddDuplicateTask() {
        // Create a TaskService and add a task, then attempt to add a duplicate, expecting an exception
        TaskService taskService = new TaskService();
        Task task = new Task("123", "TaskName", "TaskDescription");

        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () ->
                taskService.addTask(new Task("123", "AnotherTask", "AnotherDescription")));
    }

    @Test
    void testDeleteNonExistentTask() {
        // Create a TaskService and attempt to delete a non-existent task, expecting an exception
        TaskService taskService = new TaskService();

        assertThrows(IllegalArgumentException.class, () ->
                taskService.deleteTask("nonExistentID"));
    }

    @Test
    void testUpdateWithInvalidValues() {
        // Create a TaskService and a task, then attempt to update it with invalid values, expecting an exception
        TaskService taskService = new TaskService();
        Task task = new Task("123", "TaskName", "TaskDescription");

        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTask("123", "ThisIsANameThatIsTooLong", "ThisIsADescriptionThatIsTooLong"));
    }
}
