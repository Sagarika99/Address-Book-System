package com.bridgelabz.addressbook;

import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookRunner {

	Scanner sc = new Scanner(System.in);
	int record = 0;
	public LinkedList<contactBook> contactBookDetails = new LinkedList<contactBook>();

    public void addContact() {
    	System.out.println("Enter First name: ");
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
       	contactBookDetails.add(addressBookCollections);

}
    	
    public void PrintPersonDetails(){
    	for (int i=0; i<contactBookDetails.size(); i++) {
    		System.out.println(contactBookDetails.get(i));
    	}
    }
      
    public void editDetails() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the First Name: ");
    	String name = sc.next();
    	
    	for (int j=0; j < contactBookDetails.size(); j++) {
        	if(name.equals(contactBookDetails.get(j).firstName)){
                System.out.println("Enter First name");
                contactBookDetails.get(j).firstName = sc.nextLine();
                System.out.println("Enter Last name");
                contactBookDetails.get(j).lastName = sc.nextLine();
                System.out.println("Enter address");
                contactBookDetails.get(j).address = sc.nextLine();
                System.out.println("Enter city");
                contactBookDetails.get(j).city = sc.nextLine();
                System.out.println("Enter state");
                contactBookDetails.get(j).state = sc.nextLine();
                System.out.println("Enter zip code");
                contactBookDetails.get(j).zip = sc.nextInt();
                System.out.println("Enter phone number");
                contactBookDetails.get(j).phoneNum = sc.nextLine();
        	}

    	}
    }
    	
    public void deleteDetails() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of user to be deleted: ");
        String firstname = sc.nextLine();
        for (int i = 0; i < contactBookDetails.size(); i++) {
            if (firstname.equals(contactBookDetails.get(i).firstName)) {
            	contactBookDetails.remove(i);
            }
        }
     } 
    
	public static void main(String[] args) {
		AddressBookRunner bookBuilder = new AddressBookRunner();
		Scanner sc = new Scanner(System.in);
		int flag=0;
		while (flag==0) {
			System.out.println("Choose an option: ");
			System.out.println("1. Add a contact ; 2. Edit a contact ; 3. Delete a contact ; 4. Print all contacts 5. Exit: ");
			int i = sc.nextInt();
			//int total = 0;
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
					flag = 1;
					break;
			}
		}
	}
}

