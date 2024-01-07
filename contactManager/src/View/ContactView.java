package View;

import java.util.Map;
import java.util.Scanner;

import Model.Contact;

public class ContactView {

	private Scanner in;

	public ContactView() {
		in = new Scanner(System.in);
	}

	public int menu() {

		System.out.println("\n\n1. Add new contact");
		System.out.println("2. Show the contacts");
		System.out.println("3. Edit contact");
		System.out.println("4. Delete contact");
		System.out.println("5. Search contact based on phone number");
		System.out.println("6. Search contact based on name");
		System.out.println("7. Search contact based on email");
		System.out.println("0. Exit");

		System.out.print("Enter choice : ");
		int choice = in.nextInt();
		in.nextLine();

		return choice;
	}

	public void createNewContact(Map<String, Contact> contactList, String contactNumber) {
		System.out.print("Enter contact name : ");
		String name = in.nextLine();

		System.out.print("Enter contact email : ");
		String email = in.nextLine();

		contactList.put(contactNumber, new Contact(contactNumber, name, email));

	}

	public void showContacts(Map<String, Contact> contactList) {
		System.out.println("\nDisplaying Contact List : ");
		for (String i : contactList.keySet()) {
			System.out.println("Contact name : " + contactList.get(i).getName());
			System.out.println("Contact phone number : " + contactList.get(i).getPhoneNumber());
			System.out.println("Contact email : " + contactList.get(i).getEmail());
			System.out.println();
		}

	}

	public void displayContact(Contact contact) {
		System.out.println("contact found : ");
		System.out.println("Contact name : " + contact.getName());
		System.out.println("Contact phone number : " + contact.getPhoneNumber());
		System.out.println("Contact email : " + contact.getEmail());
		System.out.println();
	}

	public String contactNumber() {
		System.out.print("Enter phone number : ");
		String phone = in.nextLine();
		return phone;
	}

	public String contactName() {
		System.out.print("Enter contact name : ");
		String name = in.nextLine();
		return name;
	}

	public String contactEmail() {
		System.out.print("Enter email : ");
		String email = in.nextLine();
		return email;
	}

}
