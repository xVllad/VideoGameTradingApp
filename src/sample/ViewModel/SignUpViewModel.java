package sample.ViewModel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.Person;
import sample.View.SignUp;


public class SignUpViewModel {

    private Person person;
    private String Name;
    private String Password;

    public SignUpViewModel(Person pers)
    {
        person = pers;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void addName(String value)
    {
        person.setName(value);
    }

    public void addPassword(String value)
    {
        person.setPassword(value);
    }



}
