
public abstract class Calculator {
	private double firstOperand;
	private double secondOperand;
	private char operation;
	
	public Calculator(double firstOperand, double secondOperand, char operation) {
		this.firstOperand=firstOperand;
		this.secondOperand=secondOperand;
		this.operation=operation;
	}
	public abstract double calculate();
	
	public double getFirstOperand() {
		return firstOperand;
	}
	public double getSecondOperand() {
		return secondOperand;
	}
	public char getOperation() {
		return operation;
	}
}
