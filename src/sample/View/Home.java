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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getGames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getGames() throws IOException
    {
        GameListVB.getChildren().removeAll(GameListVB.getChildren());
        System.out.println(DataBase.getGamesData().size());
        Node[] nd = new Node[DataBase.getGamesData().size()];
        for(int i=0 ; i<nd.length;i++)
        {
            GameView.index = i;
            nd[i] = (Node) FXMLLoader.load(getClass().getResource("GameView.fxml"));
            GameListVB.getChildren().add(nd[i]);
        }
    }

    public void AddGame(ActionEvent actionEvent) throws IOException {
        DataBase.AddGame();
        getGames();
    }




}
