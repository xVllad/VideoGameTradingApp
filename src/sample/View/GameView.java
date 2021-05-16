package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Model.DataBase;
import sample.Model.Games;

import java.net.URL;
import java.util.ResourceBundle;

public class GameView implements Initializable {

    public Label GameName;
    public Label GameDesc;
    public Label GameType;
    public Label GamePrice;
    public static int index;
    public ObservableList<Games> gmList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        GameName.setText(DataBase.getGamesData().get(index).getName());
        GameDesc.setText(DataBase.getGamesData().get(index).getDescription());
        GameType.setText(DataBase.getGamesData().get(index).getType());
        GamePrice.setText(DataBase.getGamesData().get(index).getPrice());
        //System.out.println(GameName.);
    }

    public void BuyGame(ActionEvent actionEvent) {

    }

    //public void

}
