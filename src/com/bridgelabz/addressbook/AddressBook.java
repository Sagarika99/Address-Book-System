package com.bridgelabz.addressbook;

import java.util.Arrays;
import java.util.Scanner;

class contactBook{
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	String phoneNum;

	//constructor of class contact book
	public contactBook (String firstName, String lastName, String address, String city, String state, int zip, String phoneNum){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = city;
		this.city = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
	}
}

public class AddressBook{
	Scanner sc = new Scanner(System.in);
	int record = 0;
	public contactBook details[];

    public void addContact() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of entries: ");
    	int record = sc.nextInt();
    	details = new contactBook[record];
    	for (int i=0; i<record; i++) {
    		System.out.println(i+1);
    		System.out.println("Enter First name: ");
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
        	
        	details[i] = new contactBook (firstName, lastName, address, city, state, zip, phoneNum );
        	//book.PrintPersonDetails();
    	}
}
    	
    public void PrintPersonDetails(){
      	for (int i=0; i < details.length; i++) {
      		if(details[i]!=null) {
      		  System.out.println("First Name: "+details[i].firstName);
              System.out.println("Last Name: "+details[i].lastName);
              System.out.println("Address: "+details[i].address);
              System.out.println("City: "+details[i].city);
              System.out.println("State: "+details[i].state);
              System.out.println("Zip Code: "+details[i].zip);
              System.out.println("Phone Number: "+details[i].phoneNum);
              System.out.println();
      		}
      	}
      }
      
    public void editDetails() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the First Name: ");
    	String name = sc.next();
    	for (int j=0; j < details.length; j++) {
        	if(name.equals(details[j].firstName)){
                System.out.println("Enter First name");
                details[j].firstName = sc.next();
                System.out.println("Enter Last name");
                details[j].lastName = sc.next();
                System.out.println("Enter address");
                details[j].address = sc.next();
                System.out.println("Enter city");
                details[j].city = sc.next();
                System.out.println("Enter state");
                details[j].state = sc.next();
                System.out.println("Enter zip code");
                details[j].zip = sc.nextInt();
                System.out.println("Enter phone number");
                details[j].phoneNum = sc.next();
        	}
    	}   	
    }

    public void deleteDetails() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of user to be deleted: ");
        String firstname = sc.nextLine();
        for (int i = 0; i < details.length; i++) {
            if (firstname.equals(details[i].firstName)) {
            	details[i].firstName = null;
            	details[i].lastName = null;
            	details[i].address = null;
            	details[i].city = null;
            	details[i].state = null;
            	details[i].zip = 0;
            	details[i].phoneNum = null;
            }
        }
        	
    }
    
	public static void main(String[] args) {
		AddressBook bookBuilder = new AddressBook();
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
