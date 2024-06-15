package BankingSystem;
									//Defining BankException Class for Different kinds of Exception can be occured at Runtime
public class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }
}
