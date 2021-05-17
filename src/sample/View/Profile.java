package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    public VBox GameColectionList;
    public Label UserName;
    public static String username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UserName.setText(Login.username);
            GameColectionList.getChildren().removeAll(GameColectionList.getChildren());
            if(DataBase.getPersonData().get(DataBase.indexLogin).getType() == 0)
            {
                getCollectionBuyer();
            }
            else if(DataBase.getPersonData().get(DataBase.indexLogin).getType() == 1)
            {
                getCollectionSeller();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddGameLi(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddGameToSell.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root,1300,1000));
        stage.show();
    }

    public void getCollectionSeller() throws IOException
    {
        GameColectionList.getChildren().removeAll(GameColectionList.getChildren());
        Node[] nd = new Node[DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().size()];
        for(int i=0 ; i<nd.length;i++)
        {
            GameViewSeller.index = i;
            nd[i] = (Node) FXMLLoader.load(getClass().getResource("GameViewSeller.fxml"));
            GameColectionList.getChildren().add(nd[i]);
        }
    }

    public void getCollectionBuyer() throws IOException
    {
        GameColectionList.getChildren().removeAll(GameColectionList.getChildren());
        Node[] nd = new Node[DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().size()];
        for(int i=0 ; i<nd.length;i++)
        {
            GameViewCol.index = i;
            nd[i] = (Node) FXMLLoader.load(getClass().getResource("GameViewCol.fxml"));
            GameColectionList.getChildren().add(nd[i]);
        }
    }

}
