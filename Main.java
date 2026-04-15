import java.util.Scanner;

class BankAccount {
    private double balance;


    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

        // Initial balance input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter INITIAL BALANCE for Account " + (i + 1) + ": ");
            double bal = sc.nextDouble();
            accounts[i] = new BankAccount(bal);
        }

        // Show initial balances
        System.out.println("\n--- Initial Balances ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Account " + (i + 1) + ": " + accounts[i].getBalance());
        }

        int choice;

        do {
            System.out.println("\n1.Deposit  2.Withdraw  3.Check Balance  4.All Accounts  5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter account number: ");
                int acc = sc.nextInt();

                if (acc < 1 || acc > n) {
                    System.out.println("Invalid account!");
                    continue;
                }

                BankAccount a = accounts[acc - 1];

                if (choice == 1) {
                    System.out.print("Enter amount: ");
                    a.deposit(sc.nextDouble());
                } 
                else if (choice == 2) {
                    System.out.print("Enter amount: ");
                    a.withdraw(sc.nextDouble());
                } 
                else if (choice == 3) {
                    System.out.println("Balance: " + a.getBalance());
                } 
                else if (choice == 4) {
                    System.out.println("\nAll Account Balances:");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Account " + (i+1) + ": " + accounts[i].getBalance());
                    }
                }
            }

        } while (choice != 5);

        System.out.println("Thank you!");
        sc.close();
    }
}
