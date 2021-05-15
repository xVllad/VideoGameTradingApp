package sample.Model;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
//import com.sun.xml.internal.bind.v2.runtime.XMLSerializer;
import com.sun.xml.internal.txw2.output.XmlSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class DataBase {
    private static Object Person;

    private static List<Person> personData = new ArrayList<>();
    private List<Games> GameListAll;
    private static File file = new File("C:\\Users\\vladb\\Documents\\Java\\Login.xml");

    public void addPersonToList(Person p)
    {
        //ListPersonWrap.PersonLoginCred.add(p);
        writeXMLPerson();
    }

    public static List<Person> getPersonData() {
        return personData;
    }

    public static void AddAccount(String name,String password)
    {
        personData.add(new Person(name,password,null));
        writeXMLPerson();
    }

    public static void writeXMLPerson(){
        try {
            file.createNewFile();
            JAXBContext context = JAXBContext
                    .newInstance(ListPersonWrap.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ListPersonWrap wrapper = new ListPersonWrap();
            wrapper.setPersonLoginCred(personData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            Preferences prefs = Preferences.userNodeForPackage(DataBase.class);
            prefs.put("filePath", file.getPath());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

}
