package ir.ac.kntu;

import java.util.Scanner;

public class Library {
    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[43m" + "welcome to library" + "\033[0m");
        System.out.println("1.Show your games");
        System.out.println("2.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showGames();
                break;
            case 2:
                User x = new User();
                x.userMenu(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void showGames() {
        int count = 0;
        for (int i = 0; i < Sign.getUsersArr().get(indexOfUser).getGamesOfUser().size(); i++) {
            System.out.println("Your game title:" + "\033[1;92m"
                    + Sign.getUsersArr().get(indexOfUser).getGamesOfUser().get(i).getTitle() + "\033[0m"
                    + " With index of: " + "\033[1;91m"
                    + Admin.getGamesArr().indexOf(Sign.getUsersArr().get(indexOfUser).getGamesOfUser().get(i))
                    + "\033[0m");
            count++;
        }
        if (count != 0) {
            System.out.println("Enter index of game:");
            Scanner input = new Scanner(System.in);
            int u = input.nextInt();
            shGa(u);
            int h = input.nextInt();
            if (h == 1) {
                shGa1(u);
                int des = input.nextInt();
                switch (des) {
                    case 1:
                        System.out.println(Admin.getGamesArr().get(u).getCommunity());
                        break;
                    case 2:
                        shGa2(u);
                        break;
                    case 3:
                        Admin.getGamesArr().get(u).setRatingNumber(Admin.getGamesArr().get(u).getRatingNumber() + 1);
                        System.out.println("Enter your rate:");
                        Scanner inputTwo = new Scanner(System.in);
                        Float rate = inputTwo.nextFloat();
                        Admin.getGamesArr().get(u).setRating((rate + Admin.getGamesArr().get(u).getRating())
                                / Admin.getGamesArr().get(u).getRatingNumber());
                        System.out.println("\nrate added successfully!\n");
                        break;
                    case 4:
                        start(indexOfUser);
                        break;
                    default:
                        break;
                }
                start(indexOfUser);
            }
            if (h == 2) {
                start(indexOfUser);
            }
        } else {
            start(indexOfUser);
        }
    }

    public void shGa(int u) {
        System.out.println(
                "\n" + "Title of game: " + "\033[1;93m" + Admin.getGamesArr().get(u).getTitle() + "\033[0m");
        System.out
                .println("\n" + "Info of game: " + "\033[1;93m" + Admin.getGamesArr().get(u).getInfo() + "\033[0m");
        System.out.println(
                "\n" + "genre of game: " + "\033[1;93m" + Admin.getGamesArr().get(u).getGenre() + "\033[0m");
        System.out.println(
                "\n" + "price of game: " + "\033[1;93m" + Admin.getGamesArr().get(u).getPrice() + "\033[0m");
        System.out.println(
                "\n" + "rating of game: " + "\033[1;93m" + Admin.getGamesArr().get(u).getRating() + "\033[0m");
        System.out.println( "\n" + Admin.getGamesArr().get(u).getComments() + "\n");
        System.out.println("\nEnter 1 to go community of game");
        System.out.println("Enter 2 back\n");
    }

    public void shGa1(int u) {
        System.out.println("\033[1;95m" + "Community Menu" + "\033[0m");
        System.out.println("1.see community of users");
        System.out.println("2.add a comment");
        System.out.println("3.rate the game");
        System.out.println("4.back");
    }

    public void shGa2(int u) {
        System.out.println("Enter your comment:");
        Scanner inputOne = new Scanner(System.in);
        String comment = inputOne.nextLine();
        String oldCommuent = "\033[1;96m" + Admin.getGamesArr().get(u).getComments() + "\033[0m";
        Admin.getGamesArr().get(u).setComments(oldCommuent + "\n" + "Username: "
                + Sign.getUsersArr().get(indexOfUser).getUsername() + " commented: " + "\033[1;96m"
                + comment + "\033[0m");
        System.out.println("\ncomment added successfully!\n");
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
}
