package project;
import java.util.Scanner;

public class Person{
	private int IDnumber = 0;
	private String Firstname = "Tom";
	private String Lastname = "Jason";
	private String Address = "123 abc rd";
	private String Zip = "12345";
	private String State = "Ga";
	private String Username = "person";
	private String Password = "123456";
	private String Email = "tom@email.com";
	private String SSN = "123456789";
	private String SecurityQ = "IDK";
	  
	public Person() {
		this.IDnumber = 0;
		this.Firstname = "Tom";
		 this.Lastname = "Jason";
		 this.Address = "123 abc rd";
		 this.Zip = "12345";
		 this.State = "Ga";
		 this.Username = "person";
		 this.Password = "123456";
		 this.Email = "tom@email.com";
		 this.SSN = "123456789";
		 this.SecurityQ = "IDK";
	}
	public Person( 
	int IDnumber,		
	String Firstname,
	String Lastname,
	String Address,
	String Zip,
	String State,
	String Username,
	String Password,
	String Email,
	String SSN,
	String SecurityQ)
	{
         this.IDnumber = IDnumber;
		 this.Firstname = Firstname;
		 this.Lastname = Lastname;
		 this.Address = Address;
		 this.Zip = Zip;
		 this.State = State;
		 this.Username = Username;
		 this.Password = Password;
		 this.Email = Email;
		 this.SSN = SSN;
		 this.SecurityQ = SecurityQ;   
	}  
	public int getIDnumber() {
		return IDnumber;
	}
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
	public String getEmail() {
		return Email;
	}
	public void setSSN(String customerSSN) {
		this.SSN = customerSSN;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSecurityQ(String SecurityQ) {
		this.SecurityQ = SecurityQ;
	}
	public String getSecurityQ() {
		return SecurityQ;
	}
	@Override
	public String toString() {
		return 
				"\n*Name: "+ getFirstname() + " " + getLastname()+
				"\n*Address: "+ getAddress() + " " + getState() + ", " + getZip() + 
				"\n*Username: " + getUsername() +
				"\nPassword: " +  getPassword();
				
	}
}