package ir.ac.kntu;

public class GamingController extends Accessories {
    private String systemKind;

    private String systemConnection;

    public GamingController(){
        super();
    }

    public GamingController(String systemKind, String systemConnection, int numberOfAccessory, String title, String info, int price){
        super(title,info,price,numberOfAccessory);
        this.systemKind=systemKind;
        this.systemConnection=systemConnection;

    }
}
