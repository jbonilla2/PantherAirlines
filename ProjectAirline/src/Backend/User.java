package Backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends Customer {

    private IntegerProperty ssn, zip;
    private StringProperty firstname, lastname, address, state, username, password, email, securityQ, securityA;

    public User() {
        ssn = new SimpleIntegerProperty();
        firstname = new SimpleStringProperty("");
        lastname = new SimpleStringProperty("");
        address = new SimpleStringProperty("");
        zip = new SimpleIntegerProperty();
        state = new SimpleStringProperty("");
        username = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        securityQ = new SimpleStringProperty("");
        securityA = new SimpleStringProperty("");
    }

    public User(int ssn, String firstname, String lastname, String address, int zip,
    		String state, String username, String password, String email, String securityQ, String securityA) {
    	
    	super(ssn, firstname, lastname, address, zip, state, username, password, email,securityQ,securityA);	
    	
    }

	public int getSSN() {
		return super.getSSN();
	}
	
    public IntegerProperty ssnProperty() {
		return super.ssnProperty();
	}
    @Override
	public void setSSN(int ssn) {
		super.setSSN(ssn);
	}

	public int getZip() {
		return super.getZip();
	}
	
	public IntegerProperty zipProperty() {
		return super.zipProperty();
	}
	
	public void setZip(int zip) {
		super.setZip(zip);
	}

	public String getFirstname() {
		return super.getFirstname();
	}
	
	public StringProperty firstnameProperty() {
		return super.firstnameProperty();
	}

	public void setFirstname(String firstname) {
		super.setFirstname(firstname);
	}

	public String getLastname() {
		return super.getLastname();
	}
	
	 public StringProperty lastnameProperty() {
	        return super.lastnameProperty();
	    }

	public void setLastname(String lastname) {
		super.setLastname(lastname);
	}

	public String getAddress() {
        return super.getAddress();
    }

    public StringProperty addressProperty() {
        return super.addressProperty();
    }

    public void setAddress(String address) {
        super.setAddress(address);;
    }

    public String getState() {
        return super.getState();
    }

    public StringProperty stateProperty() {
        return super.stateProperty();
    }

    public void setState(String state) {
        super.setState(state);
    }

    public String getUsername() {
        return super.getUsername();
    }

    public StringProperty usernameProperty() {
        return super.usernameProperty();
    }

    public void setUsername(String username) {
        super.setUsername(username);
    }

    public String getPassword() {
        return super.getPassword();
    }

    public StringProperty passwordProperty() {
        return super.passwordProperty();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public StringProperty emailProperty() {
        return super.emailProperty();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getSecurityQ() {
        return super.getSecurityQ();
    }

    public StringProperty securityQProperty() {
        return super.securityQProperty();
    }

    public void setSecurityQ(String securityQ) {
        super.setSecurityQ(securityQ);
    }

    public String getSecurityA() {
        return super.getSecurityA();
    }

    public StringProperty securityAProperty() {
        return super.securityAProperty();
    }

    public void setSecurityA(String securityA) {
        super.setSecurityA(securityA);
    }

	 //toString method
    @Override
    public String toString() {
    	return  "\n*SSN: " + getSSN() +
				"\n*Name: "+ getFirstname() + " " + getLastname()+
				"\n*Address: "+ getAddress() + " " + getState() + ", " + getZip() + 
				"\n*Username: " + getUsername() +
				"\n*Password: " +  getPassword();
    }

	

	
}
