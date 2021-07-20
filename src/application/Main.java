package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

public class Main {
	public static void main(String [] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.print("Modelo do Carro: ");
		String car = scan.nextLine();
		System.out.print("Data Inicio da locação (dd/MM/yyyy HH:ss): ");
		String dtIn = scan.nextLine();
		Date in = sdf.parse(dtIn);
		System.out.print("Data Fim locação: ");
		String dtFn = scan.nextLine();
		Date fn = sdf.parse(dtFn);
		
		Vehicle ver = new Vehicle(car);
		CarRental carRental = new CarRental(ver,in,fn);
		
		System.out.print("Informe o preço Por Hora: ");
		double phor = scan.nextDouble();
		
		System.out.print("Informe o preço por Dia: ");
		double pdia = scan.nextDouble();
		
		System.out.print(" ");
		BrazilTaxService btx = new BrazilTaxService();
		RentalService rs = new RentalService(btx,phor, pdia);
		
		rs.processInvoice(carRental);
		
		System.out.println("Pagamento básico: " + String.format(" %.2f",carRental.getInvoice().getBasicPayment()) );
		System.out.println("Taxa:" + String.format(" %.2f", carRental.getInvoice().getTax()));
		System.out.println("Total: " + String.format(" %.2f",carRental.getInvoice().getTotalPayment()));
		
		
		
		
		
		System.out.println("ok");
	}
	
	
}
