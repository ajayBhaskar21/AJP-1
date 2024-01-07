package Model;

public class Contact {
	private String phoneNumber;
	private String name;
	private String email;

	public Contact(String phoneNumber, String name, String email) {
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
	}
	
	public Contact(String name, String email) {
		this.email = email;
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
