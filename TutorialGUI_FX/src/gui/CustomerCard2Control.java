package gui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CustomerCard2Control {

	//Array list for customer searched information
	ArrayList<String> customerDetails=new ArrayList<String>();
    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField SearchBt;

    @FXML
    private Label emailTxt;

    @FXML
    private Label telTxt;
    
    @FXML
    private Label NameInput;

    @FXML
    private Button HistoryBt;
    @FXML
    void HistoryBt(MouseEvent event) {
		try {
			Parent root1;
			root1 = FXMLLoader.load(getClass().getResource("PurchaseHistory.fxml"));
		      Stage stage = new Stage();
		      stage.setScene(new Scene(root1));  
		     
		      stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Method for search field .
	public void getSearchText(ActionEvent event) throws Exception {
		//Check what's the input of user.
		String input=SearchBt.getText();
		customerDetails=QueryControl.CustomerCard(input);
		updateInfo();
	}
	public void updateInfo()
	{
		int i=1;
		String fullName=customerDetails.get(i)+" "+customerDetails.get(++i);
		NameInput.setText(fullName);
		emailTxt.setText(customerDetails.get(++i));
		telTxt.setText(customerDetails.get(++i));
	}

}