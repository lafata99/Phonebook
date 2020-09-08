package business;

public class Address {
	
	String street;
	String city;
	String state; 
	String zip;
	
	
	public Address(String street, String city, String state, String zip) {
		this.city = city;
		this.state = state;
		this.street = street;
		this.zip = zip;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		return "Address: " + street + ", " + city + ", " + state + ", " + zip;
	}

}