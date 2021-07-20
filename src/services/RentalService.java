package services;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxService brazilTaxService;
	
	public RentalService() {
		
	}
	public RentalService(BrazilTaxService bts, Double pricePerHour, Double pricePerDay) {
		brazilTaxService = bts; 
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
	}
	
	
	public void processInvoice(CarRental carRental) {
		
		long t1 = carRental.getStart().getTime();//pega a data em milisegundos
		long t2 = carRental.getFinish().getTime();
		
		double hour = (double) (t2 - t1)/1000/60/60;//converto milisegundos em hora
		//   valor / 1000miliseg / 60seg / 60min = hora
		
		//double basicPayment = (hour <= 12) ? Math.ceil(hour)*pricePerHour : Math.ceil(hour)*pricePerDay;
		double basicPayment;
		if(hour <=12) {
			basicPayment = Math.ceil(hour)*pricePerHour;
		}else {
			basicPayment = Math.ceil(hour)*pricePerDay;
		}
		double tax = brazilTaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}
	
	
	
}
 