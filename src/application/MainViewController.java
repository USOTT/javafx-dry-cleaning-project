package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainViewController {
	
	FXMLLoader fxmlLoader;
	Stage stage;
	Parent root;
	@FXML
	private ChoiceBox cbxItem1Name,cbxItem2Name,cbxItem3Name,cbxItem4Name, cbxOrderStatus;
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
	    private DatePicker dtpDateLeft;

	    @FXML
	    private DatePicker dtpDateExpected;

	    @FXML
	    private DatePicker dtpDatePickedUp;

	    @FXML
	    private TextField dtpTimeLeft;

	    @FXML
	    private TextField dtpTimeExpected;

	    @FXML
	    private TextField dtpTimePickedUp;

	    @FXML
	    private TextField txtUnitPriceItem2;


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

	   // @FXML
	  //  private ChoiceBox<?> cbxOrderStatus;

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

	 
	
	ObservableList<String> cbxItem1NameList,cbxItem2NameList,cbxItem3NameList,cbxItem4NameList, cbxOrderStatusList;
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
		cbxOrderStatusList = FXCollections.observableArrayList("Not Yet Ready", "Clean and Ready for Pickup", "Picked Up");
		
		
		cbxItem1Name.setItems(cbxItem1NameList);
		cbxItem1Name.getSelectionModel().selectFirst();
		cbxItem2Name.setItems(cbxItem2NameList);
		cbxItem2Name.getSelectionModel().selectFirst();
		cbxItem3Name.setItems(cbxItem3NameList);
		cbxItem3Name.getSelectionModel().selectFirst();
		cbxItem4Name.setItems(cbxItem4NameList);
		cbxItem4Name.getSelectionModel().selectFirst();
		cbxOrderStatus.setItems(cbxOrderStatusList);
		cbxOrderStatus.getSelectionModel().selectFirst();
	}
    @FXML
    void btnNewCustomer(ActionEvent event) {
    	try {
    	fxmlLoader = new FXMLLoader(getClass().getResource("customers.fxml"));
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
    	fxmlLoader = new FXMLLoader(getClass().getResource("employee1.fxml"));
    	root = (Parent) fxmlLoader.load();
    	stage = new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}

    }
    
    @FXML
    void btnSave(ActionEvent event) {
    	 stage = (Stage) btnSave.getScene().getWindow();
         stage.close();
    }
    
    @FXML
    void test(ActionEvent event) {
    	/*System.out.println(txtCleaningOrderID.getText());
    	try {
			// create a mysql database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root", "saruul0201");			
			Statement myStmt = (Statement) conn.createStatement();
			ResultSet myRs = ((java.sql.Statement) myStmt).executeQuery("select * from customers");
			while (myRs.next()) {
				System.out.println(myRs.getString(""));
			}
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}*/
    	 //System.out.println(((TextField)event.getSource()).getId());
    }
    
    @FXML
    void btnClose(ActionEvent event) {
        stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    @FXML
	void btnNewCleaningOrder(ActionEvent event) {
    	System.out.println("test");
		/*txtEmployeeNumber.setText("");
		txtEmployeeName.setText("");
		txtCustomerPhone.setText("");
		txtCustomerName.setText("");
		txtCleaningOrderID.setText("");
		
		LocalDate ubtime = LocalDate.now(ZoneId.of("Asia/Ulaanbaatar"));
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
	    txtEmployeeNumber.requestFocus();*/
	}
	
	@FXML
	private void calcPrice(KeyEvent event) {

		txtQuantityShirts.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="") 
			txtSubTotalShirts.setText(""+strToDouble(txtUnitPriceShirts.getText())*strToDouble(txtQuantityShirts.textProperty().get()));
			});
		txtUnitPriceShirts.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalShirts.setText(""+strToDouble(newValue)*strToDouble(txtQuantityShirts.getText()));
		});
		
		txtQuantityPants.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalPants.setText(""+strToDouble(txtUnitPricePants.getText())*strToDouble(txtQuantityPants.textProperty().get()));
		});
		txtUnitPricePants.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalPants.setText(""+strToDouble(newValue)*strToDouble(txtQuantityPants.getText()));
		});

		txtQuantityItem1.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem1.setText(""+strToDouble(txtUnitPriceItem1.getText())*strToDouble(newValue));
		});
		txtUnitPriceItem1.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem1.setText(""+strToDouble(newValue)*strToDouble(txtQuantityItem1.getText()));
		});
		
		
		txtQuantityItem2.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem2.setText(""+strToDouble(txtUnitPriceItem2.getText())*strToDouble(newValue));
		});
		txtUnitPriceItem2.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem2.setText(""+strToDouble(newValue)*strToDouble(txtQuantityItem2.getText()));
		});
		
		
		txtQuantityItem3.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem3.setText(""+strToDouble(txtUnitPriceItem3.getText())*strToDouble(newValue));
		});
		txtUnitPriceItem3.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem3.setText(""+strToDouble(newValue)*strToDouble(txtQuantityItem3.getText()));
		});
		
		
		txtQuantityItem4.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem4.setText(""+strToDouble(txtUnitPriceItem4.getText())*strToDouble(newValue));
		});
		txtUnitPriceItem4.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue!="")
			txtSubTotalItem4.setText(""+strToDouble(newValue)*strToDouble(txtQuantityItem4.getText()));
		});
		calcCleaningTotal();
		calcTaxAmount();
		calcNetPrice();
	}
	
	
//	@FXML
//	private void calcPrice(KeyEvent event) {
//		Node n =(Node)event.getSource();
//		switch(n.getId()) {
//		case "txtUnitPriceShirts":
//		case "txtQuantityShirts":
//			if(txtUnitPriceShirts.getText().length()>0 && txtQuantityShirts.getText().length()>0) {
//			txtSubTotalShirts.setText(""+strToDouble(txtUnitPriceShirts.getText())*strToDouble(txtQuantityShirts.getText()));
//
////				txtSubTotalShirts.setText(""+strToDouble(txtUnitPriceShirts.getText())*strToDouble(txtQuantityShirts.textProperty().get()));
//			}
//			break;
//		case "txtUnitPricePants":
//		case "txtQuantityPants":
//			if(txtUnitPricePants.getText().length()>0 && txtQuantityPants.getText().length()>0) {
//				txtSubTotalPants.setText(""+strToDouble(txtUnitPricePants.getText())*strToDouble(txtQuantityPants.getText()));
//			}
//			break;
//		case "txtUnitPriceItem1":
//		case "txtQuantityItem1":
//			if(txtUnitPriceItem1.getText().length()>0 && txtQuantityItem1.getText().length()>0) {
//				txtSubTotalItem1.setText(""+strToDouble(txtUnitPriceItem1.getText())*strToDouble(txtQuantityItem1.getText()));
//			}
//			break;
//		case "txtUnitPriceItem2":
//		case "txtQuantityItem2":
//			if(txtUnitPriceItem2.getText().length()>0 && txtQuantityItem2.getText().length()>0) {
//				txtSubTotalItem2.setText(""+strToDouble(txtUnitPriceItem2.getText())*strToDouble(txtQuantityItem2.getText()));
//			}
//			break;
//		case "txtUnitPriceItem3":
//		case "txtQuantityItem3":
//			if(txtUnitPriceItem3.getText().length()>0 && txtQuantityItem3.getText().length()>0) {
//				txtSubTotalItem3.setText(""+strToDouble(txtUnitPriceItem3.getText())*strToDouble(txtQuantityItem3.getText()));
//			}
//			break;
//		case "txtUnitPriceItem4":
//		case "txtQuantityItem4":
//			if(txtUnitPriceItem4.getText().length()>0 && txtQuantityItem4.getText().length()>0) {
//				txtSubTotalItem4.setText(""+strToDouble(txtUnitPriceItem4.getText())*strToDouble(txtQuantityItem4.getText()));
//			}
//			break;
//		}
//		
//		calcCleaningTotal();
//		calcTaxAmount();
//		calcNetPrice();
//	}
	
	@FXML
	private void calcCleaningTotal() {
		txtCleaningTotal.setText(""+
		(Float.parseFloat(txtSubTotalShirts.getText())+
		Float.parseFloat(txtSubTotalPants.getText())+
		Float.parseFloat(txtSubTotalItem1.getText())+
		Float.parseFloat(txtSubTotalItem2.getText())+
		Float.parseFloat(txtSubTotalItem3.getText())+
		Float.parseFloat(txtSubTotalItem4.getText()))
				);
	}
	
	private void calcTaxAmount() {
		txtTaxAmount.setText(""+(Float.parseFloat(txtCleaningTotal.getText())*
							Float.parseFloat(txtTaxRate.getText()))/100);
	}
	
	private void calcNetPrice(){
		txtNetPrice.setText(String.valueOf(Float.parseFloat(txtCleaningTotal.getText())-Float.parseFloat(txtTaxAmount.getText())));
	}
	
	private Float strToDouble(String s) {
		  if (s != null && s.length() > 0) {
		       try {
		          return Float.parseFloat(s);
		       } catch(Exception e) {
		          return (float)-1;  
		       }
		   }
		   else return (float)0;
	}

}
