package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class MainViewController {
	
	FXMLLoader fxmlLoader;
	Stage stage;
	Parent root;
	@FXML
	private ChoiceBox cbxItem1Name,cbxItem2Name,cbxItem3Name,cbxItem4Name;
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
}
