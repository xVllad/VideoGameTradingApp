package sample.Model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javafx.stage.Stage;
import sample.Main;
import sample.Model.Person;
import sample.Model.Games;
import sample.Model.ListPersonWrap;
import sample.View.SignUp;
import sample.View.Login;


public class DataBase {
    private static Object Person;

    private static List<Person> personData = new ArrayList<>();
    private static ObservableList<Games> GameListData = FXCollections.observableArrayList();
    public static File fileLogin ;
    public static File fileGames ;


    public static List<Person> getPersonData() {
        return personData;
    }

    public static ObservableList<Games> getGamesData() {
        return GameListData;
    }

    public static void AddAccount(String name,String password)
    {
        personData.add(new Person(name,password,null));
        writeXMLPerson();
    }

    public static int getLenght()
    {
        return GameListData.size();
    }

    public static void AddGame()
    {
        GameListData.add(new Games("Half Life","ceva ceava ceva ceava","Joc", "12"));
        writeXMLGames();
    }


    public DataBase()
    {

    }

    public static void writeXMLGames()
    {
        try {
            fileGames.createNewFile();
            JAXBContext context = JAXBContext
                    .newInstance(ListGamesWrap.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ListGamesWrap wrapper = new ListGamesWrap();
            wrapper.setGamesListAll(GameListData);
            m.marshal(wrapper, fileGames);
            Preferences prefs = Preferences.userNodeForPackage(DataBase.class);
            prefs.put("filePath", fileGames.getPath());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + fileGames.getPath());

            alert.showAndWait();
        }
    }

    public static void writeXMLPerson(){
        try {
            fileLogin.createNewFile();
            JAXBContext context = JAXBContext
                    .newInstance(ListPersonWrap.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ListPersonWrap wrapper = new ListPersonWrap();
            wrapper.setPersonLoginCred(personData);
            m.marshal(wrapper, fileLogin);
            Preferences prefs = Preferences.userNodeForPackage(DataBase.class);
            prefs.put("filePath", fileLogin.getPath());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + fileLogin.getPath());

            alert.showAndWait();
        }
    }

    public static void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(DataBase.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());


        } else {
            prefs.remove("filePath");

        }
    }

    public static void readXMLPerson()
    {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ListPersonWrap.class);
            Unmarshaller um = context.createUnmarshaller();
            ListPersonWrap wrapper = (ListPersonWrap) um.unmarshal(fileLogin);
            personData.clear();
            personData.addAll(wrapper.getPersonLoginCred());
            setPersonFilePath(fileLogin);

        } catch (Exception e) { // catches ANY exception
            System.out.println("File Login not Found");
        }
    }

    public static void readXMLGames()
    {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ListGamesWrap.class);
            Unmarshaller um = context.createUnmarshaller();
            ListGamesWrap wrapper = (ListGamesWrap) um.unmarshal(fileGames);
            GameListData.clear();
            GameListData.addAll(wrapper.getGamesListAll());
            setPersonFilePath(fileGames);


        } catch (Exception e) {
            System.out.println("File Games not Found");
        }
    }

}
