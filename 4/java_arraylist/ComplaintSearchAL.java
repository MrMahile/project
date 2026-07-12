import java.util.ArrayList;
import java.util.Scanner;

// US006 (ArrayList): Search Complaints by Consumer ID
// Output: ConsumerID | CustomerName | ComplaintType | Category | ProblemDescription | Mobile | Status

public class ComplaintSearchAL {

    static ArrayList<ComplaintAL> complaints = new ArrayList<>();

    public static void main(String[] args) {
        // Pre-populate some complaint data
        complaints.add(new ComplaintAL("Billing Related", "Incorrect Bill", "MG Road", "Rajesh Kumar", "Wrong bill amount", 1001, "12 MG Road", "9876543210"));
        complaints.add(new ComplaintAL("Voltage Related", "Low Voltage", "Park Street", "Priya Sharma", "Low voltage issue", 2001, "45 Park Street", "8765432109"));
        complaints.add(new ComplaintAL("Frequent Disruption", "Power Cut", "Anna Salai", "Amit Singh", "Frequent power cuts", 3001, "78 Anna Salai", "7654321098"));
        complaints.add(new ComplaintAL("Street Light Related", "Light Not Working", "Brigade Road", "Sunita Devi", "Street light not working", 4001, "23 Brigade Road", "6543210987"));

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Complaint Search (ArrayList) ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        System.out.printf("%n%-13s | %-18s | %-18s | %-15s | %-25s | %-12s | %-8s%n",
                "ConsumerID", "CustomerName", "ComplaintType", "Category", "ProblemDescription", "Mobile", "Status");
        System.out.println("-".repeat(120));
        for (ComplaintAL c : complaints) {
            if (c.consumerNumber == searchID) {
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
