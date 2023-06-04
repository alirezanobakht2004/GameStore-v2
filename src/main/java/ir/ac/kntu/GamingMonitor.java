package ir.ac.kntu;

public class GamingMonitor extends Accessories {

    private int fps;

    private int size;

    private int answerTime;

    public GamingMonitor() {
    }

    public GamingMonitor(String title, String info, int price, int numberOfAccessory, int fps, int size, int answerTime) {
        super(title, info, price, numberOfAccessory);
        this.fps = fps;
        this.size = size;
        this.answerTime = answerTime;
    }
}
