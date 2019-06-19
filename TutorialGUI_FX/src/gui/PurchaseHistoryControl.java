package gui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class PurchaseHistoryControl  {

	ObservableList<TableColumn> list;
    @FXML
    private Pane pnlOverview;

    @FXML
    private TableView MyTable;

    @FXML
    private TableColumn CityCol;

    @FXML
    private TableColumn TypeCol;

    @FXML
    private TableColumn DateCol;
    
	public void initialize() {
		ArrayList<String> PurchaseHistory=QueryControl.purchaseHistory(QueryControl.getCustomerId());
		ArrayList<String> tmp=new ArrayList<String>();
		int size=PurchaseHistory.size();
		//	PurchaseHistory p=new PurchaseHistory();
		final ObservableList<PurchaseHistory> data=FXCollections.observableArrayList();
    //Update information for table.
		while(size>0)
		{
			for(int i=0;i<3;i++)
			{
				tmp.add(PurchaseHistory.get(0));
				PurchaseHistory.remove(0);
				size--;
			}
			data.add(new PurchaseHistory(tmp));
			tmp.removeAll(tmp);
		}
		CityCol.setCellValueFactory(new PropertyValueFactory<PurchaseHistory,String>("City"));
		TypeCol.setCellValueFactory(new PropertyValueFactory<PurchaseHistory,String>("PurchaseType"));
		DateCol.setCellValueFactory(new PropertyValueFactory<PurchaseHistory,String>("PurchaseDate"));
	//Change the information
		MyTable.setItems(data);
	}
    

}
