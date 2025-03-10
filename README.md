### Project Overview

In this assignment, you will implement a simple banking system that demonstrates object-oriented programming concepts in
Java including inheritance, polymorphism, abstraction, and encapsulation. The system will model different types of bank
accounts and their operations.

### Project Setup

1. Open the project in your IDE
2. Locate the starter code at: src/main/java/academy/javapro
    - `AccountOperations.java` (interface)
    - `BankingSystem.java` (main class)
    - `Account.java` (abstract class)
    - `CheckingAccount.java` (concrete class)
    - `SavingsAccount.java` (concrete class)
3. Do not modify the package structure or class name
4. Implement the required functionality

### Task Description

You need to implement a banking system with the following components:

- A `CheckingAccount` class that extends the `Account` class
- A `SavingsAccount` class that extends the `Account` class

### Functional Requirements

The `CheckingAccount` class should:

- Extend the `Account` class
- Implement overdraft protection (allow withdrawals that exceed balance up to the overdraft limit)
- Apply transaction fees for withdrawals
- Override display methods to show checking account-specific details

The `SavingsAccount` class should:

- Extend the `Account` class
- Implement interest calculation based on the account balance
- Apply transaction fees for withdrawals
- Override display methods to show savings account-specific details

### Starter Code

The `AccountOperations` interface is provided for you:

```java
package academy.javapro;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all bank accounts.
 * Implements the AccountOperations interface.
 */
public abstract class Account implements AccountOperations {
    private final String accountNumber;
    private final String customerName;
    private double balance;
    private final List<String> transactionHistory = new ArrayList<>();

    /**
     * Constructor to initialize an account with provided details.
     *
     * @param accountNumber The account number
     * @param customerName The name of the account holder
     * @param initialBalance The initial balance
     */
    public Account(String accountNumber, String customerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialBalance;
        logTransaction("INITIAL_DEPOSIT", initialBalance);
    }

    /**
     * Getter for account number.
     *
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Getter for customer name.
     *
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Protected method to set the balance.
     * Used by subclasses.
     *
     * @param balance The new balance
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }

        balance += amount;
        logTransaction("DEPOSIT", amount);
    }

    /**
     * Abstract method to withdraw money from the account.
     * Each account type implements its own withdrawal rules.
     */
    @Override
    public abstract void withdraw(double amount);

    @Override
    public void logTransaction(String type, double amount) {
        String record = String.format("%s | $%.2f | Balance: $%.2f",
                                     type, amount, balance);
        transactionHistory.add(record);
    }

    @Override
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    /**
     * Displays detailed information about the account.
     * Can be overridden by subclasses to include additional information.
     */
    public void displayInfo() {
        System.out.println("===== Account Information =====");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}
```

The `Account` class is provided for you:

```java
package academy.javapro;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all bank accounts.
 * Implements the AccountOperations interface.
 */
public abstract class Account implements AccountOperations {
    private final String accountNumber;
    private final String customerName;
    private double balance;
    private final List<String> transactionHistory = new ArrayList<>();

    /**
     * Constructor to initialize an account with provided details.
     *
     * @param accountNumber The account number
     * @param customerName The name of the account holder
     * @param initialBalance The initial balance
     */
    public Account(String accountNumber, String customerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialBalance;
        logTransaction("INITIAL_DEPOSIT", initialBalance);
    }

    /**
     * Getter for account number.
     *
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Getter for customer name.
     *
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Protected method to set the balance.
     * Used by subclasses.
     *
     * @param balance The new balance
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }

        balance += amount;
        logTransaction("DEPOSIT", amount);
    }

    /**
     * Abstract method to withdraw money from the account.
     * Each account type implements its own withdrawal rules.
     */
    @Override
    public abstract void withdraw(double amount);

    @Override
    public void logTransaction(String type, double amount) {
        String record = String.format("%s | $%.2f | Balance: $%.2f",
                                     type, amount, balance);
        transactionHistory.add(record);
    }

    @Override
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    /**
     * Displays detailed information about the account.
     * Can be overridden by subclasses to include additional information.
     */
    public void displayInfo() {
        System.out.println("===== Account Information =====");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}
```

#### Testing Your Implementation

To test your implementation, use the provided `BankingSystem` class. This class contains a `main` method that performs
the following tasks:

- Creates instances of `SavingsAccount` and `CheckingAccount`
- Displays initial account information
- Performs various account operations (deposits, withdrawals)
- Tests account-specific operations (applying interest, changing overdraft limit)
- Displays updated account information
- Prints transaction history

Your output should match the expected output format below:

```text
======= Banking System Demonstration =======

--- Initial Account Information ---
===== Account Information =====
Account Number: SA001
Customer Name: John Doe
Balance: $1000.00
Account Type: Savings Account
Interest Rate: 2.5%
Minimum Balance Requirement: $100.0

===== Account Information =====
Account Number: CA001
Customer Name: Jane Smith
Balance: $2000.00
Account Type: Checking Account
Overdraft Limit: $500.00
Transaction Fee: $1.50

--- Performing Account Operations ---

1. Testing deposits:

2. Testing withdrawals:
Withdrew $1300.00 from savings account
Cannot withdraw $200.0. Minimum balance of $100.0 must be maintained.
Withdrew $2500.00 from checking account
Transaction fee: $1.50
Account is in overdraft. Current balance: $-201.50

3. Testing account-specific operations:

Savings Account - Applying interest:
Interest applied: $5.00

Checking Account - Modifying overdraft limit:
Overdraft limit updated to $1000.0

--- Updated Account Information ---
===== Account Information =====
Account Number: SA001
Customer Name: John Doe
Balance: $205.00
Account Type: Savings Account
Interest Rate: 2.5%
Minimum Balance Requirement: $100.0

===== Account Information =====
Account Number: CA001
Customer Name: Jane Smith
Balance: $-201.50
Account Type: Checking Account
Overdraft Limit: $1000.00
Transaction Fee: $1.50

--- Transaction History ---

Savings Account Transactions:
INITIAL_DEPOSIT | $1000.00 | Balance: $1000.00
DEPOSIT | $500.00 | Balance: $1500.00
WITHDRAWAL | $1300.00 | Balance: $200.00
INTEREST | $5.00 | Balance: $205.00

Checking Account Transactions:
INITIAL_DEPOSIT | $2000.00 | Balance: $2000.00
DEPOSIT | $300.00 | Balance: $2300.00
WITHDRAWAL | $2500.00 | Balance: $-201.50
FEE | $1.50 | Balance: $-201.50

======= End of Banking System Demonstration =======
```

#### Evaluation Criteria

Your assignment will be evaluated based on:

- Correctness of implementation
- Proper use of object-oriented principles
- Code organization and clarity
- Documentation quality (REMOVE TODO comments)
- Adherence to Java coding conventions

#### Tips

- Read the requirements carefully before starting
- Plan your class hierarchy before coding
- Implement and test one feature at a time
- Use appropriate access modifiers to encapsulate your data
- Use polymorphism to simplify your code where appropriate