package Backend;

public class Person {

	//private int IDnumber = 0;
	private String Firstname = "";
	private String Lastname = "";
	private String Address = "";
	private String City = "";
	private String State = "";
	private String Zip = "";
	private String Username = "";
	private String Password = "";
	private String Email = "";
	private String SSN = "";
	private String SecurityQ = "";
	private String SecurityA = "";

	public Person() {
	}

	public Person(String Firstname, String Lastname, String Address, String City, String State, String Zip,
			String Username, String Password, String Email, String SSN, String SecurityQ, String SecurityA) {
		
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.Zip = Zip;
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
		this.SSN = SSN;
		this.SecurityQ = SecurityQ;
		this.SecurityA = SecurityA;
	}

	/*public int getIDnumber() {
		return IDnumber;
	}*/

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setLastname(String customerLastname) {
		this.Lastname = customerLastname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setAddress(String customerAddress) {
		this.Address = customerAddress;
	}

	public String getAddress() {
		return Address;
	}

	public void setZip(String customerZip) {
		this.Zip = customerZip;
	}

	public String getZip() {
		return Zip;
	}

	public void setState(String customerState) {
		this.State = customerState;
	}

	public String getState() {
		return State;
	}

	public void setUsername(String customerUsername) {
		this.Username = customerUsername;
	}

	public String getUsername() {
		return Username;
	}

	public void setPassword(String customerPassword) {
		this.Password = customerPassword;
	}

	public String getPassword() {
		return Password;
	}

	public void setEmail(String customerEmail) {
		this.Email = customerEmail;
	}

	public String setEmail() {
		return Email;
	}

	public void setSSN(String customerSSN) {
		this.SSN = customerSSN;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSecurityQ(String customerSecurityQ) {
		this.SecurityQ = customerSecurityQ;
	}

	public String getSecurityQ() {
		return SecurityQ;
	}

	// needs to be updated!
	@Override
	public String toString() {
		return "\n*Name: " + getFirstname() + " " + getLastname() + "\n*Address: " + getAddress() + " " + getState()
				+ ", " + getZip() + "\n*Username: " + getUsername() + "\nPassword: " + getPassword();

	}

	public String getSecurityA() {
		return SecurityA;
	}

	public void setSecurityA(String securityA) {
		SecurityA = securityA;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
}
