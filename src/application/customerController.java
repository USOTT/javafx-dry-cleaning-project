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

public class customerController implements Initializable {
	@FXML
	private TableView<customer> tableview;

	@FXML
	private TableColumn<customer, String> colID;

	@FXML
	private TableColumn<customer, String> colNumber;

	@FXML
	private TableColumn<customer, String> colName;

	@FXML
	private Button btnClose;

	@FXML
	private TextField txtCustomerPhone;

	@FXML
	private TextField txtCustomerName;

	@FXML
	private Button btnSubmit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		colNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		colName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
		tableview.setItems(observableList);
		refresh();
	}
	
	void refresh() {
		tableview.getItems().clear();
		try {
			// create a mysql database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root", "saruul0201");			
			Statement myStmt = (Statement) conn.createStatement();
			ResultSet myRs = ((java.sql.Statement) myStmt).executeQuery("select * from customers");
			while (myRs.next()) {
				customer customer = new customer(myRs.getString("customerID"), myRs.getString("phoneNumber"),
						myRs.getString("fullName"));
				tableview.getItems().add(customer);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	ObservableList<customer> observableList = FXCollections.observableArrayList();

	@FXML
	void btnCloseAction(ActionEvent event) {
		Stage stage1 = (Stage) btnClose.getScene().getWindow();
		// do what you have to do
		stage1.close();
	}

	@FXML
	void btnSubmitAction(ActionEvent event) {
		try {
			// create a mysql database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root", "saruul0201");			
			Statement myStmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO customers(phoneNumber, fullName) VALUES ('" + txtCustomerPhone.getText() + "', '"
					+ txtCustomerName.getText() + "')";
			((java.sql.Statement) myStmt).execute(sql);
			conn.close();
			refresh();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
