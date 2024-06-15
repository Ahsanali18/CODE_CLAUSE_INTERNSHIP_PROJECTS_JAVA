package BankingSystem;
		
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
						//Defining Customer Class to interact customer/Account Holders with Bank System
public class Customer {
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String phoneNumber;
	private ArrayList<Account> accounts;
	
	//Parametrized constructor for of Customer class.
	public Customer(String customerId, String customerName, String customerAddress,String phoneNumber) {
		this.customerId=customerId;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.phoneNumber=phoneNumber;
		this.accounts=new ArrayList<>();
	}
	//setters and getters
	public void setCustomerId(String id) { this.customerId=id;} public String getCustomerId() {return customerId;}
	public void setCustomerName(String name) { this.customerName=name;} public String getCustomerName() { return customerName;}
	public void setCustomerAddress(String address) { this.customerAddress=address;} public String getCustomerAddress() { return customerAddress;}
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber=phoneNumber;} public String getPhoneNumber() { return phoneNumber;}
	
	public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(String accountId) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getAccountId().equals(accountId)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public void updateContactInfo(String address, String phoneNumber, String email) {
        this.customerAddress=address;
        this.phoneNumber=phoneNumber;
    }           
}