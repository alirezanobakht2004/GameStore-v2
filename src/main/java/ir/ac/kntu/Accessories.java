package ir.ac.kntu;

public class Accessories extends Item{

    private int numberOfAccessory;

    public Accessories(){
        super();
    }

    public Accessories(String title, String info, int price, int numberOfAccessory) {
        super(title, info, price);
        this.numberOfAccessory = numberOfAccessory;
    }
}
