package ir.ac.kntu;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.Scanner;

public class StoreMenu {

    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[1;94m" + "welcome to store" + "\033[0m");
        System.out.println("1.Show all games and accessories");
        System.out.println("2.Search game");
        System.out.println("3.Filter games by price");
        System.out.println("4.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showGamesAndAcc();
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

    public void showGamesAndAcc() {
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            String game = "* Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m" + " Index of game is: " + i + " *";
            System.out.println();
            for (int u = 0; u < game.length() - 11; u++) {
                System.out.print('*');
            }
            System.out.println();
            System.out.println(game);
            for (int u = 0; u < game.length() - 11; u++) {
                System.out.print('*');
            }
        }

        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            String acc = "| Title of accessory: " + "\033[1;93m" + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + "\033[0m" + " Index of accessory is: " + i + " |";
            System.out.println();
            for (int u = 0; u < acc.length() - 11; u++) {
                System.out.print('-');
            }
            System.out.println();
            System.out.println(acc);
            for (int u = 0; u < acc.length() - 11; u++) {
                System.out.print('-');
            }
        }
        System.out.println();
        System.out.println("Do you want to see games or accessories?");
        System.out.println("1.Game");
        System.out.println("2.Accessory");
        System.out.println("3.Back");
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        switch (t) {
            case 1:
                System.out.println("\nEnter index of the game you want:");
                Scanner inputOne = new Scanner(System.in);
                showGame(inputOne.nextInt());
                break;
            case 2:
                System.out.println("\nEnter index of the accessory you want:");
                Scanner inputTwo = new Scanner(System.in);
                showAccessory(inputTwo.nextInt());
                break;
            case 3:
                start(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void showAccessory(int i) {
        Accessories acc = AccessoriesManagement.getAccessoriesArr().get(i);
        if (acc.getFps() == null) {
            for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "systemConnection of accessory: " + "\033[1;93m" + acc.getSystemConnection() + "\033[0m", "\n" + "systemKind of accessory: " + "\033[1;93m" + acc.getSystemKind() + "\033[0m")) {
                System.out.println(s);
            }
        } else {
            for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "fps of accessory: " + "\033[1;93m" + acc.getFps() + "\033[0m", "\n" + "size of accessory: " + "\033[1;93m" + acc.getSize() + "\033[0m", "\n" + "answerTime of accessory: " + "\033[1;93m" + acc.getAnswerTime() + "\033[0m")) {
                System.out.println(s);
            }
        }
        System.out.println("1." + "\033[1;92m" + "Buy the accessory" + "\033[0m");
        System.out.println("2.Back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in) {
            case 1:
                if (UserManagement.getUsersArr().get(indexOfUser).getWallet() >= Integer.parseInt(acc.getPrice())) {
                    UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().add(acc);
                    acc.getCommunity().getUserList().add(UserManagement.getUsersArr().get(indexOfUser));
                    UserManagement.getUsersArr().get(indexOfUser).setWallet(UserManagement.getUsersArr().get(indexOfUser).getWallet() - Integer.parseInt(acc.getPrice()));
                    System.out.println("\n" + "You bought the accessory successfully!" + "\n");
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
        start(indexOfUser);
    }

    public void showGame(int i) {
        for (String s : Arrays.asList("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m", "\n" + "Info of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getInfo() + "\033[0m", "\n" + "level of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getLevel() + "\033[0m", "\n" + "genre of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getGenre() + "\033[0m", "\n" + "price of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getPrice() + "\033[0m", "\n" + "version of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getVersion() + "\033[0m")) {
            System.out.println(s);
        }
        if (GameManagement.getGamesArr().get(i).getVersion() == GameVersion.ORIGINAL) {
            System.out.println("\n" + "rating of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getCommunity().getRating() + "\033[0m");
            System.out.println("\n" + GameManagement.getGamesArr().get(i).getCommunity().getComments() + "\n");
        }
        if (!UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().contains(GameManagement.getGamesArr().get(i))) {
            int afterDiscountPercent=(100- levelScore(i))/100;
            System.out.println("2.Back");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            switch (in) {
                case 1:
                    if (UserManagement.getUsersArr().get(indexOfUser).getWallet() >=afterDiscountPercent*Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice())) {
                        UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().add(GameManagement.getGamesArr().get(i));
                        GameManagement.getGamesArr().get(i).getCommunity().getUserList().add(UserManagement.getUsersArr().get(indexOfUser));
                        UserManagement.getUsersArr().get(indexOfUser).setWallet(
                                UserManagement.getUsersArr().get(indexOfUser).getWallet()
                                        -afterDiscountPercent*Integer.parseInt(GameManagement.getGamesArr().get(i).getPrice()));
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

    public int levelScore(int i){
        if(GameManagement.getGamesArr().get(i).getLevel()==1){
            System.out.println("1." + "\033[1;92m" + "Buy the game with 0% discount" + "\033[0m");
            return 0;
        }
        if (GameManagement.getGamesArr().get(i).getLevel()==2 && UserManagement.getUsersArr().get(indexOfUser).getScore()>=20){
            System.out.println("1." + "\033[1;92m" + "Buy the game with 10% discount" + "\033[0m");
            return 10;
        }
        if (GameManagement.getGamesArr().get(i).getLevel()==3 && UserManagement.getUsersArr().get(indexOfUser).getScore()>=50){
            System.out.println("1." + "\033[1;92m" + "Buy the game with 20% discount" + "\033[0m");
            return 20;
        }
        if (GameManagement.getGamesArr().get(i).getLevel()==4 && UserManagement.getUsersArr().get(indexOfUser).getScore()>=100){
            System.out.println("1." + "\033[1;92m" + "Buy the game with 30% discount" + "\033[0m");
            return 30;
        }
        return 0;
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
