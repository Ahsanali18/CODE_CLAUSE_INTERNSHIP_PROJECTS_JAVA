
public class DivisionCalculator extends Calculator{

	public DivisionCalculator(double firstOperand, double secondOperand, char operation) {
		super(firstOperand, secondOperand, operation);
	}
	
	public double calculate(){
		return (getFirstOperand()/getSecondOperand());
	}
}
