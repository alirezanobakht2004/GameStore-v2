package ir.ac.kntu;

import java.util.Scanner;

public class Friends {
    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[43m" + "Friends menu" + "\033[0m");
        System.out.println("1.Show all friends");
        System.out.println("2.Search friends");
        System.out.println("3.Send request");
        System.out.println("4.See requests");
        System.out.println("5.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                showAllFriends();
                break;
            case 2:
                searchFriends();
                break;
            case 3:
                sendRequest();
                break;
            case 4:
                seeRequest();
                break;
            case 5:
                User x = new User();
                x.userMenu(indexOfUser);
                break;
            default:
                break;
        }
        start(indexOfUser);
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

    public void showAllFriends() {
        System.out.println("\033[46m" + "Friends list menu" + "\033[0m");
        System.out.println("\n" + UserManagement.getUsersArr().get(indexOfUser).getFriends() + "\n");
        System.out.println("Enter -1 to comeback");
        System.out.println("Enter index of your friend to see his|her games\n");
        Scanner inputOne = new Scanner(System.in);
        int friendUs = inputOne.nextInt();
        if (friendUs == -1) {
            start(indexOfUser);
        } else {
            for (int o = 0; o < UserManagement.getUsersArr().get(friendUs).getGamesOfUser().size(); o++) {
                System.out.println("Title of game: "
                        + UserManagement.getUsersArr().get(friendUs).getGamesOfUser().get(o).getTitle());
            }
        }
    }

    public void searchFriends() {
        System.out.println("\033[46m" + "Search user menu" + "\033[0m");
        System.out.println("Enter username:");
        Scanner inputTwo = new Scanner(System.in);
        String user = inputTwo.nextLine();
        int count = 0;
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getUsername().startsWith(user)) {
                System.out.println(UserManagement.getUsersArr().get(i).getUsername() + " index: " + i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("\nThere was no such a username!\n");
        } else {
            System.out.println("Enter -1 to comeback");
            System.out.println("Enter index of your friend to see his|her games");
            Scanner inputThree = new Scanner(System.in);
            int friendUs1 = inputThree.nextInt();
            if (friendUs1 == -1) {
                start(indexOfUser);
            } else {
                for (int o = 0; o < UserManagement.getUsersArr().get(friendUs1).getGamesOfUser().size(); o++) {
                    System.out.println("Title of game: "
                            + UserManagement.getUsersArr().get(friendUs1).getGamesOfUser().get(o).getTitle());
                }
            }
        }
    }

    public void sendRequest() {
        System.out.println("\033[46m" + "Send request menu" + "\033[0m");
        System.out.println("Enter username:");
        Scanner inputFour = new Scanner(System.in);
        String userReq = inputFour.nextLine();
        int countRe = 0;
        for (int j = 0; j < UserManagement.getUsersArr().size(); j++) {
            if (UserManagement.getUsersArr().get(j).getUsername().equals(userReq)) {
                UserManagement.getUsersArr().get(j)
                        .setFriendsRequest(UserManagement.getUsersArr().get(j).getFriendsRequest() + "\n" +
                                " username: " + UserManagement.getUsersArr().get(indexOfUser).getUsername()
                                + " with index of: "
                                + indexOfUser + " has requested you!");
                countRe++;
                System.out.println("\nrequest sent!\n");
                break;
            }
        }
        if (countRe == 0) {
            System.out.println("\nThere was no such a username!\n");
        }
    }

    public void seeRequest() {
        System.out.println("\033[46m" + "See request menu" + "\033[0m");
        System.out.println(UserManagement.getUsersArr().get(indexOfUser).getFriendsRequest());
        seeRequestStart();
        Scanner inputFive = new Scanner(System.in);
        int p = inputFive.nextInt();
        switch (p) {
            case 1:
                System.out.println("Enter username that you accept:");
                Scanner inputSix = new Scanner(System.in);
                String userAcc = inputSix.nextLine();
                int countReq = 0;
                for (int j = 0; j < UserManagement.getUsersArr().size(); j++) {
                    if (UserManagement.getUsersArr().get(j).getUsername().equals(userAcc)) {
                        UserManagement.getUsersArr().get(indexOfUser).setFriends(
                                UserManagement.getUsersArr().get(indexOfUser).getFriends() + "\nFriend: " + userAcc + " index: "
                                        + j
                                        + "\n");
                        UserManagement.getUsersArr().get(j).setFriends(UserManagement.getUsersArr().get(j).getFriends() + "\n" + "Friend: "
                                + UserManagement.getUsersArr().get(indexOfUser).getUsername() + " index: " + indexOfUser + "\n");
                        UserManagement.getUsersArr().get(indexOfUser).setFriendsRequest(
                                friendsReq(UserManagement.getUsersArr().get(indexOfUser).getFriendsRequest(), userAcc));
                        countReq++;
                        System.out.println("User accepted!");
                        break;
                    }
                }
                countAlarm(countReq);
                break;
            case 2:
                System.out.println("Enter username that you reject:");
                Scanner inputSeven = new Scanner(System.in);
                String userRej = inputSeven.nextLine();
                int countRej = 0;
                for (int j = 0; j < UserManagement.getUsersArr().size(); j++) {
                    if (UserManagement.getUsersArr().get(j).getUsername().equals(userRej)) {
                        UserManagement.getUsersArr().get(indexOfUser).setFriendsRequest(
                                friendsReq(UserManagement.getUsersArr().get(indexOfUser).getFriendsRequest(), userRej));
                        countRej++;
                    }
                }
                countAlarm(countRej);
                break;
            case 3:
                start(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void seeRequestStart() {
        System.out.println("Enter 1 to accept a request");
        System.out.println("Enter 2 to reject a request");
        System.out.println("Enter 3 to comeback");
    }

    public void countAlarm(int h) {
        if (h == 0) {
            System.out.println("\nThere was no such a username!\n");
        }
    }
}
