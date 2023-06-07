package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    private String adminName;

    private String password;

    private AdminMenu adminMenu=new AdminMenu();

    private Developer adminDevelpoer;

    private AccessoriesSeller adminAccessorySeller;

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
        adminAccessorySeller = new AccessoriesSeller(adminName,password);
        adminAccessorySeller.setAdmin(true);
        AccessoriesSellerManagement.getAccessoriesSellerArr().add(adminAccessorySeller);
        adminDevelpoer = new Developer(adminName,password);
        adminDevelpoer.setAdmin(true);
        DeveloperManagement.getDevelopersArr().add(adminDevelpoer);
    }


    public AccessoriesSeller getAdminAccessorySeller() {
        return adminAccessorySeller;
    }

    public Developer getAdminDevelpoer() {
        return adminDevelpoer;
    }

    public void setAdminDevelpoer(Developer adminDevelpoer) {
        this.adminDevelpoer = adminDevelpoer;
    }
}
