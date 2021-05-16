package sample.Model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Person {
    private final StringProperty Name;
    private final StringProperty Password;
    private final StringProperty Photo;

    private ObservableList<Games> GameLoginList ;

    public void setGameLoginList(ObservableList<Games> gameLoginList) {
        GameLoginList = gameLoginList;
    }

    public ObservableList<Games> getGameLoginList() {
        return GameLoginList;
    }

    public Person()
    {
        this(null,null,null,null);
    }

    public Person(String Name,String Password,String Photo,ObservableList<Games> GameLoginList) {
        this.Name = new SimpleStringProperty(Name);
        this.Password = new SimpleStringProperty(Password);
        this.Photo = new SimpleStringProperty(Photo);
        this.GameLoginList = FXCollections.observableArrayList();

    }
    // private List<Games> PersonGameList;


    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public String getPassword() {
        return Password.get();
    }

    public StringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getPhoto() {
        return Photo.get();
    }

    public StringProperty photoProperty() {
        return Photo;
    }

    public void setPhoto(String photo) {
        this.Photo.set(photo);
    }
}
