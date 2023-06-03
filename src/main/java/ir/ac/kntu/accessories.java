package ir.ac.kntu;

public class accessories extends Item{

    private int numberOfAccessory;

    public accessories(){
        super();
    }

    public accessories(String title, String info, int price, int numberOfAccessory) {
        super(title, info, price);
        this.numberOfAccessory = numberOfAccessory;
    }
}
