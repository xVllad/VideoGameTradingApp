package sample.View;

import javafx.animation.ParallelTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Games;
import sample.Model.Person;
import java.io.IOException;

public class AddGameToSell {
    public TextField GameNameE;
    public TextField GameTypeE;
    public TextField GamePriceE;
    public TextArea GameDescE;
    public static ObservableList<Games> gls = FXCollections.observableArrayList();

    public void AddGameToList(ActionEvent event) throws IOException {
        if(GameNameE.getText() != null && GameDescE.getText() != null && GameTypeE.getText() != null && GamePriceE.getText() != null) {
            //DataBase.getGamesData().add(new Games(GameNameE.getText(), GameDescE.getText(), GameTypeE.getText(), GamePriceE.getText(),DataBase.getPersonData().get(DataBase.indexLogin).getName()));
            //DataBase.writeXMLGames();
            gls.add(new Games(GameNameE.getText(), GameDescE.getText(), GameTypeE.getText(), GamePriceE.getText(),null));
            for (Person ps :
                    DataBase.getPersonData()) {
               if(ps.getName().equals(Login.username))
                {
                    ps.setGameLoginList(gls);
                }


            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            DataBase.writeXMLPerson();
        }
    }
}
