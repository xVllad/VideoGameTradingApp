package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

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
    public ImageView GamePhoto;
    public String path = "C:\\Users\\vladb\\Pictures\\";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameNameSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getName());
        GameDescSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getDescription());
        GamePriceSel.setText(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(index).getPrice());
/*
        System.out.println(path);
       // path = DataBase.getGamesData().get(index).getPhoto();
        System.out.println("C:\\Users\\vladb\\Pictures");
        Image img = new Image(path);
        GamePhoto.setImage(img);
*/
        ind = index;
    }

    public void RemoveFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().remove(ind);

        int i=0;
        for (Games gms :
                DataBase.getGamesData()) {
            if(gms.getName().equals(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(ind).getName()))
            {
                DataBase.getGamesData().remove(i);
            }
            i++;
        }
        DataBase.writeXMLPerson();
    }

    public void SellFromCol(ActionEvent event) {
        System.out.println(ind);
        DataBase.getGamesData().add(DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().get(ind));
        DataBase.writeXMLGames();

    }


}
