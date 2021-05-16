package sample.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Person {
    private final StringProperty Name;
    private final StringProperty Password;
    private final StringProperty Photo;
    private final IntegerProperty Type;

    private ObservableList<Games> GameLoginList ;

    public void setGameLoginList(ObservableList<Games> gameLoginList) {
        GameLoginList = gameLoginList;
    }

    public ObservableList<Games> getGameLoginList() {
        return GameLoginList;
    }

    public Person()
    {
        this(null,null,null,null,0);
    }

    public Person(String Name,String Password,String Photo,ObservableList<Games> GameLoginList,int Type) {
        this.Name = new SimpleStringProperty(Name);
        this.Password = new SimpleStringProperty(Password);
        this.Photo = new SimpleStringProperty(Photo);
        this.GameLoginList = FXCollections.observableArrayList();
        this.Type = new SimpleIntegerProperty(Type);

    }
    // private List<Games> PersonGameList;


    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
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

    public String getPhoto() {
        return Photo.get();
    }

    public StringProperty photoProperty() {
        return Photo;
    }

    public void setPhoto(String photo) {
        this.Photo.set(photo);
    }

    public int getType() {
        return Type.get();
    }

    public IntegerProperty typeProperty() {
        return Type;
    }

    public void setType(int type) {
        this.Type.set(type);
    }
}
