import java.time.Instant;

/**
 * Represents a single appointment with ID, description, and date.
 */
public class Appointment {
    public static final int MAX_DESC_LENGTH = 50;

    private String appointmentID;
    private String description;
    private Instant date;

    /** Default constructor (for frameworks) */
    public Appointment() {
    }

    /**
     * Full constructor with validation.
     */
    public Appointment(String appointmentID, String description, Instant date) {
        setAppointmentID(appointmentID);
        setDescription(description);
        setDate(date);
    }

    // Getters
    public String getAppointmentID() { return appointmentID; }
    public String getDescription()   { return description;   }
    public Instant getDate()         { return date;          }

    // Setters with the same validations the service layer expects

    public void setAppointmentID(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Appointment ID must not be null or empty");
        }
        this.appointmentID = id;
    }

    public void setDescription(String desc) {
        if (desc == null || desc.isBlank() || desc.length() > MAX_DESC_LENGTH) {
            throw new IllegalArgumentException(
                "Description must be non-null, non-empty, and at most " + MAX_DESC_LENGTH + " characters"
            );
        }
        this.description = desc;
    }

    public void setDate(Instant date) {
        if (date == null || date.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Date must be non-null and in the future");
        }
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment[id=" + appointmentID +
               ", desc=" + description +
               ", date=" + date + "]";
    }
}
