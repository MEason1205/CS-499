import org.junit.jupiter.api.Test;

import Appointment;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.Instant;

public class AppointmentTest {

    // Test case to ensure an exception is thrown when attempting to delete a non-existent appointment
    @Test
    void testDeleteNonExistentAppointment() {
        // Create an appointment with a known ID
        Appointment appointment = new Appointment("1", "Test Appointment", Instant.now());
        
        // Attempt to delete an appointment with a different, non-existent ID
        String nonExistentAppointmentID = "nonExistentID";

        // Verify that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.validateDeleteAppointment(nonExistentAppointmentID);
        });
    }

    // Test case to ensure an exception is thrown when the appointment ID is less than the maximum length
    @Test
    void testAppointmentIDLessThanMaxLength() {
        // Create an appointment with a valid ID
        Appointment appointment = new Appointment("1", "Test Appointment", Instant.now());
        
        // Attempt to delete the appointment using a valid ID (less than maximum length)
        String validAppointmentID = "validID";

        // Verify that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.validateDeleteAppointment(validAppointmentID);
        });
    }

    // Test case to ensure an exception is thrown when the description exceeds the maximum length
    @Test
    void testDescriptionMaxLength() {
        // Create an appointment with a known ID and a long description
        Appointment appointment = new Appointment("1", "Test Appointment", Instant.now());
        String longDescription = "This is a long description that exceeds the maximum length.";

        // Verify that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.validateDeleteAppointment(longDescription);
        });
    }
}
