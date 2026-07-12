import java.util.Scanner;

// US003 (Array): Register Complaint - Create/Delete using Array

class Complaint {
    int complaintID;
    String complaintType;
    String category;
    String landMark;
    String customerName;
    String problem;
    int consumerNumber;
    String address;
    String mobileNumber;
    static int nextID = 1001;

    Complaint(String complaintType, String category, String landMark, String customerName,
              String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintID = nextID++;
        this.complaintType = complaintType;
        this.category = category;
        this.landMark = landMark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return String.format("%-8d | %-20s | %-15s | %-20s | %-25s | %-12s | Active",
                complaintID, customerName, complaintType, category, problem, mobileNumber);
    }
}

public class RegisterComplaint {

    static Complaint[] complaints = new Complaint[100];
    static int count = 0;

    // Register Complaint
    static void registerComplaint(Scanner sc) {
        System.out.println("\n--- Register Complaint ---");

        System.out.print("Complaint Type (Billing/Voltage/Frequent Disruption/Street Light/Pole): ");
        String type = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Landmark: ");
        String landmark = sc.nextLine();

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Problem Description: ");
        String problem = sc.nextLine();

        System.out.print("Consumer Number (int): ");
        int consumerNum = sc.nextInt();
        sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Mobile Number (10 digits): ");
        String mobile = sc.nextLine();

        complaints[count++] = new Complaint(type, category, landmark, name, problem, consumerNum, address, mobile);
        System.out.println("Successfully registered Complaint");
    }

    // Delete Complaint
    static void deleteComplaint(Scanner sc) {
        System.out.println("\n--- Delete Complaint ---");
        System.out.print("Enter Complaint ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (complaints[i].complaintID == id) {
                for (int j = i; j < count - 1; j++) {
                    complaints[j] = complaints[j + 1];
                }
                complaints[count - 1] = null;
                count--;
                System.out.println("Complaint details are deleted");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Complaint ID not found");
        }
    }

    // Display all complaints
    static void displayComplaints() {
        System.out.println("\n--- All Complaints ---");
        if (count == 0) {
            System.out.println("No complaints found.");
            return;
        }
        System.out.printf("%-8s | %-20s | %-20s | %-15s | %-25s | %-12s | %-8s%n",
                "CompID", "CustomerName", "ComplaintType", "Category", "Problem", "Mobile", "Status");
        System.out.println("-".repeat(120));
        for (int i = 0; i < count; i++) {
            System.out.println(complaints[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Register Complaint Menu =====");
            System.out.println("1. Register Complaint");
            System.out.println("2. Delete Complaint");
            System.out.println("3. View All Complaints");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: registerComplaint(sc); break;
                case 2: deleteComplaint(sc); break;
                case 3: displayComplaints(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
