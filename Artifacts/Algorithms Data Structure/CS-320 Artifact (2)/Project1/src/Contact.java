/**
 * Represents a single contact with first name, last name, phone, and address.
 */
public class Contact {
    public static final int MAX_NAME_LENGTH    = 10;
    public static final int MAX_PHONE_LENGTH   = 10;
    public static final int MAX_ADDRESS_LENGTH = 30;

    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact() {
    }

    public Contact(String contactID, String firstName, String lastName,
                   String phone, String address) {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getters
    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public String getPhone()     { return phone;     }
    public String getAddress()   { return address;   }

    // Setters with validation
    public void setContactID(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Contact ID must not be null or empty");
        }
        this.contactID = id;
    }

    public void setFirstName(String fn) {
        if (fn == null || fn.isBlank() || fn.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name must be 1–" + MAX_NAME_LENGTH + " chars");
        }
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        if (ln == null || ln.isBlank() || ln.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must be 1–" + MAX_NAME_LENGTH + " chars");
        }
        this.lastName = ln;
    }

    public void setPhone(String ph) {
        if (ph == null || ph.isBlank() || ph.length() > MAX_PHONE_LENGTH) {
            throw new IllegalArgumentException("Phone must be 1–" + MAX_PHONE_LENGTH + " chars");
        }
        this.phone = ph;
    }

    public void setAddress(String addr) {
        if (addr == null || addr.isBlank() || addr.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be 1–" + MAX_ADDRESS_LENGTH + " chars");
        }
        this.address = addr;
    }

    @Override
    public String toString() {
        return "Contact[id=" + contactID +
               ", first=" + firstName +
               ", last=" + lastName +
               ", phone=" + phone +
               ", addr=" + address + "]";
    }
}
