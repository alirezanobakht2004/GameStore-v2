package ir.ac.kntu;

public class InboxGames {
    private Game game;

    private int expiryTime;

    private long startTime;

    public InboxGames(Game game, int expiryTime, long startTime) {
        this.game = game;
        this.expiryTime = expiryTime;
        this.startTime = startTime;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(int expiryTime) {
        this.expiryTime = expiryTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
