package sample.Model;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javafx.stage.Stage;
import sample.Model.Person;
import sample.Model.Games;
import sample.Model.ListPersonWrap;
import sample.View.SignUp;
import sample.View.Login;


public class DataBase {
    private static Object Person;

    private static List<Person> personData = new ArrayList<>();
    private static List<Games> GameListData = new ArrayList<>();
    private static File fileLogin = new File("C:\\Users\\vladb\\Documents\\Java\\Login.xml");
    private static File fileGames = new File("C:\\Users\\vladb\\Documents\\Java\\Games.xml");


    public static List<Person> getPersonData() {
        return personData;
    }

    public static List<Games> getGamesData() {
        return GameListData;
    }

    public static void AddAccount(String name,String password)
    {
        personData.add(new Person(name,password,null));
        writeXMLPerson();
    }


    public static void writeXMLGames()
    {
        try {
            fileGames.createNewFile();
            JAXBContext context = JAXBContext
                    .newInstance(ListPersonWrap.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ListPersonWrap wrapper = new ListPersonWrap();
            wrapper.setPersonLoginCred(personData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, fileGames);

            // Save the file path to the registry.
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

            // Wrapping our person data.
            ListPersonWrap wrapper = new ListPersonWrap();
            wrapper.setPersonLoginCred(personData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, fileLogin);

            // Save the file path to the registry.
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

            // Reading XML from the file and unmarshalling.
            ListPersonWrap wrapper = (ListPersonWrap) um.unmarshal(fileLogin);

            personData.clear();
            personData.addAll(wrapper.getPersonLoginCred());

            // Save the file path to the registry.
            setPersonFilePath(fileLogin);


        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + fileLogin.getPath());

            alert.showAndWait();
        }
    }

    public static void readXMLGames()
    {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ListPersonWrap.class);
            Unmarshaller um = context.createUnmarshaller();
            ListPersonWrap wrapper = (ListPersonWrap) um.unmarshal(fileGames);
            personData.clear();
            personData.addAll(wrapper.getPersonLoginCred());
            setPersonFilePath(fileGames);


        } catch (Exception e) { // catches ANY exception
            System.out.println("File Games not Found");
        }
    }

}
