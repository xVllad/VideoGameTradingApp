package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Person;
import sample.ViewModel.SignUpViewModel;

import java.awt.*;
import java.io.IOException;
public class SignUp {

    public CheckBox checkBuy;
    public CheckBox checkSel;
    private SignUpViewModel signVM;
    public TextField UserNameField;
    public TextField PasswordField;
    public TextField RePasswordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private DataBase dtBase;
    private int check=-1;

    public void CreateAccountBtn(javafx.event.ActionEvent event) throws Exception
    {
        int ok=0;
        for (Person prs :
                DataBase.getPersonData()) {
            if(prs.getName().equals(UserNameField.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Account  Registration");
                alert.setHeaderText("Account Already Exist!");
                alert.showAndWait();
                ok = 1;

            }
        }
        if(ok == 0) {
            if (PasswordField.getText().equals(RePasswordField.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Account  Registration");
                alert.setHeaderText("Account created Successful!");
                alert.showAndWait();
                if (checkBuy.isSelected()) {
                    check = 0;
                } else if (checkSel.isSelected()) {
                    check = 1;
                }
                //System.out.println(check+"DA");
                TrippleDes td = new TrippleDes();

                String encrypted = td.encrypt(PasswordField.getText());

                DataBase.AddAccount(UserNameField.getText(), encrypted, null, null, check,0);
                //DataBase.getPersonData().add(new Person(UserNameField.getText(),PasswordField.getText(),null,check));
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Password not match!!!");
                alert.showAndWait();
            }
        }
    }

    public void OnClickEventAlreadyHave(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void CheckBuy(ActionEvent event) {
        if(checkSel.isSelected())
        {
            checkSel.setSelected(false);
        }
    }

    public void CheckSel(ActionEvent event) {

        if(checkBuy.isSelected())
        {
            checkBuy.setSelected(false);
        }
    }
}
