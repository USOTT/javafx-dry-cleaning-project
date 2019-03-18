package application;

import java.io.IOError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainViewController {
	
	FXMLLoader fxmlLoader;
	Stage stage;
	Parent root;
	
	 @FXML
	    private TextField txtEmployeeName;

	    @FXML
	    private Button btnNewEmployee;

	    @FXML
	    private MaskedTextField txtEmployeeNumber;

	    @FXML
	    private TextField txtCustomerName;

	    @FXML
	    private Button btnNewCustomer;

	    @FXML
	    private MaskedTextField txtCustomerPhone;

	    @FXML
	    private TextField dtpTimeLeft;

	    @FXML
	    private TextField dtpTimeExpected;

	    @FXML
	    private TextField dtpTimePickedUp;

	    @FXML
	    private DateTimePicker dtpDateLeft;

	    @FXML
	    private DateTimePicker dtpDateExpected;

	    @FXML
	    private DateTimePicker dtpDatePickedUp;

	    @FXML
	    private TextField txtUnitPriceItem2;

	    @FXML
	    private ChoiceBox cbxItem1Name;

	    @FXML
	    private ChoiceBox cbxItem2Name;

	    @FXML
	    private ChoiceBox cbxItem3Name;

	    @FXML
	    private ChoiceBox cbxItem4Name;

	    @FXML
	    private TextField txtUnitPriceShirts;

	    @FXML
	    private TextField txtUnitPricePants;

	    @FXML
	    private TextField txtUnitPriceItem1;

	    @FXML
	    private TextField txtUnitPriceItem3;

	    @FXML
	    private TextField txtUnitPriceItem4;

	    @FXML
	    private TextField txtQuantityShirts;

	    @FXML
	    private TextField txtQuantityPants;

	    @FXML
	    private TextField txtQuantityItem1;

	    @FXML
	    private TextField txtQuantityItem2;

	    @FXML
	    private TextField txtQuantityItem3;

	    @FXML
	    private TextField txtQuantityItem4;

	    @FXML
	    private TextField txtSubTotalShirts;

	    @FXML
	    private TextField txtSubTotalPants;

	    @FXML
	    private TextField txtSubTotalItem1;

	    @FXML
	    private TextField txtSubTotalItem2;

	    @FXML
	    private TextField txtSubTotalItem3;

	    @FXML
	    private TextField txtSubTotalItem4;

	    @FXML
	    private TextField txtCleaningTotal;

	    @FXML
	    private TextField txtTaxRate;

	    @FXML
	    private TextField txtTaxAmount;

	    @FXML
	    private TextField txtNetPrice;

	    @FXML
	    private Button btnSave;

	    @FXML
	    private ChoiceBox cbxOrderStatus;

	    @FXML
	    private TextField txtCleaningOrderID;

	    @FXML
	    private Button btnOpen;

	    @FXML
	    private Button btnNewCleaningOrder;

	    @FXML
	    private TextArea txtNotes;

	    @FXML
	    private Button btnClose;
	
	ObservableList<String> cbxItem1NameList,cbxItem2NameList,cbxItem3NameList,cbxItem4NameList;
	@FXML
	private void initialize() {
		cbxItem1NameList = FXCollections.observableArrayList("None","Women Suit", "Dress",
				"Regular Skirt","Skirt With Hook", "Men's Suit 2Pc", "Men's Suit 3Pc", 
				"Sweaters", "Silk Shirt", "Tie", "Coat", "Jacket", "Swede");
		cbxItem2NameList = FXCollections.observableArrayList("None","Women Suit", "Dress",
				"Regular Skirt","Skirt With Hook", "Men's Suit 2Pc", "Men's Suit 3Pc", 
				"Sweaters", "Silk Shirt", "Tie", "Coat", "Jacket", "Swede");
		cbxItem3NameList = FXCollections.observableArrayList("None","Women Suit", "Dress",
				"Regular Skirt","Skirt With Hook", "Men's Suit 2Pc", "Men's Suit 3Pc", 
				"Sweaters", "Silk Shirt", "Tie", "Coat", "Jacket", "Swede");
		cbxItem4NameList = FXCollections.observableArrayList("None","Women Suit", "Dress",
				"Regular Skirt","Skirt With Hook", "Men's Suit 2Pc", "Men's Suit 3Pc", 
				"Sweaters", "Silk Shirt", "Tie", "Coat", "Jacket", "Swede");
		
		cbxItem1Name.setItems(cbxItem1NameList);
		cbxItem1Name.getSelectionModel().selectFirst();
		cbxItem2Name.setItems(cbxItem2NameList);
		cbxItem2Name.getSelectionModel().selectFirst();
		cbxItem3Name.setItems(cbxItem3NameList);
		cbxItem3Name.getSelectionModel().selectFirst();
		cbxItem4Name.setItems(cbxItem4NameList);
		cbxItem4Name.getSelectionModel().selectFirst();
	}
    @FXML
    void btnNewCustomer(ActionEvent event) {
    	try {
    	fxmlLoader = new FXMLLoader(getClass().getResource("/application/customer01.fxml"));
    	root = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

    @FXML
    void btnNewEmployee(ActionEvent event) {
    	try {
    	fxmlLoader = new FXMLLoader(getClass().getResource("/application/employee.fxml"));
    	root = (Parent) fxmlLoader.load();
    	stage = new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}

    }
    
    @FXML
    void btnClose(ActionEvent event) {
        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
	@FXML
	void btnNewCleaningOrder(ActionEvent event) {
		txtEmployeeNumber.setText("");
		txtEmployeeName.setText("");
		txtCustomerPhone.setText("");
		txtCustomerName.setText("");
		txtCleaningOrderID.setText("");
		
		LocalDate ubtime = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		dtpDateLeft.setValue(ubtime);
//		dtpTimeLeft.setValue(ubtime);
		dtpDateExpected.setValue(ubtime);
//		dtpTimeExpected.setValue(ubtime);
//		cbxOrderStatus.accessibleTextProperty().set("Not Yet Ready");
		dtpDatePickedUp.setValue(ubtime);
//		dtpTimePickedUp.setValue(ubtime);
	    txtUnitPriceShirts.setText("1.25");
	    txtQuantityShirts.setText("0");
	    txtSubTotalShirts.setText("0.00");

	    txtUnitPricePants.setText("1.95");
	    txtQuantityPants.setText("0");
	    txtSubTotalPants.setText("0.00");
//	    cbxItem1Name.getContextMenu().get("None");
	    txtUnitPriceItem1.setText("0.00");
	    txtQuantityItem1.setText("0");
	    txtSubTotalItem1.setText("0.00");
//	    cbxNameItem2.setText("None");
	    txtUnitPriceItem2.setText("0.00");
	    txtQuantityItem2.setText("0");
	    txtSubTotalItem2.setText("0.00");
//	    cbxNameItem3.setText("None");
	    txtUnitPriceItem3.setText("0.00");
	    txtQuantityItem3.setText("0");
	    txtSubTotalItem3.setText("0.00");
//	    cbxNameItem4.setText("None");
	    txtUnitPriceItem4.setText("0.00");
	    txtQuantityItem4.setText("0");
	    txtSubTotalItem4.setText("0.00");

	    txtCleaningTotal.setText("0.00");
	    txtTaxRate.setText("7.75");
	    txtTaxAmount.setText("0.00");
	    txtCleaningTotal.setText("0.00");
	    txtNotes.setText("");
	    txtEmployeeNumber.requestFocus();
	}
	
	@FXML
	
	private void calcPrice(KeyEvent event) {
//		if())
		Node n =(Node)event.getSource();
		System.out.println();
		switch(n.getId()) {
		case "txtUnitPriceShirts":
		case "txtQuantityShirts":
			if(txtUnitPriceShirts.getText().length()>0 && txtQuantityShirts.getText().length()>0) {
			txtSubTotalShirts.setText(""+strToDouble(txtUnitPriceShirts.getText())*strToDouble(txtQuantityShirts.getText()));
			}
			break;
		}
		
//		event.
	}
	
	private Double strToDouble(String s) {
		return Double.parseDouble(s);
	}
	
	private void btnSave_Click()
	{

//		// If the Receipt Number is empty, it appears that
//		// the user/clerk wants to create a new cleaning order
//		if (txtCleaningOrderID.Text.Length == 0)
//		{
//		    strCommand = "INSERT INTO CleaningOrders( " +
//				 "EmployeeNumber, CustomerNumber, DateLeft, " +
//				 "TimeLeft, DateExpected, TimeExpected, " +
//				 "OrderStatus, DatePickedUp, " +
//				 "TimePickedUp, UnitPriceShirts, " +
//				 "QuantityShirts, SubTotalShirts, " +
//				 "UnitPricePants, QuantityPants, " +
//				 "SubTotalPants, Item1Name, " +
//				 "UnitPriceItem1, QuantityItem1, " +
//				 "SubTotalItem1, Item2Name, " +
//				 "UnitPriceItem2, QuantityItem2, " +
//				 "SubTotalItem2, Item3Name, " +
//				 "UnitPriceItem3, QuantityItem3, " +
//				 "SubTotalItem3, Item4Name, " +
//				 "UnitPriceItem4, QuantityItem4, " +
//				 "SubTotalItem4, CleaningTotal, " +
//				 "TaxRate, TaxAmount, NetPrice, Notes) " +
//				 "VALUES('" + txtEmployeeNumber.getText() + "', '" +
//				 txtCustomerPhone.getText() + "', '" +
//				 dtpDateLeft.getValue().toString() + "', '" +
////				 dtpTimeLeft.getText().ToString("t") + "', '" +
//				 dtpDateExpected.getValue().toString() + "', '" +
////				 dtpTimeExpected.Value.ToString("t") + "', '" +
//				 cbxOrderStatus.getValue().toString() + "', '" +
//				 dtpDatePickedUp.getValue().toString() + "', '" +
//				 dtpDatePickedUp.getValue().toString() + "', '" +
//				 txtUnitPriceShirts.getText() + "', '" + 
//				 txtQuantityShirts.getText() + "', '" + 
//				 txtSubTotalShirts.getText() + "', '" +
//				 txtUnitPricePants.getText() + "', '" + 
//				 txtQuantityPants.getText() + "', '" +
//				 txtSubTotalPants.getText() + "', '" + 
////				 cbxItem1Name.get + "', '" +
//				 txtUnitPriceItem1.getText() + "', '" + 
//				 txtQuantityItem1.getText() + "', '" +
//				 txtSubTotalItem1.getText() + "', '" + 
////				 cbxItem2Name.getText() + "', '" +
//				 txtUnitPriceItem2.getText() + "', '" + 
//				 txtQuantityItem2.getText() + "', '" +
//				 txtSubTotalItem2.getText() + "', '" + 
////				 cbxItem3Name.getText() + "', '" +
//				 txtUnitPriceItem3.getText() + "', '" + 
//				 txtQuantityItem3.getText() + "', '" +
//				 txtSubTotalItem3.getText() + "', '" + 
////				 cbxItem4Name.getText() + "', '" +
//				 txtUnitPriceItem4.getText() + "', '" + 
//				 txtQuantityItem4.getText() + "', '" +
//				 txtSubTotalItem4.getText() + "', '" + 
//				 txtCleaningTotal.getText() + "', '" +
//				 txtTaxRate.getText() + "', '" + 
//				 txtTaxAmount.getText() + "', '" +
//				 txtNetPrice.getText() + "', '" + txtNotes.getText() + "');";
//		}
//		else // Since there is a receipt number, update/edit the cleaning order
//		{
//		    strCommand = "UPDATE CleaningOrders " +
//				 "SET EmployeeNumber = '" +
//				 txtEmployeeNumber.getText() + "', " +
//				" CustomerNumber = '" + txtCustomerPhone.getText() + "', " +
////			" DateLeft = '" + dtpDateLeft.Value.ToString("d") + "', " +
////			" TimeLeft = '" + dtpTimeLeft.Value.ToString("t") + "', " +
////			" DateExpected = '" + dtpDateExpected.Value.ToString("d") + "', " +
////			" TimeExpected = '" + dtpTimeExpected.Value.ToString("t") + "', " +
////			" OrderStatus = '" + cbxOrderStatus.getText() + "', " +
////			" DatePickedUp = '" + dtpDatePickedUp.Value.ToString("d") + "', " +
////			" TimePickedUp = '" + dtpDatePickedUp.Value.ToString("t") + "', " +
//			" UnitPriceShirts = '" + txtUnitPriceShirts.getText() + "', " +
//			" QuantityShirts = '" + txtQuantityShirts.getText() + "', " +
//			" SubTotalShirts = '" + txtSubTotalShirts.getText() + "', " +
//			" UnitPricePants = '" + txtUnitPricePants.getText() + "', " +
//			" QuantityPants = '" + txtQuantityPants.getText() + "', " +
//			" SubTotalPants = '" + txtSubTotalPants.getText() + "', " +
////			" Item1Name = '" + cbxItem1Name.Text + "', " +
//			" UnitPriceItem1 = '" + txtUnitPriceItem1.getText() + "', " +
//			" QuantityItem1 = '" + txtQuantityItem1.getText() + "', " +
//			" SubTotalItem1 = '" + txtSubTotalItem1.getText() + "', " +
////			" Item2Name = '" + cbxItem2Name.Text + "', " +
//			" UnitPriceItem2 = '" + txtUnitPriceItem2.getText() + "', " +
//			" QuantityItem2 = '" + txtQuantityItem2.getText() + "', " +
//			" SubTotalItem2 = '" + txtSubTotalItem2.getText() + "', " +
////			" Item3Name = '" + cbxItem3Name.Text + "', " +
//			" UnitPriceItem3 = '" + txtUnitPriceItem3.getText() + "', " +
//			" QuantityItem3 = '" + txtQuantityItem3.getText() + "', " +
//			" SubTotalItem3 = '" + txtSubTotalItem3.getText() + "', " +
////			" Item4Name = '" + cbxItem4Name.Text + "', " +
//			" UnitPriceItem4 = '" + txtUnitPriceItem4.getText() + "', " +
//			" QuantityItem4 = '" + txtQuantityItem4.getText() + "', " +
//			" SubTotalItem4 = '" + txtSubTotalItem4.getText() + "', " +
//			" CleaningTotal = '" + txtCleaningTotal.getText() + "', " +
//			" TaxRate = '" + txtTaxRate.getText() + "', " +
//			" TaxAmount = '" + txtTaxAmount.getText() + "', " +
//			" NetPrice = '" + txtNetPrice.getText() + "', " +
//			" Notes = '" + txtNotes.getText() + "' " +
//			" WHERE CleaningOrderID = '" + txtCleaningOrderID.getText() + "';";
//		}
//
////		SqlCommand cmdCleaningOrders = new SqlCommand(strCommand,
////		cnnCleaningOrders);
////
////		cnnCleaningOrders.Open();
////		cmdCleaningOrders.ExecuteNonQuery();
////
////		btnNewCleaningOrder_Click(sender, e);
//	    }
//	}

	}}
