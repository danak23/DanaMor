package gui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
public class PurchasesController implements EventHandler<ActionEvent> {
	private final int numgrids =100 ;
	private final int numLeds =4 ;
	private  final int numLedsPerRow = 4 ;
	  @FXML
	private Label label[][];
	 @FXML
		private GridPane ledPanel[] ; //each row is table;
	
	 ObservableList<String> list;
	   
    @FXML
    private Pane pnlOverview;
    @FXML
    private Button downloadbtn[];
    @FXML
    private ToolBar ToolBar;

    @FXML
    private Button allBtn;

    @FXML
    private Button subscribersBtn;

    @FXML
    private Button onetimeBtn;

    @FXML
    private ComboBox sortCmb;

    @FXML
    private TextField searchText;

    @FXML
    private HBox Details;

    @FXML
    private VBox Table;

    @FXML
    void getAllBtn(ActionEvent event) {
    	System.out.println("press on AllBtn");

    }

    @FXML
    void getOneBtn(ActionEvent event) {
    	System.out.println("press on OneBtn");
    }

    

    @FXML
    void getSubscribersBtn(ActionEvent event) {
    	System.out.println("press on SubscribersBtn");
    }
    public void initialize() {
    	
    	setSortComboBox();
	    ledPanel =new GridPane[numgrids];
	    label= new Label[numgrids][numLeds];
	    downloadbtn=new Button[numgrids];
	    for (int i=0; i<numgrids; i++) {
	    	Button button=new Button();
	    	button.setText("⇩");
	    	button.setOnAction(this);
	    	downloadbtn[i]=button;	 
	    	 GridPane gridpane=new GridPane();
	    	 gridpane.setOnMouseClicked(event -> {
	    		 Node node;;
	    		 gridpane.setStyle("-fx-background-color:#a3c2a3");
	    		
	    		 gridpane.setAlignment(Pos.CENTER.TOP_LEFT);
	    		 node=gridpane.getChildren().get(0);
	    		
	    		  for (int k=0; k<numgrids;k++)
	    		  {
	    			  if(gridpane!=ledPanel[k])
	    			  ledPanel[k].setStyle("-fx-background-color:#ffffff");
	    			  
	    		  }
		        });
	    	    ledPanel[i]=gridpane;
	    		ledPanel[i].setHgap(150);
	    		ledPanel[i].setVgap(9);
	    		
	       for(int j=0;j<numLeds;j++)////initialization Table for 
	       {
	    	  
	        Label leb=new Label("asfs");
	     
	        leb.setFont(new Font(15));
	   
	 	   label[i][j]=leb;
		
			if(i==0)
	        {
				if(j==0)
					label[i][j].setText("City");
				else if(j==1)
					label[i][j].setText("Type");
					else if(j==2)
						label[i][j].setText("Date exp");
					else if(j==3)
					{
						label[i][j].setText("Download");
					}
				 ledPanel[i].add( label[i][j],  j ,0); //each row is table;
	        }
			else
			{
				label[i][j].setText("fasfsa");
				if(j<numLeds-1)
				ledPanel[i].add( label[i][j],  j ,0);
				else
					ledPanel[i].add(downloadbtn[i],j,0); //each row is table;
			}
	        
	       /// ledPanel[i].setLayoutY(i*50);

	    }
	     
	    }
	    Details.getChildren().addAll(ledPanel[0]);
		for(int i=1 ;i<numgrids;i++)
	     Table.getChildren().addAll(ledPanel[i]);
}
public void getSearchText(ActionEvent event) throws Exception {///action after type enter on Search 
	System.out.println("textbox text is:");
	//System.exit(0);			
}

@Override
public void handle(ActionEvent event) {
	for (int i=0;i<numgrids;i++)
	{
		if(event.getSource()==downloadbtn[i])
		{			
		   System.out.println("btn id preesed:"+i);///ActionEvent to specific download btn
		}
	
	}
	
}
private void setSortComboBox() {////initialization combo box 
	ArrayList<String> al = new ArrayList<String>();	

	al.add("Newest");
	al.add("Oldest=");
	ObservableList<String> list = FXCollections.observableArrayList(al);
	sortCmb.setItems(list);
	this.sortCmb.setValue(sortCmb.getValue());

}
	
}
