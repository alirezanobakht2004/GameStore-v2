package ir.ac.kntu;

import java.util.Scanner;

public class LibraryMenu {
    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[1;96m" + "welcome to library" + "\033[0m");
        System.out.println("1.Show your games");
        System.out.println("2.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showGames();
                break;
            case 2:
                UserManagement.getUsersArr().get(indexOfUser).getUserMenu().userMenu(indexOfUser);
                break;
            default:
                break;
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


    public String friendsReq(String freReq, String user) {
        String[] lines = freReq.split("\n");
        StringBuilder newString = new StringBuilder();
        for (String line : lines) {
            if (!line.contains(user)) {
                newString.append(line).append("\n");
            }
        }
        return newString.toString();
    }

    public void sendFeedback(int u) {
        System.out.println("\033[1;93m" + "Send Feedback Menu+" + "\033[0m");
        System.out.println("Enter Your Feedback:");
        Scanner input = new Scanner(System.in);
        String feed = input.nextLine();
        GameManagement.getGamesArr().get(u).getDevelopersOfGame().get(0).getFeedback().add("Game: "+GameManagement.getGamesArr().get(u).getTitle() +" feedback: "+ feed);
    }
}
