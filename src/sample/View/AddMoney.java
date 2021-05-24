package sample.View;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.DataBase;

public class AddMoney {
    public TextField FullName;
    public TextField CardNr;
    public TextField CVC;
    public TextField MoneyAmm;

    public void OKClick(ActionEvent event) {
        float mny = DataBase.getPersonData().get(DataBase.indexLogin).getMoney();
        mny += Float.valueOf(MoneyAmm.getText());
        DataBase.getPersonData().get(DataBase.indexLogin).setMoney(mny);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        DataBase.writeXMLPerson();
    }
}
