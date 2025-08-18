import java.time.Instant;

public class Appointment {
    // Unique identifier for the appointment
    private String appointmentID;
    
    // Description of the appointment
    private String description;
    
    // Date and time of the appointment
    private Instant date;

    // Constructor to initialize the appointment with provided values
    public Appointment(String appointmentID, String description, Instant date) {
        this.appointmentID = appointmentID;
        this.description = description;
        this.date = date;
    }

    // Getter method for retrieving the appointment ID
    public String getAppointmentID() {
        return appointmentID;
    }

    // Getter method for retrieving the appointment description
    public String getDescription() {
        return description;
    }

    // Getter method for retrieving the appointment date and time
    public Instant getDate() {
        return date;
    }

    // Method to validate if the appointment ID matches the ID to be deleted
    public void validateDeleteAppointment(String appointmentIDToDelete) {
        // If the provided appointment ID does not match the current appointment's ID,
        // throw an IllegalArgumentException indicating that the appointment was not found.
        if (!appointmentID.equals(appointmentIDToDelete)) {
            throw new IllegalArgumentException("Appointment not found for ID: " + appointmentIDToDelete);
        }
    }
}
