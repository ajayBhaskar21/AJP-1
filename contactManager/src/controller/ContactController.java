package controller;

import java.util.HashMap;
import java.util.Map;

import Model.Contact;
import View.ContactView;

public class ContactController {
	private ContactView view;
	private Map<String, Contact> contactList;

	public ContactController(ContactView view) {
		this.view = view;
		contactList = new HashMap<>();
	}

	public void startMenu() {

		while (true) {
			int val = view.menu();
			if (val == 0) {
				break;
			} else if (val == 1) {
				addContact();
			} else if (val == 2) {
				displayContacts();
			} else if (val == 3) {
				updateContact();
			} else if (val == 4) {
				deleteContact();
			} else if (val == 5) {
				searchBasedOnNumber();
			} else if (val == 6) {
				searchBasedOnName();
			} else if (val == 7) {
				searchBasedOnEmail();
			} else {
				System.out.println("Wrong choice");
			}
		}

	}

	private void addContact() {
		String contactNumber = view.contactNumber();
		if (isContactExists(contactNumber)) {
			System.out.println("contact already exists!!");
		} else {
			view.createNewContact(contactList, contactNumber);
			System.out.println("contact created successfully");
		}
	}

	private void displayContacts() {
		view.showContacts(contactList);
	}

	private void updateContact() {
		String contactNumber = view.contactNumber();
		if (isContactExists(contactNumber)) {
			System.out.println("Provide new name and email to update the contact : ");
			String name = view.contactName();
			String email = view.contactEmail();
			contactList.put(contactNumber, new Contact(contactNumber, name, email));
		} else {
			System.out.println("contact number not found!!!");
		}
	}

	private void deleteContact() {
		String contactNumber = view.contactNumber();
		if (isContactExists(contactNumber)) {
			contactList.remove(contactNumber);
			System.out.println("contact deleted from contacts.");
		} else {
			System.out.println("contact number not found!!!");
		}
	}

	private void searchBasedOnEmail() {
		String contactEmail = view.contactEmail();
		boolean contactFound = false;
		for (String i : contactList.keySet()) {
			if (contactList.get(i).getEmail().equalsIgnoreCase(contactEmail)) {
				contactFound = true;
				view.displayContact(contactList.get(i));
				break;
			}
		}
		if (!contactFound) {
			System.out.println("No contacts found with this email");
		}
	}

	private void searchBasedOnName() {

		String contactName = view.contactName();
		boolean contactFound = false;
		for (String i : contactList.keySet()) {
			if (contactList.get(i).getName().equalsIgnoreCase(contactName)) {
				contactFound = true;
				view.displayContact(contactList.get(i));
			}
		}
		if (!contactFound) {
			System.out.println("No contacts found with this name");
		}

	}

	private void searchBasedOnNumber() {
		String contactNumber = view.contactNumber();
		if (isContactExists(contactNumber)) {

			view.displayContact(contactList.get(contactNumber));
		} else {
			System.out.println("contact number not found!!");
		}
	}

	private boolean isContactExists(String phoneNumber) {
		if (contactList.containsKey(phoneNumber))
			return true;
		return false;
	}

}
