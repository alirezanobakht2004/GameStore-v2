package ir.ac.kntu;

public class gamingController extends accessories{
    private String systemKind;

    private String systemConnection;

    public gamingController(){
        super();
    }

    public gamingController(String systemKind,String systemConnection,int numberOfAccessory,String title, String info, int price){
        super(title,info,price,numberOfAccessory);
        this.systemKind=systemKind;
        this.systemConnection=systemConnection;

    }
}
