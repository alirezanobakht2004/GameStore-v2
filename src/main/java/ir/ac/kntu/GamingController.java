package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class GamingController extends Accessories {
    private String systemKind;

    private SystemConnection systemConnection;


    public GamingController(){
        super();
    }

    public GamingController(String systemKind, SystemConnection systemConnection, String numberOfAccessory, String title, String info, String price){
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

    public SystemConnection getSystemConnection() {
        return systemConnection;
    }

    public void setSystemConnection(SystemConnection systemConnection) {
        this.systemConnection = systemConnection;
    }
}
