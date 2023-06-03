package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String title;

    private String info;

    private int price;

    private Community community;

    private List<String> feedback  =new ArrayList<String>();

    public Community getCommunity() {
        return community;
    }
}
