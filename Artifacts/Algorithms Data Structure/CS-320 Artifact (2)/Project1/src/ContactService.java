import java.util.HashMap;
import java.util.Map;

/**
 * Manages Contact records with O(1) operations.
 */
public class ContactService {
    private final Map<String,Contact> contacts = new HashMap<>();

    public boolean addContact(Contact c) {
        validateContact(c);
        String id = c.getContactID();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists: " + id);
        }
        contacts.put(id, c);
        return true;
    }

    public Contact getContact(String id) {
        validateId(id);
        return contacts.get(id);
    }

    public boolean deleteContact(String id) {
        validateId(id);
        if (contacts.remove(id) == null) {
            throw new IllegalArgumentException("No contact with ID: " + id);
        }
        return true;
    }

    public boolean updateContact(String id, String fn, String ln, String ph, String addr) {
        validateId(id);
        Contact existing = contacts.get(id);
        if (existing == null) {
            throw new IllegalArgumentException("No contact with ID: " + id);
        }
        validateName(fn, "First name");
        validateName(ln, "Last name");
        validatePhone(ph);
        validateAddress(addr);

        existing.setFirstName(fn);
        existing.setLastName(ln);
        existing.setPhone(ph);
        existing.setAddress(addr);
        return true;
    }

    // -------------- Validation Helpers --------------

    private void validateContact(Contact c) {
        if (c == null) throw new IllegalArgumentException("Contact must not be null");
        validateId(c.getContactID());
    }

    private void validateId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID must not be null/empty");
    }

    private void validateName(String val, String field) {
        if (val == null || val.isBlank() || val.length() > 10) {
            throw new IllegalArgumentException(field + " must be 1–10 chars");
        }
    }

    private void validatePhone(String ph) {
        if (ph == null || ph.isBlank() || ph.length() > 10) {
            throw new IllegalArgumentException("Phone must be 1–10 chars");
        }
    }

    private void validateAddress(String a) {
        if (a == null || a.isBlank() || a.length() > 30) {
            throw new IllegalArgumentException("Address must be 1–30 chars");
        }
    }
}
