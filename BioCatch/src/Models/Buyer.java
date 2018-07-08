package Models;

public class Buyer
{
	
	private String stateSymbol;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String email;
	private String phone;
	
	public Buyer(String stateSymbol,String firstName, String lastName, 
			String address, String city, String state, String zipCode,
			 String email, String phone)
	{
		this.stateSymbol = stateSymbol;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.email = email;
		this.phone = phone;
	}

	public String getStateSymbol() {
		return stateSymbol;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	
}
