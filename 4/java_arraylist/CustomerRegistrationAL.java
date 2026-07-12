import java.util.ArrayList;
import java.util.Scanner;

// US001 (ArrayList): Customer Registration - Create/Update/Delete using ArrayList

class CustomerAL {
    int consumerID;
    int billNumber;
    String title;
    String customerName;
    String email;
    String mobileNumber;
    String userID;
    String password;
    String confirmPassword;

    CustomerAL(int consumerID, int billNumber, String title, String customerName,
               String email, String mobileNumber, String userID, String password, String confirmPassword) {
        this.consumerID = consumerID;
        this.billNumber = billNumber;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userID = userID;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return String.format("%-15d | %-10s | %-20s | %-30s | %-15s",
                consumerID, title, customerName, email, mobileNumber);
    }
}

public class CustomerRegistrationAL {

    static ArrayList<CustomerAL> customers = new ArrayList<>();

    // Add Customer
    static void addCustomer(Scanner sc) {
        System.out.println("\n--- Add Customer ---");
        System.out.print("Consumer ID (13 digit): ");
        int consumerID = sc.nextInt();
        sc.nextLine();

        System.out.print("Bill Number: ");
        int billNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Title (Mr./Mrs./Ms./Dr.): ");
        String title = sc.nextLine();

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Mobile Number (10 digits): ");
        String mobile = sc.nextLine();

        System.out.print("User ID (default: user" + consumerID + "): ");
        String userID = sc.nextLine();
        if (userID.isEmpty()) userID = "user" + consumerID;

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Confirm Password: ");
        String confirmPassword = sc.nextLine();

        customers.add(new CustomerAL(consumerID, billNumber, title, name, email, mobile, userID, password, confirmPassword));
        System.out.println("Customer Registration is successful");
    }

    // Update Customer Email
    static void updateCustomer(Scanner sc) {
        System.out.println("\n--- Update Customer ---");
        System.out.print("Enter Consumer ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (CustomerAL c : customers) {
            if (c.consumerID == id) {
                System.out.print("Enter new Email: ");
                c.email = sc.nextLine();
                System.out.println("Customer details are updated successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Consumer ID not found");
        }
    }

    // Delete Customer
    static void deleteCustomer(Scanner sc) {
        System.out.println("\n--- Delete Customer ---");
        System.out.print("Enter Consumer ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean removed = customers.removeIf(c -> c.consumerID == id);
        if (removed) {
            System.out.println("Customer details are deleted");
        } else {
            System.out.println("Consumer ID not found");
        }
    }

    // Select/Display all Customers
    static void selectCustomers() {
        System.out.println("\n--- All Customers ---");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.printf("%-15s | %-10s | %-20s | %-30s | %-15s%n",
                "ConsumerID", "Title", "CustomerName", "Email", "Mobile");
        System.out.println("-".repeat(100));
        for (CustomerAL c : customers) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Customer Registration Menu (ArrayList) =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View All Customers");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addCustomer(sc); break;
                case 2: updateCustomer(sc); break;
                case 3: deleteCustomer(sc); break;
                case 4: selectCustomers(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
