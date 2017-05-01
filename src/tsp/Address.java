package tsp;

public class Address {
	int street;
	int avenue;
	String house;
	String address; 
	boolean visited ;
	
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	} 
	public  Address(String add) {
		this.address = add;
	}
	public int getStreet() {
		return Integer.parseInt(address.split(",")[0].replaceAll("\\D+",""));
	}
	public void setStreet(int street) {
		this.street = street;
	}
	public int getAvenue() {
		return Integer.parseInt(address.split(",")[1].replaceAll("\\D+",""));
	}
	public void setAvenue(int avenue) {
		this.avenue = avenue;
	} 

}
