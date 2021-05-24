package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        GamePrice.setText(Float.toString(DataBase.getGamesData().get(index).getPrice()));
        GameAuthor.setText(DataBase.getGamesData().get(index).getUserName());


        ind = index;
    }

    public void BuyGame(ActionEvent actionEvent) throws IOException {
        //System.out.println(ind + "NU");
        int i = 0, j = 0;
        //DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().add()
        if(DataBase.getPersonData().get(DataBase.indexLogin).getMoney() >= DataBase.getGamesData().get(ind).getPrice()) {
            DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().add(new Games(DataBase.getGamesData().get(ind).getName(), DataBase.getGamesData().get(ind).getDescription(), DataBase.getGamesData().get(ind).getPhoto(), DataBase.getGamesData().get(ind).getPrice(), null));

            for (Person ps :
                    DataBase.getPersonData()) {
                if(ps.getName().equals(DataBase.getGamesData().get(ind).getUserName()))
                {j=0;
                    for (Games gms :
                            ps.getGameLoginList()) {

                        if(gms.getName().equals(DataBase.getGamesData().get(ind).getName())) {
                            float sellermn = ps.getMoney();
                            float buyermoney = DataBase.getPersonData().get(DataBase.indexLogin).getMoney();
                            sellermn = sellermn + DataBase.getGamesData().get(ind).getPrice();
                            buyermoney = buyermoney - DataBase.getGamesData().get(ind).getPrice();
                            ps.setMoney(sellermn);
                            DataBase.getPersonData().get(DataBase.indexLogin).setMoney(buyermoney);
                            DataBase.getGamesData().remove(ind);
                            ps.getGameLoginList().remove(j);
                            break;
                        }
                        j++;
                    }
                    break;
                }
            }
            DataBase.writeXMLGames();
            DataBase.writeXMLPerson();
            /*
            gmList.add(new Games(DataBase.getGamesData().get(ind).getName(), DataBase.getGamesData().get(ind).getDescription(), DataBase.getGamesData().get(ind).getPhoto(), DataBase.getGamesData().get(ind).getPrice(), null));
            HereList1item.add(new Games(DataBase.getGamesData().get(ind).getName(), DataBase.getGamesData().get(ind).getDescription(), DataBase.getGamesData().get(ind).getPhoto(), DataBase.getGamesData().get(ind).getPrice(), DataBase.getGamesData().get(ind).getUserName()));
            for (Person prs :
                    DataBase.getPersonData()) {
                System.out.println(prs.getName() + " = " + HereList1item.get(0).getUserName());
                if (prs.getName().equals(HereList1item.get(0).getUserName())) {
                    j = 0;
                    for (Games gms :
                            DataBase.getPersonData().get(i).getGameLoginList()) {
                        if (gms.getName().equals(DataBase.getGamesData().get(ind).getName())) {
                            DataBase.getPersonData().get(i).setMoney(DataBase.getGamesData().get(ind).getPrice());
                            float mny = DataBase.getPersonData().get(DataBase.indexLogin).getMoney();
                            System.out.println(mny);
                            mny = mny - DataBase.getGamesData().get(ind).getPrice();
                            System.out.println(mny);
                            DataBase.getPersonData().get(DataBase.indexLogin).setMoney(mny);
                            DataBase.getPersonData().get(i).getGameLoginList().remove(j);
                            break;
                        }
                        j++;
                    }
                    break;
                }
                i++;
            }
            DataBase.getPersonData().get(DataBase.indexLogin).setGameLoginList(gmList);
            DataBase.getGamesData().remove(ind);
            DataBase.writeXMLGames();
            DataBase.writeXMLPerson();
             */
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not enough Money!!!");
            alert.showAndWait();
        }


    }


}
