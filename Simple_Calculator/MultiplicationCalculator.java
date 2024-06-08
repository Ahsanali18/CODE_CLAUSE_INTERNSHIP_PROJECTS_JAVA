
public class MultiplicationCalculator extends Calculator{

	public MultiplicationCalculator(double firstOperand, double secondOperand, char operation) {
		super(firstOperand, secondOperand, operation);
	}
	
	public double calculate() {
		return (getFirstOperand()*getSecondOperand());
	}
	

}
