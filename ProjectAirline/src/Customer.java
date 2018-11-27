import java.util.ArrayList;

public class Customer extends Person { 

	ArrayList<Object> CusInfo = new ArrayList<Object>();
	
	private int IDnumber = 0;
	private String Firstname;
	private String Lastname;
	private String Address;
	private String Zip;
	private String State;
	private String Username;
	private String Password;
	private String Email;
	private String SSN;
	private String SecurityQ;
	private String Flight;
	
	public Customer() {
		//THIS INFO BELOW CAN BE DELETED BECAUSE IT IS A NOARGS CONSTRUCTOR
		this.IDnumber = 0;
		this.Firstname = "Tom";
		 this.Lastname = "Jason";
		 this.Address = "123 abc rd";
		 this.Zip = "12345";
		 this.State = "Ga";
		 this.Username = "customer";
		 this.Password = "123456";
		 this.Email = "tom@email.com";
		 this.SSN = "123456789";
		 this.SecurityQ = "IDK";
		 this.Flight = "N/A";
		 
	}
	public Customer(
			int customerIDnumber,
			String customerFirstname,
			String customerLastname,
			String customerAddress,
			String customerZip,
			String customerState,
			String customerUsername,
			String customerPassword,
			String customerEmail,
			String customerSSN,
			String customerSecurityQ)
	{
		super.Person(customerIDnumber,customerFirstname, customerLastname, customerAddress, customerZip,customerState,customerUsername,customerPassword,
				customerEmail, customerSSN, customerSecurityQ);    
	}
	public void FlightString() {
		System.out.println("Here is your Flight list:");
		int count = 0;
		for(int i = 0; i < CusInfo.size(); i++) {
			count++;
		}
		if(count <1) {
			System.out.println("Nothing");
		}else {
		for(int i = 0; i < CusInfo.size(); i++) {
			System.out.println("\n"+CusInfo.get(i));
		}
		}
	}
	public boolean Flight(String a) {
		for(int i = 0; i < CusInfo.size(); i++) {
			if(CusInfo.get(i).equals(a)) {
				return false;
			}
		}
		return true;
	}
	public int getcustomerIDnumber() {
		return super.getIDnumber();
	}
	public void setcustomerFirstname(String customerFirstname) {
		super.setFirstname(customerFirstname);
	}public String getcustomerFirstname() {
		return super.getFirstname();
	}
	public void setcustomerLastname(String customerLastname) {
		super.setLastname(customerLastname);
	}
	public void setcustomerAddress(String customerAddress) {
		super.setAddress(customerAddress);	
		}
	public void setcustomerZip(String customerZip) {
		super.setZip(customerZip);
	}
	public void setcustomerState(String customerState) {
		super.setState(customerState);
	}
	public void setcustomerUsername(String customerUsername) {
		super.setUsername(customerUsername);
	}
	public String getcustomerUsername() {
		return super.getUsername();
	}
	public void setcustomerPassword(String customerPassword) {
		super.setPassword(customerPassword);
	}
	public String getcustomerPassword() {
		return super.getPassword();
	}
	public void setcustomerEmail(String customerEmail) {
		super.setEmail(customerEmail);
	}
	public void setcustomerSSN(String customerSSN) {
		super.setSSN(customerSSN);
	}
	public void setcustomerSecurityQ(String customerSecurityQ) {
		super.setSecurityQ(customerSecurityQ);
	}
	public String getcustomerSecurityQ() {
		return super.getSecurityQ();
	}
	public void addFlight(String Flight) {
		CusInfo.add(Flight);
	}public void deletFlight(String Flight) {
		CusInfo.remove(Flight);
	}
	@Override
	public String toString() {
		return  "\n*ID Number: " + getcustomerIDnumber() +
				"\n*Name: "+ getFirstname() + " " + getLastname()+
				"\n*Address: "+ getAddress() + " " + getState() + ", " + getZip() + 
				"\n*Username: " + getUsername() +
				"\n*Password: " +  getPassword();
	}
	}
