package ir.ac.kntu;

public class AccessoriesSellerMenu {
    private AccessoriesSeller accessoriesSeller;
    public void start(int i){
        accessoriesSeller=AccessoriesSellerManagement.getAccessoriesSellerArr().get(i);

    }
}
