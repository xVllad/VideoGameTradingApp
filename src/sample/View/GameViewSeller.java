package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Model.DataBase;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewSeller implements Initializable {
    //public Label GameTypeSel;
    public Label GameNameSel;
    public Label GameDescSel;
    public Label GamePriceSel;
    //public Label GameAuthor;
    public static int index;
    public Profile prf;
    public int ind;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameNameSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameDescSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
        GamePriceSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice());
       // GameAuthor.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getUserName());
        ind = index;
    }

    public void RemoveFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().remove(ind);
        DataBase.writeXMLPerson();

    }

    public void SellFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getGamesData().add(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(ind));
        DataBase.writeXMLGames();

    }


}
