package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Model.DataBase;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewSeller implements Initializable {
    public Label GameTypeSel;
    public Label GameNameSel;
    public Label GameDescSel;
    public Label GamePriceSel;
    public static int index;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameTypeSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameNameSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
        GameDescSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getType());
        GamePriceSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice());
    }

    public void RemoveFromCol(ActionEvent event) {

    }

    public void SellFromCol(ActionEvent event) {
        DataBase.getGamesData().add(AddGameToSell.gls.get(index));
        DataBase.writeXMLGames();
    }


}
