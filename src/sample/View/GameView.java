package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        //System.out.println(GameName.);
    }

    //public void

}
