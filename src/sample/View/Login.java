package sample.View;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Person;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import sample.Model.DataBase;
public class Login {

    @FXML

    ImageView myImageView;




    public TextField LoginField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void OnClickEventRegister(javafx.event.ActionEvent event) throws IOException {


                Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }

    public void OnClickEventLogin(javafx.event.ActionEvent event) throws IOException {
        for (Person pers : DataBase.getPersonData()) {
            if (pers.getName().equals(LoginField.getText())) {

                Parent root = FXMLLoader.load(getClass().getResource("UserControl.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
