import org.junit.jupiter.api.Test;

import Contact;
import ContactService;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        // Test adding a contact to the ContactService and verifying it can be retrieved by ID
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        // Test adding a contact, deleting it, and verifying it cannot be retrieved anymore
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);

        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        // Test adding a contact, updating its fields, and verifying the updates are reflected
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);
        System.out.println("Original Contact: " + contact);

        contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Elm St");
        Contact updatedContact = contactService.getContact("1234567890");

        System.out.println("Updated Contact: " + updatedContact);

        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        // Test attempting to update a non-existent contact, expecting an exception
        ContactService contactService = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContact("nonExistentID", "Jane", "Smith", "9876543210", "456 Elm St"));
    }

    @Test
    public void testAddDuplicateContact() {
        // Test adding a contact and attempting to add another with the same ID, expecting an exception
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Elm St")));
    }

    @Test
    public void testDeleteNonExistentContact1() {
        // Test attempting to delete a non-existent contact, expecting an exception
        ContactService contactService = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                contactService.deleteContact("nonExistentID"));
    }

    @Test
    public void testUpdateWithInvalidValues() {
        // Test attempting to update a contact with invalid values, expecting an exception
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContact("1234567890", "ThisIsANameThatIsTooLong", "Smith", "9876543210", "456 Elm St"));
    }

    @Test
    void testAddMultipleContacts() {
        // Test adding multiple contacts with unique IDs and verifying they can be retrieved
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("9876543210", "Jane", "Smith", "9876543210", "456 Elm St");

        contactService.addContact(contact1);
        contactService.addContact(contact2);

        assertNotNull(contactService.getContact("1234567890"));
        assertNotNull(contactService.getContact("9876543210"));
    }

    @Test
    void testAddContactWithMaxLengthFields() {
        // Test adding a contact with maximum allowed lengths for fields and verifying it can be retrieved
        ContactService contactService = new ContactService();

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St, Apt 10");

        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    void testDeleteContactWhenOnlyOneExists() {
        // Test adding a contact, deleting it, and verifying it cannot be retrieved anymore
        ContactService contactService = new ContactService();

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("1234567890");

        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    void testDeleteNonExistentContact() {
        // Test attempting to delete a non-existent contact, expecting an exception
        ContactService contactService = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                contactService.deleteContact("nonExistentID"));
    }

    @Test
    void testUpdateContactWithMinAndMaxLengthFields() {
        // Test adding a contact, updating it with minimum and maximum allowed lengths for fields, and verifying the updates
        ContactService contactService = new ContactService();

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "A", "B", "9876543210", "X");

        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("A", updatedContact.getFirstName());
        assertEquals("B", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("X", updatedContact.getAddress());
    }

    @Test
    void testUpdateContactWithSameValues() {
        // Test adding a contact, updating it with the same values, and verifying it remains unchanged
        ContactService contactService = new ContactService();

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        Contact unchangedContact = contactService.getContact("1234567890");
        assertEquals(contact, unchangedContact);
    }

    @Test
    void testUpdateContactWithMaxLengthContactID() {
        // Test adding a contact, updating it with the maximum allowed length for contact ID, and verifying the updates
        ContactService contactService = new ContactService();

        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Elm St");

        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
}
