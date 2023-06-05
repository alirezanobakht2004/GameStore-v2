package ir.ac.kntu;

public class InboxGames {
    private Game game;

    private int  ExpiryTime;

    private long startTime;

    public InboxGames(Game game, int expiryTime, long startTime) {
        this.game = game;
        ExpiryTime = expiryTime;
        this.startTime = startTime;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getExpiryTime() {
        return ExpiryTime;
    }

    public void setExpiryTime(int expiryTime) {
        ExpiryTime = expiryTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
