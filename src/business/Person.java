package business;


public class Person {

	String firstName, lastName, middleName;
	String telephone;
	
	Address address;
	
	public Person(String firstName,String middleName, String lastName, Address address, String telephone){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
	}
	

	public static void addPerson() {
		
	}
	
	public String formatPhone() {
		String myPhone = this.telephone;
		return "(" + telephone.substring(0,3) + ")" + telephone.substring(3,6) + "-" + telephone.substring(6);
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		
		return (("----------------------- \n") + 
				"Name: " + firstName +
				getMid() + "\n" + 
				address.toString() + "\n" + 
				"Telephone: " + formatPhone() + 
				"\n" + "_______________________ " + "\n");
	}
	
	public String getMid() {
		if(middleName==null){
			return (" " + lastName);
		}else {
			return(" " + middleName + " " + lastName);
		}
	}
	
	public void printPersonInfo() {
		System.out.println("----------------------- ");
		System.out.print("Name: " + firstName);
		if(middleName==null){
			System.out.println(" " + lastName);
		}else {
			System.out.println(" " + middleName + " " + lastName);
		}
		System.out.println(address.toString());
		System.out.println("Telephone: " + formatPhone());
		System.out.println("_______________________ ");
	}
	
}
