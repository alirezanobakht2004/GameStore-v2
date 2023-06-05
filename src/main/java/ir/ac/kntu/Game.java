package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Item{

    private String genre;

    private int level;

    private GameVersion gameVersion;

    private List<Developer> developersOfGame = new ArrayList<Developer>();
    public Game(){
        super();
    }
    public Game(String title, String genre, String info, String price, int level, GameVersion gameVersion){
        super(title,info,price);
        this.genre=genre;
        this.level=level;
        this.gameVersion = gameVersion;
    }
    public List<Developer> getDevelopersOfGame() {
        return developersOfGame;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void gameModify(int i) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[0;91m" + "game modify menu" + "\033[0m");
        System.out.println("1.change title");
        System.out.println("2.change genre");
        System.out.println("3.change info");
        System.out.println("4.change price");
        System.out.println("5.back");
        int in = input.nextInt();
        switch (in) {
            case 1 -> {
                System.out.println("Enter new title:");
                Scanner inputOne = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setTitle(inputOne.nextLine());
                System.out.println("your game title changed!");
                gameModify(i);
            }
            case 2 -> {
                System.out.println("Enter new genre:");
                Scanner inputTwo = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).genre = inputTwo.nextLine();
                System.out.println("your game genre changed!");
                gameModify(i);
            }
            case 3 -> {
                System.out.println("Enter new info:");
                Scanner inputThree = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setInfo(inputThree.nextLine());
                System.out.println("your game info changed!");
                gameModify(i);
            }
            case 4 -> {
                System.out.println("Enter new price:");
                Scanner inputFour = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setPrice(inputFour.nextLine());
                System.out.println("your game price changed!");
                gameModify(i);
            }
            case 5 -> {
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.gameManage();
            }
            default -> {
            }
        }
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
}
