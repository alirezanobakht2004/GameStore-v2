package ir.ac.kntu;

public class Admin {
    private String adminName;
    private String password;
    private AdminMenu adminMenu=new AdminMenu();

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
}
