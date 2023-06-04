package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Developer{
    private String developerName;
    private String password;
    private DeveloperMenu developerMenu ;

    private List<Game> developerGames = new ArrayList<Game>();
    public Developer() {
    }

    public Developer(String developerName, String password) {
        this.developerName = developerName;
        this.password = password;
        developerMenu = new DeveloperMenu();
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DeveloperMenu getDeveloperMenu() {
        return developerMenu;
    }

    public void setDeveloperMenu(DeveloperMenu developerMenu) {
        this.developerMenu = developerMenu;
    }

    public List<Game> getDeveloperGames() {
        return developerGames;
    }
}
