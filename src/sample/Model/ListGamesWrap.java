package sample.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "games")
public class ListGamesWrap {
    private List<Games> GamesListAll;
    @XmlElement(name = "game")

    public List<Games> getGamesListAll() {
        return GamesListAll;
    }

    public void setGamesListAll(List<Games> gamesListAll) {
        GamesListAll = gamesListAll;
    }
}
