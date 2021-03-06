package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import java.io.File;
import java.net.URL;
import java.util.Objects;
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
    public ImageView GamePhoto;
    public String path = "C:\\Users\\vladb\\Pictures\\";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameNameSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameDescSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
        GamePriceSel.setText(Float.toString(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice()));
        if(!DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPhoto().equals("")) {
            Image img = new Image(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPhoto());
            GamePhoto.setImage(img);
        }
        ind = index;
    }

    public void RemoveFromCol(ActionEvent event) {
        System.out.println(ind);

        int i=0;

        for (Games gms:
             DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList()) {
            if(gms.getName().equals(DataBase.getGamesData().get(ind).getName()))
            {
                DataBase.getGamesData().remove(i);
                break;
            }
            i++;
        }
        DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().remove(ind);
        DataBase.writeXMLPerson();
        DataBase.writeXMLGames();
    }

    public void SellFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getGamesData().add(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(ind));
        DataBase.writeXMLGames();

    }


}
