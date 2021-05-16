package sample.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.ViewModel.SignUpViewModel;

import java.awt.*;
import java.io.IOException;
public class SignUp {

    private SignUpViewModel signVM;
    public TextField UserNameField;
    public TextField PasswordField;
    public TextField RePasswordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private DataBase dtBase;



    public void CreateAccountBtn(javafx.event.ActionEvent event) throws IOException
    {
        if(PasswordField.getText().equals(RePasswordField.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Account  Registration");
            alert.setHeaderText("Account created Successful!");
            alert.showAndWait();
            DataBase.AddAccount(UserNameField.getText(),PasswordField.getText(),null);
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password not match!!!");
            alert.showAndWait();
        }
    }
    public void AddAccount()
    {

    }
    public void OnClickEventAlreadyHave(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
