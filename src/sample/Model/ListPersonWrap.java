package sample.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "persons")
public class ListPersonWrap {
    private List<Person> PersonLoginCred;
    @XmlElement(name = "person")
    public List<Person> getPersonLoginCred() {
        return PersonLoginCred;
    }
    public void setPersonLoginCred(List<Person> personLoginCred) {
        PersonLoginCred = personLoginCred;
    }
}
