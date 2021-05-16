package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.security.krb5.internal.crypto.Des;

import javax.management.Descriptor;
import javax.naming.Name;

public class Games {


    private final StringProperty name;
    private final StringProperty Description;
    private final StringProperty Type;
    private final StringProperty price;

    public Games()
    {
        this(null,null,null,null);
    }



    public Games(String name, String description, String type, String price) {
        this.name = new SimpleStringProperty(name);
        this.Description = new SimpleStringProperty(description);
        this.Type = new SimpleStringProperty(type);
        this.price = new SimpleStringProperty(price);
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

    public String getType() {
        return Type.get();
    }

    public StringProperty typeProperty() {
        return Type;
    }

    public void setType(String type) {
        this.Type.set(type);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
    @Override
    public String toString()
    {
        return String.format(getName() + " " + getDescription() + " " + getType() + " " + getPrice());
    }

}
