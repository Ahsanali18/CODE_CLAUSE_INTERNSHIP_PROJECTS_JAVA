import java.util.Scanner;

public class UserInterface {
	Scanner sc=new Scanner(System.in);
	public void introduction() {		//introduction(); function to display the introductory part of the system.
		
			System.out.println("\t\n\n\n\t\t\t\t\t\t\t\t                        CALCULATOR                  \n");
		    System.out.println("\t\t\t\t\t\t============================================================================================");
		    System.out.println("\t\t\t\t\t\t\t--------------------------------------------------------------------------");
		    System.out.println("\t\t\t\t\t\t\t->\t            WELCOME TO SIMPLE CALCULATOR SYSTEM                ");
		    System.out.println("\t\t\t\t\t\t\t->\t            MADE BY AHSAN ALI (ID == CS11WX154872)                 ");
		    System.out.println("\t\t\t\t\t\t\t->\t             SUBMITTED TO CODSOFT                                 ");
		    System.out.println("\t\t\t\t\t\t============================================================================================");
		    System.out.println("\t\t\t\t\t\t\t__________________________________________________________________________");
		    System.out.print("Enter 's' to start the system: ");
		    char start=sc.next().toLowerCase().charAt(0);
		    if(start=='s') {
		    	perform_Arithmetic_Operations();
		    }
		    else {
		    	System.out.println("Please enter suggested character!");
		}
	}
	public  void perform_Arithmetic_Operations() {
		Scanner sc = new Scanner(System.in);
		char choice='y';
			do{
			System.out.print("\t\t\t\t\tEnter First number: ");
			double firstNumber = sc.nextDouble();
			System.out.print("\t\t\t\t\tEnter Second number: ");
			double secondNumber = sc.nextDouble();
			System.out.print("\t\t\t\t\tEnter Operator (+,-,*,/): ");
			char operator = sc.next().charAt(0);
			
			Calculator calculator;
			switch (operator) {
				case '+' -> {
					calculator = new AdditionCalculator(firstNumber, secondNumber, operator);
					System.out.println("\t\t\t\t\tAddition is: " + calculator.calculate());
				}
				case '-' -> {
					calculator = new SubtractionCalculator(firstNumber, secondNumber, operator);
					System.out.println("\t\t\t\t\tSubtraction is: " + calculator.calculate());
				}
				case '*' -> {
					calculator = new MultiplicationCalculator(firstNumber, secondNumber, operator);
					System.out.println("\t\t\t\t\tMultiplication is: " + calculator.calculate());
				}
				case '/' -> {
					if (secondNumber != 0) {
						calculator = new DivisionCalculator(firstNumber, secondNumber, operator);
						System.out.println("\t\t\t\t\tDivision is: " + calculator.calculate());
					} else {
						System.out.println("\t\t\t\t\tDivision by zero is not possible!");
					}
				}
				default -> {
					System.out.println("\t\t\t\t\tPlease, enter a valid operator!");
					continue;
				}
			}
			System.out.print("Do you want to continue (y/n): ");
			choice=sc.next().toLowerCase().charAt(0);
		}while(choice!='n' && choice!='N');
		System.out.println("System End... (Thank You......)");
	}
}
