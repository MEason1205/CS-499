import java.sql.SQLException;
import java.util.List;

public class ContactService {
    private final ContactDAO dao = new ContactDAO();

    public void addContact(Contact contact) {
        try {
            dao.addContact(contact);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding contact", e);
        }
    }

    public Contact getContact(String id) {
        try {
            return dao.getContact(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving contact", e);
        }
    }

    public void deleteContact(String id) {
        try {
            dao.deleteContact(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting contact", e);
        }
    }

    public void updateContact(Contact contact) {
        try {
            dao.updateContact(contact);
        } catch (SQLException e) {
            throw new RuntimeException("Error updating contact", e);
        }
    }

    public List<Contact> getAllContacts() {
        try {
            return dao.getAllContacts();
        } catch (SQLException e) {
            throw new RuntimeException("Error listing contacts", e);
        }
    }
}
