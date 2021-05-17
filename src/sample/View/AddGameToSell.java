package sample.View;

import javafx.animation.ParallelTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

public class AddGameToSell {
    public TextField GameNameE;
    public TextField GameTypeE;
    public TextField GamePriceE;
    public TextArea GameDescE;
    public static ObservableList<Games> gls = FXCollections.observableArrayList();
    public Label PhotoPath;

    public void AddGameToList(ActionEvent event) throws IOException {
        if(GameNameE.getText() != null && GameDescE.getText() != null && GamePriceE.getText() != null) {

            gls.add(new Games(GameNameE.getText(), GameDescE.getText(), PhotoPath.getText(), GamePriceE.getText(),DataBase.getPersonData().get(DataBase.indexLogin).getName()));
            for (Person ps :
                    DataBase.getPersonData()) {
               if(ps.getName().equals(Login.username))
                {
                    ps.setGameLoginList(gls);
                }
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            DataBase.writeXMLPerson();
        }
    }

    public void AddPhoto(ActionEvent event) {
        Stage stg = new Stage();
        File fl = new FileChooser().showOpenDialog(stg);
        PhotoPath.setText(fl.getPath());
    }
}
