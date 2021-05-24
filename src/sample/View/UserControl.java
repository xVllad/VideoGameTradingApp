package sample.View;

import javafx.event.ActionEvent;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserControl implements Initializable {
    @FXML
    private Button btnHome;
    @FXML
    public AnchorPane LoadFXMLScene;
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

        btn2();

    }
    public void ButtonProfile(javafx.event.ActionEvent event) throws IOException {

        btn();

    }

    public void btn2() throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("Home.fxml"));
        LoadFXMLScene.getChildren().setAll(obj);
    }

    public void btn() throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        LoadFXMLScene.getChildren().setAll(obj);
    }


    public void SignOutbtn(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("VideoGameTrade");
        primaryStage.setScene(new Scene(root, 1600, 1000));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
