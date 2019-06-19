package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class loginControl {

	String userName;
	String Password;
	
    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField UserNameInput;

    @FXML
    private Button loginBt;

    @FXML
    private PasswordField PasswordInput;

    @FXML
    private Button RegisterBt;

    @FXML
    String PasswordInput(MouseEvent event) {
    	Password =PasswordInput.getText();
    	if(Password==null)
    	{
    		System.out.print("null!!!");
    	}
		return Password;
    }
//If the client needs to register opens the registration window.
    @FXML
    void RegisterBt(MouseEvent event)
    {
     	Platform.setImplicitExit(false);
	      Parent root1;
		try {
			  Node source = (Node) event.getSource();
		        Window theStage = source.getScene().getWindow();
		        theStage.hide();
			root1 = FXMLLoader.load(getClass().getResource("/gui/RegisterClient.fxml"));
		      Stage stage = new Stage();
		      stage.setScene(new Scene(root1));  
		     
		      stage.show();
		} catch (IOException e) {
			// Throw exception if needed.
			e.printStackTrace();
		}
    }

    @FXML
    String UserNameInput(MouseEvent event) {
    	userName=UserNameInput.getText();
    	return userName;
    }

    @FXML
    void loginBt(MouseEvent event) {
    	System.out.print("dana");
    	QueryControl.login(userName,Password);
    }
    
  

	}

