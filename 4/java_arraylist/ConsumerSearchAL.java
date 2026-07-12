import java.util.ArrayList;
import java.util.Scanner;

// US004 (ArrayList): Search Customer by Consumer ID
// Output: ConsumerID | CustomerName | MobileNumber | Email

public class ConsumerSearchAL {

    static ArrayList<CustomerAL> customers = new ArrayList<>();

    public static void main(String[] args) {
        // Pre-populate some data
        customers.add(new CustomerAL(1001, 54321, "Mr.", "Rajesh Kumar", "rajesh@email.com", "9876543210", "rajesh1", "pass123", "pass123"));
        customers.add(new CustomerAL(2001, 67890, "Ms.", "Priya Sharma", "priya@email.com", "8765432109", "priya1", "pass456", "pass456"));
        customers.add(new CustomerAL(3001, 12345, "Mr.", "Amit Singh", "amit@email.com", "7654321098", "amit1", "pass789", "pass789"));

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Consumer Details Search (ArrayList) ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (CustomerAL c : customers) {
            if (c.consumerID == searchID) {
                System.out.printf("%n%-15s | %-20s | %-15s | %-30s%n", "ConsumerID", "CustomerName", "MobileNumber", "Email");
                System.out.println("-".repeat(85));
                System.out.printf("%-15d | %-20s | %-15s | %-30s%n",
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
