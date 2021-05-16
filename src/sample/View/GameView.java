package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameView implements Initializable {

    public Label GameName;
    public Label GameDesc;
    public Label GameType;
    public Label GamePrice;
    public static int index;
    public static ObservableList<Games> gmList = FXCollections.observableArrayList();
    public  ObservableList<Games> HereList1item = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        GameName.setText(DataBase.getGamesData().get(index).getName());
        GameDesc.setText(DataBase.getGamesData().get(index).getDescription());
        GameType.setText(DataBase.getGamesData().get(index).getType());
        GamePrice.setText(DataBase.getGamesData().get(index).getPrice());
    }

    public void BuyGame(ActionEvent actionEvent) throws IOException {
        int i=0,j=0;
        gmList.add(new Games(DataBase.getGamesData().get(index).getName(),DataBase.getGamesData().get(index).getDescription(),DataBase.getGamesData().get(index).getType(),DataBase.getGamesData().get(index).getPrice(),null));
        HereList1item.add(new Games(DataBase.getGamesData().get(index).getName(),DataBase.getGamesData().get(index).getDescription(),DataBase.getGamesData().get(index).getType(),DataBase.getGamesData().get(index).getPrice(),DataBase.getGamesData().get(index).getUserName()));
        for (Person prs :
                DataBase.getPersonData()) {
                if(prs.getName().equals(HereList1item.get(0).getUserName())) {
                    j=0;
                    for (Games gms :
                            DataBase.getPersonData().get(i).getGameLoginList()) {
                        if(gms.getName().equals(DataBase.getGamesData().get(index).getName()))
                        {
                            DataBase.getPersonData().get(i).getGameLoginList().remove(j);
                            break;
                        }
                        j++;
                    }
                    break;
                }
        }
        DataBase.getPersonData().get(DataBase.indexLogin).setGameLoginList(gmList);
        DataBase.getGamesData().remove(index);
        DataBase.writeXMLGames();
        DataBase.writeXMLPerson();

    }

}
