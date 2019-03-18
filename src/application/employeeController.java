package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class employeeController implements Initializable {

	@FXML
	private TableView<employee> tableUsers;

	@FXML
	private TableColumn<employee, String> columnEmployeeID;

	@FXML
	private TableColumn<employee, String> columnFirstName;

	@FXML
	private TableColumn<employee, String> columnLastName;

	@FXML
	private TableColumn<employee, String> columnFullName;

	@FXML
	private TableColumn<employee, String> columnTitle;

	@FXML
	private TableColumn<employee, String> columnEmployeeNumber;

	@FXML
	private TableColumn<employee, String> columnHourlySalary;

	@FXML
	private Button btnClose;

	@FXML
	private TextField txtEmployeeNumber;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtTitle;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtHourlySalary;

	@FXML
	private Button btnSubmit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnEmployeeID.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
		columnFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		columnFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
		columnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		columnEmployeeNumber.setCellValueFactory(new PropertyValueFactory<>("EmployeeNumber"));
		columnHourlySalary.setCellValueFactory(new PropertyValueFactory<>("HourlySalary"));
		tableUsers.setItems(observableList);
		refresh();

	}

	void refresh() {
		tableUsers.getItems().clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// create a mysql database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root",
					"");
			Statement myStmt = (Statement) conn.createStatement();
			ResultSet myRs = ((java.sql.Statement) myStmt).executeQuery("select * from employees");

			while (myRs.next()) {
				employee employee = new employee(myRs.getString("EmployeeID"), myRs.getString("FirstName"),
						myRs.getString("LastName"), myRs.getString("FullName"), myRs.getString("Title"),
						myRs.getString("EmployeeNumber"), myRs.getString("HourlySalary"));
				tableUsers.getItems().add(employee);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	ObservableList<employee> observableList = FXCollections.observableArrayList();

	@FXML
	void btnCloseAction(ActionEvent event) {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnSubmitAction(ActionEvent event) {

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root",
					"");
			Statement myStmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO employees(FirstName, LastName,  FullName, Title, EmployeeNumber, HourlySalary) VALUES ('"
					+ txtFirstName.getText() + "','" + txtLastName.getText() + "','" + txtFirstName.getText() + ", "
					+ txtLastName.getText() + "', '" + txtTitle.getText() + "','" + txtEmployeeNumber.getText() + "','"
					+ txtHourlySalary.getText() + "')";

			((java.sql.Statement) myStmt).execute(sql);
			conn.close();
			refresh();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
