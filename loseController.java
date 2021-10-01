package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class loseController {

    @FXML
     Button noButton;

    @FXML
     Button yesButton;

    @FXML
     void onNo(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
     void onYes(ActionEvent actionEvent) {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
