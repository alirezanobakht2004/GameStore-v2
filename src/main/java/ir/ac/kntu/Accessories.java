package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Accessories extends Item{

    private int numberOfAccessory;
    private List<AccessoriesSeller> accessoriesSellers = new ArrayList<AccessoriesSeller>();

    private String systemKind;

    private SystemConnection systemConnection;

    private String fps;

    private String size;

    private int numberBought=0;
    private String answerTime;
    public Accessories(){
        super();
    }

    public Accessories(String title, String info, int price, int numberOfAccessory) {
        super(title, info, price);
        this.numberOfAccessory = numberOfAccessory;
    }
    public List<AccessoriesSeller> getAccessoriesSellers() {
        return accessoriesSellers;
    }


    public int getNumberOfAccessory() {
        return numberOfAccessory;
    }

    public void setNumberOfAccessory(int numberOfAccessory) {
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

    public SystemConnection getSystemConnection() {
        return systemConnection;
    }

    public void setSystemConnection(SystemConnection systemConnection) {
        this.systemConnection = systemConnection;
    }

    public String getSystemKind() {
        return systemKind;
    }

    public void setSystemKind(String systemKind) {
        this.systemKind = systemKind;
    }


    public int getNumberBought() {
        return numberBought;
    }

    public void setNumberBought(int numberBought) {
        this.numberBought = numberBought;
    }
}
