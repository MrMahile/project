import java.util.Scanner;

// US002 (Array): Bill Details - Add/Update/Delete using Array

class Bill {
    int consumerNumber;
    double dueAmount;
    double payableAmount;

    Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return String.format("%-15d | %-15.2f | %-15.2f", consumerNumber, dueAmount, payableAmount);
    }
}

public class BillDetails {

    static Bill[] bills = new Bill[100];
    static int count = 0;

    // Add Bill
    static void addBill(Scanner sc) {
        System.out.println("\n--- Add Bill ---");
        System.out.print("Consumer Number (int): ");
        int consumerNumber = sc.nextInt();

        System.out.print("Due Amount (double): ");
        double dueAmount = sc.nextDouble();

        System.out.print("Payable Amount (double): ");
        double payableAmount = sc.nextDouble();
        sc.nextLine();

        bills[count++] = new Bill(consumerNumber, dueAmount, payableAmount);
        System.out.println("Bill details are added successfully");
    }

    // Update Bill Amount
    static void updateBill(Scanner sc) {
        System.out.println("\n--- Update Bill ---");
        System.out.print("Enter Consumer Number to update: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (bills[i].consumerNumber == id) {
                System.out.print("Enter new Due Amount: ");
                bills[i].dueAmount = sc.nextDouble();
                System.out.print("Enter new Payable Amount: ");
                bills[i].payableAmount = sc.nextDouble();
                sc.nextLine();
                System.out.println("Bill details are updated successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Consumer Number not found");
        }
    }

    // Delete Bill
    static void deleteBill(Scanner sc) {
        System.out.println("\n--- Delete Bill ---");
        System.out.print("Enter Consumer Number to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (bills[i].consumerNumber == id) {
                for (int j = i; j < count - 1; j++) {
                    bills[j] = bills[j + 1];
                }
                bills[count - 1] = null;
                count--;
                System.out.println("Bill Details are deleted");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Consumer Number not found");
        }
    }

    // Display all bills
    static void displayBills() {
        System.out.println("\n--- All Bills ---");
        if (count == 0) {
            System.out.println("No bills found.");
            return;
        }
        System.out.printf("%-15s | %-15s | %-15s%n", "ConsumerNo", "Due Amount", "Payable Amount");
        System.out.println("-".repeat(50));
        for (int i = 0; i < count; i++) {
            System.out.println(bills[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Bill Details Menu =====");
            System.out.println("1. Add Bill");
            System.out.println("2. Update Bill");
            System.out.println("3. Delete Bill");
            System.out.println("4. View All Bills");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addBill(sc); break;
                case 2: updateBill(sc); break;
                case 3: deleteBill(sc); break;
                case 4: displayBills(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
