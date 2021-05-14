package sample.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {


    @FXML private Button Login;

    public void OnClickEvent(MouseEvent mouseEvent) throws IOException {

        Parent RegisterSceneParent = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        Scene RegisterScene = new Scene(RegisterSceneParent);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
}
