package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Accessories extends Item{

    private String numberOfAccessory;
    private List<AccessoriesSeller> accessoriesSellers = new ArrayList<AccessoriesSeller>();

    private String systemKind;

    private String systemConnection;

    private String fps;

    private String size;

    private String answerTime;
    public Accessories(){
        super();
    }

    public Accessories(String title, String info, String price, String numberOfAccessory) {
        super(title, info, price);
        this.numberOfAccessory = numberOfAccessory;
    }
    public List<AccessoriesSeller> getAccessoriesSellers() {
        return accessoriesSellers;
    }

    public String getNumberOfAccessory() {
        return numberOfAccessory;
    }

    public void setNumberOfAccessory(String numberOfAccessory) {
        this.numberOfAccessory = numberOfAccessory;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFps() {
        return fps;
    }

    public void setFps(String fps) {
        this.fps = fps;
    }

    public String getSystemConnection() {
        return systemConnection;
    }

    public void setSystemConnection(String systemConnection) {
        this.systemConnection = systemConnection;
    }

    public String getSystemKind() {
        return systemKind;
    }

    public void setSystemKind(String systemKind) {
        this.systemKind = systemKind;
    }
}
