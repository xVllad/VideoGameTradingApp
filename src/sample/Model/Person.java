package sample.Model;

import javafx.collections.ObservableList;

public class Person {
    private String name;
    private String password;
    private ObservableList<Games> PersonGameList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
