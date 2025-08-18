import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Gather contact info from user
            System.out.print("Enter contact ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter phone number (e.g., 123-456-7890): ");
            String phone = scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            // 2. Create contact object
            Contact newContact = new Contact(id, firstName, lastName, phone, address);

            // 3. Add contact to DB
            ContactDAO dao = new ContactDAO();
            dao.addContact(newContact);
            System.out.println("\n✅ Contact added successfully!");

            // 4. Prompt user to search by ID
            System.out.print("\nEnter ID to search: ");
            String searchId = scanner.nextLine();

            Contact result = dao.getContact(searchId);
            if (result != null) {
                System.out.println("\n📇 Contact Found:");
                System.out.println("ID: " + result.getId());
                System.out.println("Name: " + result.getFirstName() + " " + result.getLastName());
                System.out.println("Phone: " + result.getPhone());
                System.out.println("Address: " + result.getAddress());
            } else {
                System.out.println("\n❌ No contact found with ID: " + searchId);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
