import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a person's contact details
class PersonInfo {
    private String fullName;
    private String contactNumber;
    private String mailAddress;

    // Constructor
    public PersonInfo(String fullName, String contactNumber, String mailAddress) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.mailAddress = mailAddress;
    }

    // Getters and setters for contact details
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    // Display the contact information
    public void showContactDetails() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Phone Number: " + contactNumber);
        System.out.println("Email Address: " + mailAddress);
        System.out.println("---------------------");
    }
}

// Main class to manage contacts
public class ContactDirectory {
    private static ArrayList<PersonInfo> personList = new ArrayList<>();
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("=== Contact Directory System ===");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Modify Existing Contact");
            System.out.println("4. Remove a Contact");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");
            int userOption = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume the newline character

            switch (userOption) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    displayAllContacts();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    deleteExistingContact();
                    break;
                case 5:
                    exitProgram = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    // Add a new contact
    private static void addNewContact() {
        System.out.print("Enter the person's full name: ");
        String fullName = inputScanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = inputScanner.nextLine();
        System.out.print("Enter email address: ");
        String mailAddress = inputScanner.nextLine();

        PersonInfo newContact = new PersonInfo(fullName, contactNumber, mailAddress);
        personList.add(newContact);
        System.out.println("Contact successfully added!");
    }

    // Display all contacts
    private static void displayAllContacts() {
        if (personList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("=== Contact List ===");
            for (PersonInfo person : personList) {
                person.showContactDetails();
            }
        }
    }

    // Update an existing contact's information
    private static void updateExistingContact() {
        System.out.print("Enter the full name of the contact to update: ");
        String fullName = inputScanner.nextLine();

        for (PersonInfo person : personList) {
            if (person.getFullName().equalsIgnoreCase(fullName)) {
                System.out.print("Enter new contact number: ");
                String newNumber = inputScanner.nextLine();
                System.out.print("Enter new email address: ");
                String newEmail = inputScanner.nextLine();

                person.setContactNumber(newNumber);
                person.setMailAddress(newEmail);
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Delete a contact by name
    private static void deleteExistingContact() {
        System.out.print("Enter the full name of the contact to delete: ");
        String fullName = inputScanner.nextLine();

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFullName().equalsIgnoreCase(fullName)) {
                personList.remove(i);
                System.out.println("Contact removed successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
