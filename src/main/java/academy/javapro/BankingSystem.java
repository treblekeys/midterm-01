package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        // Create different types of accounts
        // TODO: Create a new SavingsAccount object with account number "SA001", account holder name "John Doe", initial balance 1000.0, and interest rate 2.5

        // TODO: Create a new CheckingAccount object with account number "CA001", account holder name "Jane Smith", initial balance 2000.0, and overdraft limit 500.0

        // Store accounts in an array to demonstrate polymorphism
        // TODO: Create an array of Account objects and store the savings and checking accounts in it

        // Display initial information for all accounts
        System.out.println("--- Initial Account Information ---");

        // TODO: Loop through the accounts array and call the displayInfo method for each account, followed by a newline using System.out.println()

        // Demonstrate account operations
        System.out.println("--- Performing Account Operations ---");

        // Test deposit operations
        System.out.println("\n1. Testing deposits:");

        // TODO: Deposit 500.0 into the savings account and 300.0 into the checking account

        // Test withdrawal operations
        System.out.println("\n2. Testing withdrawals:");

        // TODO: Withdraw 1300.0 from the savings account (should fail due to minimum balance requirement)

        // TODO: Withdraw 200.0 from the savings account (should succeed)

        // TODO: Withdraw 2500.0 from the checking account (should go into overdraft)

        // Test account-specific operations
        System.out.println("\n3. Testing account-specific operations:");

        // Savings account - apply interest
        System.out.println("\nSavings Account - Applying interest:");

        // TODO: Call the applyInterest method on the savings account

        // Checking account - modify overdraft
        System.out.println("\nChecking Account - Modifying overdraft limit:");

        // TODO: Set the overdraft limit of the checking account to 1000.0

        // Display updated information for all accounts
        System.out.println("\n--- Updated Account Information ---");

        // TODO: Loop through the accounts array and call the displayInfo method for each account, followed by a newline using System.out.println()

        // Display transaction history
        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");

        // TODO: Loop through the transaction history of the savings account and print each transaction using System.out.println()

        System.out.println("\nChecking Account Transactions:");

        // TODO: Loop through the transaction history of the checking account and print each transaction using System.out.println()

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}