package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameView implements Initializable {

    public Label GameName;
    public Label GameDesc;
    public Label GamePrice;
    public static int index;
    public static ObservableList<Games> gmList = FXCollections.observableArrayList();
    public ObservableList<Games> HereList1item = FXCollections.observableArrayList();
    public Label GameAuthor;
    public int ind;
    public ImageView PhotoGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        GameName.setText(DataBase.getGamesData().get(index).getName());
        GameDesc.setText(DataBase.getGamesData().get(index).getDescription());
        GamePrice.setText(DataBase.getGamesData().get(index).getPrice());
        GameAuthor.setText(DataBase.getGamesData().get(index).getUserName());


        ind = index;
    }

    public void BuyGame(ActionEvent actionEvent) throws IOException {
        System.out.println(ind + "NU");
        int i = 0, j = 0;

        gmList.add(new Games(DataBase.getGamesData().get(ind).getName(), DataBase.getGamesData().get(ind).getDescription(), DataBase.getGamesData().get(ind).getPhoto(), DataBase.getGamesData().get(ind).getPrice(), null));
        HereList1item.add(new Games(DataBase.getGamesData().get(ind).getName(), DataBase.getGamesData().get(ind).getDescription(), DataBase.getGamesData().get(ind).getPhoto(), DataBase.getGamesData().get(ind).getPrice(), DataBase.getGamesData().get(ind).getUserName()));
        for (Person prs :
                DataBase.getPersonData()) {
            if (prs.getName().equals(HereList1item.get(0).getUserName())) {
                j = 0;
                for (Games gms :
                        DataBase.getPersonData().get(i).getGameLoginList()) {
                    if (gms.getName().equals(DataBase.getGamesData().get(ind).getName())) {
                        DataBase.getPersonData().get(i).getGameLoginList().remove(j);
                        break;
                    }
                    j++;
                }
                break;
            }
        }
        DataBase.getPersonData().get(DataBase.indexLogin).setGameLoginList(gmList);
        DataBase.getGamesData().remove(ind);
        DataBase.writeXMLGames();
        DataBase.writeXMLPerson();


    }


}
