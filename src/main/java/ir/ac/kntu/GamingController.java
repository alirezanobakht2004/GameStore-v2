package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class GamingController extends Accessories {
    private String systemKind;

    private String systemConnection;


    public GamingController(){
        super();
    }

    public GamingController(String systemKind, String systemConnection, String numberOfAccessory, String title, String info, String price){
        super(title,info,price,numberOfAccessory);
        this.systemKind=systemKind;
        this.systemConnection=systemConnection;

    }


    public String getSystemKind() {
        return systemKind;
    }

    public void setSystemKind(String systemKind) {
        this.systemKind = systemKind;
    }

    public String getSystemConnection() {
        return systemConnection;
    }

    public void setSystemConnection(String systemConnection) {
        this.systemConnection = systemConnection;
    }
}
