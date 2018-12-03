package databaseAccess;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    //fields
    private IntegerProperty ssn, zip;
    private StringProperty firstname, lastname, address, state, username, password, email, securityQ, securityA;


    //constructors
    public User() {
        ssn = new SimpleIntegerProperty();
        zip = new SimpleIntegerProperty();
        firstname = new SimpleStringProperty("");
        lastname = new SimpleStringProperty("");
        address = new SimpleStringProperty("");
        state = new SimpleStringProperty("");
        username = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        securityQ = new SimpleStringProperty("");
        securityA = new SimpleStringProperty("");
    }

    public User(int ssn, int zip, String firstname, String lastname, String address,
    		String state, String username, String password, String email, String securityQ, String securityA) {
    	this.ssn = new SimpleIntegerProperty(ssn);
        this.zip = new SimpleIntegerProperty(zip);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.address = new SimpleStringProperty(address);
        this.state = new SimpleStringProperty(state);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.securityQ = new SimpleStringProperty(securityQ);
        this.securityA = new SimpleStringProperty(securityA);
    }

	public int getSSN() {
		return ssn.get();
	}
	
    public IntegerProperty ssnProperty() {
		return ssn;
	}

	public void setSSN(int ssn) {
		this.ssn.set(ssn);
	}

	public int getZip() {
		return zip.get();
	}
	
	public IntegerProperty zipProperty() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip.set(zip);
	}

	public String getFirstname() {
		return firstname.get();
	}
	
	public StringProperty firstnameProperty() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname.set(firstname);
	}

	public String getLastname() {
		return lastname.get();
	}
	
	 public StringProperty lastnameProperty() {
	        return lastname;
	    }

	public void setLastname(String lastname) {
		this.lastname.set(lastname);
	}

	public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getSecurityQ() {
        return securityQ.get();
    }

    public StringProperty securityQProperty() {
        return securityQ;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ.set(securityQ);
    }

    public String getSecurityA() {
        return securityA.get();
    }

    public StringProperty securityAProperty() {
        return securityA;
    }

    public void setSecurityA(String securityA) {
        this.securityA.set(securityA);
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
