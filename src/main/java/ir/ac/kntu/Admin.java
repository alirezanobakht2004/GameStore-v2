package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String adminName;
    private String password;
    private AdminMenu adminMenu=new AdminMenu();

    private List<Accessories> accessories = new ArrayList<Accessories>();

    private List<Game> games = new ArrayList<Game>();

    public AdminMenu getAdminMenu() {
        return adminMenu;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public List<Accessories> getAccessories() {
        return accessories;
    }

    public List<Game> getGames() {
        return games;
    }
}
