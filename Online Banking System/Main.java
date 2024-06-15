package BankingSystem;
				//Defining Main  class for Running the whole code!
public class Main {
	
	LoginPage firstPage;
	
	public Main() {
		firstPage=new LoginPage();
		firstPage.setVisible(true);
	}
	public static void main(String[] args) {
		Main onlineBankAccount=new Main();
	}

}
