package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryMenu {
    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[1;96m" + "welcome to library" + "\033[0m");
        System.out.println("1.Show your games");
        System.out.println("2.show your accessories");
        System.out.println("3.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showGames();
                break;
            case 2:
                showAccessories();
                break;
            case 3:
                UserManagement.getUsersArr().get(indexOfUser).getUserMenu().userMenu(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void showAccessories() {
        int count = 0;
        for (int i = 0; i < UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().size(); i++) {
            System.out.println("Accessory: " + UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().get(i).getTitle() + " index: " + AccessoriesManagement.getAccessoriesArr().indexOf(UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().get(i)));
            count++;
        }
        if (count != 0) {
            System.out.println("Enter index of Accessory:");
            Scanner input = new Scanner(System.in);
            int u = input.nextInt();
            showAccInfo(u);
            int h = input.nextInt();
            if (h == 1) {
                AccessoriesManagement.getAccessoriesArr().get(u).getCommunity().start(indexOfUser);
                start(indexOfUser);
            }
            if (h == 2) {
                start(indexOfUser);
            }
        } else {
            start(indexOfUser);
        }
    }

    public void showAccInfo(int u) {
        for (int i = 0; i < UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().size(); i++) {
            Accessories acc = UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().get(u);
            if (acc.getFps() == null) {
                for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "systemConnection of accessory: " + "\033[1;93m" + acc.getSystemConnection() + "\033[0m", "\n" + "systemKind of accessory: " + "\033[1;93m" + acc.getSystemKind() + "\033[0m")) {
                    System.out.println(s);
                }
            } else {
                for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "fps of accessory: " + "\033[1;93m" + acc.getFps() + "\033[0m", "\n" + "size of accessory: " + "\033[1;93m" + acc.getSize() + "\033[0m", "\n" + "answerTime of accessory: " + "\033[1;93m" + acc.getAnswerTime() + "\033[0m")) {
                    System.out.println(s);
                }
            }
            System.out.println("Enter 1 to see community");
            System.out.println("Enter 2 to back");
        }
    }


    public void showGames() {
        int count = 0;
        for (int i = 0; i < UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().size(); i++) {
            System.out.println("Your game title:" + "\033[1;92m"
                    + UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().get(i).getTitle() + "\033[0m"
                    + " With index of: " + "\033[1;91m"
                    + GameManagement.getGamesArr().indexOf(UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().get(i))
                    + "\033[0m" + " VERSION: " + "\033[1;96m" + UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().get(i).getVersion() + "\033[1;91m");
            count++;
        }
        if (count != 0) {
            System.out.println("Enter index of game:");
            Scanner input = new Scanner(System.in);
            int u = input.nextInt();
            showInfo(u);
            int h = input.nextInt();
            if (h == 1) {
                GameManagement.getGamesArr().get(u).getCommunity().start(indexOfUser);
                start(indexOfUser);
            }
            if (h == 2) {
                sendFeedback(u);
                start(indexOfUser);
            }
            if (h == 3) {
                start(indexOfUser);
            }
        } else {
            start(indexOfUser);
        }
    }

    public void showInfo(int u) {
        System.out.println("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getTitle() + "\033[0m");
        System.out.println("\n" + "Info of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getInfo() + "\033[0m");
        System.out.println("\n" + "level of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getLevel() + "\033[0m");
        System.out.println("\n" + "genre of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getGenre() + "\033[0m");
        System.out.println("\n" + "price of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getPrice() + "\033[0m");
        System.out.println("\n" + "version of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getVersion() + "\033[0m");
        if (GameManagement.getGamesArr().get(u).getVersion() == GameVersion.ORIGINAL) {
            System.out.println("\n" + "rating of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(u).getCommunity().getRating() + "\033[0m");
            System.out.println("\n" + GameManagement.getGamesArr().get(u).getCommunity().getComments() + "\n");
            System.out.println("\nEnter 1 to go community of game");
            System.out.println("Enter 3 back\n");
        } else {
            System.out.println("\nEnter 2 to send feedback");
            System.out.println("Enter 3 back\n");
        }
    }


    public void sendFeedback(int u) {
        System.out.println("\033[1;93m" + "Send Feedback Menu+" + "\033[0m");
        System.out.println("Enter Your Feedback:");
        Scanner input = new Scanner(System.in);
        String feed = input.nextLine();
        GameManagement.getGamesArr().get(u).getDevelopersOfGame().get(0).getFeedback().add("Game: " + GameManagement.getGamesArr().get(u).getTitle() + " feedback: " + feed);
    }
}
