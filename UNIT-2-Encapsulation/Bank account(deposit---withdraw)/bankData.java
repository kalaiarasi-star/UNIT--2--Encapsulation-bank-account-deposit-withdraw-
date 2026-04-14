import java.util.*;
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void displayAccountDetails();
}
class BankAccount implements Account {
    private String accNo;
    private String holderName;
    private double balance;
    private String accType;

 BankAccount(String accNo, String holderName, double balance, String accType) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.accType = accType;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Transaction");
        } else {
            balance += amount;
            System.out.printf("Deposit Successful. Updated Balance: $%.1f\n", balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0 || balance < amount) {
            System.out.println("Invalid Transaction");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal Successful. Updated Balance: $%.1f\n", balance);
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Account Type: " + accType);
        System.out.printf("Balance: $%.1f\n", balance);
    }
}
public class bankData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number:");
        String a = sc.nextLine();

        System.out.println("Enter the account holder's name:");
        String b = sc.nextLine();
        System.out.println("Enter the initial balance:");
        double c = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the account type:");
        String d = sc.nextLine();
        Account account = new BankAccount(a, b, c, d);
        account.displayAccountDetails();
        System.out.println("Enter deposit amount:");
        double amount = sc.nextDouble();
        account.deposit(amount);
        System.out.println("Enter withdrawal amount:");
        double amount1 = sc.nextDouble();
        account.withdraw(amount1);
        account.displayAccountDetails();
    }
}