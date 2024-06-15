package BankingSystem;

import java.util.ArrayList;
import java.util.List;
									//Defining Account Class for Accounts Operations
public class Account {
    private String accountId;
    private double balance;
    private List<Transaction> transactions;
    
    			// Parametrized Constructor of Account Class
    public Account(String accountId, double initialBalance, String accountType) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }
    			// Getters for ID and Balance
    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }
    		
    			// Other Methods Implementation
    public void deposit(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, accountId, null));
    }

    public void withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new BankException("Insufficient funds");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount, accountId, null));
    }

    public void transfer(Account toAccount, double amount) throws BankException {
        if (toAccount == null) {
            throw new BankException("Destination account is null");
        }
        if (this.equals(toAccount)) {
            throw new BankException("Cannot transfer to the same account");
        }
        if (amount <= 0) {
            throw new BankException("Transfer amount must be positive");
        }
        if (amount > balance) {
            throw new BankException("Insufficient funds for transfer");
        }

        this.withdraw(amount);
        toAccount.deposit(amount);
        transactions.add(new Transaction("Transfer", amount, accountId, toAccount.getAccountId()));
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
