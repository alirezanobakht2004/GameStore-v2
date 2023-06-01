package ir.ac.kntu;

import java.util.Scanner;

public class Store {

    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[43m" + "welcome to store" + "\033[0m");
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
                User x = new User();
                x.userMenu(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void showGames() {
        for (int i = 0; i < Admin.getGamesArr().size(); i++) {
            System.out
                    .println("\n" + "Title of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getTitle() + "\033[0m"
                            + " Index of game is: " + i + "\n");
        }

        System.out.println("\nEnter index of the game you want:");
        Scanner input = new Scanner(System.in);
        showGame(input.nextInt());
    }

    public void showGame(int i) {
        System.out.println("\n" + "Title of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getTitle() + "\033[0m");
        System.out.println("\n" + "Info of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getInfo() + "\033[0m");
        System.out.println("\n" + "genre of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getGenre() + "\033[0m");
        System.out.println("\n" + "price of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getPrice() + "\033[0m");
        System.out
                .println("\n" + "rating of game: " + "\033[1;93m" + Admin.getGamesArr().get(i).getRating() + "\033[0m");
        System.out.println("\n" + Admin.getGamesArr().get(i).getComments() + "\n");
        if (Sign.getUsersArr().get(indexOfUser).getGamesOfUser().indexOf(Admin.getGamesArr().get(i)) == -1) {
            System.out.println("1." + "\033[1;92m" + "Buy the game" + "\033[0m");
            System.out.println("2.Back");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            switch (in) {
                case 1:
                    if (Sign.getUsersArr().get(indexOfUser).getWallet() >= Admin.getGamesArr().get(i).getPrice()) {
                        Sign.getUsersArr().get(indexOfUser).getGamesOfUser().add(Admin.getGamesArr().get(i));
                        String oldCommunity = "\033[1;96m" + Admin.getGamesArr().get(i).getCommunity() + "\033[0m";
                        Admin.getGamesArr().get(i).setCommunity(oldCommunity + "\n" + "\033[1;96m"
                                + Sign.getUsersArr().get(indexOfUser).getUsername() + "\033[0m");
                        Sign.getUsersArr().get(indexOfUser).setWallet(
                                Sign.getUsersArr().get(indexOfUser).getWallet()
                                        - Admin.getGamesArr().get(i).getPrice());
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
        for (int i = 0; i < Admin.getGamesArr().size(); i++) {
            if (Admin.getGamesArr().get(i).getTitle().startsWith(name)) {
                System.out.println("name of game: " + Admin.getGamesArr().get(i).getTitle() +
                        " genre: " + Admin.getGamesArr().get(i).getGenre() +
                        " info: " + Admin.getGamesArr().get(i).getInfo() + " index of game is: " +
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
        for (int i = 0; i < Admin.getGamesArr().size(); i++) {
            if (Admin.getGamesArr().get(i).getPrice() <= high && Admin.getGamesArr().get(i).getPrice() >= low) {
                System.out.println("name of game: " + Admin.getGamesArr().get(i).getTitle() +
                        " genre: " + Admin.getGamesArr().get(i).getGenre() +
                        " info: " + Admin.getGamesArr().get(i).getInfo() + " index of game is: " +
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
