package BankingSystem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
									//Defining Bank Class for Banking Operations
public class Bank {
    private List<Customer> customers;
    public  List<TransactionThread> transactions;
    
    //No Argument Constructor of Bank Class
    public Bank() {
        customers = new ArrayList<>();
        transactions=new ArrayList<>();
        
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(String customerId) {
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public List<Customer> getCustomers(){
    	return customers;
    }
    
    public void addTransactions(TransactionThread transaction) {
    	transactions.add(transaction);
    }
    
    public List<TransactionThread> getTransactions(){
    	return transactions;
    }
    
    public Account getAccount(String accountId) {
        for (Customer customer : customers) {
            Account account = customer.getAccount(accountId);
            if (account != null) {
                return account;
            }
        }
        return null;
    }

    public void processTransaction(TransactionThread transaction) {
    	transaction.start();
        addTransactions(transaction);
    }
}

