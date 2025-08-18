import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import org.junit.jupiter.api.Test;

import Appointment;
import AppointmentService;

public class AppointmentServiceTest {

    // Test case to verify the addition of an appointment to the service
    @Test
    public void testAddAppointment() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Define a future Instant for the appointment
        Instant futureInstant = Instant.now().plusSeconds(86400);
        
        // Create an appointment with a unique ID, description, and future Instant
        Appointment appointment = new Appointment("123", "Appointment Description", futureInstant);
        
        // Add the appointment to the service
        appointmentService.addAppointment(appointment);
        
        // Verify that the added appointment can be retrieved by its ID
        assertEquals(appointment, appointmentService.getAppointment("123"));
    }

    // Test case to verify the deletion of an appointment from the service
    @Test
    public void testDeleteAppointment() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Define a future Instant for the appointment
        Instant futureInstant = Instant.now().plusSeconds(86400);
        
        // Create an appointment with a unique ID, description, and future Instant
        Appointment appointment = new Appointment("123", "Appointment Description", futureInstant);
        
        // Add the appointment to the service
        appointmentService.addAppointment(appointment);
        
        // Delete the appointment by its ID
        appointmentService.deleteAppointment("123");
        
        // Verify that the appointment with the specified ID is no longer present
        assertNull(appointmentService.getAppointment("123"));
    }

    // Test case to verify the retrieval of an appointment from the service
    @Test
    public void testGetAppointment() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Define a future Instant for the appointment
        Instant futureInstant = Instant.now().plusSeconds(86400);
        
        // Create an appointment with a unique ID, description, and future Instant
        Appointment appointment = new Appointment("123", "Appointment Description", futureInstant);
        
        // Add the appointment to the service
        appointmentService.addAppointment(appointment);
        
        // Verify that the added appointment can be retrieved by its ID
        assertEquals(appointment, appointmentService.getAppointment("123"));
    }

    // Test case to verify the prevention of adding an appointment with an existing ID
    @Test
    public void testAddAppointmentWithExistingID() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Define a future Instant for the appointments
        Instant futureInstant = Instant.now().plusSeconds(86400);
        
        // Create and add an appointment with a unique ID
        Appointment appointment = new Appointment("123", "Appointment Description", futureInstant);
        appointmentService.addAppointment(appointment);
        
        // Attempt to add another appointment with the same ID, expecting an exception
        assertThrows(IllegalArgumentException.class, () ->
                appointmentService.addAppointment(new Appointment("123", "Another Appointment", futureInstant)));
    }

    // Test case to verify the prevention of deleting a non-existent appointment
    @Test
    public void testDeleteNonExistentAppointment() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Attempt to delete an appointment with a non-existent ID, expecting an exception
        assertThrows(IllegalArgumentException.class, () ->
                appointmentService.deleteAppointment("nonExistentID"));
    }

    // Test case to verify a specific scenario or case
    @Test
    public void testSpecificCase() {
        // Create an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();
        
        // Define a future Instant for the appointment
        Instant futureInstant = Instant.now().plusSeconds(86400);
        
        // Create and add a special appointment with a unique ID
        Appointment appointment = new Appointment("SpecialID", "Special Meeting", futureInstant);
        appointmentService.addAppointment(appointment);
        
        // Verify that the added special appointment can be retrieved by its ID
        assertNotNull(appointmentService.getAppointment("SpecialID"));
    }
}
