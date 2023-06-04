package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesSeller {

    private String accessoriesSellerName;
    private String password;
    AccessoriesSellerMenu accessoriesSellerMenu;

    private List<Accessories> accessories = new ArrayList<Accessories>();

    public AccessoriesSeller(String accessoriesSellerName, String password) {
        this.accessoriesSellerName = accessoriesSellerName;
        this.password = password;
        accessoriesSellerMenu=new AccessoriesSellerMenu();
    }


    public String getAccessoriesSellerName() {
        return accessoriesSellerName;
    }

    public void setAccessoriesSellerName(String accessoriesSellerName) {
        this.accessoriesSellerName = accessoriesSellerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessoriesSellerMenu getAccessoriesSellerMenu() {
        return accessoriesSellerMenu;
    }

    public List<Accessories> getAccessories() {
        return accessories;
    }
}
