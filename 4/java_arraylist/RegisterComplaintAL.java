import java.util.ArrayList;
import java.util.Scanner;

// US003 (ArrayList): Register Complaint - Create/Delete using ArrayList

class ComplaintAL {
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

    ComplaintAL(String complaintType, String category, String landMark, String customerName,
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

public class RegisterComplaintAL {

    static ArrayList<ComplaintAL> complaints = new ArrayList<>();

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

        complaints.add(new ComplaintAL(type, category, landmark, name, problem, consumerNum, address, mobile));
        System.out.println("Successfully registered Complaint");
    }

    // Delete Complaint
    static void deleteComplaint(Scanner sc) {
        System.out.println("\n--- Delete Complaint ---");
        System.out.print("Enter Complaint ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean removed = complaints.removeIf(c -> c.complaintID == id);
        if (removed) {
            System.out.println("Complaint details are deleted");
        } else {
            System.out.println("Complaint ID not found");
        }
    }

    // Display all complaints
    static void displayComplaints() {
        System.out.println("\n--- All Complaints ---");
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }
        System.out.printf("%-8s | %-20s | %-20s | %-15s | %-25s | %-12s | %-8s%n",
                "CompID", "CustomerName", "ComplaintType", "Category", "Problem", "Mobile", "Status");
        System.out.println("-".repeat(120));
        for (ComplaintAL c : complaints) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Register Complaint Menu (ArrayList) =====");
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
