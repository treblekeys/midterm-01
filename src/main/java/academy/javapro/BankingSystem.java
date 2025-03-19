package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        // Create different types of accounts
       SavingsAccount savingsJohnDoe = new SavingsAccount("SA001" , "John Doe" , 1000.00 , 2.5);
       CheckingAccount checkingJaneSmith = new CheckingAccount("CA001" , "Jane Smith" , 2000.00 , 500.00);

       // Store accounts in an array to demonstrate polymorphism
       Account[] accounts = {savingsJohnDoe , checkingJaneSmith};

        // Display initial information for all accounts
        System.out.println("--- Initial Account Information ---");
        for(Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        // Demonstrate account operations
        System.out.println("--- Performing Account Operations ---");

        // Test deposit operations
        System.out.println("\n1. Testing deposits:");

        savingsJohnDoe.deposit(500);
        checkingJaneSmith.deposit(300);

        // Test withdrawal operations
        System.out.println("\n2. Testing withdrawals:");

        savingsJohnDoe.withdraw(1300);

        savingsJohnDoe.withdraw(200);

        checkingJaneSmith.withdraw(2500);

        // Test account-specific operations
        System.out.println("\n3. Testing account-specific operations:");

        // Savings account - apply interest
        System.out.println("\nSavings Account - Applying interest:");

        savingsJohnDoe.applyInterest();

        // Checking account - modify overdraft
        System.out.println("\nChecking Account - Modifying overdraft limit:");

        checkingJaneSmith.setOverdraftLimit(1000);

        // Display updated information for all accounts
        System.out.println("\n--- Updated Account Information ---");

        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        // Display transaction history
        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");

        for (String transaction : savingsJohnDoe.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transactions:");

        for (String transaction : checkingJaneSmith.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}