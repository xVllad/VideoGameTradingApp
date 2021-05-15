package sample.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class UserControl {
    @FXML
    private Button btnHome;
    @FXML
    private AnchorPane LoadFXMLScene;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setBtnHome() throws IOException {
        /*
        Parent root = FXMLLoader.load(getClass().getResource("UserControl.fxml"));
        Stage = (Stage)((Node).getSource()).getScene().getWindow();

         */
        /*
        System.out.println("Ana are mere");
        Parent HomeRoot = FXMLLoader.load(getClass().getResource("View.SignUp.fxml"));
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(HomeRoot,1600,1000));

         */
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
