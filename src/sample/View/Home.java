package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import sample.Model.DataBase;
import sample.Model.Games;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    public ListView<Games> GameListAll;
    public VBox GameListVB;
    //public ObservableList<Games> Gametest = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getGames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    private void initialize() throws IOException {
        //System.out.println(DataBase.getPersonData());
        //GameListAll.getItems().add(new Games("Ana","desc","Type","12"));
       //Gametest.setItem(DataBase.getGamesData()).toString());
        //GameListAll.setItems(DataBase.getGamesData());
        //GameListAll.setCellFactory(param -> new ListCell<Games>());

    }
     */
    public void getGames() throws IOException
    {
        Node[] nd = new Node[DataBase.getGamesData().size()];
        for(int i=0 ; i<nd.length;i++)
        {
            GameView.index = i;
            nd[i] = (Node) FXMLLoader.load(getClass().getResource("GameView.fxml"));
            GameListVB.getChildren().add(nd[i]);
        }
    }

    public void AddGame(ActionEvent actionEvent) {
        DataBase.AddGame();
    }


}
