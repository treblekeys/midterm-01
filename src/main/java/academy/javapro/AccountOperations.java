package academy.javapro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface defining the core operations that all bank accounts must implement.
 */
public interface AccountOperations {
    // A list to store transaction history
    List<String> transactionHistory = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount The amount to deposit
     */
    void deposit(double amount);

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount The amount to withdraw
     */
    void withdraw(double amount);

    /**
     * Returns the current balance of the account.
     *
     * @return The current balance
     */
    double getBalance();

    /**
     * Logs a transaction with the specified type and amount.
     * Includes a timestamp with each transaction.
     *
     * @param type The type of transaction (deposit, withdrawal, fee, interest, etc.)
     * @param amount The amount involved in the transaction
     */
    default void logTransaction(String type, double amount) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(formatter);
        String record = String.format("%s | %s | $%.2f | Balance: $%.2f",
                                      timestamp, type, amount, getBalance());
        transactionHistory.add(record);
    }

    /**
     * Returns a list of all transactions for this account.
     *
     * @return A list of transaction records as strings
     */
    default List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy to prevent modification
    }
}