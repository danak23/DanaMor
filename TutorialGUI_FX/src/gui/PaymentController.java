package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PaymentController {
	//Local class variables to hold input information and transfer into sql.
	String creditNumber;
	String ExpirationDate;
	String cvv; 

    @FXML
    private Button DoneBt;

    @FXML
    private Button BackBt;

    @FXML
    private TextField numberTxt;

    @FXML
    private TextField dateTxt;
    
    @FXML
    private Label errorMsg;
    
    @FXML
    private TextField cvvTxt;

    @FXML
    void BackBt(MouseEvent event) {
//     	/*Platform.setImplicitExit(false);
        Parent root22;
     //   handleInfo();
  	try {
  		Node source= (Node) event.getSource();
  	        Window theStage = source.getScene().getWindow();
  	        theStage.hide();
  		root22 = FXMLLoader.load(getClass().getResource("/gui/RegisterClient.fxml"));
  	      Stage stage = new Stage();
  	      stage.setScene(new Scene(root22));  
  	      stage.show();
  	} catch (IOException e) {
  		// Handle exception.
  		e.printStackTrace();
  	}
    }

    @FXML
    void DoneBt(MouseEvent event) {
    	Parent root22;
    	cvv=cvvTxt.getText();
    	ExpirationDate=dateTxt.getText();
    	creditNumber=numberTxt.getText();
    	//Update sql table with the information.
    	if(checkInput()) {
    	 /* 	try {
    	  		Node source= (Node) event.getSource();
    	  	        Window theStage = source.getScene().getWindow();
    	  	        theStage.hide();
    	  		root22 = FXMLLoader.load(getClass().getResource("/gui/payment.fxml"));
    	  	      Stage stage = new Stage();
    	  	      stage.setScene(new Scene(root22));  
    	  	      stage.show();
    	  	} catch (IOException e) {
    	  		// Handle exception.
    	  		e.printStackTrace();
    	  	}*/
    	       }
    	       else
    	      	 return;
    }
    void handleInfo()
    {
    	//Method that sends information to sql controller for update.
    	QueryControl.newTableInfoPayment(creditNumber,ExpirationDate,cvv);
    }
  //Method for all possible errors in input.
    public boolean checkInput()
    {
    	String errMsg ="";
    	//Check for possible empty fields.
    	if(creditNumber.trim().equals("") || cvv.trim().equals("") ||ExpirationDate.trim().equals(""))
    	{
    		errMsg+=("**Fields cannot be EMPTY!!\n");
    	}
    	//Check that credit and cvv contain only numbers
    	if(creditNumber.matches("[a-zA-Z]+")||cvv.matches("[a-zA-Z]+"))
    	{
    		errMsg+=("**Only numbers for credit information!!!\n");
    	}
    	//Check that cvv is only 3 numbers
    	if(cvv.length()!=3)
    	{
    	    errMsg+=("**cvv can be only 3 numbers!!!\n");
    	}
    	//Check if password entered is the same as original
    	if(Integer.parseInt(ExpirationDate)<2019)
    	{
    	    errMsg+=("**wrong expiration date!!!\n");
    	}
    	if(errMsg.trim().equals("")) return true;
    	errorMsg.setVisible(true);
    	errorMsg.setText(errMsg);
         return false;
    }


}




