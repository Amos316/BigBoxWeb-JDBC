package BusinessClass;

import UtilClass.Formatter;
import java.io.Serializable;
//import java.util.Formatter;



public class Store extends Facility implements Serializable {

	/**
	 * auto generated serial.
	 */
	private static final long serialVersionUID = 1L;
	
	private String storeNum;
	private double sales;
	private Division division;

	public Store(int id, Division d, String StoreNum, double sales, String facName, String facAddress, String facCity,
			String facState, String facZip) {
		this(d, StoreNum, sales, facName, facAddress, facCity, facState, facZip);

		
		setId(id);
	}

	public Store(Division inDiv, String StoreNum, double sales, String facName, String facAddress, String facCity,
			String facState, String facZip) {
		// super();

//		System.out.println("Division ID Set : " + inDiv);
		setDivision(inDiv);
		setStoreNum(StoreNum);
		setSales(sales);
		setName(facName);
		setAddress(facAddress);
		setCity(facCity);
		setState(facState);
		setZip(facZip);
	}

	public Store() {
		super();
	}

	public Store(String divisionNumber, String storeNumber2, double sales2, String name, String address, String city,
			String state, String zipCode) {
		// TODO Auto-generated constructor stub

		
		Division d = new Division();
		d.setDivNum(divisionNumber);
		this.setDivision(d);
		this.storeNum = storeNumber2;
		this.sales = sales2;
		this.setName(name);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZip(zipCode);
	}

	public int getDivID() {
		return getDivision().getId();
	}

	public Division getDivision() {
		return division;
	}

	public String getDivisionNumber() {
		return getDivision().getDivNum();
	}

	public void setDivision(Division d) {
		division = d;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String toString() {
		return "[Store: div#=" + getDivisionNumber() + ", store#=" + getStoreNum() + ", sales="
				+ Formatter.getFormattedDouble(getSales()) + "], " + super.toString();
	}
}