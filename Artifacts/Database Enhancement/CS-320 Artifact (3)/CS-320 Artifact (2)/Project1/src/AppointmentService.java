import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages Appointment records with O(1) operations.
 */
public class AppointmentService {
    private static final int MAX_DESC = 50;
    private final Map<String,Appointment> appts = new HashMap<>();

    public boolean addAppointment(Appointment a) {
        validateAppointment(a);
        String id = a.getAppointmentID();
        if (appts.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID exists: " + id);
        }
        appts.put(id, a);
        return true;
    }

    public Appointment getAppointment(String id) {
        validateId(id);
        return appts.get(id);
    }

    public boolean deleteAppointment(String id) {
        validateId(id);
        if (appts.remove(id) == null) {
            throw new IllegalArgumentException("No appointment with ID: " + id);
        }
        return true;
    }

    public boolean updateAppointment(String id, String desc, Instant date) {
        validateId(id);
        validateDescription(desc);
        validateDate(date);
        Appointment existing = appts.get(id);
        if (existing == null) throw new IllegalArgumentException("No appointment with ID: " + id);
        existing.setDescription(desc);
        existing.setDate(date);
        return true;
    }

    // -------------- Validation Helpers --------------

    private void validateAppointment(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment must not be null");
        validateId(a.getAppointmentID());
        validateDescription(a.getDescription());
        validateDate(a.getDate());
    }

    private void validateId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID must not be null/empty");
    }

    private void validateDescription(String d) {
        if (d == null || d.isBlank() || d.length() > MAX_DESC) {
            throw new IllegalArgumentException("Description must be 1–" + MAX_DESC + " chars");
        }
    }

    private void validateDate(Instant dt) {
        if (dt == null || dt.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Date must be in the future");
        }
    }
}
