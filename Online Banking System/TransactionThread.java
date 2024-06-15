package BankingSystem;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TransactionThread extends Thread {
    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private Date date;
    
    

    public TransactionThread(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = new Date();
    }
    
    @Override
    public void run() {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                try {
                    fromAccount.transfer(toAccount, amount);
                } catch (BankException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Date getDate() {
    	return date;
    }
    
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
	}

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }
    public double getAmount() {
    	return amount;
    }
    
}
