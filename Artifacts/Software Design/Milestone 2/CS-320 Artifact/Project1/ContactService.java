import java.util.Map;
import java.util.HashMap;

public class ContactService {
    // Data structure to store contacts using their IDs as keys
    private Map<String, Contact> contacts;

    // Constructor to initialize the contacts data structure
    public ContactService() {
        // Initialize the contacts data structure
        contacts = new HashMap<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        // Check if a contact with the same ID already exists
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with the same ID already exists");
        }

        // Add the contact to the contacts map
        contacts.put(contact.getContactID(), contact);
    }

    // Method to delete a contact by contact ID
    public void deleteContact(String contactID) {
        // Check if the contact with the specified ID exists
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with the specified ID does not exist");
        }

        // Remove the contact from the contacts map
        contacts.remove(contactID);
    }

    // Method to update contact information
    public void updateContact(String existingContactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
        // Check if the contact with the specified ID exists
        if (!contacts.containsKey(existingContactID)) {
            throw new IllegalArgumentException("Contact with the specified ID does not exist");
        }

        // Get the existing contact
        Contact existingContact = contacts.get(existingContactID);

        // Print the original state of the contact for debugging
        System.out.println("Original Contact in updateContact: " + existingContact);

        // Attempt to update the first name
        try {
            existingContact.setFirstName(newFirstName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("First name must not be null and should not exceed 10 characters");
        }

        // Update other fields
        try {
            // Update last name
            existingContact.setLastName(newLastName);

            // Update phone
            existingContact.setPhone(newPhone);

            // Update address
            existingContact.setAddress(newAddress);
        } catch (IllegalArgumentException e) {
            // If any of the field updates fail, revert the first name and re-throw the exception
            existingContact.setFirstName(existingContact.getFirstName());
            throw e;
        }

        // Print the updated state of the contact for debugging
        System.out.println("Updated Contact in updateContact: " + existingContact);
    }

    // Method to get a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
