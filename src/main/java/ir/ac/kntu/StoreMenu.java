package ir.ac.kntu;

import java.net.http.HttpClient;
import java.util.Scanner;

public class StoreMenu {

    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[1;94m" + "welcome to store" + "\033[0m");
        System.out.println("1.Show all games");
        System.out.println("2.Search game");
        System.out.println("3.Filter games by price");
        System.out.println("4.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showGames();
                break;
            case 2:
                searchGame();
                break;
            case 3:
                filterPrice();
                break;
            case 4:
                UserManagement.getUsersArr().get(indexOfUser).getUserMenu().userMenu(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void showGames() {
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            System.out
                    .println("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m"
                            + " Index of game is: " + i + "\n");
        }

        System.out.println("\nEnter index of the game you want:");
        Scanner input = new Scanner(System.in);
        showGame(input.nextInt());
    }

    public void showGame(int i) {
        System.out.println("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m");
        System.out.println("\n" + "Info of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getInfo() + "\033[0m");
        System.out.println("\n" + "level of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getLevel() + "\033[0m");
        System.out.println("\n" + "genre of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getGenre() + "\033[0m");
        System.out.println("\n" + "price of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getPrice() + "\033[0m");
        System.out.println("\n" + "version of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getVersion() + "\033[0m");
        if (GameManagement.getGamesArr().get(i).getVersion() == GameVersion.ORIGINAL) {
            System.out.println("\n" + "rating of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getCommunity().getRating() + "\033[0m");
            System.out.println("\n" + GameManagement.getGamesArr().get(i).getCommunity().getComments() + "\n");
        }

        if (!UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().contains(GameManagement.getGamesArr().get(i))) {
            System.out.println("1." + "\033[1;92m" + "Buy the game" + "\033[0m");
            System.out.println("2.Back");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            switch (in) {
                case 1:
                    if (UserManagement.getUsersArr().get(indexOfUser).getWallet() >= Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice())) {
                        UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().add(GameManagement.getGamesArr().get(i));
                        GameManagement.getGamesArr().get(i).getCommunity().getUserList().add(UserManagement.getUsersArr().get(indexOfUser));
                        UserManagement.getUsersArr().get(indexOfUser).setWallet(
                                UserManagement.getUsersArr().get(indexOfUser).getWallet()
                                        - Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice()));
                        System.out.println("\n" + "You bought the game successfully!" + "\n");
                    } else {
                        System.out.println("\033[1;91m" + "Not enough money in wallet" + "\033[0m");
                    }
                    break;
                case 2:
                    start(indexOfUser);
                    break;
                default:
                    break;
            }
        }
        start(indexOfUser);
    }

    public void searchGame() {
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        Scanner input = new Scanner(System.in);
        System.out.println("\033[46m" + "Search game menu" + "\033[0m");
        System.out.println("Enter name of game:");
        String name = input.nextLine();
        if (name.equals("###")) {
            start(indexOfUser);
        }
        int count = 0;
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            if (GameManagement.getGamesArr().get(i).getTitle().startsWith(name)) {
                System.out.println("name of game: " + GameManagement.getGamesArr().get(i).getTitle() +
                        " genre: " + GameManagement.getGamesArr().get(i).getGenre() +
                        " info: " + GameManagement.getGamesArr().get(i).getInfo() + " index of game is: " +
                        "\033[1;93m" + String.valueOf(i) + "\033[0m");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("there was no such a game!");
            searchGame();
        } else {
            System.out.println("\033[1;96m" + "Enter the index of the game you want to see:" + "\033[0m");
            int des = input.nextInt();
            showGame(des);
        }

    }

    public void filterPrice() {
        System.out.println("\033[0;101m" + "Filter by price menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter lower level:");
        int low = input.nextInt();
        System.out.println("Enter higher level:");
        int count = 0;
        int high = input.nextInt();
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            if (Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice()) <= high && Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice()) >= low) {
                System.out.println("name of game: " + GameManagement.getGamesArr().get(i).getTitle() +
                        " genre: " + GameManagement.getGamesArr().get(i).getGenre() +
                        " info: " + GameManagement.getGamesArr().get(i).getInfo() + " index of game is: " +
                        "\033[1;93m" + String.valueOf(i) + "\033[0m");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("there was no such a game!");
            start(indexOfUser);
        } else {
            System.out.println("\033[1;96m" + "Enter the index of the game you want to see:" + "\033[0m");
            int des = input.nextInt();
            showGame(des);
        }
    }

}
