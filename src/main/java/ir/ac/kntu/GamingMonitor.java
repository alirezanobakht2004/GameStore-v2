package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class GamingMonitor extends Accessories {

    private String fps;

    private String size;

    private String answerTime;

    private List<AccessoriesSeller> accessoriesSellers = new ArrayList<AccessoriesSeller>();

    public GamingMonitor() {
    }

    public GamingMonitor(String title, String info, String price, String numberOfAccessory, String fps, String size, String answerTime) {
        super(title, info, price, numberOfAccessory);
        this.fps = fps;
        this.size = size;
        this.answerTime = answerTime;
    }

    public List<AccessoriesSeller> getAccessoriesSellers() {
        return accessoriesSellers;
    }
}
