import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test case for setting first name to null
    @Test
    void testFirstNameNull() {
        // Arrange
        Contact contact = new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");

        // Act
        contact.setFirstName(null);

        // Assert
        assertNull(contact.getFirstName());
    }

    // Test case for setting first name that exceeds maximum length
    @Test
    void testFirstNameExceedsMaxLength() {
        // Arrange
        Contact contact = new Contact();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            StringBuilder longName = new StringBuilder();
            for (int i = 0; i < Contact.MAX_NAME_LENGTH + 1; i++) {
                longName.append("A");
            }
            contact.setFirstName(longName.toString());
        });
    }

    // Test case for setting address to null
    @Test
    void testAddressNull() {
        // Arrange
        Contact contact = new Contact();

        // Act
        contact.setAddress(null);

        // Assert
        assertNull(contact.getAddress());
    }

    // Test case for setting contact ID to maximum length
    @Test
    void testContactIDMaxLength() {
        // Arrange
        Contact contact = new Contact();

        // Act
        Exception exception = null;
        try {
            StringBuilder maxContactID = new StringBuilder();
            for (int i = 0; i < Contact.MAX_NAME_LENGTH; i++) {
                maxContactID.append("A");
            }
            contact.setContactID(maxContactID.toString());
        } catch (Exception e) {
            exception = e;
        }

        // Assert
        assertNull(exception);
    }

    // Test case for setting first name to maximum length
    @Test
    void testFirstNameMaxLength() {
        // Arrange
        Contact contact = new Contact();

        // Act
        Exception exception = null;
        try {
            StringBuilder maxFirstName = new StringBuilder();
            for (int i = 0; i < Contact.MAX_NAME_LENGTH; i++) {
                maxFirstName.append("A");
            }
            contact.setFirstName(maxFirstName.toString());
        } catch (Exception e) {
            exception = e;
        }

        // Assert
        assertNull(exception);
    }

    // Test case for checking object equality with the same contact
    @Test
    void testEqualsSameContact() {
        // Arrange
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Act & Assert
        assertTrue(contact1.equals(contact2));
    }

    // Test case for checking object equality with different contacts
    @Test
    void testEqualsDifferentContact() {
        // Arrange
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("0987654321", "Jane", "Doe", "9876543210", "456 Side St");

        // Act & Assert
        assertFalse(contact1.equals(contact2));
    }
}
