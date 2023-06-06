package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Developer{
    private String developerName;
    private String password;
    private DeveloperMenu developerMenu ;
    private List<Game> developerGames = new ArrayList<Game>();

    private List<InboxGames> inbox = new ArrayList<InboxGames>();

    private List<InboxGames> scheduleEvent = new ArrayList<InboxGames>();

    private List<String> feedback = new ArrayList<String>();

    private Boolean isAdmin=false;

    public Developer() {
    }

    public Developer(String developerName, String password) {
        this.developerName = developerName;
        this.password = password;
        developerMenu = new DeveloperMenu();
    }
    public List<InboxGames> getScheduleEvent() {
        return scheduleEvent;
    }
    public int getScheduleEventSize(){
        return scheduleEvent.size();
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

    public List<InboxGames> getInbox() {
        return inbox;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
