package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Games;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.image.Image;


import org.apache.commons.lang.math.NumberUtils;

public class AddGameToSell implements Initializable {
    public TextField GameNameE;
    public TextField GameTypeE;
    public TextField GamePriceE;
    public TextArea GameDescE;
    public static ObservableList<Games> gls = FXCollections.observableArrayList();
    public Label PhotoPath;
    public Label lblGamePrice;
    public Label lblPriceType;
    public ImageView imgGame;
    private float pr=0;


    public void AddGameToList(ActionEvent event) throws IOException {
        if (NumberUtils.isNumber(GamePriceE.getText())) {
            if (GameNameE.getText() != null && GameDescE.getText() != null) {
                if (GamePriceE.getText().equals("")) {
                    pr = 0;
                } else {
                    pr = Float.parseFloat(GamePriceE.getText());
                }
                DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().add(new Games(GameNameE.getText(), GameDescE.getText(), PhotoPath.getText(), pr, DataBase.getPersonData().get(DataBase.indexLogin).getName()));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();


                DataBase.writeXMLPerson();
            }
        }
        else if(DataBase.getPersonData().get(DataBase.indexLogin).getType() == 0)
        {

            DataBase.getPersonData().get(DataBase.indexLogin).getGameLoginList().add(new Games(GameNameE.getText(), GameDescE.getText(), PhotoPath.getText(), 0, DataBase.getPersonData().get(DataBase.indexLogin).getName()));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            DataBase.writeXMLPerson();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong Price!!!");
            alert.showAndWait();
        }
    }

    public void AddPhoto(ActionEvent event) {
        Stage stg = new Stage();
        File fl = new FileChooser().showOpenDialog(stg);
        PhotoPath.setText(fl.toURI().toString());
        Image img = new Image(PhotoPath.getText());
        imgGame.setImage(img);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(DataBase.getPersonData().get(DataBase.indexLogin).getType() == 0)
        {
            lblGamePrice.setVisible(false);
            GamePriceE.setVisible(false);
            lblPriceType.setVisible(false);
        }
    }
}
