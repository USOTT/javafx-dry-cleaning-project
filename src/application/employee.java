package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class employee {
	private final StringProperty EmployeeID;
	private final StringProperty FirstName;
	private final StringProperty LastName;
	private final StringProperty FullName;
	private final StringProperty Title;
	private final StringProperty EmployeeNumber;
	private final StringProperty HourlySalary;

	public employee(String EmployeeID, String FirstName, String LastName, String FullName, String Title,
			String EmployeeNumber, String HourlySalary) {
		this.EmployeeID = new SimpleStringProperty(EmployeeID);
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		this.FullName = new SimpleStringProperty(FullName);
		this.Title = new SimpleStringProperty(Title);
		this.EmployeeNumber = new SimpleStringProperty(EmployeeNumber);
		this.HourlySalary = new SimpleStringProperty(HourlySalary);
	}

	public String getEmployeeID() {
		return EmployeeID.get();
	}

	public String getFirstName() {
		return FirstName.get();
	}

	public String getLastName() {
		return LastName.get();
	}

	public String getFullName() {
		return FullName.get();
	}

	public String getTitle() {
		return Title.get();
	}

	public String getEmployeeNumber() {
		return EmployeeNumber.get();
	}

	public String getHourlySalary() {
		return HourlySalary.get();
	}

	public void setEmployeeID(String value) {
		EmployeeID.set(value);
	}

	public void setLastName(String value) {
		LastName.set(value);
	}

	public void setFirstName(String value) {
		FirstName.set(value);
	}

	public void setFullName(String value) {
		FullName.set(value);
	}

	public void setTitle(String value) {
		Title.set(value);
	}

	public void setEmployeeNumber(String value) {
		EmployeeNumber.set(value);
	}

	public void setHourlySalary(String value) {
		HourlySalary.set(value);
	}

	public StringProperty EmployeeIDProperty() {
		return EmployeeID;
	}

	public StringProperty FirstNameProperty() {
		return FirstName;
	}

	public StringProperty LastNameProperty() {
		return LastName;
	}

	public StringProperty FullNameProperty() {
		return FullName;
	}

	public StringProperty TitleIDProperty() {
		return Title;
	}

	public StringProperty EmployeeNumberProperty() {
		return EmployeeNumber;
	}

	public StringProperty HourlySalaryProperty() {
		return HourlySalary;
	}
}
