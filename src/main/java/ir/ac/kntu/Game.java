package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Item{

    private GameKind genre;

    private int level;

    private GameVersion gameVersion;

    private int numberBought=0;

    private List<Developer> developersOfGame = new ArrayList<Developer>();

    public Game(){
        super();
    }

    public Game(String title, GameKind genre, String info, int price, int level, GameVersion gameVersion){
        super(title,info,price);
        this.genre=genre;
        this.level=level;
        this.gameVersion = gameVersion;
    }

    public List<Developer> getDevelopersOfGame() {
        return developersOfGame;
    }

    public GameKind getGenre() {
        return genre;
    }

    public void setGenre(GameKind genre) {
        this.genre = genre;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public GameVersion getVersion() {
        return gameVersion;
    }

    public void setVersion(GameVersion gameVersion) {
        this.gameVersion = gameVersion;
    }

    public int getNumberBought() {
        return numberBought;
    }

    public void setNumberBought(int numberBought) {
        this.numberBought = numberBought;
    }
}
