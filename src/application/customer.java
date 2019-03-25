package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class customer {
	private final StringProperty customerID;
	private final StringProperty phoneNumber;
	private final StringProperty fullName;
	
	public customer(String customerID, String phoneNumber, String fullName) {
		this.customerID = new SimpleStringProperty(customerID);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.fullName = new SimpleStringProperty(fullName);
	}
	
	public String getCustomerID() {
		return customerID.get();
	}
	
	public String getPhoneNumber() {
		return phoneNumber.get();
	}
	
	public String getFullName() {
		return fullName.get();
	}

	public void setCustomerID(String value) {
		customerID.set(value);
	}
	
	public void setPhoneNumber(String value) {
		phoneNumber.set(value);
	}
	
	public void setFullName(String value) {
		fullName.set(value);
	}
	
	public StringProperty customerIDProperty() {
		return customerID;
	}
	
	public StringProperty phoneNumberProperty() {
		return phoneNumber;
	}
	
	public StringProperty fullNameProperty() {
		return fullName;
	}
}
