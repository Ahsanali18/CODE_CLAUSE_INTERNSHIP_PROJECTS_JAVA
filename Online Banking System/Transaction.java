package BankingSystem;
import java.text.SimpleDateFormat;
import java.util.Date;
							
public class Transaction {
    private String transactionId;
    private Date date;
    private String type;
    private double amount;
    private String fromAccountId;
    private String toAccountId;
    private String status;
    
    public Transaction(String type, double amount, String fromAccountId, String toAccountId) {
        this.transactionId = generateTransactionId();
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.status = "Completed";
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    public String getTransactionId() {
    	return transactionId;
    }
    public Date getDate() {
    	return date;
    }
    public String getType() {
    	return type;
    }
    public double getAmount() {
    	return amount;
    }
    public String getFromAccountId() {
    	return fromAccountId;
    }
    public String getToAccountId() {
    	return toAccountId;
    }
    public String getStatis() {
    	return status;
    }
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public String getTransactionDetails() {
        return "Date: " + date + ", Type: " + type + ", Amount: " + amount + ", From: " + fromAccountId + ", To: " + toAccountId + ", Status: " + status;
    }
}
