import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Error: Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance!");
        } else {
            System.out.println("Error: Invalid withdrawal amount!");
        }
    }
    public double checkBalance() {
        return balance;
    }
    public void displayAccount() {
        System.out.println("\n--- Final Account Details ---");
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Current Balance     : ₹" + balance);
    }
}

public class BankManagementSystem {
    public static void performDeposit(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    public static void performWithdraw(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(accNum, accName, initBalance);
        performDeposit(userAccount, scanner);
        performWithdraw(userAccount, scanner);
        userAccount.displayAccount();

        scanner.close();
    }
}
