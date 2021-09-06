package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBookRunner {

	Scanner sc = new Scanner(System.in);
	int record = 0;
	public ArrayList<contactBook> contactDetails;
	public ArrayList<ArrayList<contactBook>> addressBook = new ArrayList<ArrayList<contactBook>>();
	public HashMap<String, String> personInCity = new HashMap<String, String>();
	public HashMap<String, String> personInState = new HashMap<String, String>();

	public void addAddressBook() {
		addressBook.add(contactDetails = new ArrayList<contactBook>());
	}
	 
	public void printAddressBook() {
		System.out.println("Enter index number from: "+addressBook.size());
		int index = sc.nextInt();
		for (int i=0 ; i<addressBook.get(index).size() ; i++) {
            System.out.println((addressBook.get(index)).get(i).firstName);
            System.out.println((addressBook.get(index)).get(i).lastName);
            System.out.println((addressBook.get(index)).get(i).address);
            System.out.println((addressBook.get(index)).get(i).city);
            System.out.println((addressBook.get(index)).get(i).state);
            System.out.println((addressBook.get(index)).get(i).zip);
            System.out.println((addressBook.get(index)).get(i).phoneNum);
		}
	}
	
	public boolean checkDuplicate(String firstname) {
		ArrayList<String> duplicateArr = new ArrayList<String>();
    	for (int j=0; j<addressBook.size(); j++) {
    		for (int i=0; i<addressBook.get(j).size(); i++) {
    			duplicateArr.add(addressBook.get(j).get(i).firstName);
    		}
	  	}
    	if (duplicateArr.stream().anyMatch(n -> firstname.equals(n)))
    		return true;
	  	return false;
	}
	
    public void addContact() {
     
    	System.out.println("Enter First name: ");
    	//String dummy = sc.next();
       	String firstName = sc.next();
       	System.out.println("Enter Last name: ");
       	String lastName = sc.next();
       	System.out.println("Enter address: ");
       	String address = sc.next();
       	System.out.println("Enter city: ");
       	String city = sc.next();
       	System.out.println("Enter state: ");
       	String state = sc.next();
       	System.out.println("Enter zip code: ");
       	int zip = sc.nextInt();
       	System.out.println("Enter phone number: ");
       	String phoneNum = sc.next();     
       	
       	if (checkDuplicate(firstName) == true) {
       		System.out.println("Duplicate Entry");
       		contactDetails.remove(firstName);
       	}
       	else {
       		contactBook addressBookCollections = new contactBook (firstName, lastName, address, city, state, zip, phoneNum );
		    contactDetails.add(addressBookCollections);
		    String value = firstName+ " " +lastName;
		    personInCity.put(value, city);
		    personInState.put(value, state);
		}
    }
    
    public void searchByStateCity() {
    	System.out.println("Enter city or state you want to search: 1.City 2.State");
    	int choice = sc.nextInt();
    	if (choice == 1) {
    		System.out.println("Enter name of city:");
    		String citySearch = sc.next();
    		addressBook.stream().forEach(n -> { for (contactBook book : n) {
    			if (book.city.equals(citySearch)) {
    				System.out.println(book.firstName + " " + book.lastName + " from " + book.city);
    			}}});
    	}
    	else {
        	System.out.println("Enter name of state:");
        	String stateSearch = sc.next();;
    		addressBook.stream().forEach(n -> { for (contactBook book : n) {
    			if (book.state.equals(stateSearch)) {
    				System.out.println(book.firstName + " " + book.lastName + " from " + book.state);
    			}}});
    	}
    }
    
    public void viewPersonByCityState() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("View person by 1.City 2.State: ");
    	int choice = sc.nextInt();
    	if (choice == 1) {
    		personInCity.keySet().stream().forEach(n -> 
    		System.out.println(n + " lives in city " +personInCity.get(n)));
    		}
    	else {
    		personInState.keySet().stream().forEach(n -> 
    		System.out.println(n + " lives in city " +personInState.get(n)));
    	}
    }
    
    public void countPersonInCityState() {
    	Scanner sc = new Scanner(System.in);    	
    	System.out.println("Enter 1.City 2.State: ");
    	int choice = sc.nextInt();
    	if (choice == 1) {
    		Map<String, Long> count = personInCity.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    		count.keySet().stream().forEach(n -> 
    		System.out.println(n +" : " + count.get(n)));
    	}
    	else {
       		Map<String, Long> count = personInState.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    		count.keySet().stream().forEach(n -> 
    		System.out.println(n +" : " + count.get(n)));
    	}
    }
    	
    public void PrintPersonDetails(){
    	for (int i=0; i<contactDetails.size(); i++) {
    		System.out.println(contactDetails.get(i));
    	}
    }
      
    public void editDetails() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the First Name: ");
    	String name = sc.next();
    	
    	for (int j=0; j < addressBook.size(); j++) {
    		for (int i=0; i<addressBook.get(j).size(); i++) {
            	if(name.equals(addressBook.get(j).get(i).firstName)){
                    System.out.println("Enter First name");
                    contactDetails.get(j).firstName = sc.next();
                    System.out.println("Enter Last name");
                    contactDetails.get(j).lastName = sc.next();
                    System.out.println("Enter address");
                    contactDetails.get(j).address = sc.next();
                    System.out.println("Enter city");
                    contactDetails.get(j).city = sc.next();
                    System.out.println("Enter state");
                    contactDetails.get(j).state = sc.next();
                    System.out.println("Enter zip code");
                    contactDetails.get(j).zip = sc.nextInt();
                    System.out.println("Enter phone number");
                    contactDetails.get(j).phoneNum = sc.next();
                    

    				personInCity.put(contactDetails.get(j).firstName+ " " +contactDetails.get(j).lastName, contactDetails.get(j).city);
        		    personInState.put(contactDetails.get(j).firstName+ " " +contactDetails.get(j).lastName, contactDetails.get(j).state);
            	}
    		}
    	}
    }
    	
    public void deleteDetails() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of user to be deleted: ");
        String firstname = sc.nextLine();
        for (int j=0; j < addressBook.size(); j++) {
    		for (int i=0; i<addressBook.get(j).size(); i++)  {
    			if (firstname.equals(addressBook.get(j).get(i).firstName)) {
        			addressBook.get(j).remove(i);
    			}
            }
        }
     } 
    
    public void sortByNames() {
    	for (int i=0; i<addressBook.size(); i++) {
    		List<contactBook> sort = addressBook.get(i).stream().sorted((o1, o2) -> o1.firstName.compareTo(o2.firstName)).collect(Collectors.toList());
    		sort.forEach(System.out::println);
    	}
    }
    
    public void sortByCityStateZip() {
    	 Scanner sc = new Scanner(System.in);
         System.out.println("Enter to Sort 1.City 2.State 3.Zip");
         int choice = sc.nextInt();
         if (choice == 1) {
         	for (int i=0; i<addressBook.size(); i++) {
         		System.out.println("Address Book " +i);
        		List sortCity = addressBook.get(i).stream().sorted((o1, o2) -> o1.city.compareTo(o2.city)).collect(Collectors.toList());
        		sortCity.forEach(System.out::println);
        		System.out.println();
         	}
         }
         else if (choice == 2) {
          	for (int i=0; i<addressBook.size(); i++) {
          		System.out.println("Address Book"  +i);
         		List sortState = addressBook.get(i).stream().sorted((o1, o2) -> o1.state.compareTo(o2.state)).collect(Collectors.toList());
         		sortState.forEach(System.out::println);
          	}
         }
         else {
          	for (int i=0; i<addressBook.size(); i++) {
          		System.out.println("Address Book"  +i);
         		List sortZip = addressBook.get(i).stream().sorted(Comparator.comparingInt(contactBook::getZip)).collect(Collectors.toList());
         		sortZip.forEach(System.out::println);
          	}
         }
    }
    
	public static void main(String[] args) {
		AddressBookRunner bookBuilder = new AddressBookRunner();
		Scanner sc = new Scanner(System.in);
		bookBuilder.addAddressBook();
		int flag=0;
		while (flag==0) {
			System.out.println("Choose an option: ");
			System.out.println("1.Add a contact 2.Edit a contact 3.Delete a contact  4.Print all contacts 5.Add Another Address Book 6.Print Address Book 7.Search By City or State 8.View persons in city or state 9.Count Person In City or State 10.Sort By Name 11.Sort by City,State or ZipCode 12.Exit: ");
			int i = sc.nextInt();
			
			switch(i) {
				case 1:
					bookBuilder.addContact();
					break;
				case 2:
					bookBuilder.editDetails();
					break;
				case 3:
					bookBuilder.deleteDetails();
					break;
				case 4:
					bookBuilder.PrintPersonDetails();
					break;
				case 5:
					bookBuilder.addAddressBook();
					break;
				case 6:
					bookBuilder.printAddressBook();
					break;
				case 7:
					bookBuilder.searchByStateCity();
					break;
				case 8:
					bookBuilder.viewPersonByCityState();
					break;
				case 9:
					bookBuilder.countPersonInCityState();
					break;
				case 10:
					bookBuilder.sortByNames();
					break;
				case 11:
					bookBuilder.sortByCityStateZip();
					break;
				case 12:
					flag = 1;
					break;
			}
		}
	}
}

