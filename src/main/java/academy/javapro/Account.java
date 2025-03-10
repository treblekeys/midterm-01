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