package business;

import java.util.Arrays;

public class Phonebook {

	Person[] persons = new Person[0];

	public void addPerson(Person Person) {
		Person[] temp = new Person[persons.length + 1];

		for(int i = 0; i < persons.length; i++) {
			temp[i]= persons[i];
		}

		temp[temp.length-1] = Person;

		persons = temp;
	}

	public Person[] getPersons() {
		return persons;
	}

	public void setPersons(Person[] persons) {
		this.persons = persons;
	}

	public Person[] searchByFName(String name) {
		Person[] personsSearched = new Person[0];
		
		for(Person person : this.persons) {
			if(person.getFirstName().toLowerCase().equals(name.toLowerCase())) {
				personsSearched = expandArray(personsSearched, person);
				
			}
		}
		return personsSearched;
		
	}	
	
	public Person[] searchByLName(String name) {
		Person[] personsSearched = new Person[0];
		
		for(Person person : this.persons) {
			if(person.getLastName().toLowerCase().equals(name.toLowerCase())) {
				personsSearched = expandArray(personsSearched, person);
				
			}
		}
		return personsSearched;
		
	}
	
	public Person[] searchByFullName(String fname,String lname) {
		Person[] personsSearched = new Person[0];
		
		for(Person person : this.persons) {
			if(person.getFirstName().toLowerCase().equals(fname.toLowerCase())
					&& person.getLastName().toLowerCase().equals(lname.toLowerCase())) {
				personsSearched = expandArray(personsSearched, person);
				
			}
		}
		return personsSearched;
		
	}
	
	public Person searchByPhonenumber(String number) {
		Person[] personsSearched = new Person[0];
		
		for(Person person : this.persons) {
			if(person.getTelephone().equals(number)) {
				//personsSearched = expandArray(personsSearched, person);
				return person;
			}
		}
		
		return personsSearched[0];
		
	}
	
	public Person[] searchByCity(String city) {
		Person[] personsSearched = new Person[0];
		
		for(Person per : this.persons) {
			if(per.getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
				personsSearched = expandArray(personsSearched, per);
				
			}
		}
		return personsSearched;
	}
	
	public Person[] searchByState(String state) {
		Person[] personsSearched = new Person[0];
		
		for(Person per : this.persons) {
			if(per.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
				personsSearched = expandArray(personsSearched, per);
				
			}
		}
		return personsSearched;
		
	}

	public void removePerson(Person person) {
		System.out.println("Person to be removed:"  + person.getFirstName() + person.getTelephone());
		Person[] temp = new Person[persons.length - 1];
		int counter = 0;
		
		for(int i = 0; i < persons.length; i++) {
			if(persons[i] != person) {
				temp[counter] = persons[i];
				counter++;
			}
		}
		persons = temp;
		System.out.println("Person removed");
	}
	
	public Person[] expandArray(Person[] array, Person per) {
		Person[] temp = new Person[array.length + 1];
		
		for(int i = 0; i < array.length; i++) {
			temp[i]= array[i];
		}
		
		temp[temp.length-1] = per;
		
		return temp;
	}
	
	public String[] convert(Person[] p) {
		String[] convert = new String[p.length];
		for(int i = 0; i < p.length; i++) {
			convert[i] = p[i].toString();
		}
		Arrays.sort(convert);
		
		return convert;
	}
	 
	
	
	

}
