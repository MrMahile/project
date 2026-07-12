import java.util.ArrayList;
import java.util.Scanner;

// US005 (ArrayList): Search Unpaid Bills by Consumer ID
// Output: ConsumerID | CustomerName | DueAmount | PayableAmount

public class UnpaidBillSearchAL {

    static ArrayList<BillAL> bills = new ArrayList<>();

    public static void main(String[] args) {
        // Pre-populate some bill data
        bills.add(new BillAL(1001, 1250.00, 1300.00));
        bills.add(new BillAL(2001, 980.75, 1020.00));
        bills.add(new BillAL(3001, 870.00, 910.00));
        bills.add(new BillAL(1001, 1100.50, 1150.00));

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Unpaid Bill Search (ArrayList) ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        System.out.printf("%n%-15s | %-15s | %-15s | %-10s%n", "ConsumerID", "Due Amount", "Payable Amount", "Status");
        System.out.println("-".repeat(65));
        for (BillAL b : bills) {
            if (b.consumerNumber == searchID) {
                System.out.printf("%-15d | %-15.2f | %-15.2f | Unpaid%n",
                        b.consumerNumber, b.dueAmount, b.payableAmount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No unpaid bills found for Consumer ID: " + searchID);
        }

        sc.close();
    }
}
