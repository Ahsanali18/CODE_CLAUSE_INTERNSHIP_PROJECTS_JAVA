
public class SubtractionCalculator extends Calculator{

	public SubtractionCalculator(double firstOperand, double secondOperand, char operation) {
		super(firstOperand, secondOperand, operation);	
	}
	
	public double calculate() {
		return (getFirstOperand()-getSecondOperand());
	}
}
