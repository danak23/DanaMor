package gui;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReportControl {

    @FXML
    private TableView<?> MyTable;

    @FXML
    private TableColumn<?, ?> CityCol;

    @FXML
    private TableColumn<?, ?> OneTimePCol;

    @FXML
    private TableColumn<?, ?> MembershipCol;

    @FXML
    private TableColumn<?, ?> RenewdMCol;

    @FXML
    private TableColumn<?, ?> ViewsCol;

    @FXML
    private TableColumn<?, ?> dowloadCol;

}