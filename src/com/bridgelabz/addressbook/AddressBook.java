package com.bridgelabz.addressbook;

import java.util.Scanner;

class AddressBook{
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	String phoneNum;

	//constructor of class contact book
	public AddressBook (String firstName, String lastName, String address, String city, String state, int zip, String phoneNum){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = city;
		this.city = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
	}
	
    public void PrintPersonDetails(){
        System.out.println("First Name: "+firstName);
        System.out.println("Last Name: "+lastName);
        System.out.println("Address: "+address);
        System.out.println("City: "+city);
        System.out.println("State: "+state);
        System.out.println("Zip Code: "+zip);
        System.out.println("Phone Number: "+phoneNum);
    }
    
    public static void addContact() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter First name");
    	String firstName = sc.nextLine();
    	System.out.println("Enter Last name");
    	String lastName = sc.nextLine();
    	System.out.println("Enter address");
    	String address = sc.nextLine();
    	System.out.println("Enter city");
    	String city = sc.nextLine();
    	System.out.println("Enter state");
    	String state = sc.nextLine();
    	System.out.println("Enter zip code");
    	int zip = sc.nextInt();
    	System.out.println("Enter phone number");
    	String phoneNum = sc.next();
    	    
    	AddressBook book = new AddressBook (firstName, lastName, address, city, state, zip, phoneNum );
    	book.PrintPersonDetails();
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an option: ");
		System.out.println("1. Add a contact ; 2. Edit a contact ; 3. Delete a contact ; 4. Print all contacts: ");
		int i = sc.nextInt();
		switch(i) {
			case 1:
				addContact();
			case 2:
				
			case 3:
				
			case 4:
				
		}
	}
}
