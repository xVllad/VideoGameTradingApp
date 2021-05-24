package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Model.DataBase;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameViewCol implements Initializable {
    public Label GameNameCol;
    public Label GameDescCol;
    //public Label GameTypeCol;
    public Label GamePriceCol;
    public static int index;
    public int ind;
    public ImageView PhotoGame;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameNameCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameDescCol.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
       // GamePriceCol.setText(Float.toString(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice()));

        //System.out.println(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPhoto());
        if(!DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPhoto().equals("")) {
            Image img = new Image(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPhoto());
            PhotoGame.setImage(img);
        }

       //Image img = new Image(getClass().getResourceAsStream(DataBase.getGamesData().get(index).getPhoto()));
        //PhotoGame.setImage(img);
        ind = index;
    }

    public void RemoveFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().remove(ind);
        DataBase.writeXMLPerson();

    }
}
