package gui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MapCatlogController {


	private static final Image ledOff = new Image("file:///C:\\Users\\danak\\Desktop\\TutorialGUI_FX\\src\\gui\\image.jpg");//image before drag on some image
	private static final Image ledOn = new Image("file:///C:\\Users\\danak\\Desktop\\TutorialGUI_FX\\src\\gui\\image2.jpg");//image after drag on some image
	@FXML
	private GridPane ledPanel ;
	ObservableList<String> list;
	private ImageView[] leds ;
	private Label label[];
    @FXML
    private Button areaBtn;
    @FXML
    private Button cityBtn;
    @FXML
    private TextField searchText;
    @FXML
    private ComboBox cmbSort;
	@FXML
	public void initialize() {
		final int numLeds =60 ;///Number of images total
	    final int numLedsPerRow = 4 ; //Number of images per line
		setSortComboBox();//initialization combo box
		ledPanel.setHgap(9);
		ledPanel.setVgap(9);
		    leds = new ImageView[numLeds];
		    for (int i=0; i<numLeds; i++) {////initialization images 
		        ImageView led = new ImageView(ledOn);

		        leds[i] = led ;
				
				leds[i].setFitHeight(120);
		        leds[i].setFitWidth(180);
		   
		        ledPanel.add(leds[i], i % numLedsPerRow, i / numLedsPerRow);
		        ledPanel.getPadding();      
		        led.setOnMouseMoved(event -> { /////Image after drag on
		        	if (led.getImage()==ledOn) {
		                led.setImage(ledOff);
		            } 
		        	
		        });

		        led.setOnMouseExited(event -> { ///Image after drag off
		        	if (led.getImage()==ledOff) {
		                led.setImage(ledOn);
		            } 
		        	
		        });
		    }

	}
	public void getCityBtn(ActionEvent event) throws Exception { ///action after click on city button
		System.out.println("getCityBtn clicked");
		//System.exit(0);			
	}
	public void getAreaBtn(ActionEvent event) throws Exception {  ///action after click on area button
		System.out.println("getAreaBtn clicked");
		//System.exit(0);			
	}
	public void getSearchText(ActionEvent event) throws Exception {  ///action after type enter on Search 
		System.out.println("textbox text is: "+searchText.getText());
		//System.exit(0);			
	}
	private void setSortComboBox() {
		ArrayList<String> al = new ArrayList<String>();	
	
		al.add("ABC");
		al.add("Download");
		list = FXCollections.observableArrayList(al);
		cmbSort.setItems(list);
		this.cmbSort.setValue(cmbSort.getValue());
	
	}
	public void loadSort(ActionEvent event) throws Exception {
	}
}






























