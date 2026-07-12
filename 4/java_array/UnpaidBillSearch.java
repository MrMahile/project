import java.util.Scanner;

// US005 (Array): Search Unpaid Bills by Consumer ID
// Output: ConsumerID | CustomerName | DueAmount | PayableAmount

public class UnpaidBillSearch {

    static BillDetails bd = new BillDetails();

    public static void main(String[] args) {
        // Pre-populate some bill data
        BillDetails.bills[0] = new Bill(1001, 1250.00, 1300.00);
        BillDetails.bills[1] = new Bill(2001, 980.75, 1020.00);
        BillDetails.bills[2] = new Bill(3001, 870.00, 910.00);
        BillDetails.bills[3] = new Bill(1001, 1100.50, 1150.00);
        BillDetails.count = 4;

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Unpaid Bill Search ===");
        System.out.print("Enter Consumer ID: ");
        int searchID = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        System.out.printf("%n%-15s | %-15s | %-15s | %-15s%n", "ConsumerID", "Due Amount", "Payable Amount", "Status");
        System.out.println("-".repeat(65));
        for (int i = 0; i < BillDetails.count; i++) {
            if (BillDetails.bills[i].consumerNumber == searchID) {
                System.out.printf("%-15d | %-15.2f | %-15.2f | Unpaid%n",
                        BillDetails.bills[i].consumerNumber,
                        BillDetails.bills[i].dueAmount,
                        BillDetails.bills[i].payableAmount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No unpaid bills found for Consumer ID: " + searchID);
        }

        sc.close();
    }
}
