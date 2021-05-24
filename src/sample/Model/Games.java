package sample.Model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.security.krb5.internal.crypto.Des;

import javax.management.Descriptor;
import javax.naming.Name;

public class Games {


    private final StringProperty name;
    private final StringProperty Description;
    private final StringProperty Photo;
    private final SimpleFloatProperty price;
    private final StringProperty UserName;

    public Games()
    {
        this(null,null,null,0,null);
    }



    public Games(String name, String description, String photo, float price,String UserName) {
        this.name = new SimpleStringProperty(name);
        this.Description = new SimpleStringProperty(description);
        this.Photo = new SimpleStringProperty(photo);
        this.price = new SimpleFloatProperty(price);
        this.UserName = new SimpleStringProperty(UserName);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return Description.get();
    }

    public StringProperty descriptionProperty() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description.set(description);
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

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public String getUserName() {
        return UserName.get();
    }

    public StringProperty userNameProperty() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName.set(userName);
    }



}
