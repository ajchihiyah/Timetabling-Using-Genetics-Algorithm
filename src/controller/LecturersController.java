package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Lecturer;

public class LecturersController implements Initializable {
    @FXML
    private TableView<Lecturer> lecturerTable = new TableView<>();
    @FXML
    private TableColumn<Lecturer, Integer> lecturerIDCol;
    @FXML
    private TableColumn<Lecturer, String> lecturerNameCol;
    @FXML
    private TextField newLecturerName;

    public LecturersController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initilaize");
        lecturerIDCol.setCellValueFactory(cellData -> cellData.getValue().lecturerID().asObject());
        lecturerNameCol.setCellValueFactory(cellData -> cellData.getValue().lecturerName());
        lecturerTable.setItems(PaneNavigator.getMainApp().getLecturersData());
    }

    @FXML
    private void handleDeleteInstructor() {
        int selectedIndex = lecturerTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
        	lecturerTable.getItems().remove(selectedIndex);
            PaneNavigator.getMainApp().getClassData().clear();

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(PaneNavigator.getMainApp().getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Lecturer Selected");
            alert.setContentText("Please select an lecturer in the table.");

            alert.showAndWait();
        }
    }

    private boolean lecturerNameIsValid(String lecturerName){
        return true;
    }

    @FXML
    private void handleNewLecturer() {
        String lecturerName = newLecturerName.getText();

        if(lecturerNameIsValid(lecturerName)){
            PaneNavigator.getMainApp().getLecturersData().add(new Lecturer(lecturerName));
        }
    }

    @FXML
    private void goToClasses(ActionEvent event) {
        System.out.println("goToClasses");
        PaneNavigator.loadPane(PaneNavigator.CLASSES_PANE);
    }

    @FXML
    private void handleClearAll() {
    	lecturerTable.getItems().clear();
        PaneNavigator.getMainApp().getClassData().clear();
    }
}
