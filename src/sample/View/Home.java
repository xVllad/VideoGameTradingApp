package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import sample.Model.DataBase;
import sample.Model.Games;

public class Home {

    public ListView<Games> GameListAll;
    //public ObservableList<Games> Gametest = FXCollections.observableArrayList();

    @FXML
    private void initialize()
    {
        //System.out.println(DataBase.getPersonData());
        //GameListAll.getItems().add(new Games("Ana","desc","Type","12"));
       //Gametest.setItem(DataBase.getGamesData()).toString());
        GameListAll.setItems(DataBase.getGamesData());
        //GameListAll.setCellFactory(param -> new ListCell<Games>());
    }

    public void AddGame(ActionEvent actionEvent) {
        DataBase.AddGame();
    }
}
