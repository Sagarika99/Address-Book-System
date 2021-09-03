package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookRunner {

	Scanner sc = new Scanner(System.in);
	int record = 0;
	ArrayList<contactBook> contactDetails;
	ArrayList<ArrayList<contactBook>> addressBook = new ArrayList<ArrayList<contactBook>>();
	

	public void addAddressBook() {
		System.out.println("Enter name of Address Book: ");
		String name = sc.next();
		addressBook.add(contactDetails = new ArrayList<contactBook>());
	}
	
	public void totalAddressBook() {
		System.out.println(addressBook.size());   
	}
	
	public void printAddressBook() {
		System.out.println("Enter index of Address Book: ");
		int index = sc.nextInt();
		for (int i=0 ; i<addressBook.get(index).size() ; i++) {
            System.out.println((addressBook.get(index)).get(i).firstName);
            System.out.println((addressBook.get(index)).get(i).lastName);
            System.out.println((addressBook.get(index)).get(i).address);
            System.out.println((addressBook.get(index)).get(i).state);
            System.out.println((addressBook.get(index)).get(i).city);
            System.out.println((addressBook.get(index)).get(i).zip);
            System.out.println((addressBook.get(index)).get(i).phoneNum);
		}
	}
	
    public void addContact() {
    	System.out.println("Enter First name: ");
    	String dummy = sc.next();
       	String firstName = sc.nextLine();
       	System.out.println("Enter Last name: ");
       	String lastName = sc.nextLine();
       	System.out.println("Enter address: ");
       	String address = sc.nextLine();
       	System.out.println("Enter city: ");
       	String city = sc.nextLine();
       	System.out.println("Enter state: ");
       	String state = sc.nextLine();
       	System.out.println("Enter zip code: ");
       	int zip = sc.nextInt();
       	System.out.println("Enter phone number: ");
       	String phoneNum = sc.next();        	
       
       	contactBook addressBookCollections = new contactBook (firstName, lastName, address, city, state, zip, phoneNum );
       	contactDetails.add(addressBookCollections);

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
    	
    	for (int j=0; j < contactDetails.size(); j++) {
        	if(name.equals(contactDetails.get(j).firstName)){
                System.out.println("Enter First name");
                contactDetails.get(j).firstName = sc.nextLine();
                System.out.println("Enter Last name");
                contactDetails.get(j).lastName = sc.nextLine();
                System.out.println("Enter address");
                contactDetails.get(j).address = sc.nextLine();
                System.out.println("Enter city");
                contactDetails.get(j).city = sc.nextLine();
                System.out.println("Enter state");
                contactDetails.get(j).state = sc.nextLine();
                System.out.println("Enter zip code");
                contactDetails.get(j).zip = sc.nextInt();
                System.out.println("Enter phone number");
                contactDetails.get(j).phoneNum = sc.nextLine();
        	}

    	}
    }
    	
    public void deleteDetails() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of user to be deleted: ");
        String firstname = sc.nextLine();
        for (int i = 0; i < contactDetails.size(); i++) {
            if (firstname.equals(contactDetails.get(i).firstName)) {
            	contactDetails.remove(i);
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
			System.out.println("1. Add a contact ; 2. Edit a contact ; 3. Delete a contact ; 4. Print all contacts 5. Add Another Address Book 6. Print Address Book 7. Show Number of Address Book 8. Exit: ");
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
					bookBuilder.totalAddressBook();
					break;
				case 8:
					flag = 1;
					break;
			}
		}
	}
}

