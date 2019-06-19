
package gui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterClientControl {
	//Local class variables to hold input information and transfer into sql.
	String userName;
	String email;
	String tel;
	String password; 
	String Password2;
	String name;
	String surname;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField FirstNameBT;

    @FXML
    private TextField LastNameBT;

    @FXML
    private TextField Usernamelab;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField RepeatPassword;

    @FXML
    private TextField maillab;

    @FXML
    private TextField tellab;

    @FXML
    private Button RegisterBt;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label errorMessage;

    @FXML
    void RegisterBt(MouseEvent event) {
    // 	Platform.setImplicitExit(false);
        Parent root222;
        password =passwordTxt.getText();
        userName=Usernamelab.getText();
        email=maillab.getText();
        tel=tellab.getText();
        Password2=RepeatPassword.getText();
        name=FirstNameBT.getText();
        surname=LastNameBT.getText();
        //Send input for verification.
       if( checkInput()) {
      //Update sql table with the information.
       handleInfo();
  	try {
  		Node source= (Node) event.getSource();
  	        Window theStage = source.getScene().getWindow();
  	        theStage.hide();
  		root222 = FXMLLoader.load(getClass().getResource("/gui/payment.fxml"));
  	      Stage stage = new Stage();
  	      stage.setScene(new Scene(root222));  
  	    stage.setTitle("2.register-->paymet registration");
  	      stage.show();
  	} catch (IOException e) {
  		// Handle exception.
  		e.printStackTrace();
  	}
       }
       else
      	 return;
    }

  //If the user wants to go back to login window.Open it via button.
    @FXML
    void cancelBtn(MouseEvent event) {
       	Platform.setImplicitExit(false);
	      Parent root1;
		try {
			Node source= (Node) event.getSource();
		        Window theStage = source.getScene().getWindow();
		        theStage.hide();
			root1 = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
		      Stage stage = new Stage();
		      stage.setScene(new Scene(root1));  
		      stage.show();
		} catch (IOException e) {
			// Handle exception.
			e.printStackTrace();
		}
    }


void handleInfo()
{
	//Method that sends information to sql controller for update.
	QueryControl.newTableInfo(name,surname,email,tel,password,userName);
}

//Method for all possible errors in input.
public boolean checkInput()
{
	String errMsg ="";
	//Check for possible empty fields.
	if(password.trim().equals("") || userName.trim().equals("") ||email.trim().equals(""))
	{
		errMsg+=("**Fields cannot be EMPTY!!\n");
	}
	//Check that names are only letters not numbers
	if(!(name.matches("[a-zA-Z]+"))||!(surname.matches("[a-zA-Z]+")))
	{
		errMsg+=("**Name can contain only letters!!!\n");
	}
	//Check that telephone number contains only numbers.
	if(tel.matches("[a-zA-Z]+"))
	{
	    errMsg+=("**Telephone number incorrect!!!\n");
	}
	//Check if password entered is the same as original
	if(!(password.equals(Password2)))
	{
	    errMsg+=("**Passwords doesn't match!!!\n");
	}
	if(errMsg.trim().equals("")) return true;
	 errorMessage.setVisible(true);
     errorMessage.setText(errMsg);
     return false;
}
}















