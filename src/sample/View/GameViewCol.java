package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Model.DataBase;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewCol implements Initializable {
    public Label GameNameCol;
    public Label GameDescCol;
    //public Label GameTypeCol;
    public Label GamePriceCol;
    public static int index;
    public int ind;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameNameCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameDescCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
        //GameTypeCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getType());
        GamePriceCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice());
        ind = index;
    }

    public void RemoveFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().remove(ind);
        DataBase.writeXMLPerson();

    }
}
