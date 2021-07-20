package entities;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish;
	
	private Invoice invoice;
	private Vehicle vehicle;
	
	
	public CarRental() {
	}
	public CarRental(Vehicle v, Date start, Date finish) {
		this.vehicle = v;
		this.start = start;
		this.finish = finish;
	}
	
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
}
