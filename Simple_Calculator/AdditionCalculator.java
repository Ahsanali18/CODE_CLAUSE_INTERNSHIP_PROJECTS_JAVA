
public class AdditionCalculator extends Calculator{

	public AdditionCalculator(double firstOperand, double secondOperand, char operation) {
		super(firstOperand, secondOperand, operation);
	}
	
	public double calculate() {
		return (getFirstOperand()+getSecondOperand());
	}
}
