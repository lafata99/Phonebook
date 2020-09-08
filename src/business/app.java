package business;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		
		Phonebook phonebook = new Phonebook();
		
		Person[] persons = new Person[4]; 
		persons[0] = new Person("John",null,"Doe", new Address("114 Market St","St Louis", "MO", "63403"),"6366435698");
		persons[1] = new Person("John","Michael West","Doe", new Address("574 Pole Ave","St Peters", "MO", "63333"),"5628592375");
		persons[2] = new Person("John","E","Doe", new Address("320 Main St","St Charles", "MO", "63303"),"8475390126");
		persons[3] = new Person("Anthony", "Dominc", "LaFata", new Address("4045 Whitehall Dr", "Arnold", "MO", "63010"), "3142887138");
		
		
		for(Person person: persons) {
			phonebook.addPerson(person);
		}
		
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		while (choice != 5) {
			choice = getMenu();
			
			switch(choice) {
			case 1:
				Scanner input = new Scanner(System.in);
				System.out.println("Enter new Info: (Should be in format of(first,middle,last,street,city,state,zip,phonenumber)");
				String line = input.nextLine();
				String[] array = line.split(", ");
				String fName = array[0];
				String mName = array[1];
				String lName = array[2];
				String street = array[3];
				String city = array[4];
				String state = array[5];
				String zip = array[6];
				String phonenum = array[7];
				Person newPerson = new Person(fName,mName,lName,new Address(street,city,state,zip),phonenum);
				phonebook.addPerson(newPerson);
				break;
			case 2: 
				int search = 0;
				
				while(search != 6) {
					search = searchMenu();
					
					switch(search) {
					case 1:
						Scanner first = new Scanner(System.in);
						System.out.println("Please Enter a first name for search: ");
						String fname = first.nextLine();
						Person[] perf = phonebook.searchByFName(fname);
						for(Person person: perf) {
							person.printPersonInfo();
						}
						break;
					case 2:
						Scanner last = new Scanner(System.in);
						System.out.println("Please Enter a last name for search: ");
						String lname = last.nextLine();
						Person[] perl = phonebook.searchByLName(lname);
						for(Person person: perl) {
							person.printPersonInfo();
						}
						break;
					case 3:
						Scanner name = new Scanner(System.in);
						System.out.println("Please Enter a full name for search: (first,last)");
						String fullname = name.nextLine();
						String[] farray = fullname.split(" ");
						String firstn = farray[0];
						String lastn = farray[1];
						
						Person[] per = phonebook.searchByFullName(firstn,lastn);
						for(Person person: per) {
							person.printPersonInfo();
						}
						break;
					case 4:
						Scanner number = new Scanner(System.in);
						System.out.println("Please Enter a phonenumber for search: ");
						String phonenumber = number.nextLine();
						Person numbers = phonebook.searchByPhonenumber(phonenumber);
						numbers.printPersonInfo();
//						for(Person person: numbers) {
//							person.printPersonInfo();
//						}
						break;
					case 5:
						
						System.out.println("What to search by state or city?");
						String cors = in.nextLine();
						if(cors.toLowerCase().equals("city")) {
							System.out.println("Please Enter the City:");
							String city1 = in.nextLine();
							Person[] citys = phonebook.searchByCity(city1);
							for(Person person: citys) {
								person.printPersonInfo();
							}
						}else if(cors.toLowerCase().contentEquals("state")) {
							System.out.println("Please Enter the State:");
							String state1 = in.nextLine();
							Person[] states = phonebook.searchByState(state1);
							for(Person person: states) {
								person.printPersonInfo();
							}
						}else {
							System.out.println("Please type city or state");
						}
						break;
					case 6:
						break;
					default:
						System.out.println("Please enter a number between 1 and 6 inclusive");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Do you want to update or delete:");
				String edit = in.nextLine();
				Scanner number = new Scanner(System.in);
				if(edit.toLowerCase().equals("update")) {
					
					System.out.println("Please Enter a phonenumber to edit: ");
					String phonenumber = number.nextLine();
					Person numbers = phonebook.searchByPhonenumber(phonenumber);

					int x = 0;
					while (x != 9) {
						x = editMenu();
						
						switch(x) {
						case 1:
							System.out.println("Please enter edited First Name:");
							String newFirstName = in.nextLine();
							numbers.setFirstName(newFirstName);
							break;
						case 2:
							System.out.println("Please enter edited Middle Name:");
							String newMiddleName = in.nextLine();
							numbers.setMiddleName(newMiddleName);
							break;
						case 3:
							System.out.println("Please enter edited Last Name:");
							String newLastName = in.nextLine();
							numbers.setLastName(newLastName);
							break;
						case 4:
							System.out.println("Please enter edited Street:");
							String newStreet = in.nextLine();
							numbers.address.setStreet(newStreet);
							break;
						case 5:
							System.out.println("Please enter edited City:");
							String newCity = in.nextLine();
							numbers.address.setCity(newCity);
							break;
						case 6:
							System.out.println("Please enter edited State:");
							String newState = in.nextLine();
							numbers.address.setState(newState);
							break;
						case 7:
							System.out.println("Please enter edited Zip:");
							String newZip = in.nextLine();
							numbers.address.setState(newZip);
							break;
						case 8:
							System.out.println("Please enter edited Phone number:");
							String newPhone = in.nextLine();
							numbers.setTelephone(newPhone);
							break;
						case 9:
							break;
						default:
							break;
						}
					}
				}else if(edit.toLowerCase().equals("delete")){
					System.out.println("Please Enter a phonenumber to delete: ");
					String phonenumber = number.nextLine();
					phonebook.removePerson(phonebook.searchByPhonenumber(phonenumber));
				}
				break;
			case 4:
				Person[] people = phonebook.getPersons();
				Arrays.sort(people, (a,b) -> a.firstName.compareTo(b.firstName));
	//			Arrays.sort(people);
				System.out.println(Arrays.asList(people));
				
				
//				for(Person person: people) {
//					person.printPersonInfo();
//				}
				break;
			case 5:
				break;
			default:
				System.out.println("Please enter a number between 1 and 5 inclusive");
				break;
			}
		}
	}
	



	public static int getMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1: Add new entry");
		System.out.println("2: Search for entry");
		System.out.println("3: Edit an entry");
		System.out.println("4: Show all records");
		System.out.println("5: Exit program");
		System.out.print("Select the number you want to do: ");

		return scanner.nextInt();
	}

	public static int searchMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How would you like to search");
		System.out.println("1: Search by First Name");
		System.out.println("2: Search by Last Name");
		System.out.println("3: Search by First and Last name(first,last)");
		System.out.println("4: Search by phone number");
		System.out.println("5: Search by city or state");
		System.out.println("6: Exit");
		System.out.print("Select the number you want to do: ");
		
		return scanner.nextInt();
	}

	public static int editMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How would you like to edit");
		System.out.println("1: First Name");
		System.out.println("2: Middle Name");
		System.out.println("3: Last Name");
		System.out.println("4: Street");
		System.out.println("5: City");
		System.out.println("6: State");
		System.out.println("7: zip");
		System.out.println("8: Phone Number");
		System.out.println("9: Exit");
		return scanner.nextInt();
	}
}
