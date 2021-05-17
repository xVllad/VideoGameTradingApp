package sample.View;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import sample.Model.DataBase;
public class Login {

    public javafx.scene.control.PasswordField PasswordField;
    @FXML

    ImageView myImageView;

    public TextField LoginField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static String username;

    public void OnClickEventRegister(javafx.event.ActionEvent event) throws IOException {

                Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }

    public void OnClickEventLogin(javafx.event.ActionEvent event) throws Exception {
        int i=0;
        for (Person pers : DataBase.getPersonData()) {
            if (pers.getName().equals(LoginField.getText())) {
                TrippleDes td = new TrippleDes();
                String decrypted = td.decrypt(DataBase.getPersonData().get(i).getPassword());
                if(PasswordField.getText().equals(decrypted)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Account  Registration");
                    alert.setHeaderText("Login Succeed!!!");
                    alert.showAndWait();
                    username = LoginField.getText();
                    Parent root = FXMLLoader.load(getClass().getResource("UserControl.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    DataBase.indexLogin = i;
                    break;
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong Password or UserName!!!");
                    alert.showAndWait();
                }
            }

            i++;
        }

        for (Games gms:
             DataBase.getPersonData().get(i).getGameLoginList()) {
            GameView.gmList.add(gms);
            AddGameToSell.gls.add(gms);
        }


    }
}
