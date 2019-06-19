package gui;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerCardControl implements EventHandler<ActionEvent>{
	private final int numgrids =100 ;
	private final int numLeds =4 ;
	private  final int numLedsPerRow = 4 ;
	  @FXML
	private Label label[][];
    @FXML
    private Button btnHome;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMaps;

    @FXML
    private Button btnCotent;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    @FXML
    private Button Historybtn[];
    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField SearchBt;

    @FXML
    private VBox Table;

    @FXML
    private HBox ClientInfo;

    @FXML
    private Button PurchaseHistoryBt;
    @FXML
	private GridPane ledPanel[] ;
    @FXML
    private HBox Details;

    @FXML
    private Button HistoryBt;
    @FXML
    void HistoryBt(MouseEvent event) {

    }

    @FXML
	public void initialize() {
    	
		    //Initialize the  window of CustomerCard.
		    ledPanel =new GridPane[numgrids];
		    label= new Label[numgrids][numLeds];
		    Historybtn=new Button[numgrids];
		    //Creating buttons of purchase history for each client.
		    for (int i=0; i<numgrids; i++) {
		    	Button button=new Button();
		    	button.setText("נ“");
		    	button.setOnAction(this);
		    	Historybtn[i]=button;
		    	 
		    	 GridPane gridpane=new GridPane();
		    	 
		    	
		    	 //If a customer name was chosen by clicking on it.
		    	 gridpane.setOnMouseClicked(event -> {
		    		 Node node;;
		    		 //Color the Name in green for highlighting.
		    		 gridpane.setStyle("-fx-background-color:#a3c2a3");
		    		 node=gridpane.getChildren().get(0);
		    		//If the choice had changed go back to orugunal color.
		    		  for (int k=0; k<numgrids;k++)
		    		  {
		    			  if(gridpane!=ledPanel[k])
		    			  ledPanel[k].setStyle("-fx-background-color:#ffffff");
		    			  
		    		  }
			        });
		    	    ledPanel[i]=gridpane;
		    		ledPanel[i].setHgap(150);
		    		ledPanel[i].setVgap(9);
		    	//Set up the basic form for table of customers details. 
		       for(int j=0;j<numLeds;j++)
		       {
		    	  
		        Label leb=new Label("asfs");
		     
		        leb.setFont(new Font(20));
		        leb.setAlignment(Pos.CENTER.TOP_LEFT);
		 	   label[i][j]=leb;
			//Place the titles of columns in a specific location.
				if(i==0)
		        {
					if(j==0)
						label[i][j].setText("City name");
					else if(j==1)
						label[i][j].setText("E-mail");
						else if(j==2)
							label[i][j].setText("Tel");
						else if(j==3)
						{
							label[i][j].setText("Purchase History");
						}
					 ledPanel[i].add( label[i][j],  j ,0);
		        }
				//Once the titles are done put the information in the rows.
				else
				{
					
					label[i][j].setText("fasfsa");
					if(j<numLeds-1)
					ledPanel[i].add( label[i][j],  j ,0);
					else
						ledPanel[i].add(Historybtn[i],j,0);
				}
		    }
		     
		    }
		    Details.getChildren().addAll(ledPanel[0]);
			for(int i=1 ;i<numgrids;i++)
		     Table.getChildren().addAll(ledPanel[i]);
	}
    
    //Method for search field .
	public void getSearchText(ActionEvent event) throws Exception {
		//Check what's the input of user.
		System.out.println("textbox text is:");			
	}
	//Load purchase history if it is requested by user.
	@Override
	public void handle(ActionEvent event) {
		for (int i=0;i<numgrids;i++)
		{
			if(event.getSource()==Historybtn[i])
			{
			      Parent root1;
				try {
					
					root1 = FXMLLoader.load(getClass().getResource("PurchaseHistory.fxml"));
				      Stage stage = new Stage();
				      stage.setScene(new Scene(root1));  
				     
				      stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
	}
}



