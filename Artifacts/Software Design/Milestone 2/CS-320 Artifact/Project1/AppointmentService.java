import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // Maximum length allowed for appointment descriptions
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    // Map to store appointments with their unique IDs
    private Map<String, Appointment> appointments = new HashMap<>();

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        // Validate the provided appointment details
        validateAppointment(appointment);

        // Check if an appointment with the same ID already exists
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment with ID " + appointment.getAppointmentID() + " already exists.");
        }

        // Add the new appointment to the map
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Method to update an appointment's ID (Not implemented)
    public void updateAppointmentID(String oldAppointmentID, String newAppointmentID) {
        // Implement the logic to update the appointment ID
        throw new UnsupportedOperationException("Updating appointment ID is not allowed.");
    }

    // Method to delete an appointment by its ID
    public void deleteAppointment(String appointmentID) {
        // Check if the appointment with the specified ID exists
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentID + " does not exist.");
        }

        // Remove the appointment from the map
        appointments.remove(appointmentID);
    }

    // Method to get an appointment by its ID (Not implemented)
    public Appointment getAppointment(String appointmentID) {
        // Implement the logic to get an appointment by ID
        return appointments.get(appointmentID);
    }

    // Private method to validate the details of an appointment
    private void validateAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        // Validate the description length
        validateDescription(appointment.getDescription());

        // Validate the appointment date
        validateDate(appointment.getDate());
    }

    // Private method to validate the length of the appointment description
    private void validateDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Invalid description.");
        }
    }

    // Private method to validate the appointment date
    private void validateDate(Instant date) {
        if (date == null || date.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Invalid appointment date.");
        }
    }
}
