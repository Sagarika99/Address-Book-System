package com.bridgelabz.addressbook;

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
	
    public void PrintPersonDetails(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zip);
        System.out.println(phoneNum);
    }
   
}


public class AddressBook {
	public static void main(String[] args) {
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
        String phoneNum = sc.nextLine();
        
        contactBook book = new contactBook (firstName, lastName, address, city, state, zip, phoneNum );
        book.PrintPersonDetails();
	}
}
