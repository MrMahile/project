import java.util.Scanner;

// US004 (Array): Search Customer by Consumer ID
// Output: ConsumerID | CustomerName | MobileNumber | Email

public class ConsumerSearch {

    static CustomerRegistration cr = new CustomerRegistration();

    public static void main(String[] args) {
        // Pre-populate some data
        CustomerRegistration.customers[0] = new Customer(1001, 54321, "Mr.", "Rajesh Kumar", "rajesh@email.com", "9876543210", "rajesh1", "pass123", "pass123");
        CustomerRegistration.customers[1] = new Customer(2001, 67890, "Ms.", "Priya Sharma", "priya@email.com", "8765432109", "priya1", "pass456", "pass456");
        CustomerRegistration.customers[2] = new Customer(3001, 12345, "Mr.", "Amit Singh", "amit@email.com", "7654321098", "amit1", "pass789", "pass789");
        CustomerRegistration.count = 3;

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Consumer Details Search ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < CustomerRegistration.count; i++) {
            if (CustomerRegistration.customers[i].consumerID == searchID) {
                Customer c = CustomerRegistration.customers[i];
                System.out.println("\nConsumerID   | CustomerName        | MobileNumber   | Email");
                System.out.println("-".repeat(80));
                System.out.printf("%-13d | %-19s | %-14s | %-30s%n",
                        c.consumerID, c.customerName, c.mobileNumber, c.email);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Consumer ID not found");
        }

        sc.close();
    }
}
