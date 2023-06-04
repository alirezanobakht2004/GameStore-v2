package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String title;
    private String info;

    private String price;

    private Community community;

    private List<String> feedback  =new ArrayList<String>();

    public Item(){
        community = new Community();
    }
    public Item(String title, String info, String price) {
        community = new Community();
        this.title = title;
        this.info = info;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public Community getCommunity() {
        return community;
    }
}
