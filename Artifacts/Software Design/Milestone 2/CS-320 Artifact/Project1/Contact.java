import java.util.Objects;

public class Contact {
    // Maximum length for the first and last names
    public static final int MAX_NAME_LENGTH = 10;

    // Fields to represent contact information
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Default constructor
    public Contact() {
        // Initialize default values or leave them null
    }

    // Constructor with parameter validation
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Validate and initialize fields
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getter Methods
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter Methods with Validation
    public void setContactID(String contactID) {
        // Validate and set the contact ID
        if (contactID != null && contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID should not exceed 10 characters");
        }
        this.contactID = contactID;
    }

    public void setFirstName(String firstName) {
        // Validate and set the first name
        if (firstName != null && firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name should not exceed " + MAX_NAME_LENGTH + " characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        // Validate and set the last name
        if (lastName != null && lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name should not exceed 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        // Validate and set the phone number
        if (phone != null && phone.length() != 10) {
            throw new IllegalArgumentException("Phone number should be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        // Validate and set the address
        if (address != null && address.length() > 30) {
            throw new IllegalArgumentException("Address should not exceed 30 characters");
        }
        this.address = address;
    }

    // Override the equals method to compare Contact objects based on their fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactID, contact.contactID) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(phone, contact.phone) &&
                Objects.equals(address, contact.address);
    }

    // Override the hashCode method to generate a hash code based on the Contact fields
    @Override
    public int hashCode() {
        return Objects.hash(contactID, firstName, lastName, phone, address);
    }
}
