package sample.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class UserControl {
    @FXML
    private Button btnHome;
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


    public void switchToScene(javafx.event.ActionEvent event) throws IOException {
        /*
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */
    }
}