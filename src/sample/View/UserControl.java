package sample.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserControl implements Initializable {
    @FXML
    private Button btnHome;
    @FXML
    private AnchorPane LoadFXMLScene;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane obj = null;
        try {
            obj = FXMLLoader.load(getClass().getResource("Home.fxml"));
            LoadFXMLScene.getChildren().setAll(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ButtonHome(javafx.event.ActionEvent event) throws IOException {

        AnchorPane obj = FXMLLoader.load(getClass().getResource("Home.fxml"));
        LoadFXMLScene.getChildren().setAll(obj);

    }
    public void ButtonProfile(javafx.event.ActionEvent event) throws IOException {

        AnchorPane obj = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        LoadFXMLScene.getChildren().setAll(obj);

    }



}
