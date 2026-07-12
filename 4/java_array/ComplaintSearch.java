import java.util.Scanner;

// US006 (Array): Search Complaints by Consumer ID
// Output: ConsumerID | CustomerName | ComplaintType | Category | ProblemDescription | Mobile | Status

public class ComplaintSearch {

    static RegisterComplaint rc = new RegisterComplaint();

    public static void main(String[] args) {
        // Pre-populate some complaint data
        RegisterComplaint.complaints[0] = new Complaint("Billing Related", "Incorrect Bill", "MG Road", "Rajesh Kumar", "Wrong bill amount", 1001, "12 MG Road", "9876543210");
        RegisterComplaint.complaints[1] = new Complaint("Voltage Related", "Low Voltage", "Park Street", "Priya Sharma", "Low voltage issue", 2001, "45 Park Street", "8765432109");
        RegisterComplaint.complaints[2] = new Complaint("Frequent Disruption", "Power Cut", "Anna Salai", "Amit Singh", "Frequent power cuts", 3001, "78 Anna Salai", "7654321098");
        RegisterComplaint.complaints[3] = new Complaint("Street Light Related", "Light Not Working", "Brigade Road", "Sunita Devi", "Street light not working", 4001, "23 Brigade Road", "6543210987");
        RegisterComplaint.count = 4;

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Complaint Search ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        System.out.printf("%n%-13s | %-18s | %-18s | %-15s | %-25s | %-12s | %-8s%n",
                "ConsumerID", "CustomerName", "ComplaintType", "Category", "ProblemDescription", "Mobile", "Status");
        System.out.println("-".repeat(120));
        for (int i = 0; i < RegisterComplaint.count; i++) {
            if (RegisterComplaint.complaints[i].consumerNumber == searchID) {
                Complaint c = RegisterComplaint.complaints[i];
                System.out.printf("%-13d | %-18s | %-18s | %-15s | %-25s | %-12s | %-8s%n",
                        c.consumerNumber, c.customerName, c.complaintType, c.category, c.problem, c.mobileNumber, "Active");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found for Consumer ID: " + searchID);
        }

        sc.close();
    }
}
