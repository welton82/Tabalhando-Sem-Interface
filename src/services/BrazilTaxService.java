package services;

public class BrazilTaxService {
	
	
	public double tax(double amount) {
		
		double tax = (amount <= 100.00) ? amount * 0.20:amount * 0.15;
		
		
		return tax;
	}
	
	
}
