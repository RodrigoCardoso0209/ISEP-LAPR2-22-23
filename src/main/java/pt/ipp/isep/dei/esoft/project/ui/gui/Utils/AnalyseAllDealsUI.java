package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnalyseAllDealsUI implements Initializable {
    @FXML
    public MenuItem doLogout;
    @FXML
    public MenuItem backToStoreManagerMenu;
    @FXML
    public Button multipleRegressionButton;
    public Button simpleRegressionButton;
    public MenuItem backToAnalyeDeals;
    public Button BubbleSortMethodButton;
    public Button SelectionSortMethodButton;

    @FXML
    private Label label;
    @FXML
    private DatePicker beginDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button submitButton;

    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    @FXML
    public void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);
    }
    @FXML
    private void getBackToStoreManagerMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI-fxml/StoreManagerUI.fxml");

    }






    @FXML
    private void switchToSimpleRegressionUI(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/SimpleRegressionUI.fxml");
    }

    @FXML
    private void switchToMultipleRegressionUI(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/MultipleRegression.fxml");
    }

}
