import java.time.Instant;

/**
 * Simple driver to compare List vs. Map operations.
 */
public class BenchmarkDemo {
    public static void main(String[] args) {
        ContactService cs = new ContactService();
        AppointmentService as = new AppointmentService();
        TaskService ts = new TaskService();

        final int N = 100_000;

        // Benchmark Contact add/get/delete
        Benchmark.measure("Contact add " + N, () -> {
            for (int i = 0; i < N; i++) {
                cs.addContact(new Contact("C"+i, "Ab", "Cd", "123", "Addr"));
            }
            return null;
        });
        Benchmark.measure("Contact get middle", () -> cs.getContact("C"+(N/2)));
        Benchmark.measure("Contact delete " + N, () -> {
            for (int i = 0; i < N; i++) {
                cs.deleteContact("C"+i);
            }
            return null;
        });

        // Similarly for Appointment
        Benchmark.measure("Appointment add " + N, () -> {
            for (int i = 0; i < N; i++) {
                as.addAppointment(new Appointment("A"+i, "Desc", Instant.now().plusSeconds(3600)));
            }
            return null;
        });
        Benchmark.measure("Appointment get middle", () -> as.getAppointment("A"+(N/2)));
        Benchmark.measure("Appointment delete " + N, () -> {
            for (int i = 0; i < N; i++) {
                as.deleteAppointment("A"+i);
            }
            return null;
        });

        // And for Task
        Benchmark.measure("Task add " + N, () -> {
            for (int i = 0; i < N; i++) {
                ts.addTask(new Task("T"+i, "Name", "Desc"));
            }
            return null;
        });
        Benchmark.measure("Task get middle", () -> ts.getTask("T"+(N/2)));
        Benchmark.measure("Task delete " + N, () -> {
            for (int i = 0; i < N; i++) {
                ts.deleteTask("T"+i);
            }
            return null;
        });
    }
}
